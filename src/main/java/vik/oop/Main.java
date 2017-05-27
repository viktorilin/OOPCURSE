package vik.oop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vik.oop.dao.Bill.impls.DaoBillImpl;
import vik.oop.dao.GroupOfStudent.impls.DaoGroupOfStudentImpl;
import vik.oop.dao.Lesson.impls.DaoLessonImpl;
import vik.oop.dao.Teacher.impls.DaoTeacher;
import vik.oop.model.Bill.Bill;
import vik.oop.model.GroupOfStudent.GroupOfStudent;
import vik.oop.model.Lesson.Lesson;
import vik.oop.model.Teacher.Teacher;
import vik.oop.services.Bill.impls.BillServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 27.03.2017.
 */
public class Main
{
    public static void main(String[] args) {
      //  ApplicationContext check = new ClassPathXmlApplicationContext("bill-context.xml");

//
//        Bill bill1 = (Bill) check.getBean("Bill1");
//        Bill bill2 = (Bill) check.getBean("Bill2");
//        Bill bill3 = (Bill) check.getBean("Bill3");
//        Bill bill4 = (Bill) check.getBean("Bill4");
//        Bill bill5 = (Bill) check.getBean("Bill5");
//        Bill bill6 = (Bill) check.getBean("Bill6");
//        Bill bill7 = (Bill) check.getBean("Bill7");
//        Bill bill8 = (Bill) check.getBean("Bill8");
//        Bill bill9 = (Bill) check.getBean("Bill9");
//        Bill bill10 = (Bill) check.getBean("Bill10");
//
//
//
//        ArrayList<Bill> arrayList = new ArrayList<Bill>();
//        arrayList.add(bill1);
//        arrayList.add(bill2);
//        arrayList.add(bill3);
//        arrayList.add(bill4);
//        arrayList.add(bill5);
//        arrayList.add(bill6);
//        arrayList.add(bill7);
//        arrayList.add(bill8);
//        arrayList.add(bill9);
//        arrayList.add(bill10);
//
//        for (int i=0;i<arrayList.size();i++){
//            System.out.println(arrayList.get(i));
//        }
//         ApplicationContext checks = new ClassPathXmlApplicationContext("bill-context.xml");
//        Bill checks1 = (Bill) checks.getBean("Bill1");
//        System.out.println(checks1.toString());


//
//        System.out.println("---------------------------------------------------------------------");
//
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
//        BillServiceImpl service_bill = (BillServiceImpl) context.getBean("service_bill");
//        service_bill.showAll();



//        ArrayList<Bill> list = new ArrayList<>();
//        DaoBillImpl daoBill = new DaoBillImpl();
//        list = daoBill.readAll();
//        System.out.println(list);
//        DaoBillImpl daoBill = new DaoBillImpl();
//        ArrayList<Bill> bills = new ArrayList<Bill>();
//        daoBill.deleteBill(1);
//        bills = daoBill.readAll();
//       // System.out.println(bills);
//        Teacher teacher = new Teacher(10,"viktor","+3821646",10,600);
//        DaoTeacher daoTeacher = new DaoTeacher();
//        daoTeacher.createTeacher(teacher);
//        System.out.println(daoTeacher.getAll());
//        DaoGroupOfStudentImpl daoGroupOfStudent = new DaoGroupOfStudentImpl();
//        List<GroupOfStudent> list = daoGroupOfStudent.readAll();
//        System.out.println(list.get(1));
//        int i = list.get(1).getNumberOfGroup() / 100;
//
//        System.out.println(i);
        DaoLessonImpl daoLesson = new DaoLessonImpl();
        System.out.println(daoLesson.getLesson(1).getNumberOfClassRoom());

    }
}
