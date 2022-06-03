package com.kh.miniProject3.health.view;

import com.kh.hw.member.model.vo.Member;
import com.kh.miniProject3.health.controller.HealthMemberController;
import com.kh.miniProject3.health.model.HealthMember;

import java.util.Scanner;

public class HealthMemberMenu {

    Scanner sc = new Scanner(System.in);
    private HealthMemberController mc = new HealthMemberController();

    // 메인 메뉴 출력

    public void mainMenu() {

        while (true) {

            System.out.println("OOO헬스장");

            System.out.println("# 1. 회원 관리");
            System.out.println("# 2. 락커 관리");
            System.out.println("# 3. 모든 회원 정보");
            System.out.println("# 9. 프로그램 종료");

            System.out.print("\n# 메뉴 번호: ");
            int menu = sc.nextInt();


            switch (menu) {

                case 1 :  // 회원 관리
                    memberManage();
                    break;
                case 2 :  // 락커 관리
                    locker();
                    break;
                case 3 :  // 모든 회원 정보
                    printAll();
                    break;
                case 9 :  // 프로그램 종료
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0); // 프로세스 종료
                    break;
                default:
                    System.out.println("잘못 입력했습니다. 다시 입력하세요!");

            }
        }
    }

    private void locker() {
        
    }

    private void printAll() {
        HealthMember[] members = mc.printAll();

        System.out.println("\n========== 전체 회원 정보 =============");
        for (HealthMember m : members) {
            if (m == null) break;
            m.inform();
        }
    }

    // 멤버 관리
    private void memberManage() {

        System.out.println("\n# 1. 회원 정보 등록");
        System.out.println("\n# 2. 회원 정보 수정");
        System.out.println("\n# 3. 회원 정보 검색");
        System.out.println("\n# 4. 회원 탈퇴");
        System.out.println("# 9. 메인으로 돌아가기");

        int menu = inputNumber("- 메뉴 입력: ");

        switch (menu) {
            case 1 :
                insert();
                break;
            case 2 :
                update();
                break;
            case 3 :
                search();
                break;
            case 4 :
                delete();
                break;
            case 9 :
                return;
            default:
                System.out.println("메뉴를 잘못 입력했습니다.");
        }
    }

    private void delete() {
        String targetName = inputStr("\n# 삭제 대상 이름:");
        String targetId = inputStr("\n# 삭제 대상 아이디:");

        if (mc.findIndexById(targetId) != -1) {
            System.out.println("\n# 회원 정보가 삭제됩니다. [Y/N]");
            String answer = inputStr(">> ");

            switch (answer.toUpperCase().charAt(0)) {
                case 'Y': case 'ㅛ':
                    mc.delete(targetName, targetId);
                    System.out.printf("\n- [%s]멤버님의 데이터가 삭제되었습니다.\n", targetId);
                    break;
                case 'N': case 'ㅜ':
                    System.out.println("\n- 삭제를 취소합니다.");
                    break;
            }

        }
    }

    private void search() {

        System.out.printf("저장되어 있는 멤버 수: %d", mc.existMemberNum());

        String targetName = inputStr("- 조회할 이름: ");
        HealthMember[] members = mc.searchName(targetName);
        if (members.length > 0) {
            System.out.println("\n=========== 검색된 멤버 정보 ============");
            for (HealthMember m : members) {
                m.inform();
            }
        } else {
            System.out.println("\n- 존재하는 멤버가 아닙니다.");
        }
    }

    private void update() {

        System.out.println("\n# 1. 회원 이름 수정");
        System.out.println("\n# 2. 회원 나이 수정");
        System.out.println("\n# 3. 회원 성별 수정");
        System.out.println("\n# 4. 회원 직업 수정");
        System.out.println("\n# 5. 회원등록 시작날짜 수정");
        System.out.println("\n# 9. 메인으로 돌아가기");

        int menu = inputNumber("- 메뉴 입력: ");

        switch (menu) {
            case 1 :
                updateName();
                break;
            case 2 :
                updateAge();
                break;
            case 3 :
                updateGender();
                break;
            case 4 :
                updateJob();
                break;
            case 5 :
                updateStart();
                break;
            case 9 :
                break;
            default:
                System.out.println("메뉴를 잘못 입력했습니다.");
        }
    }

    private void updateStart() {
        String id = inputStr("- 아이디: ");
        int newDay = inputNumber("- 수정할 날짜: ");

        if (mc.updateStart(id, newDay)) {
            System.out.println("\n날짜 수정 완료!");
        } else {
            System.out.println("\n수정 실패!");
        }
    }

    private void updateJob() {
        String id = inputStr("- 아이디: ");
        String  newJob = inputStr("- 수정할 직업: ");

        if (mc.updateJob(id, newJob)) {
            System.out.println("\n직업 수정 완료!");
        } else {
            System.out.println("\n수정 실패!");
        }
    }

    private void updateGender() {
        String id = inputStr("- 아이디: ");
        char newGender = inputStr("- 수정할 성별(M/F): ").toUpperCase().charAt(0);

        if (mc.updateGender(id, newGender)) {
            System.out.println("\n성별 수정 완료!");
        } else {
            System.out.println("\n수정 실패!");
        }
    }

    private void updateAge() {
        String id = inputStr("- 아이디: ");
        int newAge = inputNumber("- 수정할 나이: ");

        if (mc.updateAge(id, newAge)) {
            System.out.println("\n나이 수정 완료!");
        } else {
            System.out.println("\n수정 실패!");
        }
    }

    private void updateName() {
        String id = inputStr("- 아이디: ");
        String newName = inputStr("- 수정할 이름: ");

        if (mc.updateName(id, newName)) {
            System.out.println("\n이름 수정 완료!");
        } else {
            System.out.println("\n수정 실패!");
        }

    }

    private void insert() {

        int id = inputNumber("- id: ");
        String name = inputStr("- 이름: ");
        char gender = inputStr("- 성별(M/F): ").toUpperCase().charAt(0);
        int age = inputNumber("- 나이: ");
        String job = inputStr("- 직업: ");
        int start = inputNumber("- 시작 날짜: ");
        int month = inputNumber("- 개월 수: ");

        mc.insertMember(id,  name, gender, age, job, start, month);

        System.out.println("회원 등록 완료");
    }


    // 입력처리를 간단하게 만드는 메서드
    private String inputStr(String msg) {
        System.out.printf(msg);
        return sc.next();
    }
    private int inputNumber(String msg) {
        System.out.printf(msg);
        return sc.nextInt();
    }

}
