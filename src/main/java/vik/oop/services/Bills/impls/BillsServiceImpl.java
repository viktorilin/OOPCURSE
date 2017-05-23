package vik.oop.services.Bills.impls;

import vik.oop.model.Bill.Bill;
import vik.oop.model.Teacher.Teacher;
import vik.oop.services.Bills.interfaces.IBillsService;
import vik.oop.services.GroupOfStudent.impls.GroupOfStudentServiceImpl;
import vik.oop.services.GroupOfStudent.interfaces.IGroupOfStudentService;
import vik.oop.services.Lesson.interfaces.ILessonService;
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
        return 0;
    }

    public int salaryForTeacher(Bill bill) {
        ITeacherService iTeacherService = null;
        return (iTeacherService.getPaymentForTeacher(bill.getTeacher())) * (bill.getGroupOfStudent().getNumberOfStudents());
    }

    public int paymentFromGroupOfStudent(Bill bill) {
        ILessonService iLessonService = null;
        return (int) (iLessonService.getRentOfClassRoom(bill.getLesson()) * bill.getGroupOfStudent().getNumberOfStudents());
    }

    public double maxRentOfClassRoom(List<Bill> bills) {
        ILessonService iLessonService = null;
        double result = iLessonService.getRentOfClassRoom(bills.get(0).getLesson());
        for (int i = 0; i < bills.size() - 1; i++) {
            if (iLessonService.getRentOfClassRoom(bills.get(i).getLesson()) > iLessonService.getRentOfClassRoom(bills.get(i + 1).getLesson()))
                result = iLessonService.getRentOfClassRoom(bills.get(i).getLesson());
        }
        return result;
    }

    public int maximumSalary(List<Bill> bills) {
        int i =0;
        int result =0;
        for (i = 0; i < bills.size()-1;i++) {
            Bill bill  = bills.get(i);
            if(iBillsService.salaryForTeacher(bill) > iBillsService.salaryForTeacher(bills.get(i+1)))
            result = iBillsService.salaryForTeacher(bills.get(i));
        }
        return result;
    }

}
