package vik.oop.dao.Bill.interfaces;

import vik.oop.model.Bill.Bill;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 03.04.2017.
 */
public interface IDaoBill
{
    ArrayList<Bill> readAll();
    List<Bill> getAll();
    Bill getBill(int id);
    void createBill (Bill bill);
    void updateBill (Bill bill);
    void deleteBill (int id);
    void showAll();

}
