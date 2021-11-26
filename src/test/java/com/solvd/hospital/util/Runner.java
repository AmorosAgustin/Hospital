package com.solvd.hospital.util;

import com.solvd.hospital.model.equipmentAndMachinery.Bed;
import com.solvd.hospital.model.equipmentAndMachinery.ECG;
import com.solvd.hospital.model.equipmentAndMachinery.Scalpel;
import com.solvd.hospital.model.exception.ItemNotAvailableException;
import com.solvd.hospital.model.exception.ItemNotFoundException;
import com.solvd.hospital.model.exception.PersonAlreadyInDatabaseException;
import com.solvd.hospital.model.exception.PersonNotInDatabaseException;
import com.solvd.hospital.model.generic.CompareObjectField;
import com.solvd.hospital.model.generic.MoveObject;
import com.solvd.hospital.model.generic.PrintObjectToString;
import com.solvd.hospital.model.hospital.Hospital;
import com.solvd.hospital.model.medicine.Medicine;
import com.solvd.hospital.model.people.*;
import com.solvd.hospital.model.room.Bedroom;
import com.solvd.hospital.model.room.ExamRoom;
import com.solvd.hospital.model.room.IntensiveCareUnit;
import com.solvd.hospital.model.room.Reception;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;


public class Runner {


    private static final Logger log = LogManager.getLogger(Runner.class);


    public static void main(String[] args) {

        log.info("Here i create my hospital with its patients, employees, equipment, machinery and rooms");

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

        log.info("\n" + reception1);


        try {
            receptionist1.addToPatientList(patient1);
            receptionist1.addToPatientList(patient2);
            receptionist1.addToPatientList(patient3);
            receptionist1.addToPatientList(patient4);
            receptionist1.addToPatientList(patient4);//I add patient4 to throw an exception
        } catch (PersonAlreadyInDatabaseException e) {
            log.info(e);
        }

        try {
            receptionist1.removeFromEmployeeList(doctor1);
        } catch (PersonNotInDatabaseException e) {
            log.info(e);
        }


        receptionist1.addToEmployeeList(doctor1);
        receptionist1.addToEmployeeList(doctor2);
        receptionist1.addToEmployeeList(nurse1);
        receptionist1.addToEmployeeList(nurse2);
        receptionist1.addToEmployeeList(receptionist1);

        receptionist1.assignNextPatientToRoom(bedroom1);
        receptionist1.assignNextPatientToRoom(bedroom2);
        log.info("\n" + reception1);
        nurse1.movePatient(patient3, examRoom1);
        nurse2.movePatient(patient4, intensiveCareUnit1);

        doctor1.performSurgery();


        nurse1.movePatient(patient1, reception1);
        patient1.leave();
        doctor1.prescribe(med2, patient3);

        log.info("\n" + hospital1);


        doctor1.diagnosePatient(patient3);
        doctor1.treatPatient(patient3);
        patient3.printMedicalHistory();
        doctor1.prescribe(med1, patient3);
        try {
            doctor1.askForItem(nurse2);
            log.info(doctor1.getEquipmentInUse().getType());

        } catch (ItemNotFoundException | ItemNotAvailableException e) {
            log.info(e);
        }

        try {
            doctor1.askForItem(nurse1);
            log.info(doctor1.getEquipmentInUse().getType());

        } catch (ItemNotFoundException | ItemNotAvailableException e) {
            log.info(e);
        }

        log.info(med1.equals(med2));

        try {
            log.info(doctor2.askForMedicalHistory(receptionist1, patient3).toString());
            log.info(doctor2.askForMedicalHistory(receptionist1, patient5).toString());
        } catch (PersonNotInDatabaseException e) {
            log.error("PersonNotInDatabaseException", e);
        }


        PrintObjectToString<Object> printer = new PrintObjectToString<>();

        log.info("\nHere i print some objects using my generic print class \n");
        printer.print(doctor1);
        printer.print(patient2);
        printer.print(bed2);

        MoveObject<Object> mover = new MoveObject<>();

        mover.move(patient3, reception1);

        CompareObjectField<Object> comparer = new CompareObjectField<>();

        log.info(doctor1.getID());
        log.info(doctor2.getID());
        log.info("comparing doctor1 and doctor2 ID..." + comparer.compareField(doctor1, doctor2, "ID"));

        doctor2.setID(doctor1.getID());
        log.info(doctor1.getID());
        log.info(doctor2.getID());

        log.info("comparing doctor1 and doctor2 ID..." + comparer.compareField(doctor1, doctor2, "ID"));

        doctor2.setID(5);

        log.info(patient1.getLocationRoom());
        log.info(patient2.getLocationRoom());

        log.info("comparing patient1 and patient2 locationRoom..." + comparer.compareField(patient1, patient2, "locationRoom"));


    }


}
