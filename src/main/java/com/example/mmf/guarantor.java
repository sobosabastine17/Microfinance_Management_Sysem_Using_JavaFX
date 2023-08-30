package com.example.mmf;

public class guarantor {
    private int id,SC_id;
    private String SC_name,first_address,first_name,first_relationship,first_phone,second_name,second_address,
            second_relationship,second_phone;

    public guarantor(int id, int SC_id, String SC_name, String first_address, String first_name, String first_relationship,
                     String first_phone, String second_name, String second_address, String second_relationship,
                     String second_phone) {
        this.id = id;
        this.SC_id = SC_id;
        this.SC_name = SC_name;
        this.first_address = first_address;
        this.first_name = first_name;
        this.first_relationship = first_relationship;
        this.first_phone = first_phone;
        this.second_name = second_name;
        this.second_address = second_address;
        this.second_relationship = second_relationship;
        this.second_phone = second_phone;
    }

    public guarantor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSC_id() {
        return SC_id;
    }

    public void setSC_id(int SC_id) {
        this.SC_id = SC_id;
    }

    public String getSC_name() {
        return SC_name;
    }

    public void setSC_name(String SC_name) {
        this.SC_name = SC_name;
    }

    public String getFirst_address() {
        return first_address;
    }

    public void setFirst_address(String first_address) {
        this.first_address = first_address;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getFirst_relationship() {
        return first_relationship;
    }

    public void setFirst_relationship(String first_relationship) {
        this.first_relationship = first_relationship;
    }

    public String getFirst_phone() {
        return first_phone;
    }

    public void setFirst_phone(String first_phone) {
        this.first_phone = first_phone;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getSecond_address() {
        return second_address;
    }

    public void setSecond_address(String second_address) {
        this.second_address = second_address;
    }

    public String getSecond_relationship() {
        return second_relationship;
    }

    public void setSecond_relationship(String second_relationship) {
        this.second_relationship = second_relationship;
    }

    public String getSecond_phone() {
        return second_phone;
    }

    public void setSecond_phone(String second_phone) {
        this.second_phone = second_phone;
    }
}
