package com.kh.miniProject3.health;

import com.kh.miniProject3.health.controller.HealthMemberController;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class test {
    public static void main(String[] args) {
//        HealthMemberController hc = new HealthMemberController();

//        System.out.println(hc.last());
//        System.out.println(Arrays.toString(hc.lastMonth()));
        String txt = "테스트";
        String name = "C:\\Users\\pjy03\\OneDrive\\바탕 화면\\miniProject03-master\\miniProject03-master\\src\\com\\kh\\miniProject3\\health\\consultationData\\test.txt";


        try {
            File file = new File(name);
            FileWriter fw = new FileWriter(file, true);
            fw.write(txt);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
