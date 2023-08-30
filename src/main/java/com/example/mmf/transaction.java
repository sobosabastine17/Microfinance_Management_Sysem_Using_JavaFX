package com.example.mmf;

public class transaction {
    private int id,customer_id,staff_id;
    private double amount;
    private String customer_name,date,staff_name,transaction_type,account_number;

    public transaction(int id, int customer_id, int staff_id, double amount, String customer_name, String date,
                       String staff_name, String transaction_type, String account_number) {
        this.id = id;
        this.customer_id = customer_id;
        this.staff_id = staff_id;
        this.amount = amount;
        this.customer_name = customer_name;
        this.date = date;
        this.staff_name = staff_name;
        this.transaction_type = transaction_type;
        this.account_number = account_number;
    }

    public transaction() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public String getTransaction_type() {
        return transaction_type;
    }

    public void setTransaction_type(String transaction_type) {
        this.transaction_type = transaction_type;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }
}
