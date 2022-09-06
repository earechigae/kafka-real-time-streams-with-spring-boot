package guru.learningjournal.examples.kafka.rewards.services;

import guru.learningjournal.kafka.avroposgen.model.Notification;
import guru.learningjournal.kafka.avroposgen.model.PosInvoice;
import org.springframework.stereotype.Service;

@Service
public class RecordBuilder {
    /**
     * Transform PosInvoice to Notification
     *
     * @param invoice PosInvoice Object
     * @return Notification Object
     */
    public Notification getNotification(PosInvoice invoice) {
        Notification notification =  new Notification();
        notification.setInvoiceNumber(invoice.getInvoiceNumber().toString());
        notification.setCustomerCardNo(invoice.getCustomerCardNo());
        notification.setTotalAmount(invoice.getTotalAmount());
        notification.setEarnedLoyaltyPoints(invoice.getTotalAmount() * 0.02);
        notification.setTotalLoyaltyPoints(notification.getEarnedLoyaltyPoints());
        return notification;
    }
}
