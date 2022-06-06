package com.kh.miniProject3.health.model.vo;
public class HealthMember {

    private String id;
    private String name;
    private char gender;
    private int age;
    private String job;
    private int month;
    private int start;
    private int last;
    private int locker;

    public HealthMember() {

    }

    public HealthMember(int num, String name, char gender, int age, String job, int start, int month , int locker) {
        this.id = String.format("A%02d",num);
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.job = job;
        this.start = start;
        this.month = month;
        this.locker = locker;
    }


    public String inform()
    {
        String lock = locker == 0 ? "무" : String.valueOf(locker);
        int last = start+month;
        int m = (last / 100) % 100;
        if(m > 12) {
            last = start + 10000 + month - 1200;
        }
        return String.format("[ 고객코드 : %s | 이름 : %s | 성별 : %s | 나이 : %d | 직업 : %s | 시작날짜 %d | 마지막날짜 : %d | 락커유무 : %s ] \n"
                ,id,name,gender,age,job,start,last,lock);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }

    public int getLocker() {
        return locker;
    }

    public void setLocker(int locker) {
        this.locker = locker;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }
}
