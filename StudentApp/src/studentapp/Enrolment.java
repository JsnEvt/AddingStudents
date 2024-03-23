/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentapp;

/**
 *
 * @author jason
 */
public class Enrolment {
    
    private Student student;
    private Course course;
    
    public Enrolment(){
    }
    
    public Enrolment(Student student, Course course){
        this.student = student;
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
    
    public String toStringWithLineBreak(){
        return student.getStudId() + "\n" + course.getCode() + "\n";
    }
    
    @Override
    public String toString(){
        return student.getName() + " (" + student.getStudId() + ")" +
                "enrolled in: " + course.getCode() + " " + course.getName();
    }
    
}
