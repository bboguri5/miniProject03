package com.kh.miniProject3.health.controller;

import com.kh.miniProject3.health.model.vo.HealthMember;

import java.lang.reflect.Member;
import java.nio.channels.MembershipKey;

public class HealthMemberController {
    public static final int SIZE = 10;
    HealthMember[] hm = new HealthMember[SIZE];

    public HealthMemberController() {

        hm[0] = new HealthMember(1, "황정아", '남', 31, "무직", 20220301, 1200, 0);
        hm[1] = new HealthMember(2, "손성빈", '여', 22, "회사원", 20220101, 300, 1);
        hm[2] = new HealthMember(3, "최성렬", '여', 23, "회사원", 20220121, 400, 3);
        hm[3] = new HealthMember(4, "최성렬", '여', 23, "회사원", 20220121, 400, 5);

    }

    //region 회원
    //실제 회원 수
    public int existHealthMemberNum() {
        int count = 0;
        for (HealthMember m : hm) {
            if (m == null) break;
            count++;
        }
        return count;
    }

    //회원등록 기능
    public void insertMember(String name, char gender, int age, String job, int start, int month) {
        int count = existHealthMemberNum();
        hm[count] = new HealthMember(count + 1, name, gender, age, job, start, month, 0);

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
        System.out.printf(" %s 회원님의 정보가 등록되었습니다. \n", name);
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
    }

    // 해당 아이디 회원 추출
    public HealthMember searchId(String id) {
        int index = findIndexById(id);
        return (index != -1) ? hm[index] : null;
    }

    // 동명인 배열로 가져오기
    public HealthMember[] searchName(String name) // 동명인 가져오는 함수 배열
    {
        int count = 0;
        int length = existHealthMemberNum();
        HealthMember[] members = new HealthMember[length];

        for (int i = 0; i < length; i++) {
            if (hm[i].getName().equals(name)) members[count++] = hm[i];
        }

        HealthMember[] resultM = new HealthMember[count];
        for (int i = 0; i < count; i++) {
            resultM[i] = members[i];
        }
        return resultM;
    }

    //region 수정 - update ~
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

    //endregion
    // 해당 인덱스 추출
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

    // 탈퇴
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

    // 멤버 모두 출력하기
    public HealthMember[] printAllMember() {
        int memberLength = existHealthMemberNum();
        HealthMember[] members = new HealthMember[memberLength];
        for (int i = 0; i < memberLength; i++) {
            members[i] = hm[i];
        }
        return members;
    }

    // 멤버 최대등록 초과 체크
    public boolean checkFull() {
        return (existHealthMemberNum() == SIZE);
    }
    //endregion
    //region 락커
    //락커사용자 추출
    public HealthMember[] printAllLocker() {
        int memberLength = existHealthMemberNum();
        int existNum = existLockerNum();
        HealthMember[] members = new HealthMember[existNum];
        int count = 0;

        for (int i = 0; i < memberLength; i++) {
            System.out.println(i);
            if (hm[i].getLocker() != 0) members[count++] = hm[i];
        }
        return members; // 락커가 있는 멤버만 나와야함.
    }

    // 락커 사용 등록
    public void insertLockerNum(String id) {
        HealthMember m = searchId(id);
        while (true) {
            int rn = (int) (Math.random() * SIZE + 1);
            if (m.getLocker() == 0 && !isDuplicate(rn)) {
                m.setLocker(rn);
                break;
            }
        }

        System.out.println("수정 완료 : " + m.inform());
    }

    // 락커 중복 체크
    public boolean isDuplicate(int rn) {
        for (int i = 0; i <existLockerNum(); i++) {
            if(hm[i].getLocker()==rn)
                return true;
        }
        return false;
    }

    // 락커 실제 사용 갯수
    public int existLockerNum() {
        int existMemberNum = existHealthMemberNum();
        int count = 0;
        for (int i = 0; i < existMemberNum; i++) {
            if (hm[i].getLocker() != 0) count++;
        }

        return count;

    }

    //endregion
    //region 매출현황
    //월 매출
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

    // 년 매출
    public int yearStatus() {
        int total = 0;
        int[] a = lastMonth();
        for (int i = 0; i < 13; i++) {
            total += a[i];
        }
        return total;
    }
    //endregion



}
