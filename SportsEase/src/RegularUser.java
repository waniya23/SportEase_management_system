import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class RegularUser extends User{

    protected boolean authenticateUser() {
        try {
            Scanner obj = new Scanner(System.in);
            System.out.print("Enter your NU-email: ");
            String email = obj.nextLine();


            BufferedReader br = new BufferedReader(new FileReader("RegularUserfile.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String parts[] = line.split(" ");
                String thisemail = parts[0];
                String thispass = parts[1];
                if (thisemail.equals(email)) {
                    System.out.print("Enter password: ");
                    String pass = obj.nextLine();
                    if (pass.equals(thispass)) {
                        System.out.println("User authenticated");
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
    protected void viewCourtBookings(ManagementSystem sports){
        ArrayList<SportsFacility> bground = sports.getBadmintonCourts();
        ArrayList<SportsFacility> cground = sports.getCricketGrounds();
        ArrayList<SportsFacility> fground = sports.getFootballCourts();

        System.out.println("\nYour Bookings:");

        // Check and display bookings for Badminton courts
        for (SportsFacility facility : bground) {
            for (Slot slot : facility.getSlots()) {
                if (getEmail().equals(slot.getPerson())) {
                    System.out.println("Badminton Court ID: " + facility.getId()+ " Slot: " +slot.getSlotid()+ " Time: " + slot.getTime());
                }
            }
        }

        // Check and display bookings for Cricket grounds
        for (SportsFacility facility : cground) {
            for (Slot slot : facility.getSlots()) {
                if (getEmail().equals(slot.getPerson())) {
                    System.out.println("Cricket Ground ID: " + facility.getId() +"  Slot: " +slot.getSlotid()+ " Time: " + slot.getTime());
                }
            }
        }

        // Check and display bookings for Football grounds
        for (SportsFacility facility : fground) {
            for (Slot slot : facility.getSlots()) {
                if (getEmail().equals(slot.getPerson())) {
                    System.out.println("Football Ground ID: " + facility.getId() +" Slot: " +slot.getSlotid()+  " Time: " + slot.getTime());
                }
            }
        }
    }

    protected void viewEquipmentBookings(ManagementSystem sports){
        ArrayList<SportEquipment> bequip = sports.getBadmintonEquipments();
        ArrayList<SportEquipment> cequip = sports.getCricketEquipments();
        ArrayList<SportEquipment> fequip = sports.getFootballEquipments();

        // Check and display equipment bookings
        for (SportEquipment equipment : bequip) {
            for (Equipment equip : equipment.getEquipment()) {
                if (getEmail().equals(equip.getPerson())) {
                    System.out.println("Badminton Equipment ID: " + equipment.getId() + " Slot: " +equip.getEquipment_id() + " Time: " + equip.getTime());
                }
            }
        }

        for (SportEquipment equipment : cequip) {
            for (Equipment equip : equipment.getEquipment()) {
                if (getEmail().equals(equip.getPerson())) {
                    System.out.println("Cricket Equipment ID: " + equipment.getId() + " Slot: " +equip.getEquipment_id() + " Time: " + equip.getTime());
                }
            }
        }

        for (SportEquipment equipment : fequip) {
            for (Equipment equip : equipment.getEquipment()) {
                if (getEmail().equals(equip.getPerson())) {
                    System.out.println("Football Equipment ID: " + equipment.getId() + " Slot: " +equip.getEquipment_id() + " Time: " + equip.getTime());
                }
            }
        }
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
                if (getEmail().equals(slot.getPerson())) {
                    System.out.println("Badminton Court ID: " + facility.getId()+ " Slot: " +slot.getSlotid()+ " Time: " + slot.getTime());
                }
            }
        }

        // Check and display bookings for Cricket grounds
        for (SportsFacility facility : cground) {
            for (Slot slot : facility.getSlots()) {
                if (getEmail().equals(slot.getPerson())) {
                    System.out.println("Cricket Ground ID: " + facility.getId() +"  Slot: " +slot.getSlotid()+ " Time: " + slot.getTime());
                }
            }
        }

        // Check and display bookings for Football grounds
        for (SportsFacility facility : fground) {
            for (Slot slot : facility.getSlots()) {
                if (getEmail().equals(slot.getPerson())) {
                    System.out.println("Football Ground ID: " + facility.getId() +" Slot: " +slot.getSlotid()+  " Time: " + slot.getTime());
                }
            }
        }

        // Check and display equipment bookings
        for (SportEquipment equipment : bequip) {
            for (Equipment equip : equipment.getEquipment()) {
                if (getEmail().equals(equip.getPerson())) {
                    System.out.println("Badminton Equipment ID: " + equipment.getId() + " Slot: " +equip.getEquipment_id() + " Time: " + equip.getTime());
                }
            }
        }

        for (SportEquipment equipment : cequip) {
            for (Equipment equip : equipment.getEquipment()) {
                if (getEmail().equals(equip.getPerson())) {
                    System.out.println("Cricket Equipment ID: " + equipment.getId() + " Slot: " +equip.getEquipment_id() + " Time: " + equip.getTime());
                }
            }
        }

        for (SportEquipment equipment : fequip) {
            for (Equipment equip : equipment.getEquipment()) {
                if (getEmail().equals(equip.getPerson())) {
                    System.out.println("Football Equipment ID: " + equipment.getId() + " Slot: " +equip.getEquipment_id() + " Time: " + equip.getTime());
                }
            }
        }
    }


}
