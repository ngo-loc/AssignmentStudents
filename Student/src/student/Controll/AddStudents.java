/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.Controll;

import java.sql.SQLException;
import java.util.Scanner;
import student.Model.StudentModel;
import student.entity;

/**
 *
 * @author Admin
 */
public class AddStudents {

    StudentModel model = new StudentModel();
    entity student = new entity();

    public void addStudent() throws SQLException {
        Scanner scan = new Scanner(System.in);
//add rollNumber
        System.out.println("please enter student rollNumber"); // moi nguoi dung nhap
        while (true) {                                                                          // test fr
            String rollNumber = scan.nextLine();                                // nhap vao tu ban phim
            if (rollNumber != null && rollNumber.length() > 4) {        // neu roll # null va > 5
                student.setRollNumber(rollNumber);                                  // thi set gia tri cho roll
                break;                                                                                  // neu if thoa man thi break ra khoi while
            }
            System.err.println("rollNumber phai khac null va nhieu hon 5 ky tu");//neu if khong thoa man cho nhap lai
        }
// add name
        System.out.println("plaese enter student name:");
        while (true) {
            String name = scan.nextLine();
            if (name != null && name.length() > 8) {
                student.setName(name);
                break;
            }
            System.err.println("phai khac null va nhieu hon 5 ky tu");
        }
// add email
        System.out.println("please enter student email:");
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
// add phone
        System.out.println("please enter student phone:");
        while (true) {
            String phone = scan.nextLine();
            if (phone != null && phone.length() > 5) {
                student.setPhone(phone);
                break;
            }
            System.err.println("phai khac null va nhieu hon 5 ky tu");
        }
        model.addStudent(student);
    }
}
