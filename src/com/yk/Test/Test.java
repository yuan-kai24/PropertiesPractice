package com.yk.Test;

import com.yk.entity.Information;

import java.io.*;

public class Test {
    public static void main(String[] args) {
        File fl = new File("source/test.properties");
        try {
            FileInputStream flr = new FileInputStream(fl);
            Information inf = new Information(fl);
            inf.loader();
            System.out.println(inf.getAge());
            inf.setAge("20");
            inf.saveNew();
            inf.loader();
            System.out.println(inf.getAge());
            System.out.println("------------------------------------------------------");
            System.out.println(inf.getAllInfo());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
