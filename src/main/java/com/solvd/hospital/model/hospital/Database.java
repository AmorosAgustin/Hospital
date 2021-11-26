package com.solvd.hospital.model.hospital;

import com.solvd.hospital.model.exception.PersonNotInDatabaseException;
import com.solvd.hospital.model.medicine.Medicine;
import com.solvd.hospital.model.people.Employee;
import com.solvd.hospital.model.people.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Database {


    private static final Logger log = LogManager.getLogger(Database.class);

    private Set<Employee> employeeList;
    private Set<Patient> patientList;
    private List<Medicine> medicineList;

    public Database(HashSet<Employee> employeeList, HashSet<Patient> patientList, ArrayList<Medicine> medicineList) {
        this.employeeList = employeeList;
        this.patientList = patientList;
        this.medicineList = medicineList;
    }

    public Database() {
        this.employeeList = new HashSet<Employee>();
        this.patientList = new HashSet<Patient>();
        this.medicineList = new ArrayList<Medicine>();

    }


    public Set<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(HashSet<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Set<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(HashSet<Patient> patientList) {
        this.patientList = patientList;
    }

    public Patient searchPatientInsurance(String insuranceNumber) {
        for (Iterator<Patient> it = this.patientList.iterator(); it.hasNext(); ) {

            if (it.next().getInsuranceNumber() == insuranceNumber) {
                log.info("The patient with the introduced insurance number is" + it.next().toString());
                return it.next();
            }
        }
        throw new PersonNotInDatabaseException("There are no patients with the introduced insurance number");


    }


    public Employee searchEmployeeID(int ID) {
        for (Iterator<Employee> it = this.employeeList.iterator(); it.hasNext(); ) {

            if (it.next().getID() == ID) {
                log.info("The employee with the introduced ID number is" + it.next().toString());
                return it.next();
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
        return "---Employee List--- " + "\n" + employeeList + "\n" +
                " ---Patient List--- " + "\n" + patientList + "\n" +
                " ---Medicine List---  " + "\n" + medicineList;
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
