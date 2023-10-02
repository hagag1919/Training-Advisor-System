package CoursePackage;


import Database.*;
import CourseAdd_on.*;

public class Course {

    private String courseName;
    private String coursetype;
    private String courseID;
    private double courseScore;
    private double courseCost;
    private String prerequisite = new String();
    public Exams exam = new Exams();
    public Materials materials;
    Repository database = Repository.getInstance();


    public Course() {
        this.courseName = "course Name";
        this.coursetype = "course type";
        this.courseID = "course ID";
        this.courseScore = 0;
        this.courseCost = 0;
    }

    public Course(String name, String type, String ID, String pre, double cost, String material) {
        courseName = name;
        coursetype = type;
        courseID = ID.toUpperCase();
        courseCost = cost;
        prerequisite = pre;
        materials.materialsVector.add(material);
    }

    public void setCourse(String name, String type, String ID, int score, int cost) {
        this.courseName = name;
        this.coursetype = type;
        this.courseID = ID.toUpperCase();
        this.courseScore = score;
        this.courseCost = cost;
    }

    
    

    //Setters
    public void setCourseName(String name) {
        courseName = name;
    }

    public void setCourseType(String type) {
        coursetype = type;
    }

    public void setCourseID(String ID) {
        courseID = ID.toUpperCase();
    }

    public void setCourseScore(Double score) {
        courseScore = score;
    }

    public void setCourseCost(Double cost) {
        courseCost = cost;
    }

    public void setPrerequisites(String pre) {
        prerequisite = pre;
    }

    //Getters
    public String getCourseName() {
        return courseName;
    }

    public String getCourseType() {
        return coursetype;
    }

    public String getCourseID() {
        return courseID;
    }

    public double getCourseScore() {
        return courseScore;
    }

    public double getCourseCost() {
        return courseCost;
    }

    public String getPrerequisites() {
        return prerequisite;
    }

 
}