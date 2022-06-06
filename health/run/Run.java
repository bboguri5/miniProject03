package com.kh.miniProject3.health.run;

import com.kh.miniProject3.health.controller.HealthMemberController;
import com.kh.miniProject3.health.view.HealthMenu;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class Run {
    public static void main(String[] args) throws FileNotFoundException {

        HealthMenu hmm = new HealthMenu();
        hmm.mainMenu();

    }
}
