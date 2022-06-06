package com.kh.miniProject3.health.view;

import com.kh.miniProject3.health.controller.TrainerController;
import com.kh.miniProject3.health.model.vo.Trainer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TrainerMenu {

    Common com ;
    private TrainerController tc = new TrainerController();

    // 4. 직원 메뉴
    public void trainerManagement() {

        com = new Common();
        System.out.println("============== 직원 관리 ==============");
        System.out.println("\n# 1. 직원등록");
        System.out.println("# 2. 직원삭제");
        System.out.println("# 3. 직원정보");
        System.out.println("# 4. 급여조회");
        System.out.println("# 5. 근태관리");
        System.out.println("# 0. 메인으로 돌아가기");

        int menu = com.inputInt("- # 메뉴 입력: ");
        switch (menu) {
            case 1:
                insertTrainer();
                break;
            case 2:
                deleteTrainer();
                break;
            case 3:
                informationTrainer();
                break;
            case 4:
                managementPayroll();
                break;
            case 5:
                checkManagement();
                break;
            case 0:
                return;
            default:
                System.out.println("메뉴를 잘못 입력했습니다.");
        }
    }

    // 4-1. 직원등록
    private void insertTrainer() {

        if(tc.checkFull())
        {
            System.out.println("# 트레이너 정보 입력 갯수가 초과되었습니다.");
            return;
        }

        System.out.println("\n# 새 트레이너를 등록합니다");

        String name = com.inputStr("이름: ");
        int age = com.inputInt("나이: ");
        String number = com.inputStr("휴대폰 번호: ");
        int career = com.inputInt("경력: ");
        int timePay = com.inputInt("시급 : ");
        tc.insertTrainer(name, age, number, career, timePay);

        System.out.println("\n# 트레이너등록 성공!");
    }
    // 4-2. 직원삭제
    private void deleteTrainer() {

        String targetName = com.inputStr("\n 삭제 대상 트레이너:");

        tc.delete(targetName);
        System.out.printf("[%s]트레이너님의 데이터가 삭제되었습니다", targetName);
    }
    // 4-3. 직원조회
    public void informationTrainer() {

        Trainer[] Trainers = tc.printAll();

        System.out.println("\n===== 트레이너 정보 =====");
        for (Trainer t : Trainers) {
            if (t == null) break; // null이면 에러뜸
            t.inform(); //
        }

    }

    //4-4. 급여조회
    public void managementPayroll()
    {
        String name = com.inputStr(" - 이름 : ");
        Trainer[] trainer = tc.searchName(name);
        System.out.printf("%s님의 현재 급여는 %d원 입니다.",trainer[0].getName(),trainer[0].getPay());
    }


        //4-5 근태관리
    public void checkManagement()
    {
        System.out.println("============= 근태관리 ==============");
        System.out.println(" # 1. 출근 ");
        System.out.println(" # 2. 퇴근 ");
        System.out.println(" # 0. 이전으로 가기 ");

        int input = com.inputInt(" # 메뉴 입력 : ");
        switch (input)
        {
            case 1 : checkIn();break;
            case 2 : checkOut();break;
            case 0 : break;
        }
    }

    // 출근
    public void checkIn()
    {
        String name = com.inputStr(" - 이름 : ");
        Trainer[] trainer = tc.searchName(name);
        System.out.println(tc.checkIn(trainer[0]));
    }

    //퇴근
    public void checkOut()
    {
        String name = com.inputStr(" - 이름 : ");
        Trainer[] trainer = tc.searchName(name);
        System.out.println( tc.checkOut(trainer[0]));
        tc.calculatePay(trainer[0]);
    }
}
