package com.kh.miniProject3.health.view;


import com.kh.miniProject3.health.controller.CustomerClientController;
import com.kh.miniProject3.health.controller.HealthMemberController;
import com.kh.miniProject3.health.model.vo.CustomerClient;
import com.kh.miniProject3.health.model.vo.HealthMember;
import com.kh.miniProject3.health.run.Test;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class HealthMenu {
    Scanner sc = new Scanner(System.in);

    HealthMemberController hmc;
    TrainerMenu tm;

    CustomerClientController ccc ;

    public HealthMenu() {

        hmc = new HealthMemberController();
        tm = new TrainerMenu();
        ccc = new CustomerClientController();
    }

    public void mainMenu() {

        System.out.println(" ================ 3 조 헬스장 관리 프로그램 ================ ");
        System.out.printf(" # 현재 보유 회원은 %d명 입니다 \n", hmc.existHealthMemberNum());

        while (true) {
            System.out.println(" ===================== Main Menu ===================== ");
            String[] mainmenu = {"# 1. 회원관리", "# 2. 직원관리","# 3. 상담관리 ","# 4. 매출현황", "# 0. 프로그램 종료"};

            for (String menuStr : mainmenu) {
                System.out.println(menuStr);
            }

            
            int input = inputInt(" 메뉴 입력 : ");

            switch (input) {
                case 1:
                    administerMember();
                    break; // 1. 회원관리
                case 2:
                    tm.trainerManagement();
                    break; // 2. 직원관리
                case 3:
                    administerConsulting(); // 3. 상담관리
                    break;
                case 4:
                    // 매출현황
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                default:
                    System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
            }
        }
    }


    //region 회원관리 및 회원수정
    public void administerMember() {
        String[] memberManagerMenu = {"# 1. 회원등록", "# 2. 회원수정", "# 3. 회원검색", "# 4. 회원탈퇴","# 0. 메인메뉴로 돌아가기"};

            System.out.println(" ===================== 회원관리 ===================== ");

            for (String menuStr : memberManagerMenu) {
                System.out.println(menuStr);
            }
            int input = inputInt(" 메뉴 입력 : ");

            switch (input) {
                case 1:
                    insertMember();
                    break;
                case 2:
                    updateMember();
                    break;
                case 3:
                    searchMember();
                    break;
                case 4:
                    deleteMember();
                    break;
                case 5:
                    //락커정보()
                case 0:
                    break;
                default:
                    System.out.println("잘못 입력되었습니다. 다시 입력해주세요.");
            }
    }

    public void updateMember() {

        String str = "";
        HealthMember hm = getTarget();

        if (hm == null)
            return;

        while (true) {
            System.out.println(" ===================== 회원수정 ===================== ");
            String[] updateMembers = {"1. 이름 수정", "2. 나이 수정", "3. 성별 수정", "4. 직업 수정", "5. 시작날짜 수정", "6. 개월수 수정", "0. 이전으로 가기"};

            for (String menuStr : updateMembers) {
                System.out.println(menuStr);
            }

            int input = inputInt(" 메뉴 입력 : ");

            switch (input) {
                case 1:
                    str = updateName(hm);
                    break;
                case 2:
                    str = updateAge(hm);
                    break;
                case 3:
                    str = updateGender(hm);
                    break;
                case 4:
                    str = updateJob(hm);
                    break;
                case 5:
                    str = updateStart(hm);
                    break;
                case 6:
                    str = updateMonth(hm);
                    break;
                case 0:
                    return;
            }
            System.out.println("수정 결과 : " + str);
        }
    }
    //endregion 회원관리


    //region 상담관리
    public void administerConsulting()
    {
        String[] consultingMembers = {"# 1. 상담 등록", "# 2. 상담 조회", "# 0. 이전으로 가기"};
        for(String m : consultingMembers)
        {
            System.out.println(m);
        }

        int input = inputInt(" 메뉴 입력 : ");
        switch (input)
        {
            case 1 :
                insertCustomerClient(); // 상담 등록
                break;
            case 2 :
                printCustomerClients();
                break;
            case 0 : break;
        }
    }

    public void insertCustomerClient()
    {
        ccc.insertCustomerClient();
    }
    public void printCustomerClients()
    {
        for(CustomerClient c : ccc.printAll())
        {
            System.out.println(c.inform());
        }
    }
    //endregion 상담관리

    public void printAll() {
        System.out.println();
        System.out.println("==================================== 전체 회원 정보 ==================================== ");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
        for (HealthMember m : hmc.printAll()) {
            System.out.println(m.inform());
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
        System.out.println();

    }

    public void insertMember() {
        String name = inputStr(" - 이름 : ");
        char gender = ' ';
        while (true) {
            gender = inputStr(" - 수정 할 성별(남/여) : ").charAt(0);
            if (gender == '남' || gender == '여') {
                break;
            } else
                System.out.println("다시 입력해주세요.");
        }
        int age = inputInt(" - 나이 : ");
        String job = inputStr(" - 직업 : ");
        int start = inputInt(" - 시작날짜 : ");
        int month = 0;
        while(true){
            month = inputInt(" - 수강개월 : ");
            if(month <= 12 )
                break;
        }
        hmc.insertMember(name, gender, age, job, start, month * 100);
    }

    public void searchMember() {

        System.out.println(" ===================== 회원검색 ===================== ");
        System.out.println(" 1. 이름으로 검색");
        System.out.println(" 2. 고객코드로 검색");
        System.out.println(" 0. 이전으로 가기");

        int input = inputInt("메뉴 입력 : ");

        switch (input) {
            case 1:
                searchName();
                break;
            case 2:
                searchId();
                break;
            default:
                break;
        }
    }

    public void searchName() {
        for (HealthMember m : hmc.searchName(inputStr(" - 이름 : "))) {
            System.out.println(m.inform());
        }
    }

    public void searchId() {
        System.out.println(hmc.searchId(inputStr(" - 아이디 : ")).inform());
    }

    private String updateName(HealthMember hm) {
        return hmc.updateName(hm, inputStr(" - 수정 할 이름 : ")) ? hm.inform() : "수정이 실패하였습니다.";
    }

    private String updateAge(HealthMember hm) {
        return hmc.updateAge(hm, inputInt(" - 수정 할 나이 : ")) ? hm.inform() : "수정이 실패하였습니다.";
    }

    private String updateGender(HealthMember hm) {
        while (true) {
            char newGender = inputStr(" - 수정 할 성별(남/여) : ").charAt(0);
            if (newGender == '남' || newGender == '여') {
                return hmc.updateGender(hm, newGender) ? hm.inform() : "수정이 실패하였습니다.";
            } else
                System.out.println("다시 입력해주세요.");
        }
    }

    private String updateJob(HealthMember hm) {
        return hmc.updateJob(hm, inputStr(" - 수정 할 직업 : ")) ? hm.inform() : "수정이 실패하였습니다.";
    }

    private String updateStart(HealthMember hm) {
        return hmc.updateStart(hm, inputInt(" - 수정 할 시작날짜 : ")) ? hm.inform() : "수정이 실패하였습니다.";
    }

    private String updateMonth(HealthMember hm) {
        return hmc.updateMonth(hm, inputInt(" - 수정 할 개월수 : ")) ? hm.inform() : "수정이 실패하였습니다.";
    }

    public String getId() {
        String name = "";
        String id = "";
        name = inputStr(" - 이름 : ");
        HealthMember[] members = hmc.searchName(name);
        if (members.length == 0) {
            System.out.println("존재하지 않는 이름입니다. 다시 입력해주세요.");
            return "";
        } else if (members.length > 1) {
            for (HealthMember m : members) {
                System.out.println(m.inform());
            }
            id = inputStr(" - 아이디 : ");

            if (hmc.findIndexById(id) < 0) {
                System.out.println("존재하지 않는 코드입니다. 다시 입력해주세요.");
                return "";
            }
            return id;
        }
        return members[0].getId();
    }

    public HealthMember getTarget() {
        String id = getId();
        if (id.length() == 0)
            return null;

        return hmc.searchId(id);
    }

    public void deleteMember() {
        HealthMember hm = getTarget();
        if (hm == null)
            return;
        hmc.deleteOne(hm.getId());
        printAll();
    }

    public void administrateLocker() {

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
