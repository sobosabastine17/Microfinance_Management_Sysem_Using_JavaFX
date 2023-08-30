package com.example.mmf;

    public class customer {
    public String first_name,last_name,account_type,date,date_of_birth,digital_address,education_level,email,home_town,
    house_address,id_type,id_number,nationality,phone_number,place_of_birth,profession,profile,status,account_number;
    public int id;
    public double balance;
    public customer(String date,String status,String first_name, String last_name,String nationality,String place_of_birth,
                    String home_town,String date_of_birth,String id_type,String id_number,String phone_number,
                    String email,String house_address,String digital_address,String account_type,String account_number,
                    String education_level,String profession,String profile,Double balance){

        this.id = id;
        this.date = date;
        this.first_name = first_name;
        this.last_name = last_name;
        this.account_type = account_type;
        this.date_of_birth = date_of_birth;
        this.digital_address = digital_address;
        this.education_level = education_level;
        this.email = email;
        this.home_town = home_town;
        this.house_address = house_address;
        this.id_type = id_type;
        this.id_number =id_number;
        this.nationality = nationality;
        this.phone_number = phone_number;
        this.place_of_birth = place_of_birth;
        this.profession = profession;
        this.profile = profile;
        this.status = status;
        this.account_number = account_number;
        this.balance = balance;
    }
    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
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

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
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

    public String getHome_town() {
        return home_town;
    }

    public void setHome_town(String home_town) {
        this.home_town = home_town;
    }

    public String getHouse_address() {
        return house_address;
    }

    public void setHouse_address(String house_address) {
        this.house_address = house_address;
    }

    public String getId_type() {
        return id_type;
    }

    public void setId_type(String id_type) {
        this.id_type = id_type;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPlace_of_birth() {
        return place_of_birth;
    }

    public void setPlace_of_birth(String place_of_birth) {
        this.place_of_birth = place_of_birth;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}