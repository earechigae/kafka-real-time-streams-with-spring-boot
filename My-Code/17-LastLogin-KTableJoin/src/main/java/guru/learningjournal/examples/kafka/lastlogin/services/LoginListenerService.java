package guru.learningjournal.examples.kafka.lastlogin.services;

import guru.learningjournal.examples.kafka.lastlogin.bindings.UserListenerBinding;
import guru.learningjournal.examples.kafka.lastlogin.model.UserDetails;
import guru.learningjournal.examples.kafka.lastlogin.model.UserLogin;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.streams.kstream.KTable;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneOffset;

@Service
@Log4j2
@EnableBinding(UserListenerBinding.class)
public class LoginListenerService {

    @StreamListener
    public void process(@Input("user-master-channel") KTable<String, UserDetails> users,
                        @Input("user-login-channel") KTable<String, UserLogin> logins){
        users.toStream().foreach((k, v) -> log.info("User Key = {}, Last Login = {}, Value = {}",
                k, Instant.ofEpochMilli(v.getLastLogin()).atOffset(ZoneOffset.UTC)));

        logins.toStream().foreach((k, v) -> log.info("Login Key = {}, Last Login = {}, Value = {}",
                k, Instant.ofEpochMilli(v.getCreatedTime()).atOffset(ZoneOffset.UTC)));

        // Joining KTable to KTable
        // logins is the left side of the join, users is the right side of the join
        logins.join(users,
                // Value joiner lambda
                (login, user) -> {
                    // Join operation logic.
                    user.setLastLogin(login.getCreatedTime());
                    return user;
                }).toStream()
                .foreach((k, v) -> log.info("Updated Last Login Key = {}, Last Login = {}",
                        k, Instant.ofEpochMilli(v.getLastLogin()).atOffset(ZoneOffset.UTC)));
    }
}
