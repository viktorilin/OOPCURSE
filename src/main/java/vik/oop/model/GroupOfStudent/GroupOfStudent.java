package vik.oop.model.GroupOfStudent;

/**
 * Created by Asus on 27.03.2017.
 */
public class GroupOfStudent
{
    private int id;
    private int numberOfGroup;
    private String specialty;
    private String department;
    private int numberOfStudents;

    @Override
    public String toString() {
        return "GroupOfStudent{" +
                "id=" + id +
                ", numberOfGroup=" + numberOfGroup +
                ", specialty='" + specialty + '\'' +
                ", department='" + department + '\'' +
                ", numberOfStudents=" + numberOfStudents +
                '}';
    }

    public GroupOfStudent() {
    }

    public GroupOfStudent(int id, int numberOfGroup, String specialty, String department, int numberOfStudents) {
        this.id = id;
        this.numberOfGroup = numberOfGroup;
        this.specialty = specialty;
        this.department = department;
        this.numberOfStudents = numberOfStudents;
    }

    public int getNumberOfGroup() {
        return numberOfGroup;
    }

    public void setNumberOfGroup(int numberOfGroup) {
        this.numberOfGroup = numberOfGroup;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
    }
}
