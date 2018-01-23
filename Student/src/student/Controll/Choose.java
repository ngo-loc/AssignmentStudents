/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.Controll;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Choose {

    PrintStudent print = new PrintStudent();
    AddStudents add = new AddStudents();
    UpDateStudent up = new UpDateStudent();
    deleteStudent delete = new deleteStudent();
    public void toChoose() throws SQLException {
        while (true) {
            System.out.println("please select an item ");
            System.out.println("1.student list");
            System.out.println("2.add student");
            System.out.println("3.edit student");
            System.out.println("4.delete student");
            System.out.println("5. Exit");
            Scanner scan = new Scanner(System.in);
            int choose = scan.nextInt();
            scan.nextLine();
            switch (choose) {
                case 1:
                    System.out.println("------------print student list!------------");
                    print.printfStudent();
                    System.out.println("------------------over!--------------------");
                    break;
                case 2:
                    System.out.println("------------------Add Students----------------");
                    add.addStudent();
                    System.out.println("----------------------------------------------");
                    break;
                case 3:
                    System.out.println("------------------upDate-----------------------");
                    up.upDate();
                    System.out.println("-----------------------------------------------");
                    break;
                case 4:
                    System.out.println("----------------delete student-----------------");
                    delete.deleteStudent();
                    System.out.println("-----------------------------------------------");
                    break;
                default:
                    System.err.println("please only to choose 1 to 6");
                    break;
            }
        }
    }
}
