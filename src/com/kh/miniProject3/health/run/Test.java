package com.kh.miniProject3.health.run;

import com.kh.miniProject3.health.view.common;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

// 상담신청
public class Test {

    public static void main(String[] args) throws IOException{
        common sc = new common();

        System.out.println(" ===== 상담 신청 ===== ");
        String name = sc.inputStr(" - 이름 : ");
        char gender = sc.inputStr(" - 성별 : ").charAt(0);
        String phone = sc.inputStr(" - 휴대폰 번호 : ");
        creatData(name,gender,phone);
    }

    public static void creatData(String name , char gender , String phone) throws IOException {
        String path = System.getProperty("user.dir") + "\\src\\com\\kh\\miniProject3\\health\\data\\";
        BufferedOutputStream bs = null;
        try{
            bs = new BufferedOutputStream(new FileOutputStream(path+phone+".txt"));
            String str = String.format("%s,%s",name,gender);
            bs.write(str.getBytes());
        } catch (Exception e) {
            e.getStackTrace();
        }finally {
            bs.close();
        }
    }

}
