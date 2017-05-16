package vik.oop.services.Bill.impls;

import vik.oop.dao.Bill.interfaces.IDaoBill;
import vik.oop.model.Bill.Bill;
import vik.oop.services.Bill.interfaces.IBillService;

import java.util.List;

/**
 * Created by Asus on 09.04.2017.
 */
public class BillServiceImpl implements IBillService {
    IDaoBill daoBill;

    public BillServiceImpl() {
    }

    public BillServiceImpl(IDaoBill daoBill) {
        this.daoBill = daoBill;
    }

    public IDaoBill getDaoBill() {
        return daoBill;
    }

    public void setDaoBill(IDaoBill daoBill) {
        this.daoBill = daoBill;
    }

    public List<Bill> getAll() {
        return daoBill.getAll();
    }

    public Bill getBill(int id) {
        return daoBill.getBill(id);
    }

    public void createBill(Bill bill) {
        daoBill.createBill(bill);
    }

    public void updateBill(Bill bill) {
        daoBill.updateBill(bill);
    }

    public void deleteBill(int id) {
        daoBill.deleteBill(id);
    }

    public void showAll() {
        daoBill.showAll();
    }
}
