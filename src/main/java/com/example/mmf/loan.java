package com.example.mmf;

public class loan {
    private int id,customer_id;
    private double amount;
    private String customer_name,date_ended,date_started, equilateral,status;

    public loan(int id, int customer_id, double amount, String customer_name, String date_ended, String date_started,
                String equilateral, String status) {
        this.id = id;
        this.customer_id = customer_id;
        this.amount = amount;
        this.customer_name = customer_name;
        this.date_ended = date_ended;
        this.date_started = date_started;
        this.equilateral = equilateral;
        this.status = status;
    }

    public loan() {
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

    public String getDate_ended() {
        return date_ended;
    }

    public void setDate_ended(String date_ended) {
        this.date_ended = date_ended;
    }

    public String getDate_started() {
        return date_started;
    }

    public void setDate_started(String date_started) {
        this.date_started = date_started;
    }

    public String getEquilateral() {
        return equilateral;
    }

    public void setEquilateral(String equilateral) {
        this.equilateral = equilateral;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
