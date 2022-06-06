package com.kh.miniProject3.health.model.vo;

public class ConsultMember {

    String name;
    int age;
    char gender;
    String phoneNumber;
    int consultDay;


    public ConsultMember() {

    }

    public ConsultMember(String name, int age, char gender, String phoneNumber, int consultDay) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.consultDay = consultDay;
    }

    public String inform() {
        return String.format("[ 이름 : %s | 나이 : %d | 성별 : %s | 휴대폰번호 : %s | 상담날짜 %s ] \n"
                ,name,age,gender,phoneNumber,consultDay);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGenger() {
        return gender;
    }

    public void setGenger(char genger) {
        this.gender = genger;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getConsultDay() {
        return consultDay;
    }

    public void setConsultDay(int consultDay) {
        this.consultDay = consultDay;
    }
}
