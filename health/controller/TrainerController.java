package com.kh.miniProject3.health.controller;

import com.kh.miniProject3.health.model.vo.Trainer;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TrainerController {

    private Trainer[] t = new Trainer[SIZE];

    public static final int SIZE = 5;

    public TrainerController() {
        t[0] = new Trainer("김철수", 26, "01012345678", 3, 15000, 5, 750000);
        t[1] = new Trainer("김홍수", 31, "01043215678", 6, 20000, 20, 6000000);
        t[2] = new Trainer("김남수", 36, "01056781234", 10, 25000, 10, 2500000);
        t[3] = new Trainer("황정아", 36, "01056781234", 10, 25000, 15, 3750000);
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
    public void insertTrainer(String name, int age, String number, int carrer, int timePay) {
        int count = existTrainerNum();
        t[count] = new Trainer(name, age, number, carrer, timePay, 0, 0);
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
        int index = -1;
        index = findIndexByName(name);
        if (index != -1) {
            for (int i = 0; i < existTrainerNum() - 1; i++) {
                t[i] = t[i + 1];
            }
            //기존 마지막 트레이너 주소를 null로 변경
            t[existTrainerNum() - 1] = null;
            return true;
        }
        return false;
    }

    // 트레이너 정보
    public Trainer[] printAll() {
        return t;
    }

    public String checkIn(Trainer trainer) {
        SimpleDateFormat simdate = new SimpleDateFormat("HHmm");
        Date date = new Date();
        trainer.setGoToWork(simdate.format(date));
        return trainer.getGoToWork();
    }

    public String checkOut(Trainer trainer) {
        SimpleDateFormat simdate = new SimpleDateFormat("HHmm");
        Date date = new Date();
        trainer.setLeaveWork(simdate.format(date));

        int count = trainer.getWorkDays();
        trainer.setWorkDays(++count);
    return trainer.getLeaveWork();
    }


    public void calculatePay(Trainer trainer)
    {
        int total = 0;
        int gotowork = Integer.parseInt(trainer.getGoToWork());
        int leavework = Integer.parseInt(trainer.getLeaveWork());
        int workTime = leavework / 100 - gotowork / 100;
        int todayPay = workTime * trainer.getTimePay();
        total = todayPay + trainer.getPay();
        trainer.setPay(total);

        trainer.setGoToWork(null);
        trainer.setLeaveWork(null);
    }

}
