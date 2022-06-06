package com.kh.miniProject3.health.view;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Common {
    Scanner sc = new Scanner(System.in);

    // 숫자 입력
    public int inputInt(String arg) {
        System.out.print(arg);
        int z = -1;
        while (true) {
            try {
                z = sc.nextInt();
                return z;
            } catch (java.util.InputMismatchException e) {
                System.out.print("다시 입력해주세요 \n # 메뉴 입력 : ");
                sc.nextLine(); // 이거 무한루프
            }
        }
    }

    // 문자열 입력
    public String inputStr(String arg) {
        System.out.print(arg);
        return sc.next();
    }


    // 올해 년도
    public String GetYear() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        return sdf.format(new Date());
    }

    // txt 읽어와서 배열로 추출
    public String[][] readData(String targetFile)
    {
        String path = System.getProperty("user.dir") + "\\src\\com\\kh\\miniProject3\\health\\data\\" + targetFile;

        File file = new File(path);
        ArrayList<String[]> strArr = new ArrayList<>();

        try {
            FileReader filereader = new FileReader (file);
            BufferedReader bufReader = new BufferedReader((filereader));
            String line = "";
            while((line = bufReader.readLine()) != null)
            {
                if(line.equals(""))
                    continue;
                String[] lineStrArr = line.split(",");
                strArr.add(lineStrArr);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e);
        }
        return strArr.toArray(String[][]::new);
    }

    public char getGender()
    {
        char gender;
        while (true) {
            gender = inputStr(" - 성별(남/여) : ").charAt(0);
            if (gender == '남' || gender == '여') {
                break;
            } else
                System.out.println("다시 입력해주세요.");
        }
        return gender;
    }





}
