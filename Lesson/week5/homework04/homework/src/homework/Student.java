package homework;

public class Student {
    private String name = "NULL";
    private String ID = "NULL";
    private boolean ifSet = false;

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

    public boolean isIfSet() {
        return ifSet;
    }

    public void setIfSet(boolean ifSet) {
        this.ifSet = ifSet;
    }

}
