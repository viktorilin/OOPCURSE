package vik.oop.services.Bills.impls;

import vik.oop.model.Bill.Bill;
import vik.oop.model.Teacher.Teacher;
import vik.oop.services.Bills.interfaces.IBillsService;
import vik.oop.services.GroupOfStudent.impls.GroupOfStudentServiceImpl;
import vik.oop.services.GroupOfStudent.interfaces.IGroupOfStudentService;
import vik.oop.services.Lesson.impls.LessonServiceImpl;
import vik.oop.services.Lesson.interfaces.ILessonService;
import vik.oop.services.Teacher.impls.TeacherServiceImpl;
import vik.oop.services.Teacher.interfaces.ITeacherService;

import java.util.List;

/**
 * Created by Asus on 09.04.2017.
 */
public class BillsServiceImpl implements IBillsService {
    IBillsService iBillsService;

    public List<Bill> getAll() {
        return iBillsService.getAll();
    }

    public Bill getBill(int id) {
        return iBillsService.getBill(id);
    }

    public void createBill(Bill bill) {
        iBillsService.createBill(bill);
    }

    public void updateBill(Bill bill) {
        iBillsService.updateBill(bill);
    }

    public void deleteBill(int id) {
        iBillsService.deleteBill(id);
    }

    public void showAll() {
        iBillsService.showAll();
    }


    public int earningsForDay(List<Bill> bills) {
        int result = 0;
        LessonServiceImpl lessonService = new LessonServiceImpl();
        BillsServiceImpl billsService = new BillsServiceImpl();
        for (Bill bill:bills) {
            result += billsService.paymentFromGroupOfStudent(bill);
            result -= billsService.salaryForTeacher(bill);
            result -= lessonService.getRentOfClassRoom(bill.getLesson());
        }
        return result;
    }

    public int salaryForTeacher(Bill bill) {
        TeacherServiceImpl teacherService = new TeacherServiceImpl();
        return (teacherService.getPaymentForTeacher(bill.getTeacher())) * (bill.getGroupOfStudent().getNumberOfStudents());
    }

    public int paymentFromGroupOfStudent(Bill bill) {
        LessonServiceImpl lessonService = new LessonServiceImpl();
        return (int) (lessonService.getRentOfClassRoom(bill.getLesson()) * bill.getGroupOfStudent().getNumberOfStudents());
    }

    public double maxRentOfClassRoom(List<Bill> bills) {
        LessonServiceImpl lessonService = new LessonServiceImpl();
        double result = lessonService.getRentOfClassRoom(bills.get(0).getLesson());
        for (int i = 0; i < bills.size() - 1; i++) {
            if (lessonService.getRentOfClassRoom(bills.get(i).getLesson()) > lessonService.getRentOfClassRoom(bills.get(i + 1).getLesson()))
                result = lessonService.getRentOfClassRoom(bills.get(i).getLesson());
        }
        return result;
    }

    public int maximumSalary(List<Bill> bills) {
        BillsServiceImpl billsService = new BillsServiceImpl();
        int i =0;
        int result =0;
        for (i = 0; i < bills.size()-1;i++) {
            Bill bill  = bills.get(i);
            if(billsService.salaryForTeacher(bill) > billsService.salaryForTeacher(bills.get(i+1)))
            result = billsService.salaryForTeacher(bills.get(i));
        }
        return result;
    }

}
