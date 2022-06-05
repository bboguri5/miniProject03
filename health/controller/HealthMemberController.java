package com.kh.miniProject3.health.controller;

import com.kh.miniProject3.health.model.vo.HealthMember;

public class HealthMemberController {
    public static final int SIZE = 10;
    HealthMember[] hm = new HealthMember[SIZE];

    public HealthMemberController() {

        hm[0] = new HealthMember(1, "황정아", 'F', 31, "무직", 20220301, 1200);
        hm[1] = new HealthMember(2, "손성빈", 'M', 22, "회사원", 20220101, 300);
        hm[2] = new HealthMember(3, "최성렬", 'M', 23, "회사원", 20220121, 400);
        hm[3] = new HealthMember(4, "최성렬", 'M', 23, "회사원", 20220121, 400);
    }

    public int existHealthMemberNum() {
        int count = 0;
        for (HealthMember m : hm) {
            if (m == null)
                break;
            count++;
        }
        return count;
    }

    ;

    public void insertMember(String name, char gender, int age, String job, int start, int month) {
        int count = existHealthMemberNum();
        hm[count] = new HealthMember(count + 1, name, gender, age, job, start, month);

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
        System.out.printf(" %s 회원님의 정보가 등록되었습니다. \n", name);
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
    }

    public HealthMember searchId(String id) {
        int index = findIndexById(id);
        return (index != -1) ? hm[index] : null;
    }

    public HealthMember[] searchName(String name) // 동명인 가져오는 함수 배열
    {
        int count = 0;
        int length = existHealthMemberNum();
        HealthMember[] members = new HealthMember[length];

        for (int i = 0; i < length; i++) {
            if (hm[i].getName().equals(name))
                members[count++] = hm[i];
        }

        HealthMember[] resultM = new HealthMember[count];
        for (int i = 0; i < count; i++) {
            resultM[i] = members[i];
        }
        return resultM;
    }

    public boolean updateName(HealthMember m, String newName) {
        if (m != null) {
            m.setName(newName);
            return true;
        }
        return false;
    }

    public boolean updateGender(HealthMember m, char newGender) {
        if (m != null) {
            m.setGender(newGender);
            return true;
        }
        return false;
    }

    public boolean updateAge(HealthMember m, int newAge) {
        if (m != null) {
            m.setAge(newAge);
            return true;
        }
        return false;
    }

    public boolean updateJob(HealthMember m, String newJob) {
        if (m != null) {
            m.setJob(newJob);
            return true;
        }
        return false;
    }

    public boolean updateStart(HealthMember m, int newStart) {
        if (m != null) {
            m.setStart(newStart);
            return true;
        }
        return false;
    }

    public boolean updateMonth(HealthMember m, int newMonth) {
        if (m != null) {
            m.setMonth(newMonth);
            return true;
        }
        return false;
    }

    public int findIndexById(String id) {
        int index = -1;
        for (int i = 0; i < existHealthMemberNum(); i++) {
            if (id.equals(hm[i].getId())) {
                index = i;
                break;
            }
        }
        return index;
    }

    public boolean deleteOne(String id) {
        int index = findIndexById(id);
        if (index != -1) {
            int count = existHealthMemberNum();
            for (int i = index; i < count - 1; i++) {
                hm[i] = hm[i + 1];
            }
            hm[count - 1] = null;
            return true;
        }
        return false;
    }

    public HealthMember[] printAll() {
        int memberLength = existHealthMemberNum();
        HealthMember[] members = new HealthMember[memberLength];
        for (int i = 0; i < memberLength; i++) {
            members[i] = hm[i];
        }
        return members;
    }


    public int[] lastMonth() {
        int[] monthStatus = new int[13];
        monthStatus[0] = 0;

//        for (HealthMember healthMember : hm)
        for (int t = 0; t < existHealthMemberNum(); t++) {
            int startMonth = 0;
            int period = 0;
            // 시작하는 달
            startMonth = (hm[t].getStart() / 100) % 100;
            // 다니는 기간
            period = hm[t].getMonth() / 100;
            int a = startMonth + period;

            for (int i = startMonth; i < a; i++) {
                int x = i;
                if (x > 12) {
                    x = x - 12;
                }
                monthStatus[x] += 100000;
            }

        }
        return monthStatus;
    }


    public int[] healthMemberCost() {
        int cost = 100000;
        int[] monthStatus = new int[12];
        for (HealthMember healthMember : hm) {
            int last = healthMember.getStart() + healthMember.getMonth();
            int m = (last / 100) % 100;
            for (int i = 1; i < 12; i++) {
                if (m == i) {

                }
            }
        }
        return monthStatus;
    }


}
