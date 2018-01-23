/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

/**
 *
 * @author Admin
 */
public class entity {

    private int id;
    private String rollNumber;
    private String name;
    private String email;
    private String phone;
    private int status;

    public entity(String rollNumber, String name, String email, String phone, int status) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.status = status;
    }

    public entity(String rollNumber, String name, String email, String phone) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public entity(int id, String rollNumber, String name, String email, String phone, int status) {
        this.id = id;
        this.rollNumber = rollNumber;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.status = status;
    }

    public entity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
