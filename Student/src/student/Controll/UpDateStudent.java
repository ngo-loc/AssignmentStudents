/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.Controll;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import student.Model.StudentModel;
import student.entity;

/**
 *
 * @author Admin
 */
public class UpDateStudent {

    StudentModel model = new StudentModel();
    entity student = new entity();
    Scanner scan = new Scanner(System.in);

    public void upDate() throws SQLException {

        System.out.println("nhap id ban muon sua:");
        int id = scan.nextInt();
        scan.nextLine();
        ArrayList<entity> list = model.seach(id);
        for (int i = 0; i < list.size(); i++) {
            entity get = list.get(i);
            System.out.println(get.getId()
                    + "\t" + get.getRollNumber()
                    + "\t" + get.getName()
                    + "\t" + get.getEmail()
                    + "\t" + get.getPhone()
                    + "\t" + get.getStatus());
        }

        System.out.println("ban muon sua rollNumber (yes no)");
        boolean run = true;
        while (run) {
            String test = scan.nextLine();
            switch (test) {
                case "y":
                case "yes":
                    updateRollNumber();
                    run = false;
                    break;
                case "n":
                case "no":
                    run = false;
                    break;
                default:
                    System.err.println("ban nhap khong dung vui long nhap lai (yes no)");
                    break;
            }
        }
        System.out.println("ban muon sua name khong (yes no)");
        run = true;
        while (run) {
            String test = scan.nextLine();
            switch (test) {
                case "y":
                case "yes":
                    updateName();
                    run = false;
                    break;
                case "n":
                case "no":
                    run = false;
                    break;
                default:
                    System.err.println("ban nhap khong dung vui long nhap lai (yes no)");
                    break;
            }
        }
        System.out.println("ban muon sua email khong (yes no)");
        run = true;
        while (run) {
            String test = scan.nextLine();
            switch (test) {
                case "y":
                case "yes":
                    updateEmail();
                    run = false;
                    break;
                case "n":
                case "no":
                    run = false;
                    break;
                default:
                    System.err.println("ban nhap khong dung vui long nhap lai (yes no)");
                    break;
            }
        }
        System.out.println("ban muon sua phone khong (yes no)");
        run = true;
        while (run) {
            String test = scan.nextLine();
            switch (test) {
                case "y":
                case "yes":
                    updatePhone();
                    run = false;
                    break;
                case "n":
                case "no":
                    run = false;
                    break;
                default:
                    System.err.println("ban nhap khong dung vui long nhap lai (yes no)");
                    break;
            }
        }
        System.out.println("ban muon sua status khong (yes no)");
        run = true;
        while (run) {
            String test = scan.nextLine();
            switch (test) {
                case "y":
                case "yes":
                    updateStatus();
                    run = false;
                    break;
                case "n":
                case "no":
                    run = false;
                    break;
                default:
                    System.err.println("ban nhap khong dung vui long nhap lai (yes no)");
                    break;
            }

        }
        model.upDate(id, student);
    }

    public void updateRollNumber() {
        System.out.println("enter rollNumber new:");// moi nguoi dung nhap
        while (true) {                                                                          // test fr
            String rollNumber = scan.nextLine();                                // nhap vao tu ban phim
            if (rollNumber != null && rollNumber.length() > 4) {        // neu roll # null va > 5
                student.setRollNumber(rollNumber);                                  // thi set gia tri cho roll
                break;                                                                                  // neu if thoa man thi break ra khoi while
            }
            System.err.println("rollNumber phhai nhieu hon 5 ky tu");//neu if khong thoa man cho nhap lai
        }
    }

    public void updateName() {
        System.out.println("enter name new:");
        while (true) {
            String name = scan.nextLine();
            if (name.length() > 8) {
                student.setName(name);
                break;
            }
            System.err.println("name phai nhieu hon 5 ky tu");
        }
    }

    public void updateEmail() {
        System.out.println("enter email new:");
        while (true) {
            String email = scan.nextLine();
            if (email.matches("(.*) (.*)")) {
                System.err.println("email khong dc co khoang trang");
            } else if (email.matches("(.*)@gmail.com") || email.matches("(.*)@fpt.edu.vn")) {
                student.setEmail(email);
                break;
            } else {
                System.err.println("email khong dung dinh dang");
            }
        }
    }

    public void updatePhone() {
        System.out.println("enter phone new:");

        while (true) {
            String phone = scan.nextLine();
            if (phone.length() > 5) {
                student.setPhone(phone);
                break;
            }
            System.err.println("phone phai nhieu hon 5 ky tu");
        }
    }

    public void updateStatus() {
        System.out.println("enter status new:");
        while (true) {
            int status = scan.nextInt();
            if (status == 1 || status == 0 || status == -1) {
                student.setStatus(status);
                break;
            }
            System.err.println("status khong dc de trong ");
        }
    }
}
