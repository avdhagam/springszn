package com.cars24.csms.data.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;



@Table(name = "invoices")
@Entity
@Data
public class InvoiceEntity {
    @Id
    @Column(name="invoice_id")
    private int id;

    @Column(name = "appid")
    private int appid;

   @Column(name = "amount")
    private double amount;

   @Column(name = "payment_status")
    private String status;

   @Column(name = "is_active")
   private Boolean is_active;


}
