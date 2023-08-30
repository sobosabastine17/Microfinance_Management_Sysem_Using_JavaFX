package com.example.mmf;

public class staff {
    private int id;
    private String date,date_of_birth,digital_address,education_level,email,first_name,last_name,house_address,
    marital_status,nationality,password,phone_number,position,profile,status;

    public staff(int id, String date, String date_of_birth, String digital_address, String education_level, String email,
                 String first_name, String last_name, String house_address, String marital_status, String nationality,
                 String password, String phone_number, String position, String profile, String status) {
        this.id = id;
        this.date = date;
        this.date_of_birth = date_of_birth;
        this.digital_address = digital_address;
        this.education_level = education_level;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.house_address = house_address;
        this.marital_status = marital_status;
        this.nationality = nationality;
        this.password = password;
        this.phone_number = phone_number;
        this.position = position;
        this.profile = profile;
        this.status = status;
    }

    public staff() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getDigital_address() {
        return digital_address;
    }

    public void setDigital_address(String digital_address) {
        this.digital_address = digital_address;
    }

    public String getEducation_level() {
        return education_level;
    }

    public void setEducation_level(String education_level) {
        this.education_level = education_level;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getHouse_address() {
        return house_address;
    }

    public void setHouse_address(String house_address) {
        this.house_address = house_address;
    }

    public String getMarital_status() {
        return marital_status;
    }

    public void setMarital_status(String marital_status) {
        this.marital_status = marital_status;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
