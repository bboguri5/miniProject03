package com.kh.miniProject3.health.view;

import com.kh.miniProject3.health.controller.TrainerController;
import com.kh.miniProject3.health.model.vo.Trainer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TrainerMenu {

    private Scanner sc = new Scanner(System.in);
    private TrainerController tc = new TrainerController();

    // 4번
    public void trainerManagement() {

        System.out.println("\n# 1. 직원등록");
        System.out.println("# 2. 직원삭제");
        System.out.println("# 3. 직원정보");
        System.out.println("# 4. 급여관리");
        System.out.println("# 5. 근태관리");
        System.out.println("# 0. 메인으로 돌아가기");

        int menu = inputNumber("- 메뉴 입력: ");
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

    // 4-1
    private void insertTrainer() {

        System.out.println("\n# 새 트레이너를 등록합니다");

        String name = inputStr("이름: ");
        int age = inputNumber("나이: ");
        String number = inputStr("휴대폰 번호: ");
        int career = inputNumber("경력: ");
        int timePay = inputNumber("시급 : ");
        tc.insertTrainer(name, age, number, career, timePay);

        System.out.println("\n# 트레이너등록 성공!");
    }
    // 4-2
    private void deleteTrainer() {

        String targetName = inputStr("\n 삭제 대상 트레이너:");

        tc.delete(targetName);
        System.out.printf("[%s]트레이너님의 데이터가 삭제되었습니다", targetName);
    }
    // 4-3
    public void informationTrainer() {

        Trainer[] Trainers = tc.printAll();

        System.out.println("\n===== 트레이너 정보 =====");
        for (Trainer t : Trainers) {
            if (t == null) break; // null이면 에러뜸
            t.inform(); //
        }

    }

    //4-4
    public void managementPayroll()
    {
        String name = inputStr(" - 이름 : ");
        Trainer[] trainer = tc.searchName(name);
        System.out.printf("%s님의 현재 급여는 %d원 입니다.",trainer[0].getName(),trainer[0].getPay());
    }


        //4-5
    public void checkManagement()
    {
        System.out.println("============= 근태관리 ==============");
        System.out.println(" # 1. 출근 ");
        System.out.println(" # 2. 퇴근 ");
        System.out.println(" # 0. 이전으로 가기 ");

        int input = inputNumber(" 메뉴 입력 : ");
        switch (input)
        {
            case 1 : checkIn();break;
            case 2 : checkOut();break;
            case 0 : break;
        }
    }

    public void checkIn()
    {
        String name = inputStr(" - 이름 : ");
        Trainer[] trainer = tc.searchName(name);
        System.out.println(tc.checkIn(trainer[0]));
    }

    public void checkOut()
    {
        String name = inputStr(" - 이름 : ");
        Trainer[] trainer = tc.searchName(name);
        System.out.println( tc.checkOut(trainer[0]));
        tc.calculatePay(trainer[0]);
    }



    private String inputStr(String msg) {
        System.out.printf(msg);
        return sc.next();
    }

    private int inputNumber(String msg) {
        System.out.printf(msg);
        return sc.nextInt();
    }



}
