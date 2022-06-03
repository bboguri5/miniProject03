package com.kh.hw.miniProject3.controller;

import com.kh.hw.miniProject3.model.vo.Trainer;

public class TrainerController {

    private Trainer[] t = new Trainer[SIZE];

    public static final int SIZE = 5;

    public TrainerController (){
        t[0] = new Trainer("김철수", 26, "01012345678", "3년");
        t[1] = new Trainer("김홍수", 31, "01043215678", "6년");
        t[2] = new Trainer("김남수", 36, "01056781234", "10년");
    }
    // 직원수를 세어준다
    public int existTrainerNum() {
        int count = 0;
        for (int i = 0; i < 10; i++) {
            if (t[i] == null) {
                break;
            }
            count++;
        }
        return count;
    }
    // 회원정보 저장한다
    public void insertTrainer(String name, int age, String number, String carrer) {
        int count = existTrainerNum();
        t[count] = new Trainer(name, age, number, carrer);
    }
    //회원이름찾기
    public Trainer[] searchName(String name) {

        // 임시 배열 생성
        Trainer[] temp = new Trainer[SIZE];
        int count = 0;
        for (int i = 0; i < existTrainerNum(); i++) {
            if (name.equals(t[i].getName())) {
                temp[count++] = t[i];
            }
        }
        // 리턴할 배열
        Trainer[] returned = new Trainer[count];
        for (int i = 0; i < returned.length; i++) {
            returned[i] = temp[i];
        }
        return returned;
    }
    // 이름를 통해 트레이너의 인덱스를 알려줌
    public int findIndexByName(String name) {
        int index = -1;
        for (int i = 0; i < existTrainerNum(); i++) {
            if (name.equals(t[i].getName())) {
                index = i;
                break;
            }
        }
        return index;
    }
    // 이름을 입력하면 트레이너 삭제
    public boolean delete(String name) {
        int index= -1;
        index = findIndexByName(name);
        if (index != -1) {
            for (int i = 0; i < existTrainerNum() - 1; i++) {
                t[i] = t[i + 1];
            }
            //기존 마지막 트레이너 주소를 null로 변경
            t[existTrainerNum()-1] = null;
            return true;
        }
        return false;
    }
    // 트레이너 정보
    public Trainer[] printAll() {
        return t;
    }

}
