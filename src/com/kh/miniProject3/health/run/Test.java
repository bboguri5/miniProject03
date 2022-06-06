package com.kh.miniProject3.health.run;
import com.kh.miniProject3.health.controller.CustomerClientController;
import com.kh.miniProject3.health.view.Common;

import java.io.IOException;

// 상담신청
public class Test {

    public static void main(String[] args) throws IOException {
        CustomerClientController c = new CustomerClientController();
        c.insertCustomerClient();
    }


}
