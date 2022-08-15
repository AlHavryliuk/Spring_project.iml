package org.example.dao;

import org.example.entities.Student;
import org.example.entities.Teacher;
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
public class TeacherDAO {
    private DataSource dataSource;


    @Autowired
    public TeacherDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Teacher> getAllTeachers() {
        List<Teacher> teacherList = new ArrayList<>();
        try  (Connection connection = dataSource.getConnection();
              PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM TEACHERS ORDER BY TEACHER_NAME")){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                teacherList.add(parseStudent(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teacherList;
    }

    private Teacher parseStudent(ResultSet resultSet) {
        Teacher Teacher = null;
        try {
            int id = resultSet.getInt("TEACHER_ID");
            String fio = resultSet.getString("TEACHER_NAME");
            String subject = resultSet.getString("TEACHER_SUBJECT");
            String group = resultSet.getString("TEACHER_GRADE");
            Teacher = new Teacher(id,fio,subject,group);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Teacher;
    }

    public void insertTeacher (Teacher teacher) {
        try  (Connection connection = dataSource.getConnection();
              PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO TEACHERS (TEACHER_ID, TEACHER_NAME, TEACHER_SUBJECT, TEACHER_GRADE) VALUES (NULL,:1 ,:2 ,:3)"); ) {
            preparedStatement.setString(1,teacher.getName());
            preparedStatement.setString(2,teacher.getSubject()) ;
            preparedStatement.setString(3,teacher.getGrade());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void removeTeacher(int id) {
        try  (Connection connection = dataSource.getConnection();
              PreparedStatement preparedStatement = connection.prepareStatement("DELETE TEACHERS WHERE TEACHER_ID = :2"); ) {
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTeacherByAll(int id, String name, String subject, String grade) {
        try  (Connection connection = dataSource.getConnection();
              PreparedStatement preparedStatement = connection.prepareStatement("UPDATE TEACHERS SET TEACHER_NAME = :1, TEACHER_SUBJECT = :2, TEACHER_GRADE = :1 WHERE TEACHER_ID = :4"); ) {
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,subject);
            preparedStatement.setString(3,grade);
            preparedStatement.setInt(4,id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
