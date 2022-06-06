package com.kh.miniProject3.health.controller;

import com.kh.miniProject3.health.model.vo.ConsultMember;
import com.kh.miniProject3.health.model.vo.HealthMember;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ConsultMemberController {

    public static final int SIZE = 5;
    ConsultMember[] cm = new ConsultMember[SIZE];

    public ConsultMemberController() {
        cm[0] = new ConsultMember("김철수", 20, 'M', "01012345678", 20220608);
        cm[1] = new ConsultMember("박영희", 20, 'F', "01098765432", 20220610);
    }


    // 상담정보 txt로 받기
    public boolean inputConsultMember(String name, int age, char gender, String phoneNumber, int consultDay) {
        String txt = String.format("%s, %d, %s, %s, %d",name, age, gender, phoneNumber, consultDay);
        String position = String.format("C:\\Users\\pjy03\\OneDrive\\바탕 화면\\miniProject03-master\\miniProject03-master\\src\\com\\kh\\miniProject3\\health\\consultationData\\%s.txt", name);
        try {
            File file = new File(position);
            FileWriter fw = new FileWriter(file, true);
            fw.write(txt);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

}
