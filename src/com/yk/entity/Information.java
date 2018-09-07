package com.yk.entity;

import java.io.*;
import java.util.Enumeration;
import java.util.Properties;

public class Information {
    private Properties pr = null;
    BufferedReader buf = null;
    private String name = null;
    private String sex = null;
    private String age = null;
    private File  fl = null;
    public Information(File fl) {
            this.fl = fl;

    }

    public void loader()
    {
        pr = new Properties();
        try {
            buf = new BufferedReader(new InputStreamReader(new FileInputStream(fl), "GBK"));
            pr.load(buf);
            name = pr.getProperty("name");
            sex = pr.getProperty("sex");
            age = pr.getProperty("age");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveNew() {
        BufferedOutputStream out = null;
        try {
            out = new BufferedOutputStream(new FileOutputStream(fl));
            StringBuilder stb = new StringBuilder();
            stb.append("name=" + name + "\r\n");
            stb.append("sex=" + sex + "\r\n");
            stb.append("age=" + age + "\r\n");

            out.write(stb.toString().getBytes("utf-8"));

            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return " fl=" + fl +
                "，Information{" +
                "，pr=" + pr +
                ", buf=" + buf +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public String getAllInfo()
    {
        StringBuilder strb = new StringBuilder();

        Enumeration<String> e = (Enumeration<String>) pr.propertyNames();

        while (e.hasMoreElements())
        {
            strb.append(pr.getProperty((String)e.nextElement()));
        }

        return strb.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        buf.close();
        System.out.println("析构完成！");
    }
}
