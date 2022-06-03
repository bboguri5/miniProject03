package com.kh.miniProject3.health;

import com.kh.miniProject3.health.controller.HealthMemberController;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        HealthMemberController mc = new HealthMemberController();


//        System.out.println(mc.findIndexById("A03"));
        
//        System.out.println(mc.searchId("A02"));
//        System.out.println(mc.delete("A01"));
//        System.out.println(mc.delete("A02"));
//        System.out.println(mc.existMemberNum());
//        System.out.println(Arrays.toString(mc.printAll()));
        System.out.println(mc.lockerInsert("최성렬", "3", 1));
        System.out.println(mc.searchName("최성렬"));
        System.out.println(mc.lockerNum());
//        System.out.println(Arrays.toString(mc.lockerList()));
    }


}
