package com.kh.miniProject3.health.controller;

import com.kh.miniProject3.health.model.vo.HealthMember;
import com.kh.miniProject3.health.view.HealthMemberMenu;

import java.lang.reflect.Member;
import java.util.Arrays;

public class HealthMemberController {
    private int SIZE = 10;
    HealthMember[] hm = new HealthMember[SIZE];

    public HealthMemberController() {

        hm[0] = new HealthMember(1,"황정아",'F',31,"무직",20220301,400);
        hm[1] = new HealthMember(2,"손성빈",'M',22,"회사원",20220101,300);
        hm[2] = new HealthMember(3,"최성렬",'M',23,"회사원",20220121,400);
    }

    public boolean checkInput(String input)
    {
        int length = existHealthMemberNum();
        for (int i = 0; i < length; i++) {
            if(hm[i].getId().equals(input) || hm[i].getName().equals(input))
                return true;
        }
        return false;
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

    public HealthMember searchId(String id){
        int length = existHealthMemberNum();

        for (int i = 0; i <length ; i++) {
            if(hm[i].getId().equals(id))
                return hm[i];
        }
        return null;
    }

    public HealthMember[] searchName(String name)
    {
        int count = 0;
        int length = existHealthMemberNum();
        HealthMember[] members = new HealthMember[length];

        for (int i = 0; i < length ; i++) {
            if(hm[i].getName().equals(name))
            {
                members[i] = hm[i];
                count++;
            }
        }

        HealthMember[] resultM = new HealthMember[count];

        for (int i = 0; i < count ; i++) {
            resultM[i] = members[i];
        }
        return resultM;
    }




    public boolean updateName(HealthMember m , String newName)
    {
        if(m != null)
        {
            m.setName(newName);
            return true;
        }
        return false;
    }
    public boolean updateGender(HealthMember m ,char newGender)
    {
        if(m != null)
        {
            m.setGender(newGender);
            return true;
        }
        return false;
    }
    public boolean updateAge(HealthMember m ,int newAge)
    {
        if(m != null)
        {
            m.setAge(newAge);
            return true;
        }
        return false;
    }
    public boolean updateJob(HealthMember m, String newJob)
    {
        if(m != null)
        {
            m.setJob(newJob);
            return true;
        }
        return false;
    }
    public boolean updateStart(HealthMember m , int newStart)
    {
        if(m != null)
        {
            m.setStart(newStart);
            return true;
        }
        return false;
    }
    public boolean updateMonth(HealthMember m, int newMonth)
    {
        if(m != null)
        {
            m.setMonth(newMonth);
            return true;
        }
        return false;
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
