package com.example.lma.Service;

import com.example.lma.Model.Assignment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AssignmentService {

    ArrayList<Assignment> assignments = new ArrayList<>();


    public ArrayList<Assignment> getAssignments() {
        return assignments;
    }


    public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
    }


    public boolean updateAssignment(String id, Assignment assignment) {

        for (int i = 0; i < assignments.size(); i++) {

            if (assignments.get(i).getId().equals(id)) {

                assignments.set(i, assignment);
                return true;
            }
        }

        return false;
    }


    public boolean deleteAssignment(String id) {

        for (int i = 0; i < assignments.size(); i++) {

            if (assignments.get(i).getId().equals(id)) {

                assignments.remove(i);
                return true;
            }
        }

        return false;
    }


    public Assignment getId(String id) {

        for (int i = 0; i < assignments.size(); i++) {

            if (assignments.get(i).getId().equals(id)) {

                return assignments.get(i);
            }
        }

        return null;
    }


    public ArrayList<Assignment> getByStatus(String status) {

        ArrayList<Assignment> result = new ArrayList<>();

        for (int i = 0; i < assignments.size(); i++) {

            if (assignments.get(i).getStatus().equals(status)) {
                result.add(assignments.get(i));
            }
        }

        return result;
    }

    public Assignment getByTitle(String title) {

        for (int i = 0; i < assignments.size(); i++) {

            if (assignments.get(i).getTitle().equals(title)) {
                return assignments.get(i);
            }
        }

        return null;
    }

    public ArrayList<Assignment> getByMaxGrade(int grade) {

        ArrayList<Assignment> result = new ArrayList<>();

        for (int i = 0; i < assignments.size(); i++) {

            if (assignments.get(i).getMaxGrade() >= grade) {
                result.add(assignments.get(i));
            }
        }

        return result;
    }
    public ArrayList<Assignment> getNotGraded() {

        ArrayList<Assignment> result = new ArrayList<>();

        for (int i = 0; i < assignments.size(); i++) {

            if (!assignments.get(i).getStatus().equals("graded")) {
                result.add(assignments.get(i));
            }
        }

        return result;
    }
}