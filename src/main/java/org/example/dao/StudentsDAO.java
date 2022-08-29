package org.example.dao;


import org.example.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentsDAO {
    private DataSource dataSource;


    @Autowired
    public StudentsDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM STUDENTS ORDER BY STUDENT_FIO")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                studentList.add(parseStudent(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    private Student parseStudent(ResultSet resultSet) {
        Student student = null;
        try {
            int id = resultSet.getInt("STUDENT_ID");
            String fio = resultSet.getString("STUDENT_FIO");
            int age = resultSet.getInt("STUDENT_AGE");
            String group = resultSet.getString("STUDENT_GROUP");
            student = new Student(id, fio, age, group);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    public void insertStudent(Student student) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO STUDENTS (STUDENT_ID, STUDENT_FIO, STUDENT_AGE,STUDENT_GROUP) VALUES (NULL,:1 ,:2 ,:3)");) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setString(3, student.getGroup());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void removeStudent(int id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE STUDENTS WHERE STUDENT_ID = :2");) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Student> getStudentById(int id) {

        List<Student> studentList = new ArrayList<>();
        ArrayList<Student> studentArrayList = (ArrayList<Student>) getAllStudents();
        for (Student student : studentArrayList) {
            if (student.getId() == id) {
                studentList.add(student);
            }
        }
        return studentList;
    }

    public List<Student> getStudentByName(String name) {

        List<Student> studentList = new ArrayList<>();
        ArrayList<Student> studentArrayList = (ArrayList<Student>) getAllStudents();
        for (Student student : studentArrayList) {
            if (student.getName().equals(name)) {
                studentList.add(student);
            }
        }
        return studentList;
    }

    public List<Student> getStudentByAge(int age) {

        List<Student> studentList = new ArrayList<>();
        ArrayList<Student> studentArrayList = (ArrayList<Student>) getAllStudents();
        for (Student student : studentArrayList) {
            if (student.getAge() == age) {
                studentList.add(student);
            }
        }
        return studentList;
    }


    public List<Student> getStudentByGroup(String group) {

        List<Student> studentList = new ArrayList<>();
        ArrayList<Student> studentArrayList = (ArrayList<Student>) getAllStudents();
        for (Student student : studentArrayList) {
            if (student.getGroup().equals(group)) {
                studentList.add(student);
            }
        }
        return studentList;
    }


    public void updateStudentByAll(int id, String name, int age, String group) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE STUDENTS SET STUDENT_FIO = :1, STUDENT_AGE = :2, STUDENT_GROUP = :1 WHERE STUDENT_ID = :4");) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setString(3, group);
            preparedStatement.setInt(4, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
