import java.util.ArrayList;

public class FootballEquipment extends SportEquipment{

    public FootballEquipment(int id, ArrayList<Equipment> equipment) {
        super(id, equipment);
    }

    void displayEquipment(){
        for (int i=0;i<getEquipment().size();i++){
            System.out.println("Slot ID: "+getEquipment().get(i).getEquipment_id()+" "+getEquipment().get(i).getEquipment_name()+" --- Time "+getEquipment().get(i).getTime()+" Availability : "+getEquipment().get(i).isAvalaibility());
        }

    }
}
