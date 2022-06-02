package com.kh.miniProject3.health.controller;

import com.kh.miniProject3.health.model.vo.HealthMember;
import com.kh.miniProject3.health.view.HealthMemberMenu;

import java.lang.reflect.Member;

public class HealthMemberController {
    private int SIZE = 10;
    HealthMember[] hm = new HealthMember[SIZE];

    public HealthMemberController() {

        hm[0] = new HealthMember(1,"황정아",'F',31,"무직",20220301,400);
        hm[1] = new HealthMember(2,"손성빈",'M',22,"회사원",20220101,300);
        hm[2] = new HealthMember(3,"최성렬",'M',23,"회사원",20220121,400);
    }

    public int existHealthMemberNum(){

        int count = 0;
        for(HealthMember m : hm)
        {
            if(m == null)
                break;
            count++;
        }

        return count;
    };

    public void insertMember (String name, char gender, int age, String job, int start, int month)
    {
       int count = existHealthMemberNum();
       hm[count] = new HealthMember(count+1,name,gender,age,job,start,month);
    }


    public String searchId(String id){

        return "";
    }
    public HealthMember[] searchName(String name)
    {
        return hm;
    }

    public boolean updateName()
    {
        return true;
    }
    public boolean updateGender()
    {
        return true;
    }
    public boolean updateAge()
    {
        return true;
    }
    public boolean updateJob()
    {
        return true;
    }
    public boolean updateStart()
    {
        return true;
    }
    public boolean deleteMember()
    {
        return true;
    }
    public void deleteOne()
    {

    }
    public HealthMember[] printAll()
    {
        int memberLength = existHealthMemberNum();
        HealthMember[] members = new HealthMember[memberLength];
        for (int i = 0; i < memberLength; i++) {
            members[i] = hm[i];
        }
        return members;
    }

}
