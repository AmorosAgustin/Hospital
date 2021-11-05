package People;

import java.util.Objects;

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
        return "Name= '" + this.getName() + '\'' +
                ", Surname= '" + this.getSurname() + '\'' +
                ", ID= " + ID + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return ID == employee.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ID);
    }
}
