package com.kh.miniProject3.health.view;

import com.kh.miniProject3.health.controller.ConsultMemberController;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ConsultApplyMenu {
    private Scanner sc = new Scanner(System.in);
    private ConsultMemberController cc = new ConsultMemberController();

    public void consultMemberManagement() throws FileNotFoundException {
        System.out.println(" ===================== 상담관리 ======================= ");
        String[] consultMenu = {"# 1. 상담등록", "# 0. 프로그램 종료"};

        for (String menuStr : consultMenu) {
            System.out.println(menuStr);
        }

        int input = inputInt(" 메뉴 입력 : ");

        switch (input) {
            case 1:
                inputConsult();
                break; // 상담등록
            case 0:
                break;
        }

    }

    private void inputConsult() {
        String name = inputStr(" - 이름 : ");
        int age = inputInt(" - 나이 : ");
        char gender = ' ';
        while (true) {
            gender = inputStr(" - 성별(남/여) : ").charAt(0);
            if (gender == '남' || gender == '여') {
                break;
            } else
                System.out.println("다시 입력해주세요.");
        }
        String phoneNumber = inputStr(" - 휴대폰번호 : ");
        int consultDay = inputInt(" - 상담날짜(ex:20220101) : ");

        cc.inputConsultMember(name, age, gender, phoneNumber, consultDay);
    }


    public int inputInt(String arg) {
        System.out.print(arg);
        int z = -1;
        while (true) {
            try {
                z = sc.nextInt();
                return z;
            } catch (java.util.InputMismatchException e) {
                System.out.print("다시 입력해주세요 \n 메뉴 입력 : ");
                sc.nextLine(); // 이거 무한루프
            }
        }
    }

    public String inputStr(String arg) {
        System.out.print(arg);
        return sc.next();
    }

}
