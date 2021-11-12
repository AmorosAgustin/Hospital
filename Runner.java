import EquipmentAndMachinery.Bed;
import EquipmentAndMachinery.ECG;

import EquipmentAndMachinery.Scalpel;
import Hospital.Hospital;

import Medicine.Medicine;
import Room.Bedroom;
import Room.ExamRoom;
import Room.Reception;
import Room.IntensiveCareUnit;

import People.Patient;
import People.Employee;
import People.Nurse;
import People.Receptionist;
import People.Doctor;

import Exception.ItemNotFoundException;
import Exception.PersonNotInDatabaseException;
import Exception.PersonAlreadyInDatabaseException;
import Exception.ItemNotAvailableException;
import Exception.MachineryBrokenException;

import java.util.ArrayList;


public class Runner {
    public static void main(String[] args) throws ItemNotFoundException, PersonAlreadyInDatabaseException, PersonAlreadyInDatabaseException {

        Hospital hospital1 = new Hospital();


        Patient patient1 = new Patient("Erwin", "Smith", "000000001");
        Patient patient2 = new Patient("Charles", "Jones", "000000002");
        Patient patient3 = new Patient();
        Patient patient4 = new Patient("Robert", "Wilson", "000000004");
        Patient patient5 = new Patient("Ashley", "Williams", "000000005");


        patient3.setName("John");
        patient3.setSurname("Brown");
        patient3.setInsuranceNumber("000000003");

        Nurse nurse1 = new Nurse("Barbara", "King", 1, hospital1);
        Nurse nurse2 = new Nurse("Anthony", "Robinson", 4, hospital1);

        Doctor doctor1 = new Doctor(2);
        doctor1.setName("Nancy");
        doctor1.setSurname("Wong");
        doctor1.setAssignedHospital(hospital1);
        Doctor doctor2 = new Doctor(5);
        doctor2.setSurname("Carter");
        doctor2.setName("Carl");
        doctor2.setAssignedHospital(hospital1);

        Receptionist receptionist1 = new Receptionist("Matthew", "Baker", 3, hospital1);


        Bed bed1 = new Bed();

        bed1.setInclination(2);
        bed1.setID(000002);
        bed1.setAvailable(true);
        bed1.setInUse(false);
        bed1.setType("Bed");

        IntensiveCareUnit intensiveCareUnit1 = new IntensiveCareUnit();
        Reception reception1 = new Reception(1);
        ExamRoom examRoom1 = new ExamRoom(2);
        Bedroom bedroom1 = new Bedroom(3);
        Bedroom bedroom2 = new Bedroom(new ArrayList<Employee>(), 4, null);

        reception1.getAssignedEmployee().add(receptionist1);
        receptionist1.setLocationRoom(reception1);

        examRoom1.getAssignedEmployee().add(doctor1);
        doctor1.setLocationRoom(examRoom1);

        intensiveCareUnit1.getAssignedEmployee().add(nurse1);
        nurse1.setLocationRoom(intensiveCareUnit1);

        bedroom1.setBed(bed1);
        bed1.setLocationRoom(bedroom1);
        bedroom1.getAssignedEmployee().add(nurse2);
        nurse2.setLocationRoom(bedroom1);

        Bed bed2 = new Bed(true, bedroom2, 1, false, 2);
        bedroom2.setBed(bed2);

        bedroom2.getAssignedEmployee().add(doctor2);
        doctor2.setLocationRoom(bedroom2);

        ECG ecg1 = new ECG(true, examRoom1, 3, "ECG Machine", false);
        Bed bed3 = new Bed(true, intensiveCareUnit1, 4, false, 0);
        intensiveCareUnit1.setBed(bed3);
        examRoom1.setAssignedMachinery(ecg1);

        Medicine med1 = new Medicine("Amoxicillin");
        Medicine med2 = new Medicine("Ibuprofen");

        Scalpel scalpel1 = new Scalpel(true, examRoom1, 6, "Scalpel");

        nurse1.setEquipmentInUse(scalpel1);

        hospital1.getEquipment().add(bed1);
        hospital1.getEquipment().add(bed2);
        hospital1.getEquipment().add(bed3);
        hospital1.getEquipment().add(scalpel1);
        hospital1.getMachinery().add(ecg1);


        hospital1.getRooms().add(intensiveCareUnit1);
        hospital1.getRooms().add(reception1);
        hospital1.getRooms().add(bedroom1);
        hospital1.getRooms().add(bedroom2);
        hospital1.getRooms().add(examRoom1);

        hospital1.getDatabase().getMedicineList().add(med1);
        hospital1.getDatabase().getMedicineList().add(med2);

        patient1.arrive(reception1);
        patient2.arrive(reception1);
        patient3.arrive(reception1);
        patient4.arrive(reception1);

        try {
            receptionist1.addToPatientList(patient1);
            receptionist1.addToPatientList(patient2);
            receptionist1.addToPatientList(patient3);
            receptionist1.addToPatientList(patient4);
            receptionist1.addToPatientList(patient4);//I add patient4 to throw an exception
        } catch (PersonAlreadyInDatabaseException e) {
            System.out.println(e);
        }

        try {
            receptionist1.removeFromEmployeeList(doctor1);
        } catch (PersonNotInDatabaseException e) {
            System.out.println(e);
        }


        receptionist1.addToEmployeeList(doctor1);
        receptionist1.addToEmployeeList(doctor2);
        receptionist1.addToEmployeeList(nurse1);
        receptionist1.addToEmployeeList(nurse2);
        receptionist1.addToEmployeeList(receptionist1);

        nurse1.movePatient(patient1, bedroom1);
        nurse2.movePatient(patient2, bedroom2);
        nurse1.movePatient(patient3, examRoom1);
        nurse2.movePatient(patient4, intensiveCareUnit1);

        doctor1.performSurgery();


        nurse1.movePatient(patient1, reception1);
        patient1.leave();
        doctor1.prescribe(med2, patient3);
        System.out.println(hospital1.toString());


        doctor1.diagnosePatient(patient3);
        doctor1.treatPatient(patient3);
        patient3.printMedicalHistory();
        doctor1.prescribe(med1, patient3);
        try {
            doctor1.askForItem(nurse2);
            System.out.println(doctor1.getEquipmentInUse().getType());

        } catch (ItemNotFoundException | ItemNotAvailableException e) {
            System.out.println(e);
        }

        try {
            doctor1.askForItem(nurse1);
            System.out.println(doctor1.getEquipmentInUse().getType());

        } catch (ItemNotFoundException | ItemNotAvailableException e) {
            System.out.println(e);
        }

        System.out.println(med1.equals(med2));

        try {
            System.out.println(doctor2.askForMedicalHistory(receptionist1, patient3).toString());
            System.out.println(doctor2.askForMedicalHistory(receptionist1, patient5).toString());
        } catch (PersonNotInDatabaseException e) {
            System.out.println(e);
        }


    }
}
