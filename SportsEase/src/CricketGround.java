import java.util.ArrayList;

public class CricketGround extends SportsFacility{
    public CricketGround(int id, ArrayList<Slot> slots) {
        super(id, slots);

    }

    protected void displaySlots(){
        for (int i=0;i<getSlots().size();i++){
            System.out.println("SlotID: "+getSlots().get(i).getSlotid()+" ---"+"Time: "+getSlots().get(i).getTime()+" Available: "+getSlots().get(i).getAvailable());
        }

    }

}
