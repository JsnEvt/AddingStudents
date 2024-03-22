/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentapp;

/**
 *
 * @author jason
 */
public class Course {
    private String code;
    private String name;

    public Course() throws Exception {
        this("unknown", "unknown");
    }
    
    public Course(String code, String name) throws CourseException{
        
        if(code.length() == 0)
                throw new CourseException ("Error: Code cannot be blank.");
            else if(name.length() == 0)
                throw new CourseException ("Error: Name cannot be blank.");
                    
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) throws CourseException{
        if(code.length() == 0)
            throw new CourseException ("Error: Code cannot be blank.");
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws CourseException {
        if(name.length() == 0)
            throw new CourseException ("Error: Name cannot be blank.");
        this.name = name;
    }
    
    
    @Override 
    public String toString(){
        return String.format("%-10s", code) + 
               String.format("%-20s", name);

    }   
}
