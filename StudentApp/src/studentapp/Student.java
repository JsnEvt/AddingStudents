/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentapp;

import javax.swing.JOptionPane;

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
    
    public Student() throws StudentException, Exception {
        this("unknown","unknown","unknown@net");
    }

    public Student(String name, String phone, String email) throws Exception{
        
        if(name.length() == 0)
            throw new StudentException ("Error: Name cannot be blank.");
        else if(phone.length() == 0)
            throw new StudentException ("Error: Phone cannot be blank.");
        else if(email.length() == 0)
            throw new StudentException ("Error: E-mail cannot be blank.");
        else if (email.contains("@") == false)
            throw new StudentException ("Error: Email not valid.");
                    
        studId = lastUsedId;
        lastUsedId++;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
    
    public int getStudId(){
        return studId;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) throws StudentException {
        if(name.length() == 0)
            throw new StudentException ("Error: Name cannot be blank.");
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) throws StudentException {
        if(phone.length() == 0)
            throw new StudentException ("Error: Phone cannot be blank.");
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws StudentException {
        if(email.length() == 0)
            throw new StudentException ("Error: E-mail cannot be blank.");
     
        if (email.contains("@") == false)
            throw new StudentException ("Error: Email not valid.");
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
