package com.kh.miniProject3.health.controller;

import com.kh.miniProject3.health.model.vo.CustomerClient;
import com.kh.miniProject3.health.model.vo.HealthMember;
import com.kh.miniProject3.health.view.Common;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class CustomerClientController {
    public static final int SIZE = 20;
    CustomerClient[] cc ;
    Common com ;


    public CustomerClientController() {
        cc  = new CustomerClient[SIZE];
        com = new Common();
    }

    public void insertCustomerClient()
    {
        System.out.println(" ===== 상담 신청 ===== ");
        String name = com.inputStr(" - 이름 : ");
        char gender = com.inputStr(" - 성별 : ").charAt(0);
        String phone = com.inputStr(" - 휴대폰 번호 : ");
        String customerDate = com.inputStr(" - 상담 예약 일자 : ");
        writeData(name, gender, phone, customerDate,"customerClient.txt");
    }

    private void writeData(String name, char gender, String phone, String customerDate , String targetFile)  {
        String path = System.getProperty("user.dir") + "\\src\\com\\kh\\miniProject3\\health\\data\\" + targetFile;
        String str = String.format("\n%s,%s,%s,%s",name,gender,phone,com.GetYear()+customerDate);

        File file = new File(path);
        BufferedWriter buf = null;
        try{
            buf = new BufferedWriter(new FileWriter(file,true));
            if(file.isFile() && file.canWrite())
                buf.write(str);
            buf.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    private int existCustomerClientNum(){
        int count = 0;
        for(CustomerClient c : cc)
        {
            if(c == null)
                break;
            count++;
        }
        return count;
    };

    public CustomerClient[] printAll()
    {
        saveInfo();
        int customerLength = existCustomerClientNum();
        CustomerClient[] clients = new CustomerClient[customerLength];
        for (int i = 0; i < customerLength; i++) {
            clients[i] = cc[i];
        }
        return clients;
    }

    private void saveInfo()
    {
        String[][] clientInfoList =  com.readData("customerClient.txt");
        for (int i = 0; i < clientInfoList.length ; i++) {
            String[] line = clientInfoList[i];
            System.out.printf("%s,%s,%s,%s",line[0],line[1].charAt(0),line[2],line[3]);
            cc[i] = new CustomerClient(line[0],line[1].charAt(0),line[2],line[3]);
        }
    }


}
