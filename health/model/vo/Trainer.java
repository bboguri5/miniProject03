package com.kh.miniProject3.health.model.vo;

import java.util.Date;

public class Trainer {

    private String name;
    private int age;
    private String number;
    private int career;

    private String goToWork;
    private String leaveWork;
    private int workDays;
    private int pay;
    private int timePay;

    public Trainer() {

    }

    public Trainer(String name, int age, String number, int career ,int timePay, int workDays, int pay) {
        this.name = name;
        this.age = age;
        this.number = number;
        this.career = career;
        this.timePay = timePay;
        this.workDays = workDays;
        this.pay = pay;
    }

    public void inform()
    {
        System.out.printf("[ 이름 : %s | 나이 : %d | 번호 : %s | 경력 : %s ]\n"
                ,name,age,number,career);
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getCareer() {
        return career;
    }

    public void setCareer(int career) {
        this.career = career;
    }

    public String getGoToWork() {
        return goToWork;
    }

    public void setGoToWork(String goToWork) {
        this.goToWork = goToWork;
    }

    public String getLeaveWork() {
        return leaveWork;
    }

    public void setLeaveWork(String leaveWork) {
        this.leaveWork = leaveWork;
    }



    public int getWorkDays() {
        return workDays;
    }

    public void setWorkDays(int workDays) {
        this.workDays = workDays;
    }



    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    public int getTimePay() {
        return timePay;
    }

    public void setTimePay(int timePay) {
        this.timePay = timePay;
    }
}
