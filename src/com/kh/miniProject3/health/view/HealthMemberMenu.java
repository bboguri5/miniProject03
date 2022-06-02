package com.kh.miniProject3.health.view;

import com.kh.miniProject3.health.controller.HealthMemberController;
import com.kh.miniProject3.health.model.vo.HealthMember;

import java.lang.reflect.Member;
import java.util.Scanner;

public class HealthMemberMenu {
    Scanner sc = new Scanner(System.in);
    HealthMemberController hmc;

    public HealthMemberMenu() {
        hmc = new HealthMemberController();
    }

    public void mainMenu()
    {

        System.out.println(" ================ 3 조 헬스장 시스템 ================ ");
        System.out.printf(" ============= 현재 보유 회원은 %d명 입니다 =============\n",hmc.existHealthMemberNum());

        while (true){
        System.out.println(" ===================== Main Menu ===================== ");
        String[] mainmenu = {"1. 회원관리", "2. 락커정보" , "3. 모든회원정보", "0. 프로그램 종료"};

        for(String menuStr : mainmenu)
        {
            System.out.println(menuStr);
        }

        int input = inputInt(" 메뉴 입력 : ");

        switch (input)
        {
            case 1 : administrateMember(); break; // 1. 회원관리
            case 2 : administrateLocker(); break; // 2. 락커정보
            case 3 : printAll(); break; // 3. 모든회원정보
            case 0 : System.exit(0);
            default:
                System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
        }
        }
    }

    public int inputInt(String arg)
    {
        System.out.print(arg);
        return sc.nextInt();
    }

    public String inputStr(String arg)
    {
        System.out.print(arg);
        return sc.next();
    }

    public void administrateMember()
    {
        System.out.println(" ===================== 회원관리 ===================== ");
        String[] memberManagerMenu = {"1. 회원등록", "2. 회원수정" , "3. 회원검색", "4. 회원탈퇴","0. 메인메뉴로 돌아가기"};

        for(String menuStr : memberManagerMenu)
        {
            System.out.println(menuStr);
        }

        int input = inputInt( " 메뉴 입력 : ");
        switch (input)
        {
            case 1 : insertMember(); break;
            case 2 : updateMember(); break;
            case 3 : searchMember(); break;
            case 4 : deleteMember(); break;
            case 0 : break;
            default:
                System.out.println("잘못 입력되었습니다. 다시 입력해주세요.");
        }
    }

    public void administrateLocker()
    {

    }

    public void printAll()
    {
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
        for(HealthMember m : hmc.printAll())
        {
            m.inform();
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
        System.out.println();

    }

    public void insertMember() {
        String name = inputStr(" - 이름 : ");
        char gender = inputStr(" - 성별 : ").charAt(0);
        int age = inputInt(" - 나이 : ");
        String job = inputStr(" - 직업 : ");
        int start = inputInt(" - 시작날짜 : ");
        int month = inputInt(" - 수강개월 : ");

        hmc.insertMember(name,gender,age,job,start,month);
    }

    public void searchMember() {

        System.out.println(" ===================== 회원검색 ===================== ");
        System.out.println(" 1. 이름 검색");
        System.out.println(" 2. 고객코드 검색");

        int input = inputInt("메뉴 입력 : ");
    }

    public void searchName() {

    }

    public void searchId() {

    }

    public void updateMember() {

        System.out.println(" ===================== 회원수정 ===================== ");
        String[] updateMembers = {"1. 이름 수정", "2. 나이 수정", "3. 성별 수정", "4. 직업 수정", "5. 시작날짜 수정", "6. 개월수 수정", "0. 이전으로 가기", "메인으로 가기(메뉴 제외하고 아무숫자 입력해주세요)"};

        for(String menuStr : updateMembers)
        {
            System.out.println(menuStr);
        }

        int input = inputInt(" 메뉴 입력 : ");
        switch (input)
        {
            case 1 :
        }


    }

    public void updateName() {

    }

    public void updateGender() {

    }

    public void updateAge() {

    }

    public void updateJob() {

    }

    public void updateStart() {

    }

    public void deleteMember() {

    }

    public void deleteOne() {

    }


}
