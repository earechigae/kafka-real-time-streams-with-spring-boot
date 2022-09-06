/*
 * Copyright (c) 2018. Prashant Kumar Pandey
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */

package guru.learningjournal.examples.kafka.avroposfanout.services;

import guru.learningjournal.kafka.avroposgen.model.HadoopRecord;
import guru.learningjournal.kafka.avroposgen.model.LineItem;
import guru.learningjournal.kafka.avroposgen.model.Notification;
import guru.learningjournal.kafka.avroposgen.model.PosInvoice;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Transform Invoice to other Objects
 *
 * @author prashant
 * @author www.learningjournal.guru
 */

@Service
public class RecordBuilder {
    /**
     * Create a flattened List of HadoopRecords from Invoice
     * Each Line Item is denormalized into an independent record
     *
     * @param invoice PosInvoice object
     * @return List of HadoopRecord
     */
    /*static*/ public List<HadoopRecord> getHadoopRecords(PosInvoice invoice) {
        List<HadoopRecord> records = new ArrayList<>();
        for (LineItem i : invoice.getInvoiceLineItems()) {
            HadoopRecord record = new HadoopRecord();
            record.setInvoiceNumber(invoice.getInvoiceNumber().toString());
            record.setCreatedTime(invoice.getCreatedTime());
            record.setStoreID(invoice.getStoreID().toString());
            record.setPosID(invoice.getPosID().toString());
            record.setCustomerType(invoice.getCustomerType().toString());
            record.setPaymentMethod(invoice.getPaymentMethod().toString());
            record.setDeliveryType(invoice.getDeliveryType().toString());
            record.setItemCode(i.getItemCode().toString());
            record.setItemDescription(i.getItemDescription().toString());
            record.setItemPrice(i.getItemPrice());
            record.setItemQty(i.getItemQty());
            record.setTotalValue(i.getTotalValue());
            if (invoice.getDeliveryType().toString().equalsIgnoreCase("HOME-DELIVERY")) {
                record.setCity(invoice.getDeliveryAddress().getCity().toString());
                record.setState(invoice.getDeliveryAddress().getState().toString());
                record.setPinCode(invoice.getDeliveryAddress().getPinCode().toString());
            }
            records.add(record);
        }
        return records;
    }

    /**
     * Set personally identifiable values to null
     *
     * @param invoice PosInvoice object
     * @return masked PosInvoice object
     */
    /*static*/ public PosInvoice getMaskedInvoice(PosInvoice invoice) {
        invoice.setCustomerCardNo(null);
        if (invoice.getDeliveryType().toString().equalsIgnoreCase("HOME-DELIVERY")) {
            invoice.getDeliveryAddress().setAddressLine(null);
            invoice.getDeliveryAddress().setContactNumber(null);
        }
        return invoice;
    }

    /**
     * Transform PosInvoice to Notification
     *
     * @param invoice PosInvoice Object
     * @return Notification Object
     */
    /*static*/ public Notification getNotification(PosInvoice invoice) {
        Notification notification =  new Notification();
            notification.setInvoiceNumber(invoice.getInvoiceNumber().toString());
            notification.setCustomerCardNo(invoice.getCustomerCardNo().toString());
            notification.setTotalAmount(invoice.getTotalAmount());
            notification.setEarnedLoyaltyPoints(invoice.getTotalAmount() * 0.02);
            return notification;
    }
}
