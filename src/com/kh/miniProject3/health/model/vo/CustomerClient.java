package com.kh.miniProject3.health.model.vo;

import com.kh.miniProject3.health.view.Common;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class CustomerClient {

    private String name;
    private char gender;
    private String phone;
    private String customerDate;


    public CustomerClient() {
    }

    public CustomerClient(String name, char gender, String phone, String customerDate) {
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.customerDate = customerDate;
    }

    public String inform()
    {
        return String.format("[ 이름 : %s | 성별 : %s | 휴대폰 번호 : %s | 상담 날짜 : %s ] \n"
                ,name,gender,phone,customerDate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCustomerDate() {
        return customerDate;
    }

    public void setCustomerDate(String customerDate) {
        this.customerDate = customerDate;
    }



}
