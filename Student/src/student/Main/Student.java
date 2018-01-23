/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student.Main;

import java.sql.SQLException;

import student.Controll.Choose;

/**
 *
 * @author Admin
 */
public class Student {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Choose choose = new Choose();
        try {
            choose.toChoose();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
    
}
