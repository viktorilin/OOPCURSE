package vik.oop.services.Bills.impls;

import vik.oop.model.Bill.Bill;
import vik.oop.services.Bills.interfaces.IBillsService;

import java.util.List;

/**
 * Created by Asus on 09.04.2017.
 */
public class BillsServiceImpl implements IBillsService
{
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



    public int earningsForDay() {
        return 0;
    }

    public int salaryForTeacher() {
        return 0;
    }

    public int paymentFromGroupOfStudent() {
        return 0;
    }

    public int rentOfClassRoom() {
        return 0;
    }

    public int maximumSalary() {
        return 0;
    }

}
