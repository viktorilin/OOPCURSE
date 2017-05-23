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
    public int earningsForDay(List<Bill> bills);
    public int salaryForTeacher(Bill bill);
    public int paymentFromGroupOfStudent(Bill bill);
    public double maxRentOfClassRoom(List<Bill> bills);
    public int maximumSalary(List<Bill> bills);

}
