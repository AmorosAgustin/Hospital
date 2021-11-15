package com.solvd.hospital.model.Hospital;

import com.solvd.hospital.model.Exception.PersonNotInDatabaseException;
import com.solvd.hospital.model.Medicine.Medicine;
import com.solvd.hospital.model.People.Employee;
import com.solvd.hospital.model.People.Patient;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Database {


    private List<Employee> employeeList;
    private List<Patient> patientList;
    private List<Medicine> medicineList;

    public Database(ArrayList<Employee> employeeList, ArrayList<Patient> patientList, ArrayList<Medicine> medicineList) {
        this.employeeList = employeeList;
        this.patientList = patientList;
        this.medicineList = medicineList;
    }

    public Database() {
        this.employeeList = new ArrayList<Employee>();
        this.patientList = new ArrayList<Patient>();
        this.medicineList = new ArrayList<Medicine>();

    }


    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }

    public Patient searchPatientInsurance(String insuranceNumber) throws PersonNotInDatabaseException {
        for (int i = 0; i < this.patientList.size(); i++) {

            if (this.patientList.get(i).getInsuranceNumber() == insuranceNumber) {
                System.out.println("The patient with the introduced insurance number is" + this.patientList.get(i).toString());
                return this.patientList.get(i);
            }
        }
        throw new PersonNotInDatabaseException("There are no patients with the introduced insurance number");


    }


    public Employee searchEmployeeID(int ID) throws PersonNotInDatabaseException {
        for (int i = 0; i < this.employeeList.size(); i++) {

            if (this.employeeList.get(i).getID() == ID) {
                System.out.println("The employee with the introduced ID number is" + this.employeeList.get(i).toString());
                return this.employeeList.get(i);
            }
        }
        throw new PersonNotInDatabaseException("There are no employee with the introduced ID number");

    }

    public List<Medicine> getMedicineList() {
        return medicineList;
    }

    public void setMedicineList(List<Medicine> medicineList) {
        this.medicineList = medicineList;
    }

    @Override
    public String toString() {
        return "Employee List = " + "\n" + employeeList + "\n" +
                ", Patient List = " + "\n" + patientList + "\n" +
                ", Medicine List = " + "\n" + medicineList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Database database = (Database) o;
        return Objects.equals(employeeList, database.employeeList) && Objects.equals(patientList, database.patientList) && Objects.equals(medicineList, database.medicineList);
    }

    @Override
    public int hashCode() {
        return employeeList.hashCode() * patientList.hashCode() * medicineList.hashCode();
    }
}
