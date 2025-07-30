import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends User{


    @Override
    protected boolean authenticateUser() {

        try {
            Scanner obj = new Scanner(System.in);
            System.out.print("Enter your NU-email: ");
            String email = obj.nextLine();


            BufferedReader br = new BufferedReader(new FileReader("Adminfile.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String parts[] = line.split(" ");
                String thisemail = parts[0];
                String thispass = parts[1];

                if (thisemail.equals(email)) {
                    System.out.print("Enter password: ");
                    String pass = obj.nextLine();
                    if (pass.equals(thispass)) {
                        System.out.println("Admin authenticated");
                        this.setEmail(thisemail);
                        this.setPassword(thispass);
                        return true;
                    } else {
                        System.out.println("Incorrect password. Try again");
                        return false;
                    }
                }
            }
            System.out.println("Email not found");
            br.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }



    public void viewBooking(ManagementSystem sports) {
        ArrayList<SportsFacility> bground = sports.getBadmintonCourts();
        ArrayList<SportsFacility> cground = sports.getCricketGrounds();
        ArrayList<SportsFacility> fground = sports.getFootballCourts();

        ArrayList<SportEquipment> bequip = sports.getBadmintonEquipments();
        ArrayList<SportEquipment> cequip = sports.getCricketEquipments();
        ArrayList<SportEquipment> fequip = sports.getFootballEquipments();

        System.out.println("\nYour Bookings:");

        // Check and display bookings for Badminton courts
        for (SportsFacility facility : bground) {
            for (Slot slot : facility.getSlots()) {
                if(slot.getAvailable() == false) {
                    System.out.println("Badminton Court ID: " + facility.getId() + " Slot: " + slot.getSlotid() + " Time: " + slot.getTime()+" NU-ID: "+slot.getPerson());

                }
            }
        }

        // Check and display bookings for Cricket grounds
        for (SportsFacility facility : cground) {
            for (Slot slot : facility.getSlots()) {

                if(slot.getAvailable() == false) {
                    System.out.println("Cricket Ground ID: " + facility.getId() + "  Slot: " + slot.getSlotid() + " Time: " + slot.getTime()+" NU-ID: "+slot.getPerson());

                }
            }
        }

        // Check and display bookings for Football grounds
        for (SportsFacility facility : fground) {
            for (Slot slot : facility.getSlots()) {
                if(slot.getAvailable() == false) {
                    System.out.println("Football Ground ID: " + facility.getId() + " Slot: " + slot.getSlotid() + " Time: " + slot.getTime()+" NU-ID: "+slot.getPerson());

                }
            }
        }

        // Check and display equipment bookings
        for (SportEquipment equipment : bequip) {
            for (Equipment equip : equipment.getEquipment()) {
                if (equip.isAvalaibility() == false) {
                    System.out.println("Badminton Equipment ID: " + equipment.getId() + " Slot: " + equip.getEquipment_id() + " Time: " + equip.getTime()+" NU-ID: "+equip.getPerson());

                }
            }
        }

        for (SportEquipment equipment : cequip) {
            for (Equipment equip : equipment.getEquipment()) {
                if (equip.isAvalaibility() == false) {
                    System.out.println("Cricket Equipment ID: " + equipment.getId() + " Slot: " + equip.getEquipment_id() + " Time: " + equip.getTime()+" NU-ID: "+equip.getPerson());

                }
            }
        }

        for (SportEquipment equipment : fequip) {
            for (Equipment equip : equipment.getEquipment()) {
                if (equip.isAvalaibility() == false) {
                    System.out.println("Football Equipment ID: " + equipment.getId() + " Slot: " + equip.getEquipment_id() + " Time: " + equip.getTime()+" NU-ID: "+equip.getPerson());

                }
            }
        }
    }


    protected void cancelCourtBookingBooking(ManagementSystem sports){
        ArrayList<SportsFacility> bgrounds=sports.getBadmintonCourts();
        ArrayList<SportsFacility> cgrounds = sports.getCricketGrounds();
        ArrayList<SportsFacility> fgrounds = sports.getFootballCourts();
        Scanner myobj= new Scanner(System.in);
        System.out.println("Enter Nu-id: ");
        String id = myobj.nextLine();
        RegularUser user = new RegularUser();
        user.setEmail(id);
        user.viewCourtBookings(sports);
        System.out.println("Enter CourtId: ");
        String courtId = myobj.nextLine();
        System.out.println("Enter slotId: ");
        String slotId = myobj.nextLine();

        boolean found =false;

        for(int i=0;i<bgrounds.size();i++){
            if(courtId.equals(bgrounds.get(i).getId()+"")) {
                ArrayList<Slot> slots = bgrounds.get(i).getSlots();

                for (int j = 0; j < slots.size(); j++) {
                    if (slotId.equals(slots.get(j).getSlotid()+"") && slots.get(j).getPerson().equals(id)){
                        found = true;
                        slots.get(j).setAvailable(true);
                        slots.get(j).setPerson(null);
                    }
                }
            }
        }

        for(int i=0;i<cgrounds.size();i++){
            if(courtId.equals(cgrounds.get(i).getId()+"")) {
                ArrayList<Slot> slots = cgrounds.get(i).getSlots();

                for (int j = 0; j < slots.size(); j++) {
                    if (slotId.equals(slots.get(j).getSlotid()+"") && slots.get(j).getPerson().equals(id)){
                        found = true;
                        slots.get(j).setAvailable(true);
                        slots.get(j).setPerson(null);
                    }
                }
            }
        }

        for(int i=0;i<fgrounds.size();i++){
            if(courtId.equals(fgrounds.get(i).getId()+"")) {
                ArrayList<Slot> slots = fgrounds.get(i).getSlots();

                for (int j = 0; j < slots.size(); j++) {
                    if (slotId.equals(slots.get(j).getSlotid()+"") && slots.get(j).getPerson().equals(id)){
                        found = true;
                        slots.get(j).setAvailable(true);
                        slots.get(j).setPerson(null);
                    }
                }
            }
        }
        if(found == false){
            System.out.println("No booking Found for this NU ID");
        }
        else{
            System.out.println("Booking cancelled");
        }



    }
    protected void cancelEquipmentBooking(ManagementSystem sports){
        ArrayList<SportEquipment> bequipments=sports.getBadmintonEquipments();
        ArrayList<SportEquipment> cequipments = sports.getCricketEquipments();
        ArrayList<SportEquipment> fequipments = sports.getFootballEquipments();
        Scanner myobj= new Scanner(System.in);
        System.out.println("Enter Nu-id: ");
        String id = myobj.nextLine();
        RegularUser user = new RegularUser();
        user.setEmail(id);
        user.viewEquipmentBookings(sports);
        System.out.println("Enter CourtId: ");
        String courtId = myobj.nextLine();
        System.out.println("Enter slotId: ");
        String slotId = myobj.nextLine();

        boolean found =false;

        for(int i=0;i<bequipments.size();i++){
            if(courtId.equals(bequipments.get(i).getId()+"")) {
                ArrayList<Equipment> equipment = bequipments.get(i).getEquipment();

                for (int j = 0; j < equipment.size(); j++) {
                    if (slotId.equals(equipment.get(j).getEquipment_id()+"") && equipment.get(j).getPerson().equals(id)){
                        found = true;
                        equipment.get(j).setAvalaibility(true);
                        equipment.get(j).setPerson(null);
                    }
                }
            }
        }

        for(int i=0;i<cequipments.size();i++){
            if(courtId.equals(cequipments.get(i).getId()+"")) {
                ArrayList<Equipment> equipment = cequipments.get(i).getEquipment();

                for (int j = 0; j < equipment.size(); j++) {
                    if (slotId.equals(equipment.get(j).getEquipment_id()+"") && equipment.get(j).getPerson().equals(id)){
                        found = true;
                        equipment.get(j).setAvalaibility(true);
                        equipment.get(j).setPerson(null);
                    }
                }
            }
        }

        for(int i=0;i<fequipments.size();i++){
            if(courtId.equals(fequipments.get(i).getId()+"")) {
                ArrayList<Equipment> equipment = fequipments.get(i).getEquipment();

                for (int j = 0; j < equipment.size(); j++) {
                    if (slotId.equals(equipment.get(j).getEquipment_id()+"") && equipment.get(j).getPerson().equals(id)){
                        found = true;
                        equipment.get(j).setAvalaibility(true);
                        equipment.get(j).setPerson(null);
                    }
                }
            }
        }
        if(found == false){
            System.out.println("No booking Found for this NU ID");
        }
        else{
            System.out.println("Booking cancelled");
        }



    }

}


