package vik.oop.dao.Teacher.impls;

import org.springframework.stereotype.Service;
import vik.oop.dao.Teacher.interfaces.IDaoTeacher;
import vik.oop.model.GroupOfStudent.GroupOfStudent;
import vik.oop.model.Teacher.Teacher;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 09.04.2017.
 */
@Service
public class DaoTeacher implements IDaoTeacher
{

    public List<Teacher> teachers = new ArrayList<Teacher>();

    public DaoTeacher() {

        try {
            Connection co = DriverManager.getConnection("jdbc:sqlite:laba3.db");
            Statement statement = co.createStatement();
            String query = "SELECT * FROM Teacher";
            ResultSet rs = statement.executeQuery(query);
            while(rs.next())
            {
                int id = rs.getInt("id");
                String fullName = rs.getString("fullName");
                String numberOfPhone = rs.getString("numberOfPhone");
                int timeOfWork = rs.getInt("timeOfWork");
                int salary = rs.getInt("salary");
                Teacher teacher = new Teacher(id,fullName
                        ,numberOfPhone,timeOfWork,salary);
                this.teachers.add(teacher);
            }
            co.close();
            statement.close();
        } catch (Exception e) {
            //  System.out.println(e.getMessage());
        }
    }

    public DaoTeacher(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Teacher> getAll() {
        return teachers;
    }

    @Override
    public ArrayList<Teacher> readAll() {

        return (ArrayList<Teacher>) this.teachers;

    }

    public Teacher getTeacher(int id) {
        Teacher result = null;
        for (Teacher teacher:teachers)
        {
            if((teacher.getId())==id)
            {
                result = new Teacher();
            }

        }
        return result;
    }

    public void createTeacher(Teacher teacher)
    {
        teachers.add(teacher);
    }

    public void updateTeacher(Teacher teacher)
    {
        Teacher updateTeacher = null;
        for (Teacher teacher1:teachers)
        {
            if(teacher1.getId()==teacher.getId())
            {
                updateTeacher = teacher1;
                break;
            }
        }
        updateTeacher = teacher;
    }

    public void deleteTeacher(int id)
    {
        int i =0;
        boolean is=false;
        for (Teacher teacher:teachers)
        {
            if (teacher.getId()==id)
            {
                is = true;
                break;
            }
            i++;
        }
        if (is) teachers.remove(i);

    }

    public void showAll()
    {
        for (Teacher teacher:teachers)
        {
            System.out.println(teacher.toString());
        }
    }
}
