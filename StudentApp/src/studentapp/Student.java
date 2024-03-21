/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentapp;

/**
 *
 * @author jason
 */
public class Student {
    private static int lastUsedId = 1000;
    private int studId;
    private String name;
    private String phone;
    private String email;

    public Student(String name, String phone, String email) {
        studId = lastUsedId;
        lastUsedId++;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override 
    public String toString(){
        return String.format("%8s", studId) +  "  " +
               String.format("%-20s", name) + 
               String.format("%-20s", phone) + 
               String.format("%-20s", email);
    }
}
