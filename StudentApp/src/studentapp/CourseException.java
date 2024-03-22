/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentapp;

/** 
*
 * @author jason
 */
public class CourseException extends RuntimeException{
    
    public CourseException(){
        this ("Error: Something went wrong creating a course.");
}
public CourseException(String message){
    super(message);
}
public CourseException (String message, Throwable cause){
    super(message, cause);
    }
}
