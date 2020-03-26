package homework;

public class Student {
    private String name = "NULL";
    private String ID = "NULL";

    public Student(String ID, String name) {
        super();
        this.ID = ID;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    @Override
    public String toString() {
        return "Student [ID=" + ID + ", name=" + name + "]";
    }

}
