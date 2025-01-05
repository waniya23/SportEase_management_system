import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class BadmintonCourt extends SportsFacility{



    public BadmintonCourt(int id, ArrayList<Slot> slots) {
        super(id, slots);

    }

    protected void displaySlots(){
        for (int i=0;i<getSlots().size();i++){
            System.out.println("SlotID: "+getSlots().get(i).getSlotid()+" ---"+"Time: "+getSlots().get(i).getTime()+" Available: "+getSlots().get(i).getAvailable());
        }

    }


}
