package vik.oop.dao.GroupOfStudent.impls;

import org.springframework.stereotype.Service;
import vik.oop.dao.GroupOfStudent.interfaces.IDaoGroupOfStudent;
import vik.oop.model.GroupOfStudent.GroupOfStudent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 03.04.2017.
 */
@Service
public class DaoGroupOfStudentImpl implements IDaoGroupOfStudent
{
    public List<GroupOfStudent> groupOfStudents = new ArrayList<GroupOfStudent>();

    public DaoGroupOfStudentImpl() {
        try {
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
            co.close();
            statement.close();
        } catch (Exception e) {
            //  System.out.println(e.getMessage());
        }
    }

    public DaoGroupOfStudentImpl(List<GroupOfStudent> groupOfStudents) {
        this.groupOfStudents = groupOfStudents;
    }

    @Override
    public ArrayList<GroupOfStudent> readAll() {
        return (ArrayList<GroupOfStudent>) this.groupOfStudents;

    }

    public List<GroupOfStudent> getAll() {
        return groupOfStudents;
    }

    public GroupOfStudent getGroupOfStudent(int id) {
        GroupOfStudent result = null;
        for (GroupOfStudent groupOfStudent:groupOfStudents)
        {
            if((groupOfStudent.getId())==id)
            {
                result = groupOfStudent;
            }

        }
        return result;
    }

    public void createGroupOfStudent(GroupOfStudent groupOfStudent)
    {
        groupOfStudents.add(groupOfStudent);
    }

    public void updateGroupOfStudent(GroupOfStudent groupOfStudent)
    {
        GroupOfStudent updateGroupOfStudent = null;
        for (GroupOfStudent groupOfStudent1:groupOfStudents)
        {
            if(groupOfStudent1.getId()==groupOfStudent.getId())
            {
                updateGroupOfStudent = groupOfStudent1;
                break;
            }
        }
        updateGroupOfStudent = groupOfStudent;
    }

    public void deleteGroupOfStudent(int id)
    {
        int i =0;
        boolean is=false;
        for (GroupOfStudent groupOfStudent:groupOfStudents)
        {
            if (groupOfStudent.getId()==id)
            {
                is = true;
                break;
            }
            i++;
        }
        if (is) groupOfStudents.remove(i);

    }

    public void showAll()
    {
        for (GroupOfStudent groupOfStudent:groupOfStudents)
        {
            System.out.println(groupOfStudent.toString());
        }
    }

}
