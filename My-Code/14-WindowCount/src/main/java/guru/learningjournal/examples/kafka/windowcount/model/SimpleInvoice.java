package guru.learningjournal.examples.kafka.windowcount.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SimpleInvoice {
    @JsonProperty("InvoiceNumber")
    private String invoiceNumber;

    @JsonProperty("CreatedTime")
    private String createdTime;

    @JsonProperty("StoreID")
    private String storeId;

    @JsonProperty("TotalAmount")
    private Double totalAmount;
}
