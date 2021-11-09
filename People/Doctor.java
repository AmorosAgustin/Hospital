package People;
import java.util.Scanner;

public class Doctor extends Employee {

    String type;



    public Doctor() {
        super();
        this.type= "no specialization";
    }

    public Doctor(int ID) {
        super(ID);
    }


    public Doctor(int ID, String type) {
        super(ID);
        this.type=type;
    }


    public Doctor(String name, String surname, int ID) {
        super(name, surname, ID);
    }



    public void performSurgery() {
        System.out.println("Surgery finished");
    }



    public void treatPatient(Patient patient){

        patient.setIllness("none");
        patient.getMedicalHistory().add("Cured");

    }

    public void diagnosePatient(Patient patient){
        Scanner input=new Scanner(System.in);
        System.out.println("What is the patients illness?\n");
        String illness=input.nextLine();
        patient.setIllness(illness);
        patient.getMedicalHistory().add(illness);
        System.out.println("Patient 3 has been diagnosed with: " + illness );

    }

    @Override
    public String toString() {
        return super.toString() +
                ",  Type='" + type + '\'' +
                "\n";
    }
}
