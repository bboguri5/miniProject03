package com.kh.hw.miniProject3.model.vo;

public class Trainer {

    private String name;
    private int age;
    private String number;
    private String career;

    public Trainer() {

    }

    public Trainer(String name, int age, String number, String career) {
        this.name = name;
        this.age = age;
        this.number = number;
        this.career = career;
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

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }
}
