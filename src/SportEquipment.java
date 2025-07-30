import java.util.ArrayList;

public class SportEquipment {
    int id;
    ArrayList<Equipment> equipment;
    public SportEquipment(int id , ArrayList<Equipment> equipment) {
        this.id=id;
        this.equipment=equipment;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(ArrayList<Equipment> equipment) {
        this.equipment = equipment;
    }
    void displayEquipment(){}
}
