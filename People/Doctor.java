package People;

public class Doctor extends Employee {


    public Doctor() {
        super();
    }

    public Doctor(int ID) {
        super(ID);
    }

    public Doctor(String name, String surname, int ID) {
        super(name, surname, ID);
    }


    public void performSurgery() {
        System.out.println("Surgery finished");
    }
}
