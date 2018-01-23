/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.Controll;

import java.sql.SQLException;
import java.util.ArrayList;
import student.Model.StudentModel;
import student.entity;

/**
 *
 * @author Admin
 */
public class PrintStudent {

    StudentModel model = new StudentModel();

    public void printfStudent() throws SQLException {
        ArrayList<entity> list = model.getStudentlist();
        System.out.println("id" + "\t" + "\t" + "rollNumber" + "\t" + "name" + "\t" + "\t" + "\t" + "email" + "\t" + "\t" + "status");
        for (int i = 0; i < list.size(); i++) {
            entity get = list.get(i);
            System.out.println(get.getId() + "\t" + "\t" + get.getRollNumber()
                    + "\t" + "\t" + get.getName()
                    + "\t" + "\t" + get.getEmail()
                    + "\t" + "\t" + get.getStatus()
            );
        }
    }
}
