package com.kh.miniProject3.health.run;

import com.kh.miniProject3.health.view.ConsultApplyMenu;

import java.io.FileNotFoundException;

public class ConsultApply {
    public static void main(String[] args) throws FileNotFoundException {

    ConsultApplyMenu cam = new ConsultApplyMenu();
    cam.consultMemberManagement();

    }
}
