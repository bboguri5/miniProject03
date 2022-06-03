package com.kh.hw.miniProject3.view;

import com.kh.hw.miniProject3.controller.TrainerController;
import com.kh.hw.miniProject3.model.vo.Trainer;

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
        System.out.println("# 5. 출퇴근기록");
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
//                managementPayroll();
                break;
            case 5:
//                recordCommuting
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
        String number = inputStr("번호: ");
        String career = inputStr("경력: ");

        tc.insertTrainer(name, age, number, career);

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

    private String inputStr(String msg) {
        System.out.printf(msg);
        return sc.next();
    }

    private int inputNumber(String msg) {
        System.out.printf(msg);
        return sc.nextInt();
    }

}
