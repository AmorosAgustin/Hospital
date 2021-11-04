import Equipment.Bed;
import Equipment.Equipment;
import Equipment.ECG;

import Hospital.Hospital;
import Hospital.Database;

import Room.Room;
import Room.Bedroom;
import Room.ExamRoom;
import Room.Reception;
import Room.IntensiveCareUnit;

import People.People;
import People.Patient;
import People.Employee;
import People.Nurse;
import People.Receptionist;
import People.Doctor;

import java.sql.Array;
import java.util.ArrayList;


public class Runner {
    public static void main(String[] args) {

        Hospital hospital1 = new Hospital();


        Patient patient1 = new Patient("Erwin", "Smith", 000000001);
        Patient patient2 = new Patient("Charles", "Jones", 000000002);
        Patient patient3 = new Patient();
        Patient patient4 = new Patient("Robert", "Wilson", 000000004);

        patient3.setName("John");
        patient3.setSurname("Brown");
        patient3.setInsuranceNumber(000000003);

        Nurse nurse1 = new Nurse("Barbara", "King", 000001);
        Nurse nurse2 = new Nurse("Anthony", "Robinson", 000004);

        Doctor doctor1 = new Doctor(000002);
        doctor1.setName("Nancy");
        doctor1.setSurname("Wong");
        Doctor doctor2 = new Doctor(000005);
        doctor2.setSurname("Carter");
        doctor2.setName("Carl");

        Receptionist receptionist1 = new Receptionist("Matthew", "Baker", 000003);


        Bed bed1 = new Bed();

        bed1.setInclination(2);
        bed1.setID(000002);
        bed1.setWorking(true);
        bed1.setInUse(false);
        bed1.setType("Bed");

        IntensiveCareUnit intensiveCareUnit1 = new IntensiveCareUnit();
        Reception reception1 = new Reception(1);
        ExamRoom examRoom1 = new ExamRoom(2);
        Bedroom bedroom1 = new Bedroom(3);
        Bedroom bedroom2 = new Bedroom(new ArrayList<Employee>(), 004, null);

        reception1.getAssignedEmployee().add(receptionist1);
        examRoom1.getAssignedEmployee().add(doctor1);
        intensiveCareUnit1.getAssignedEmployee().add(nurse1);



        bedroom1.setBed(bed1);
        bed1.setLocationRoom(bedroom1);
        bedroom1.getAssignedEmployee().add(nurse2);


        Bed bed2 = new Bed(true, bedroom2, 000001, false,"Bed" ,2);
        bedroom2.setBed(bed2);

        bedroom2.getAssignedEmployee().add(nurse1);

        ECG ecg1=new ECG(true,examRoom1,3,"ECG Machine",false);
        Bed bed3=new Bed(true,intensiveCareUnit1,4,false,"Bed",0);
        intensiveCareUnit1.setBed(bed3);
        examRoom1.setAssignedEquipment(ecg1);




        hospital1.getEquipment().add(bed1);
        hospital1.getEquipment().add(bed2);
        hospital1.getEquipment().add(bed3);
        hospital1.getEquipment().add(ecg1);


        hospital1.getRooms().add(intensiveCareUnit1);
        hospital1.getRooms().add(reception1);
        hospital1.getRooms().add(bedroom1);
        hospital1.getRooms().add(bedroom2);
        hospital1.getRooms().add(examRoom1);

        patient1.arrive(reception1);
        patient2.arrive(reception1);
        patient3.arrive(reception1);
        patient4.arrive(reception1);

        receptionist1.addToPatientList(patient1,hospital1);
        receptionist1.addToPatientList(patient2,hospital1);
        receptionist1.addToPatientList(patient3,hospital1);
        receptionist1.addToPatientList(patient4,hospital1);

        receptionist1.addToEmployeeList(doctor1,hospital1);
        receptionist1.addToEmployeeList(doctor2,hospital1);
        receptionist1.addToEmployeeList(nurse1,hospital1);
        receptionist1.addToEmployeeList(nurse2,hospital1);
        receptionist1.addToEmployeeList(receptionist1,hospital1);

        nurse1.movePatient(patient1,bedroom1);
        nurse2.movePatient(patient2,bedroom2);
        nurse1.movePatient(patient3,examRoom1);
        nurse2.movePatient(patient4,intensiveCareUnit1);

        doctor1.performSurgery();


        nurse1.movePatient(patient1, reception1);
        patient1.leave();
        System.out.println(hospital1.toString());

    }
}
