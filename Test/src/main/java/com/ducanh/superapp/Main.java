package com.ducanh.superapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        try {

            String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=HSF302;encrypt=true;trustServerCertificate=true";
            String user = "sa";
            String pass = "123456";
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(dbURL, user, pass);
            System.out.println("Connect to DB successfully");

            PreparedStatement stm = conn.prepareStatement("SELECT * FROM Subject");
            ResultSet rs = stm.executeQuery();
            //giống ArrayList, chứa nhiều dòng/record, mỗi dòng là info của môn học
            while (rs.next()) {
                String code = rs.getString("Code"); //tên cột là gì, data type của tên cột là gì, phải nhớ mới lấy đc
                String name = rs.getString("Name");
                int credits = rs.getInt("Credits");
                int hours = rs.getInt("StudyHours");
                //in theo kiểu ghép
//                System.out.println(code + " | " + name + " | " + credits + " | " + hours);

                //in gióng lề
                System.out.printf("|%10s|%-40s|%2d|%4d|\n", code, name, credits, hours);
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
