public class Equipment {
    private String equipment_name;
    private int equipment_id;
    private boolean avalaibility;
    private String person ;
    private String time ;

    public Equipment(int equipment_id,String equipment_name,String time, boolean avalaibility, String person) {
        this.equipment_name = equipment_name;
        this.equipment_id = equipment_id;
        this.avalaibility = avalaibility;
        this.person = person;
        this.time=time;
    }
    Equipment(Equipment otherequipment){
        this.equipment_name = otherequipment.equipment_name;
        this.equipment_id = otherequipment.equipment_id;
        this.avalaibility = otherequipment.avalaibility;
        this.person = otherequipment.person;
        this.time=otherequipment.time;

    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEquipment_name() {
        return equipment_name;
    }

    public void setEquipment_name(String equipment_name) {
        this.equipment_name = equipment_name;
    }

    public int getEquipment_id() {
        return equipment_id;
    }

    public void setEquipment_id(int equipment_id) {
        this.equipment_id = equipment_id;
    }

    public boolean isAvalaibility() {
        return avalaibility;
    }

    public void setAvalaibility(boolean avalaibility) {
        this.avalaibility = avalaibility;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }
}
