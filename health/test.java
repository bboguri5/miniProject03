package com.kh.miniProject3.health;

import com.kh.miniProject3.health.controller.HealthMemberController;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        HealthMemberController hc = new HealthMemberController();

//        System.out.println(hc.last());

        System.out.println(Arrays.toString(hc.lastMonth()));
    }
}
