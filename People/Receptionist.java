package People;

import Hospital.Hospital;

public class Receptionist extends Employee {


    public Receptionist() {
        super();
    }

    public Receptionist(int ID) {
        super(ID);
    }

    public Receptionist(String name, String surname, int ID) {
        super(name, surname, ID);
    }


    public void addToPatientList(Patient patient, Hospital hospital) {
        hospital.getDatabase().getPatientList().add(patient);


    }

    public void removeFromPatientList(Patient patient, Hospital hospital) {
        hospital.getDatabase().getPatientList().remove(patient);


    }

    public void addToEmployeeList(Employee employee, Hospital hospital) {
        hospital.getDatabase().getEmployeeList().add(employee);


    }

    public void removeFromEmployeeList(Employee employee, Hospital hospital) {
        hospital.getDatabase().getEmployeeList().remove(employee);


    }

}
