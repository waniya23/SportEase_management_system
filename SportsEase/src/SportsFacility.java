import java.util.ArrayList;

abstract public class SportsFacility {
    private int id;
    private ArrayList slots = new ArrayList();
    public SportsFacility(int id,ArrayList<Slot> slots) {
        this.id = id;
        this.slots = slots;

    }
    protected void addSlot(int id,boolean available,String time , String person){
        slots.add(new Slot(id,time,available,person));
    }

    public int getId() {
        return id;
    }

    public ArrayList<Slot> getSlots() {
        return slots;
    }

    abstract void displaySlots();

    public void setId(int id) {
        this.id = id;
    }

    public void setSlots(ArrayList slots) {
        this.slots = slots;
    }
}

