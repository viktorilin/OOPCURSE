package vik.oop.services.Bills.impls;

import org.junit.Test;
import vik.oop.dao.Bill.impls.DaoBillImpl;
import vik.oop.model.Bill.Bill;
import vik.oop.model.Lesson.Lesson;
import vik.oop.services.Lesson.impls.LessonServiceImpl;
import vik.oop.services.Teacher.impls.TeacherServiceImpl;

import static org.junit.Assert.*;

/**
 * Created by Asus on 27.05.2017.
 */
public class BillsServiceImplTest {
    @Test
    public void earningsForDay() throws Exception {
        DaoBillImpl daoBill = new DaoBillImpl();
        BillsServiceImpl billsService = new BillsServiceImpl();
        int result = 0;
        LessonServiceImpl lessonService = new LessonServiceImpl();
        for (Bill bill:daoBill.readAll()) {
            result += billsService.paymentFromGroupOfStudent(bill);
            result -= billsService.salaryForTeacher(bill);
            result -= lessonService.getRentOfClassRoom(bill.getLesson());
        }
        assertEquals(result,billsService.earningsForDay(daoBill.readAll()));
    }

    @Test
    public void salaryForTeacher() throws Exception {
        DaoBillImpl daoBill = new DaoBillImpl();
        BillsServiceImpl billsService = new BillsServiceImpl();
        TeacherServiceImpl teacherService = new TeacherServiceImpl();
        int result = (teacherService.getPaymentForTeacher(daoBill.getBill(1).getTeacher())) * (daoBill.getBill(1).getGroupOfStudent().getNumberOfStudents());
        assertEquals(result,billsService.salaryForTeacher(daoBill.getBill(1)));
    }

    @Test
    public void paymentFromGroupOfStudent() throws Exception {
        DaoBillImpl daoBill = new DaoBillImpl();
        BillsServiceImpl billsService = new BillsServiceImpl();
        LessonServiceImpl lessonService = new LessonServiceImpl();
        int result = (int) (lessonService.getRentOfClassRoom(daoBill.getBill(1).getLesson()) * daoBill.getBill(1).getGroupOfStudent().getNumberOfStudents());
        assertEquals(result,billsService.paymentFromGroupOfStudent(daoBill.getBill(1)));
    }

    @Test
    public void maxRentOfClassRoom() throws Exception {
        DaoBillImpl daoBill = new DaoBillImpl();
        BillsServiceImpl billsService = new BillsServiceImpl();
        LessonServiceImpl lessonService = new LessonServiceImpl();
        double result = lessonService.getRentOfClassRoom(daoBill.readAll().get(0).getLesson());
        for (int i = 0; i < daoBill.readAll().size() - 1; i++) {
            if (lessonService.getRentOfClassRoom(daoBill.readAll().get(i).getLesson()) >
                    lessonService.getRentOfClassRoom(daoBill.readAll().get(i + 1).getLesson()))
                result = lessonService.getRentOfClassRoom(daoBill.readAll().get(i).getLesson());
        }
        double delta = 0;
        assertEquals(result,billsService.maxRentOfClassRoom(daoBill.readAll()),delta);
    }

    @Test
    public void maximumSalary() throws Exception {
        DaoBillImpl daoBill = new DaoBillImpl();
        BillsServiceImpl billsService = new BillsServiceImpl();
        int i =0;
        int result =0;
        for (i = 0; i < daoBill.readAll().size()-1;i++) {
            Bill bill  = daoBill.readAll().get(i);
            if(billsService.salaryForTeacher(bill) > billsService.salaryForTeacher(daoBill.readAll().get(i+1)))
                result = billsService.salaryForTeacher(daoBill.readAll().get(i));
        }
        assertEquals(result,billsService.maximumSalary(daoBill.readAll()));
    }
    }

