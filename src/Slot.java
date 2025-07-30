public class Slot {
    private int slotid;
    private String time;
    private boolean available;
    private String person;

    public void setPerson(String person) {
        this.person = person;
    }

    public String getPerson() {
        return person;
    }

    public Slot(int id, String time, boolean available, String person) {
        this.slotid = id;
        this.time = time;
        this.available = available;
        this.person = person;
    }
    public Slot(Slot other){

        this.slotid = other.slotid;
        this.time = other.time;
        this.available = other.available;
        this.person= other.person;
    }

    public int getSlotid() {
        return slotid;
    }

    public void setSlotid(int slotid) {
        this.slotid = slotid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean getAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
