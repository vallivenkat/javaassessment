package com.generation.model;

import com.generation.service.CourseService;

import java.util.*;

public class Student
    extends Person
    implements Evaluation
{

    float PASS_MIN_GRADE = 3.0f;


    List<Course> enrolledCourses;
    List<Course> passedEnrolledCourses = new ArrayList<>();
    Map<String,Float> gradeValue;
    CourseService courseService = new CourseService();

    public Student( String id, String name, String email, Date birthDate )

    {
        super( id, name, email, birthDate );
        this.enrolledCourses = new ArrayList<>();
        this.gradeValue=new HashMap<>();

    }

    public void enrollToCourse( Course course )
    {
        //TODO
       this.enrolledCourses.add(course);



    }

    @Override
    public List<Course> findPassedCourses()

    {
        //TODO

        for( String courseID : gradeValue.keySet() ) {
           if(gradeValue.get(courseID) >= PASS_MIN_GRADE){
               enrolledCourses.forEach(course -> {
                    if( course.getCode().equals( courseID ) ) {
                       passedEnrolledCourses.add(course);
                    }
                });
            }
        }
        return passedEnrolledCourses;
   }




    public Course findCourseById( String courseId )
    {
        //TODO

        for( Course courseFound : enrolledCourses ) {
            if( courseFound.getCode().equals( courseId ) ) {
                return courseService.getCourse( courseId );
            }
        }
        return null;
    }



    @Override
    public List<Course> getEnrolledCourses()
    {
        //TODO
        return this.enrolledCourses;

    }

    @Override
    public String toString()
    {
        return "Student {" + super.toString() + "}";
    }

}
