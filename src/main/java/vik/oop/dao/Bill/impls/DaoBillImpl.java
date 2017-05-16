package vik.oop.dao.Bill.impls;

import vik.oop.dao.Bill.interfaces.IDaoBill;
import vik.oop.dao.GroupOfStudent.impls.DaoGroupOfStudentImpl;
import vik.oop.dao.Lesson.impls.DaoLessonImpl;
import vik.oop.dao.Teacher.impls.DaoTeacher;
import vik.oop.model.Bill.Bill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Asus on 03.04.2017.
 */
public class DaoBillImpl implements IDaoBill
{
    public List<Bill> bills = new ArrayList<Bill>();

    public DaoBillImpl() {
        try {
            Connection co = DriverManager.getConnection("jdbc:sqlite:laba3.db");
            Statement statement = co.createStatement();
            String query = "SELECT * FROM Bill";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                int lesson_id = rs.getInt("lesson_id");
                int groupOfStudents_id = rs.getInt("groupOfStudents_id");
                int teacher_id = rs.getInt("teacher_id");
                DaoTeacher teacherDao = new DaoTeacher();
                DaoLessonImpl lessonDao = new DaoLessonImpl();
                DaoGroupOfStudentImpl groupOfStudentDao = new DaoGroupOfStudentImpl();
                Bill bill = new Bill(id, teacherDao.readAll().get(teacher_id-1),
                        lessonDao.readAll().get(lesson_id-1),
                        groupOfStudentDao.readAll().get(groupOfStudents_id-1));
                this.bills.add(bill);
            }

            co.close();
            statement.close();
        } catch (Exception e) {
            //  System.out.println(e.getMessage());
        }
    }

    public DaoBillImpl(List<Bill> bills) {
        this.bills = bills;
    }

    @Override
    public ArrayList<Bill> readAll() {
        return (ArrayList<Bill>) this.bills;
    }

    public List<Bill> getAll() {
        return bills;
    }

    public Bill getBill(int id) {
        Bill result = null;
        for (Bill bill:bills)
        {
            if((bill.getId())==id)
            {
                result = new Bill();
            }

        }
        return result;
    }

    public void createBill(Bill bill)
    {
        bills.add(bill);
    }

    public void updateBill(Bill bill)
    {
        Bill updateBill = null;
        for (Bill bill1:bills)
        {
            if(bill1.getId()==bill.getId())
            {
                updateBill = bill1;
                break;
            }
        }
        updateBill = bill;
    }

    public void deleteBill(int id)
    {
        int i =0;
        boolean is=false;
        for (Bill bill:bills)
        {
            if (bill.getId()==id)
            {
                is = true;
                break;
            }
            i++;
        }
        if (is) bills.remove(i);

    }

    public void showAll()
    {
        for (Bill bill:bills)
        {
            System.out.println(bill.toString());
        }

    }
}
