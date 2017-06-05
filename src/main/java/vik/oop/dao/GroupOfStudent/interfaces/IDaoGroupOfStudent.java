package vik.oop.dao.GroupOfStudent.interfaces;

import vik.oop.model.GroupOfStudent.GroupOfStudent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 03.04.2017.
 */
public interface IDaoGroupOfStudent {
    ArrayList<GroupOfStudent> readAll();
    List<GroupOfStudent> getAll();
    GroupOfStudent getGroupOfStudent(int id);
    void createGroupOfStudent (GroupOfStudent bill);
    void updateGroupOfStudent (GroupOfStudent bill);
    void deleteGroupOfStudent (int id);
    void showAll();
}
