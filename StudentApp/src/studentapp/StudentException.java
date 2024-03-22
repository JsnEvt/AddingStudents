/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentapp;

/**
 *
 * @author jason
 */
public class StudentException extends RuntimeException{
    
    public StudentException(){
        this ("Error: Something went wrong creating a student.");
}
public StudentException(String message){
    super(message);
}
public StudentException (String message, Throwable cause){
    super(message, cause);
    }
}
