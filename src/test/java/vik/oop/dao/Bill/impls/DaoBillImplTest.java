package vik.oop.dao.Bill.impls;

import com.google.gson.Gson;
import org.junit.Test;
import vik.oop.dao.GroupOfStudent.impls.DaoGroupOfStudentImpl;
import vik.oop.dao.Lesson.impls.DaoLessonImpl;
import vik.oop.dao.Teacher.impls.DaoTeacher;
import vik.oop.model.Bill.Bill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Asus on 23.05.2017.
 */
public class DaoBillImplTest {


    @Test
    public void getAll() throws Exception {
        DaoBillImpl daoBill = new DaoBillImpl();
        int count = daoBill.readAll().size();
        assertEquals(daoBill.getAll().size(), count);
    }

    @Test
    public void getBill() throws Exception {
        DaoBillImpl daoBill = new DaoBillImpl();
        Bill result = null;
        for (Bill bill : daoBill.readAll()) {
            if (bill.getId() == 2) {
                result = new Bill();
            }
        }
        Gson gson = new Gson();
        String str1 = gson.toJson(result);
        String str2 = gson.toJson(daoBill.getBill(2));
        assertEquals(str1,str2);
    }

    @Test
    public void createBill() throws Exception {
        ArrayList<Bill> bills = new ArrayList<>();
        ArrayList<Bill> bills1 = new ArrayList<>();
        Bill bill = new Bill();
        Bill bill1 = new Bill();
        DaoBillImpl daoBill = new DaoBillImpl();
        bills=daoBill.readAll();
        bills.add(bill);

        daoBill.createBill(bill1);
        daoBill.getAll();
        bills1= (ArrayList<Bill>) daoBill.getAll();

        bills.add(bill);

        daoBill.createBill(bill1);
        assertEquals(bills1.size(),bills.size());
    }

 /*   @Test
    public void updateCheck() throws Exception {
        Check check = new Check();
        DaoCheckImpl daoCheck = new DaoCheckImpl();
        Check updateCheck = null;
        for (Check check1 : daoCheck.readAll()) {
            if (check1.getId() == 3) {
                updateCheck = check1;
                break;
            }
        }
        updateCheck = check;
        assertEquals(check.getClient(),daoCheck.updateCheck(check));
    }*/

    @Test
    public void deleteBill() throws Exception {
        ArrayList<Bill> bills = new ArrayList<>();
        ArrayList<Bill> bills1 = new ArrayList<>();
        Bill bill = new Bill();
        Bill bill1 = new Bill();
        DaoBillImpl daoBill = new DaoBillImpl();
        bills=daoBill.readAll();
        bills.remove(daoBill.readAll().size()-1);

        bills1= (ArrayList<Bill>) daoBill.getAll();
        daoBill.deleteBill(bills1.size());


        bills.add(bill);

        daoBill.createBill(bill1);
        assertEquals(bills1.size(),bills.size());
    }

 /*   @Test
    public void showAll() throws Exception {
        DaoCheckImpl daoCheck = new DaoCheckImpl();
        String result="";
        for (Check check : daoCheck.readAll()) {
            result+=check.toString();
        }
        String result2 = daoCheck.showAll();
        assertEquals(daoCheck.showAll(),result);
    }*/

    @Test
    public void readAll() throws Exception {
        ArrayList<Bill> list = new ArrayList<>();
        Connection co = DriverManager.getConnection("jdbc:sqlite:laba3.db");
        Statement statement = co.createStatement();
        String query = "SELECT * FROM Bill";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            int id = rs.getInt("id");
            int lesson_id= rs.getInt("lesson_id");
            int groupOfStudents_id = rs.getInt("groupOfStudents_id");
            int teacher_id = rs.getInt("teacher_id");
            DaoGroupOfStudentImpl daoGroupOfStudent = new DaoGroupOfStudentImpl();
            DaoTeacher daoTeacher = new DaoTeacher();
            DaoLessonImpl daoLesson = new DaoLessonImpl();
            Bill bill = new Bill(id,
                    daoTeacher.readAll().get(teacher_id - 1),
                    daoLesson.readAll().get(lesson_id - 1),
            daoGroupOfStudent.readAll().get(groupOfStudents_id - 1));
            list.add(bill);
        }

        DaoBillImpl daoBill = new DaoBillImpl();
        Gson gson = new Gson();
        String str1 = gson.toJson(list);
        String str2 = gson.toJson(daoBill.readAll());

        assertEquals(str1, str2);
    }

}