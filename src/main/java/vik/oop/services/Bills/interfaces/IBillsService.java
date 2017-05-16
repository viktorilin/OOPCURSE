package vik.oop.services.Bills.interfaces;

import vik.oop.model.Bill.Bill;

import java.util.List;

/**
 * Created by Asus on 09.04.2017.
 */
public interface IBillsService
{
    List<Bill> getAll();
    Bill getBill(int id);
    void createBill(Bill bill);
    void updateBill(Bill bill);
    void deleteBill(int id);
    void showAll();
    public int earningsForDay();
    public int salaryForTeacher();
    public int paymentFromGroupOfStudent();
    public int rentOfClassRoom();
    public int maximumSalary();

}
