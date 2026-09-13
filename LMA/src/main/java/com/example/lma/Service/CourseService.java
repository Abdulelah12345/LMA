package com.example.lma.Service;

import com.example.lma.Model.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CourseService {

    ArrayList<Course> courses = new ArrayList<>();


    public ArrayList<Course> getCourse() {
        return courses;
    }


    public void addCourse(Course course) {
        courses.add(course);
    }


    public boolean updateCourse(String id, Course course) {

        for (int i = 0; i < courses.size(); i++) {

            if (courses.get(i).getId().equals(id)) {

                courses.set(i, course);
                return true;
            }
        }

        return false;
    }


    public boolean deleteCourse(String id) {

        for (int i = 0; i < courses.size(); i++) {

            if (courses.get(i).getId().equals(id)) {

                courses.remove(i);
                return true;
            }
        }

        return false;
    }


    public Course getId(String id) {

        Course c1 ;

        for (int i = 0; i < courses.size(); i++) {

            if (courses.get(i).getId().equals(id)) {

                c1 = courses.get(i);
                return c1;
            }
        }

        return null;
    }



    public ArrayList<Course> getByCategory(String category) {

        ArrayList<Course> result = new ArrayList<>();

        for (int i = 0; i < courses.size(); i++) {

            if (courses.get(i).getCategory().equals(category)) {
                result.add(courses.get(i));
            }
        }

        return result;
    }


    public ArrayList<Course> getByDuration(int duration) {

        ArrayList<Course> result = new ArrayList<>();

        for (int i = 0; i < courses.size(); i++) {

            if (courses.get(i).getDuration() >= duration) {
                result.add(courses.get(i));
            }
        }

        return result;
    }


    public ArrayList<Course> getByDescription(String word) {

        ArrayList<Course> result = new ArrayList<>();

        for (int i = 0; i < courses.size(); i++) {

            if (courses.get(i).getDescription().contains(word)) {
                result.add(courses.get(i));
            }
        }

        return result;
    }
}
