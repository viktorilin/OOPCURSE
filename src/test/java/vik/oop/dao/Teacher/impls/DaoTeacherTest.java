package vik.oop.dao.Teacher.impls;

import com.google.gson.Gson;
import org.junit.Test;
import vik.oop.model.Teacher.Teacher;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Asus on 23.05.2017.
 */
public class DaoTeacherTest {

    @Test
    public void getAll() throws Exception {
        DaoTeacher dao = new DaoTeacher();
        int count = dao.readAll().size();
        assertEquals(dao.getAll().size(), count);
    }

    @Test
    public void getTeacher() throws Exception {
        DaoTeacher dao = new DaoTeacher();
        Teacher result = null;
        for (Teacher teacher : dao.readAll()) {
            if (teacher.getId() == 2) {
                result = new Teacher();
            }
        }
        Gson gson = new Gson();
        String str1 = gson.toJson(result);
        String str2 = gson.toJson(dao.getTeacher(2));
        assertEquals(str1,str2);
    }

    @Test
    public void createTeacher() throws Exception {
        ArrayList<Teacher> teachers = new ArrayList<>();
        ArrayList<Teacher> teachers1 = new ArrayList<>();
        Teacher teacher = new Teacher();
        Teacher teacher1 = new Teacher();
        DaoTeacher daoTeacher = new DaoTeacher();
        teachers = daoTeacher.readAll();
        teachers.add(teacher);

        daoTeacher.createTeacher(teacher1);
        daoTeacher.getAll();
        teachers1 = (ArrayList<Teacher>) daoTeacher.getAll();

        teachers.add(teacher);

        daoTeacher.createTeacher(teacher1);
        assertEquals(teachers1.size(),teachers.size());
    }


    @Test
    public void deleteTeacher() throws Exception {
        ArrayList<Teacher> teachers = new ArrayList<>();
        ArrayList<Teacher> teachers1 = new ArrayList<>();
        Teacher teacher = new Teacher();
        Teacher teacher1 = new Teacher();
        DaoTeacher daoTeacher = new DaoTeacher();
        teachers = daoTeacher.readAll();
        teachers.remove(daoTeacher.readAll().size()-1);

        teachers1 = (ArrayList<Teacher>) daoTeacher.getAll();
        daoTeacher.deleteTeacher(teachers1.size());


        teachers.add(teacher);

        daoTeacher.createTeacher(teacher1);
        assertEquals(teachers1.size(),teachers.size());
    }

    @Test
    public void readAll() throws Exception {
        ArrayList<Teacher> teachers = new ArrayList<>();

        Connection co = DriverManager.getConnection("jdbc:sqlite:laba3.db");
        Statement statement = co.createStatement();
        String query = "SELECT * FROM Teacher";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            int id = rs.getInt("id");
            String fullName = rs.getString("fullName");
            String numberOfPhone = rs.getString("numberOfPhone");
            int timeOfWork = rs.getInt("timeOfWork");
            int salary = rs.getInt("salary");
            Teacher teacher = new Teacher(id,fullName
                    ,numberOfPhone,timeOfWork,salary);
            teachers.add(teacher);
        }
        DaoTeacher daoTeacher = new DaoTeacher();
        Gson gson = new Gson();
        String str1=gson.toJson(teachers);
        String str2=gson.toJson(daoTeacher.readAll());

        assertEquals(str1,str2);

    }


}