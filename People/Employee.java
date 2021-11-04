package People;

public abstract class Employee extends People {



    private int ID;

    public Employee() {
        super();
        this.ID = 000000;
    }

    public Employee(int ID) {
        super();
        this.ID = ID;
    }

    public Employee(String name, String surname, int ID) {
        super(name, surname);
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return  "Name= '" + this.getName() + '\'' +
                ", Surname= '" + this.getSurname() + '\'' +
                ", ID= " + ID +"\n";
    }
}
