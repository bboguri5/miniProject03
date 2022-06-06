package com.kh.miniProject3.health.view;


import com.kh.miniProject3.health.controller.CustomerClientController;
import com.kh.miniProject3.health.controller.HealthMemberController;
import com.kh.miniProject3.health.model.vo.CustomerClient;
import com.kh.miniProject3.health.model.vo.HealthMember;


public class HealthMenu {
    HealthMemberController hmc;
    TrainerMenu tm;
    Common com ;
    CustomerClientController ccc ;

    public HealthMenu() {

        com = new Common();
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

            int input = com.inputInt(" # 메뉴 입력 : ");

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
                    salesStatus(); // 4. 매출현황
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                default:
                    System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
            }
        }
    }
    //region 1. 회원관리
    public void administerMember() {
        String[] memberManagerMenu = {"# 1. 회원등록", "# 2. 회원수정", "# 3. 회원검색", "# 4. 회원탈퇴", "# 5. 모든회원조회 " ,"# 6. 락커등록" ,"# 7. 락커조회","# 0. 메인메뉴로 돌아가기"};

        System.out.println(" ===================== 회원관리 ===================== ");

        for (String menuStr : memberManagerMenu) {
            System.out.println(menuStr);
        }
        int input = com.inputInt(" # 메뉴 입력 : ");

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
            case 5: printAllMember();break;
            case 6: insertLockerNum();break;
            case 7: printAllLocker();break;

            case 0:
                break;
            default:
                System.out.println("잘못 입력되었습니다. 다시 입력해주세요.");
        }
    }

    //region 1-1. 회원등록
    public void insertMember() {
        if(hmc.checkFull())
        {
            System.out.println("# 회원 정보 입력 갯수가 초과되었습니다.");
            return;
        }
        String name = com.inputStr(" - 이름 : ");
        char gender = ' ';
        while (true) {
            gender = com.inputStr(" - 수정 할 성별(남/여) : ").charAt(0);
            if (gender == '남' || gender == '여') {
                break;
            } else
                System.out.println("다시 입력해주세요.");
        }
        int age = com.inputInt(" - 나이 : ");
        String job = com.inputStr(" - 직업 : ");
        int start = com.inputInt(" - 시작날짜(ex:20220101) : ");
        int month = 0;
        while(true){
            month = com.inputInt(" - 수강개월 : ");
            if(month <= 12 )
                break;
        }
        hmc.insertMember(name, gender, age, job, start, month * 100);
    }
    //endregion 회원등록
    //region 1-2. 회원수정
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

            int input = com.inputInt(" # 메뉴 입력 : ");

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

    private String updateName(HealthMember hm) {
        return hmc.updateName(hm, com.inputStr(" - 수정 할 이름 : ")) ? hm.inform() : "수정이 실패하였습니다.";
    }

    private String updateAge(HealthMember hm) {
        return hmc.updateAge(hm, com.inputInt(" - 수정 할 나이 : ")) ? hm.inform() : "수정이 실패하였습니다.";
    }

    private String updateGender(HealthMember hm) {
        while (true) {
            char newGender = com.inputStr(" - 수정 할 성별(남/여) : ").charAt(0);
            if (newGender == '남' || newGender == '여') {
                return hmc.updateGender(hm, newGender) ? hm.inform() : "수정이 실패하였습니다.";
            } else
                System.out.println("다시 입력해주세요.");
        }
    }

    private String updateJob(HealthMember hm) {
        return hmc.updateJob(hm, com.inputStr(" - 수정 할 직업 : ")) ? hm.inform() : "수정이 실패하였습니다.";
    }

    private String updateStart(HealthMember hm) {
        return hmc.updateStart(hm, com.inputInt(" - 수정 할 시작날짜 : ")) ? hm.inform() : "수정이 실패하였습니다.";
    }

    private String updateMonth(HealthMember hm) {
        return hmc.updateMonth(hm, com.inputInt(" - 수정 할 개월수 : ")) ? hm.inform() : "수정이 실패하였습니다.";
    }
    //endregion 회원수정
    //region 1-3. 회원검색
    public void searchMember() {

        System.out.println(" ===================== 회원검색 ===================== ");
        System.out.println(" 1. 이름으로 검색");
        System.out.println(" 2. 고객코드로 검색");
        System.out.println(" 0. 이전으로 가기");

        int input = com.inputInt("# 메뉴 입력 : ");

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

    // 이름 검색
    public void searchName() {
        for (HealthMember m : hmc.searchName(com.inputStr(" - 이름 : "))) {
            System.out.println(m.inform());
        }
    }

    // 아이디 검색
    public void searchId() {
        System.out.println(hmc.searchId(com.inputStr(" - 아이디 : ")).inform());
    }
    //endregion 회원검색
    //region 1-4. 회원탈퇴
    public void deleteMember() {
        HealthMember hm = getTarget();
        if (hm == null)
            return;
        hmc.deleteOne(hm.getId());
        printAllMember();
    }
    //endregion 회원탈퇴
    //region 1-5. 모든회원조회
    public void printAllMember() {
        System.out.println();
        System.out.println(" ==================================== 전체 회원 정보 ==================================== ");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
        for (HealthMember m : hmc.printAllMember()) {
            System.out.println(m.inform());
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
        System.out.println();
    }
    //endregion 모든회원조회
    //region 1-6~7. 락커
    public void insertLockerNum()
    {
        String id = getId();
        hmc.insertLockerNum(id);
    }
    public void printAllLocker()
    {
        for(HealthMember m : hmc.printAllLocker())
        {
            System.out.println(m.inform());
        }
    }
    //endregion 락커
    //endregion 회원관리
    //2. 직원관리
    //region 3. 상담관리
    public void administerConsulting()
    {
        System.out.println("============== 상담관리 ==================");
        String[] consultingMembers = {"# 1. 상담 등록", "# 2. 상담 조회", "# 0. 이전으로 가기"};
        for(String m : consultingMembers)
        {
            System.out.println(m);
        }

        int input = com.inputInt(" # 메뉴 입력 : ");
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

    // 상담고객 등록
    public void insertCustomerClient()
    {
        ccc.insertCustomerClient();
    }
    // 전체 상담고객 조회
    public void printCustomerClients()
    {
        for(CustomerClient c : ccc.printAllCustomer())
        {
            System.out.println(c.inform());
        }
    }
    //endregion 상담관리
    //region 4. 매출현황

    private void salesStatus() {

        String[] salesStatusMenu = {"# 1. 월별 매출", "# 2. 이번년도 매출", "# 0. 메인메뉴로 돌아가기"};

        System.out.println(" ===================== 매출현황 ===================== ");

        for (String menuStr : salesStatusMenu) {
            System.out.println(menuStr);
        }
        int input = com.inputInt(" # 메뉴 입력 : ");

        switch (input) {
            case 1 :
                monthStatus();
                break;
            case 2 :
                yearStatus();
                break;
            case 0 :
                break;
        }
    }

    // 연매출
    private  void yearStatus()
    {
        System.out.printf("이번년도 총 매출액 : %s 원", hmc.yearStatus());
        System.out.println();
    }
    // 월매출
    private void monthStatus() {
        String[] monthStatus = {" ", "1월 : ", "2월 : ", "3월 : ", "4월 : ", "5월 : ", "6월 : ", "7월 : ", "8월 : ", "9월 : ", "10월 : ", "11월 : ", "12월 : ", };
        int[] a = hmc.lastMonth();
        for (int i = 1; i <= 12; i++) {
            System.out.printf(" %s %d 원", monthStatus[i], a[i]);
            System.out.println();
        }
    }
   //endregion 매출현황
    // 유효한 아이디 추출
    public String getId() {
        String name = "";
        String id = "";
        name = com.inputStr(" - 이름 : ");
        HealthMember[] members = hmc.searchName(name);
        if (members.length == 0) {
            System.out.println("존재하지 않는 이름입니다. 다시 입력해주세요.");
            return "";
        } else if (members.length > 1) {
            for (HealthMember m : members) {
                System.out.println(m.inform());
            }
            id = com.inputStr(" - 아이디 : ");

            if (hmc.findIndexById(id) < 0) {
                System.out.println("존재하지 않는 코드입니다. 다시 입력해주세요.");
                return "";
            }
            return id;
        }
        return members[0].getId();
    }

    // 유요한 아이디 없을 경우 객체 null 추출
    public HealthMember getTarget() {
        String id = getId();
        if (id.length() == 0)
            return null;
        return hmc.searchId(id);
    }
}
