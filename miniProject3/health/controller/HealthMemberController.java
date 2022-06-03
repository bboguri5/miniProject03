package com.kh.miniProject3.health.controller;

import com.kh.hw.member.model.vo.Member;
import com.kh.miniProject3.health.model.HealthMember;

public class HealthMemberController {

    HealthMember[] m = new HealthMember[SIZE];
    public static final int SIZE = 10;

    public HealthMemberController() {

        m[0] = new HealthMember(1,"황정아",'F',31,"무직",20220301,400);
        m[1] = new HealthMember(2,"손성빈",'M',22,"회사원",20220101,300);
        m[2] = new HealthMember(3,"최성렬",'M',23,"회사원",20220121,400);
    }


    // 실제 저장되어 있는 멤버 수
    public int existMemberNum() {
        // 멤버 수를 카운트
        int count = 0;
        for (HealthMember healthMember : m) {
            // 등록되지 않은 빈칸일 경우 break
            if (healthMember == null) break;
            // +count
            count++;
        }
        // 실제 멤버 수
        return count;
    }

    // 이름 입력시 해당 이름을 가진 멤버 전체 출력
    public HealthMember[] searchName(String name) {
        // 검색된 이름을 가진 멤버를 저장할 임시 배열
        HealthMember[] temp = new HealthMember[SIZE];
        int count = 0;
        // 실제 회원수 만큼 반복문
        for (int i = 0; i < existMemberNum(); i++) {
            // 검색된 이름과 같으면 임시배열에 넣기
            if(name.equals(m[i].getName())) {
                temp[count++] = m[i];
            }
        }

        // 이름을 가진 멤버 수 만큼의 배열 만들고 넣기
        HealthMember[] returned = new HealthMember[count];
        for (int i = 0; i < returned.length; i++) {
            returned[i] = temp[i];
            returned[i].inform();
        }
        return returned;
    }

    // id 입력시 인덱스 찾아주는 메서드
    public int findIndexById(String id) {
        // 기본 인덱스: 나올수 없는 인덱스로 설정
        int index = -1;
        // 실제 회원수 만큼 반복문
        for (int i = 0; i < existMemberNum(); i++) {
            // 입력아이디와 같은 아이디면 인덱스값 저장
            if (id.equals(m[i].getId())) {
                index = i;
                break;
            }
        }
        // 있다면 저장된 인덱스값 리턴 없으면 -1 리턴
        return index;
    }

    // id 입력시 해당 아이디를 가진 멤버 정보
    public HealthMember searchId(String inputId) {
        // 입력한 아이디의 인덱스 값
        int index = findIndexById(inputId);
        // 아이디가 있다면 그 멤버 정보 리턴 없으면 null 리턴
        return (index != -1) ? m[index] : null;
    }

    // 멤버 배열 전체 출력
    public HealthMember[] printAll() {
        return m;
    }

    // 멤버 추가
    public void insertMember(int num, String name, char gender, int age, String job, int start, int month) {
        // 실제 멤버수
        int idx = existMemberNum();
        // 마지막 멤버 다음 자리에 넣기
        m[idx] = new HealthMember( num,  name, gender, age, job, start, month);
    }

    // 멤버 정보 수정

    //이름 수정
    public boolean updateName(String name ,String id, String newName) {
        for (HealthMember healthMember : m) {
            if(healthMember == null) break;
            // 입력 이름이 있다면 입력한 이름으로 바꾸기
            if (searchName(name).length == 1) {
                healthMember.setName(newName);
                return true;
            }
            // 같은 이름인 멤버가 있으면
            else {
                if (id.equals(healthMember.getId())) {
                    healthMember.setName(newName);
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    //성별 수정
    public boolean updateGender(String name, String id, char newGender) {

        for (HealthMember healthMember : m) {
            if(healthMember == null) break;
            // 입력 이름이 있다면 입력한 이름으로 바꾸기
            if (searchName(name).length == 1) {
                healthMember.setGender(newGender);
                return true;
            }
            // 같은 이름인 멤버가 있으면
            else {
                if (id.equals(healthMember.getId())) {
                    healthMember.setGender(newGender);
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    // 나이 수정
    public boolean updateAge(String name, String id, int newAge) {
        for (HealthMember healthMember : m) {
            if(healthMember == null) break;
            // 입력 이름이 있다면 입력한 이름으로 바꾸기
            if (searchName(name).length == 1) {
                healthMember.setAge(newAge);
                return true;
            }
            // 같은 이름인 멤버가 있으면
            else {
                if (id.equals(healthMember.getId())) {
                    healthMember.setAge(newAge);
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    // 직업 수정
    public boolean updateJob(String name, String id, String  newJob) {
        for (HealthMember healthMember : m) {
            if(healthMember == null) break;
            // 입력 이름이 있다면 입력한 이름으로 바꾸기
            if (searchName(name).length == 1) {
                healthMember.setJob(newJob);
                return true;
            }
            // 같은 이름인 멤버가 있으면
            else {
                if (id.equals(healthMember.getId())) {
                    healthMember.setJob(newJob);
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    // 시작일 수정
    public boolean updateStart(String name, String id, int newDay) {
        for (HealthMember healthMember : m) {
            if(healthMember == null) break;
            // 입력 이름이 있다면 입력한 이름으로 바꾸기
            if (searchName(name).length == 1) {
                healthMember.setStart(newDay);
                return true;
            }
            // 같은 이름인 멤버가 있으면
            else {
                if (id.equals(healthMember.getId())) {
                    healthMember.setStart(newDay);
                    return true;
                }
                return false;
            }
        }
        return false;
    }


    // 멤버 삭제
    public boolean delete(String name, String id) {
        // 입력한 아이디의 인덱스
        int idx = findIndexById(id);
        // 실제 멤버 수
        int max = existMemberNum();
        if(idx != -1) {
            // 삭제할 멤버 뒤의 멤버들을 앞으로 한칸씩 당기기
            for (int i = idx; i < max - 1; i++) {
                m[i] = m[i + 1];
            }
            // 마지막 멤버 값을 null로 변경
            m[max-1] = null;
            return true;
        }
        return false;
    }

    // 락커 자리 남은 갯수
    public int lockerNum() {
        int count = SIZE;
        for (HealthMember healthMember : m) {
            if(healthMember == null) break;
            if (healthMember.getLocker() != 0) {
                count--;
            }
        }
        return count;
    }

    /*
     락커 번호 리스트
    public int[] lockerList() {
        int[] list = new int[lockerNum()];
        int count = 0;

        for (HealthMember healthMember : m) {
            if (healthMember.getLocker() == 0) {
                String id = healthMember.getId();
                list[count++] = findIndexById(id);
            } else if (healthMember == null) {

            }
        }

        for (int i = 0; i < SIZE; i++) {
            if (m[i].getLocker() == 0 || m[i] == null) {
                list[count++] = i+1;
            }
        }
        return list;
    }

    */

    // 락커 등록
    public boolean lockerInsert(String name, String id, int lockerNum) {
        for (HealthMember healthMember : m) {
            if(healthMember == null) break;
            // 입력 이름이 있다면 입력한 락커번호로 바꾸기
            if(name.equals(healthMember.getName())) {
                // 같은 이름인 멤버가 없으면
                if (searchName(name).length == 1) {
                    healthMember.setLocker(lockerNum);
                    return true;
                }
                // 같은 이름인 멤버가 있으면
                else {
                    if (id.equals(healthMember.getId())) {
                        healthMember.setLocker(lockerNum);
                        return true;
                    }
                    return false;
                }
            }
        }
        return false;
    }

    // 락커 삭제


}
