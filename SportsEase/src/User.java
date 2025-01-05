import com.sun.source.tree.BreakTree;

import javax.swing.plaf.basic.BasicButtonUI;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.util.ArrayList;

public abstract class User {
    private String email;
    private String password;


    abstract protected boolean authenticateUser();


    public String getEmail() {
        return email;
    }

    void display() {
        System.out.println("Email : " + getEmail());

    }

    public void setEmail(String email) {
        this.email = email;
    }
    protected abstract  void viewBooking(ManagementSystem sports);


    protected boolean canBook(Slot slot, ArrayList<SportsFacility> bground, ArrayList<SportsFacility> cground, ArrayList
            <SportsFacility> fground) {

        String time = slot.getTime();

        for (int i = 0; i < bground.size(); i++) {
            ArrayList<Slot> slots = bground.get(i).getSlots();
            for (int j = 0; j < slots.size(); j++) {
                if ((this.getEmail().equals(slots.get(j).getPerson())) && (slots.get(j).getTime().equals(time))) {
                    System.out.println("Cannot Book more than one court for time slot " + slot.getTime());

                    return false;

                }

            }
        }
        for (int i = 0; i < cground.size(); i++) {
            ArrayList<Slot> slots = cground.get(i).getSlots();
            for (int j = 0; j < slots.size(); j++) {
                if ((this.getEmail().equals(slots.get(j).getPerson())) && (slots.get(j).getTime().equals(time))) {
                    System.out.println("Cannot Book more than one court for time slot " + slot.getTime());

                    return false;

                }

            }
        }

        for (int i = 0; i < fground.size(); i++) {
            ArrayList<Slot> slots = fground.get(i).getSlots();
            for (int j = 0; j < slots.size(); j++) {
                if ((this.getEmail().equals(slots.get(j).getPerson())) && (slots.get(j).getTime().equals(time))) {
                    System.out.println("Cannot Book more than one court for time slot " + slot.getTime());

                    return false;

                }

            }
        }

        return true;

    }

    protected boolean canBookEquipment(Equipment equipment, ArrayList<SportEquipment> bequip, ArrayList<SportEquipment> cequip, ArrayList<SportEquipment> fequip) {
        String time = equipment.getTime();
        for (int i = 0; i < bequip.size(); i++) {
            ArrayList<Equipment> equip = bequip.get(i).getEquipment();
            for (int j = 0; j < equip.size(); j++) {
                if ((this.getEmail().equals(equip.get(j).getPerson())) && (equip.get(j).getTime().equals(time))) {
                    System.out.println("Cannot Book more than one equipment for time slot " + equipment.getTime());
                    return false;

                }

            }
        }
        for (int i = 0; i < cequip.size(); i++) {
            ArrayList<Equipment> equip = cequip.get(i).getEquipment();
            for (int j = 0; j < equip.size(); j++) {
                if ((this.getEmail().equals(equip.get(j).getPerson())) && (equip.get(j).getTime().equals(time))) {
                    System.out.println("Cannot Book more than one equipment for time slot " + equipment.getTime());
                    return false;

                }

            }
        }
        for (int i = 0; i < fequip.size(); i++) {
            ArrayList<Equipment> equip = fequip.get(i).getEquipment();
            for (int j = 0; j < equip.size(); j++) {
                if ((this.getEmail().equals(equip.get(j).getPerson())) && (equip.get(j).getTime().equals(time))) {
                    System.out.println("Cannot Book more than one equipment for time slot " + equipment.getTime());
                    return false;

                }

            }
        }
        return true;

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}



