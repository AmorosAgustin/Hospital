package Hospital;

import People.Employee;
import People.Patient;

import java.util.ArrayList;
import java.util.List;

public class Database {


    private List<Employee> employeeList;
    private List<Patient> patientList;


    public Database(ArrayList<Employee> employeeList, ArrayList<Patient> patientList) {
        this.employeeList = employeeList;
        this.patientList = patientList;
    }

    public Database() {
        this.employeeList = new ArrayList<Employee>();
        this.patientList = new ArrayList<Patient>();

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

    public Patient searchPatientInsurance(int insuranceNumber) {
        for (int i = 0; i < this.patientList.size(); i++) {

            if (this.patientList.get(i).getInsuranceNumber() == insuranceNumber) {
                System.out.println("The patient with the introduced insurance number is" + this.patientList.get(i).toString());
                return this.patientList.get(i);
            }
        }
        System.out.println("There are no patients with the introduced insurance number");
        return null;

    }


    public Employee searchEmployeeID(int ID) {
        for (int i = 0; i < this.employeeList.size(); i++) {

            if (this.employeeList.get(i).getID() == ID) {
                System.out.println("The employee with the introduced ID number is" + this.employeeList.get(i).toString());
                return this.employeeList.get(i);
            }
        }
        System.out.println("There are no employee with the introduced ID number");
        return null;

    }


    @Override
    public String toString() {
        return "EmployeeList = " + "\n" + employeeList + "\n" +
                ", PatientList = " + "\n" + patientList;
    }


}
