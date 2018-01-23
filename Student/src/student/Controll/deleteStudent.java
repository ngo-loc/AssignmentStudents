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
public class deleteStudent {

    StudentModel model = new StudentModel();
 Scanner scan = new Scanner(System.in);
    public void deleteStudent() throws SQLException {
        System.out.println("enter id you want delete");
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

        System.out.println("you want to delete (yes / no)");
        String delete = scan.nextLine();
        switch (delete) {
            case "y":
            case "yes":
                model.delete(id);
                break;
            default:
                System.err.println("delete failed");
                break;
        }
        ArrayList<entity> kiemTra = model.getStudentlist();

        for (int i = 0; i < kiemTra.size(); i++) {
            entity get = kiemTra.get(i);
            if (id == get.getId()) {
               if(get.getStatus() == -1){
                   System.out.println("delete success");
               }
            }
        }
    }
}
