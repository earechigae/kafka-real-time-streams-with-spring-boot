
package guru.learningjournal.examples.kafka.jsonposfanout.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "AddressLine",
    "City",
    "State",
    "PinCode",
    "ContactNumber"
})
public class DeliveryAddress {

    @JsonProperty("AddressLine")
    private String addressLine;
    @JsonProperty("City")
    private String city;
    @JsonProperty("State")
    private String state;
    @JsonProperty("PinCode")
    private String pinCode;
    @JsonProperty("ContactNumber")
    private String contactNumber;
}
