package vik.oop.dao.GroupOfStudent.impls;

import com.google.gson.Gson;
import org.junit.Test;
import vik.oop.dao.Bill.impls.DaoBillImpl;
import vik.oop.model.GroupOfStudent.GroupOfStudent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Asus on 23.05.2017.
 */
public class DaoGroupOfStudentImplTest {
    @Test
    public void getAll() throws Exception {
        DaoGroupOfStudentImpl daoGroupOfStudent = new DaoGroupOfStudentImpl();
        int count = daoGroupOfStudent.readAll().size();
        assertEquals(daoGroupOfStudent.getAll().size(), count);
    }

    @Test
    public void getGroupOfStudent() throws Exception {
        DaoGroupOfStudentImpl daoGroupOfStudent = new DaoGroupOfStudentImpl();
        GroupOfStudent result = null;
        for (GroupOfStudent groupOfStudent : daoGroupOfStudent.readAll()) {
            if (groupOfStudent.getId() == 2) {
                result = new GroupOfStudent();
            }
        }
        Gson gson = new Gson();
        String str1 = gson.toJson(result);
        String str2 = gson.toJson(daoGroupOfStudent.getGroupOfStudent(2));
        assertEquals(str1,str2);
    }

    @Test
    public void createGroupOfStudent() throws Exception {
        ArrayList<GroupOfStudent> groupOfStudents = new ArrayList<>();
        ArrayList<GroupOfStudent> groupOfStudents1 = new ArrayList<>();
        GroupOfStudent groupOfStudent = new GroupOfStudent();
        GroupOfStudent groupOfStudent1 = new GroupOfStudent();
        DaoGroupOfStudentImpl daoGroupOfStudent = new DaoGroupOfStudentImpl();
        groupOfStudents=daoGroupOfStudent.readAll();
        groupOfStudents.add(groupOfStudent);

        daoGroupOfStudent.createGroupOfStudent(groupOfStudent1);
        daoGroupOfStudent.getAll();
        groupOfStudents1= (ArrayList<GroupOfStudent>) daoGroupOfStudent.getAll();

        groupOfStudents.add(groupOfStudent);

        daoGroupOfStudent.createGroupOfStudent(groupOfStudent1);
        assertEquals(groupOfStudents1.size(),groupOfStudents.size());
    }

    @Test
    public void deleteGroupOfStudents() throws Exception {
        ArrayList<GroupOfStudent> groupOfStudents = new ArrayList<>();
        ArrayList<GroupOfStudent> groupOfStudents1 = new ArrayList<>();
        GroupOfStudent groupOfStudent = new GroupOfStudent();
        GroupOfStudent groupOfStudent1 = new GroupOfStudent();
        DaoGroupOfStudentImpl daoGroupOfStudent = new DaoGroupOfStudentImpl();
        groupOfStudents=daoGroupOfStudent.readAll();
        groupOfStudents.remove(daoGroupOfStudent.readAll().size()-1);

        groupOfStudents1= (ArrayList<GroupOfStudent>) daoGroupOfStudent.getAll();
        daoGroupOfStudent.deleteGroupOfStudent(groupOfStudents1.size());


        groupOfStudents.add(groupOfStudent);

        daoGroupOfStudent.createGroupOfStudent(groupOfStudent1);
        assertEquals(groupOfStudents1.size(),groupOfStudents.size());
    }

    @Test
    public void readAll() throws Exception {
        ArrayList<GroupOfStudent> groupOfStudents = new ArrayList<>();
        Connection co = DriverManager.getConnection("jdbc:sqlite:laba3.db");
        Statement statement = co.createStatement();
        String query = "SELECT * FROM GroupOfStudent";
        ResultSet rs = statement.executeQuery(query);
        while(rs.next())
        {
            int id = rs.getInt("id");
            int numberOfGroup = rs.getInt("numberOfGroup");
            String specialty = rs.getString("specialty");
            String department = rs.getString("department");
            int numberOfStudents = rs.getInt("numberOfStudents");
            GroupOfStudent groupOfStudent = new GroupOfStudent(id,numberOfGroup
                    ,specialty,department,numberOfStudents);
            groupOfStudents.add(groupOfStudent);
        }

        DaoGroupOfStudentImpl daoGroupOfStudent = new DaoGroupOfStudentImpl();
        Gson gson = new Gson();
        String str1=gson.toJson(groupOfStudents);
        String str2=gson.toJson(daoGroupOfStudent.readAll());

        assertEquals(str1,str2);

    }

}