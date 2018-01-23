/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import student.entity;

/**
 *
 * @author Admin
 */
public class StudentModel {

    //Phương thức printf student
    public ArrayList<entity> getStudentlist() throws SQLException {
        ArrayList<entity> list = new ArrayList<>();
        Connection connection = ConnectionDatabase.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from students");
        while (rs.next()) {
            int id = rs.getInt("id");
            String rollNumber = rs.getString("rollNumber");
            String name = rs.getString("name");
            String email = rs.getString("email");
            String phone = rs.getString("phone");
            int status = rs.getInt("status");
            entity student = new entity(id, rollNumber, name, email, phone, status);
            list.add(student);
        }
        return list;
    }
// Phuowgn thức để thêm vào bảng student

    public void addStudent(entity student) throws SQLException {
        String insertSql = "insert into students (rollNumber, name, email, phone) value (? , ?, ?, ?)";
        Connection connection = ConnectionDatabase.getConnection();
        PreparedStatement prapeStatement = connection.prepareStatement(insertSql);
        System.out.println(student.getRollNumber());
        System.out.println(student.getName());
        System.out.println(student.getEmail());
        System.out.println(student.getPhone());
        prapeStatement.setString(1, student.getRollNumber());
        prapeStatement.setString(2, student.getName());
        prapeStatement.setString(3, student.getEmail());
        prapeStatement.setString(4, student.getPhone());
        try {
            prapeStatement.execute();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    // Phương thức để lấy ra 1 student theo id

    public ArrayList<entity> seach(int id) throws SQLException {
        ArrayList<entity> list = new ArrayList<>();
        Connection connection = ConnectionDatabase.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from students where id = " + id);
        while (rs.next()) {
            int idStudent = rs.getInt("id");
            String rollNumber = rs.getString("rollNumber");
            String name = rs.getString("name");
            String email = rs.getString("email");
            String phone = rs.getString("phone");
            int status = rs.getInt("status");
            entity student = new entity(idStudent, rollNumber, name, email, phone, status);
            list.add(student);
        }
        return list;
    }
    // Phương thức update cho bang student

    public void upDate(int id, entity student) throws SQLException { // truyen id tu ben UpDateStudent packages StudentControll
        System.err.println("da ket noi");
        Connection connection = ConnectionDatabase.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from students where id = " + id);
        String rollNumber = null;
        String name = null;
        String email = null;
        String phone = null;
        int status;

        while (rs.next()) {
            rollNumber = rs.getString("rollNumber");
            name = rs.getString("name");
            email = rs.getString("email");
            phone = rs.getString("phone");
            status = rs.getInt("status");
            System.out.println(rollNumber + "\t" + name + "\t" + email + "\t" + phone + "\t" + status);
        }
        String upDateSql = "UPDATE students SET rollNumber = ?, name = ?, email = ?, phone = ?, status = ? where id = " + id;
        PreparedStatement preparedStatement = connection.prepareStatement(upDateSql);

        if (student.getRollNumber() == null) {
            student.setRollNumber(rollNumber);
        }
        if (student.getName() == null) {
            student.setName(name);
        }
        if (student.getEmail()== null) {
            student.setEmail(email);
        }
        if (student.getPhone()== null) {
            student.setPhone(phone);
        }
        preparedStatement.setString(1, student.getRollNumber());
        preparedStatement.setString(2, student.getName());
        preparedStatement.setString(3, student.getEmail());

        preparedStatement.setString(4, student.getPhone());
        preparedStatement.setInt(5, student.getStatus());
        preparedStatement.execute();
    }

    public void delete(int id) {
        try {
            Connection connection = ConnectionDatabase.getConnection();
            Statement statement = connection.createStatement();
            statement.execute("update students set status = '-1' where id = " + id);
        } catch (SQLException ex) {
            System.err.println("error : delete failed");
        }
    }
}
