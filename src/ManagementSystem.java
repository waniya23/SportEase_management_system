import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagementSystem implements Manage{
    Scanner myobj = new Scanner(System.in);
    private  ArrayList<SportEquipment> badmintonEquipments=new ArrayList<>();
    private  ArrayList<SportEquipment> cricketEquipments=new ArrayList<>();
    private ArrayList<SportEquipment> footballEquipments=new ArrayList<>();


    private ArrayList<SportsFacility> badmintonCourts = new ArrayList();
    private ArrayList<SportsFacility> footballCourts = new ArrayList<>();
    private ArrayList<SportsFacility> cricketGrounds = new ArrayList<>();

    public ArrayList<SportsFacility> getAvailablebadmintonCourts() {
        return badmintonCourts;
    }

    public ArrayList<SportEquipment> getBadmintonEquipments() {
        return badmintonEquipments;
    }

    public ArrayList<SportEquipment> getCricketEquipments() {
        return cricketEquipments;
    }

    public ArrayList<SportEquipment> getFootballEquipments() {
        return footballEquipments;
    }

    public ArrayList<SportsFacility> getBadmintonCourts() {
        return badmintonCourts;
    }

    public ArrayList<SportsFacility> getFootballCourts() {
        return footballCourts;
    }

    public ArrayList<SportsFacility> getCricketGrounds() {
        return cricketGrounds;
    }

    public void badmintonCourtBooking(User user){
        System.out.println("\n");
        for (int i=0;i<badmintonCourts.size();i++){
            System.out.println("Court ID: "+badmintonCourts.get(i).getId());
            badmintonCourts.get(i).displaySlots();
        }
        System.out.println("\n");

        System.out.print("Enter CourtID: ");
        int courtId = myobj.nextInt();
        System.out.print("Enter SlotID: ");
        int slotId = myobj.nextInt();

        for (int i=0;i<badmintonCourts.size();i++){
            boolean found = false;
            boolean canbook =false;
            if(badmintonCourts.get(i).getId() == courtId){
                ArrayList<Slot> slots = badmintonCourts.get(i).getSlots();
                for (int j=0;j<slots.size();j++){
                    if(slots.get(j).getSlotid() == slotId && slots.get(j).getAvailable() == true){
                        found = true;
                        canbook= user.canBook(slots.get(j),badmintonCourts,cricketGrounds,footballCourts);
                        if(canbook == true) {


                            slots.get(j).setAvailable(false);
                            slots.get(j).setPerson(user.getEmail());
                            System.out.println("Court ID" + courtId + ", slotID" + slotId + " Successfully booked");
                            initializeFile();
                        }
                    }

                }
                if(found == false){
                        System.out.println("Court ID"+courtId+", slotID" + slotId+" is already booked");
                }
            }

        }

    }

    public void cricketGroundBooking(User user){
        System.out.println("\n");
        for (int i=0;i<cricketGrounds.size();i++){
            System.out.println("Court ID: "+cricketGrounds.get(i).getId());
            cricketGrounds.get(i).displaySlots();
        }
        System.out.println("\n");

        System.out.print("Enter CourtID: ");
        int courtId = myobj.nextInt();
        System.out.print("Enter SlotID: ");
        int slotId = myobj.nextInt();

        for (int i=0;i<cricketGrounds.size();i++){
            boolean found = false;
            boolean canbook =false;
            if(cricketGrounds.get(i).getId() == courtId){
                ArrayList<Slot> slots = cricketGrounds.get(i).getSlots();
                for (int j=0;j<slots.size();j++){
                    if(slots.get(j).getSlotid() == slotId && slots.get(j).getAvailable() == true){
                        found = true;
                        canbook= user.canBook(slots.get(j),badmintonCourts,cricketGrounds,footballCourts);
                        if(canbook == true) {


                            slots.get(j).setAvailable(false);
                            slots.get(j).setPerson(user.getEmail());
                            System.out.println("Court ID" + courtId + ", slotID" + slotId + " Successfully booked");
                            initializeFile();
                        }
                    }

                }
                if(found == false){
                    System.out.println("Court ID"+courtId+", slotID" + slotId+" is already booked");
                }
            }

        }

    }

    public void footballCourtBooking(User user) {
        System.out.println("\n");
        for (int i = 0; i < footballCourts.size(); i++) {
            System.out.println("Court ID: " + footballCourts.get(i).getId());
            footballCourts.get(i).displaySlots();
        }
        System.out.println("\n");

        System.out.print("Enter CourtID: ");
        int courtId = myobj.nextInt();
        System.out.print("Enter SlotID: ");
        int slotId = myobj.nextInt();

        for (int i = 0; i < footballCourts.size(); i++) {
            boolean found = false;
            boolean canbook = false;
            if (footballCourts.get(i).getId() == courtId) {
                ArrayList<Slot> slots = footballCourts.get(i).getSlots();
                for (int j = 0; j < slots.size(); j++) {
                    if (slots.get(j).getSlotid() == slotId && slots.get(j).getAvailable() == true) {
                        found = true;
                        canbook = user.canBook(slots.get(j), badmintonCourts, cricketGrounds,footballCourts);
                        if (canbook == true) {


                            slots.get(j).setAvailable(false);
                            slots.get(j).setPerson(user.getEmail());
                            System.out.println("Court ID" + courtId + ", slotID" + slotId + " Successfully booked");
                            initializeFile();
                        }
                    }

                }
                if (found == false) {
                    System.out.println("Court ID" + courtId + ", slotID" + slotId + " is already booked");
                }
            }

        }
    }
    public void badmintonEquipmentBooking(User user){
        System.out.println("\n");
        for (int i=0;i<badmintonEquipments.size();i++){
            System.out.println("Equipment ID: "+badmintonEquipments.get(i).getId());
            badmintonEquipments.get(i).displayEquipment();
        }
        System.out.println("\n");

        System.out.print("Enter Equipment ID : ");
        int equipmentID = myobj.nextInt();
        System.out.println("Enter Slot ID ");
        int id=myobj.nextInt();

        for (int i=0;i<badmintonEquipments.size();i++){
            boolean found = false;
            boolean canbook =false;
            if(badmintonEquipments.get(i).getId() == equipmentID){
                ArrayList<Equipment> equipment = badmintonEquipments.get(i).getEquipment();
                for (int j=0;j<equipment.size();j++){
                    if(equipment.get(j).getEquipment_id() == id && equipment.get(j).isAvalaibility() == true){
                        found = true;
                        canbook= user.canBookEquipment(equipment.get(j),badmintonEquipments,cricketEquipments,footballEquipments);
                        if(canbook == true) {


                            equipment.get(j).setAvalaibility(false);
                            equipment.get(j).setPerson(user.getEmail());
                            System.out.println(equipment.get(j).getEquipment_name()+" for Slot "+equipment.get(j).getEquipment_id()+" ---- Time "+equipment.get(j).getTime()+" is  Successfully booked");
                            initializeEquipmentFile();
                        }
                    }

                }
                if(found == false){
                    System.out.println("This equipment is already booked");
                }
            }

        }}
    void cricketEquipmentBooking(User user){
        System.out.println("\n");
        for (int i=0;i<cricketEquipments.size();i++){
            System.out.println("Equipment ID: "+cricketEquipments.get(i).getId());
            cricketEquipments.get(i).displayEquipment();
        }
        System.out.println("\n");

        System.out.print("Enter Equipment ID : ");
        int equipmentID = myobj.nextInt();
        System.out.println("Enter Slot ID ");
        int id=myobj.nextInt();

        for (int i=0;i<cricketEquipments.size();i++){
            boolean found = false;
            boolean canbook =false;
            if(cricketEquipments.get(i).getId() == equipmentID){
                ArrayList<Equipment> equipment = cricketEquipments.get(i).getEquipment();
                for (int j=0;j<equipment.size();j++){
                    if(equipment.get(j).getEquipment_id() == id && equipment.get(j).isAvalaibility() == true){
                        found = true;
                        canbook= user.canBookEquipment(equipment.get(j),badmintonEquipments,cricketEquipments,footballEquipments);
                        if(canbook == true) {


                            equipment.get(j).setAvalaibility(false);
                            equipment.get(j).setPerson(user.getEmail());
                            System.out.println(equipment.get(j).getEquipment_name()+" for Slot "+equipment.get(j).getEquipment_id()+" ---- Time "+equipment.get(j).getTime()+" is  Successfully booked");
                            initializeEquipmentFile();
                        }
                    }

                }
                if(found == false){
                    System.out.println("This equipment is already booked");
                }
            }

        }}
    public void footballEquipmentBooking(User user){
        System.out.println("\n");
        for (int i=0;i<footballEquipments.size();i++){
            System.out.println("Equipment ID: "+footballEquipments.get(i).getId());
            footballEquipments.get(i).displayEquipment();
        }
        System.out.println("\n");

        System.out.print("Enter Equipment ID : ");
        int equipmentID = myobj.nextInt();
        System.out.println("Enter Slot ID ");
        int id=myobj.nextInt();

        for (int i=0;i<footballEquipments.size();i++){
            boolean found = false;
            boolean canbook =false;
            if(footballEquipments.get(i).getId() == equipmentID){
                ArrayList<Equipment> equipment = footballEquipments.get(i).getEquipment();
                for (int j=0;j<equipment.size();j++){
                    if(equipment.get(j).getEquipment_id() == id && equipment.get(j).isAvalaibility() == true){
                        found = true;
                        canbook= user.canBookEquipment(equipment.get(j),badmintonEquipments,cricketEquipments,footballEquipments);
                        if(canbook == true) {


                            equipment.get(j).setAvalaibility(false);
                            equipment.get(j).setPerson(user.getEmail());
                            System.out.println(equipment.get(j).getEquipment_name()+" for Slot "+equipment.get(j).getEquipment_id()+" ---- Time "+equipment.get(j).getTime()+" is  Successfully booked");
                            initializeEquipmentFile();
                        }
                    }

                }
                if(found == false){
                    System.out.println("This equipment is already booked");
                }
            }

        }}
    public void initializeEquipmentFile(){
        initialize_equipment_file("badmintonEquipment.txt",badmintonEquipments);
        initialize_equipment_file("cricketEquipment.txt",cricketEquipments);
        initialize_equipment_file("footballEquipment.txt",footballEquipments);


    }
    public void initializeEquipment(){
        ArrayList<Equipment> rackets1=new ArrayList<>();
        ArrayList<Equipment> rackets2=new ArrayList<>();
        ArrayList<Equipment> rackets3=new ArrayList<>();
        ArrayList<Equipment> rackets4=new ArrayList<>();
        ArrayList<Equipment> rackets5=new ArrayList<>();

        ArrayList<Equipment> batball1_list =new ArrayList<>();
        ArrayList<Equipment> batball2_list=new ArrayList<>();
        ArrayList<Equipment> batball3_list=new ArrayList<>();
        ArrayList<Equipment> batball4_list=new ArrayList<>();
        ArrayList<Equipment> batball5_list=new ArrayList<>();

        ArrayList<Equipment> football1_list =new ArrayList<>();
        ArrayList<Equipment> football2_list=new ArrayList<>();
        ArrayList<Equipment> football3_list=new ArrayList<>();
        ArrayList<Equipment> football4_list=new ArrayList<>();
        ArrayList<Equipment> football5_list=new ArrayList<>();

        Equipment racket1= new Equipment(1,"rackets","9-10",true,null);
        Equipment racket2= new Equipment(2,"rackets","10-11",true,null);
        Equipment racket3= new Equipment(3,"rackets","11-12",true,null);
        Equipment racket4= new Equipment(4,"rackets","12-1",true,null);
        Equipment racket5= new Equipment(5,"rackets","1-2",true,null);
        Equipment racket6= new Equipment(6,"rackets","2-3",true,null);

        Equipment batballs1= new Equipment(1,"Bat-Ball","9-10",true,null);
        Equipment batballs2= new Equipment(2,"Bat-Ball","10-11",true,null);
        Equipment batballs3= new Equipment(3,"Bat-Ball","11-12",true,null);
        Equipment batballs4= new Equipment(4,"Bat-Ball","12-1",true,null);
        Equipment batballs5= new Equipment(5,"Bat-Ball","1-2",true,null);
        Equipment batballs6= new Equipment(6,"Bat-Ball","2-3",true,null);

        Equipment footballs1= new Equipment(1,"Football","9-10",true,null);
        Equipment footballs2= new Equipment(2,"Football","10-11",true,null);
        Equipment footballs3= new Equipment(3,"Football","11-12",true,null);
        Equipment footballs4= new Equipment(4,"Football","12-1",true,null);
        Equipment footballs5= new Equipment(5,"Football","1-2",true,null);
        Equipment footballs6= new Equipment(6,"Football","2-3",true,null);



        rackets1.add(new Equipment(racket1));
        rackets1.add(new Equipment(racket2));
        rackets1.add(new Equipment(racket3));
        rackets1.add(new Equipment(racket4));
        rackets1.add(new Equipment(racket5));
        rackets1.add(new Equipment(racket6));


        rackets2.add(new Equipment(racket1));
        rackets2.add(new Equipment(racket2));
        rackets2.add(new Equipment(racket3));
        rackets2.add(new Equipment(racket4));
        rackets2.add(new Equipment(racket5));
        rackets2.add(new Equipment(racket6));


        rackets3.add(new Equipment(racket1));
        rackets3.add(new Equipment(racket2));
        rackets3.add(new Equipment(racket3));
        rackets3.add(new Equipment(racket4));
        rackets3.add(new Equipment(racket5));
        rackets3.add(new Equipment(racket6));

        rackets4.add(new Equipment(racket1));
        rackets4.add(new Equipment(racket2));
        rackets4.add(new Equipment(racket3));
        rackets4.add(new Equipment(racket4));
        rackets4.add(new Equipment(racket5));
        rackets4.add(new Equipment(racket6));

        rackets5.add(new Equipment(racket1));
        rackets5.add(new Equipment(racket2));
        rackets5.add(new Equipment(racket3));
        rackets5.add(new Equipment(racket4));
        rackets5.add(new Equipment(racket5));
        rackets5.add(new Equipment(racket6));

        batball1_list.add(new Equipment(batballs1));
        batball1_list.add(new Equipment(batballs2));
        batball1_list.add(new Equipment(batballs3));
        batball1_list.add(new Equipment(batballs4));
        batball1_list.add(new Equipment(batballs5));
        batball1_list.add(new Equipment(batballs6));

        batball2_list.add(new Equipment(batballs1));
        batball2_list.add(new Equipment(batballs2));
        batball2_list.add(new Equipment(batballs3));
        batball2_list.add(new Equipment(batballs4));
        batball2_list.add(new Equipment(batballs5));
        batball2_list.add(new Equipment(batballs6));

        batball3_list.add(new Equipment(batballs1));
        batball3_list.add(new Equipment(batballs2));
        batball3_list.add(new Equipment(batballs3));
        batball3_list.add(new Equipment(batballs4));
        batball3_list.add(new Equipment(batballs5));
        batball3_list.add(new Equipment(batballs6));

        batball4_list.add(new Equipment(batballs1));
        batball4_list.add(new Equipment(batballs2));
        batball4_list.add(new Equipment(batballs3));
        batball4_list.add(new Equipment(batballs4));
        batball4_list.add(new Equipment(batballs5));
        batball4_list.add(new Equipment(batballs6));

        batball5_list.add(new Equipment(batballs1));
        batball5_list.add(new Equipment(batballs2));
        batball5_list.add(new Equipment(batballs3));
        batball5_list.add(new Equipment(batballs4));
        batball5_list.add(new Equipment(batballs5));
        batball5_list.add(new Equipment(batballs6));

        football1_list.add(new Equipment(footballs1));
        football1_list.add(new Equipment(footballs2));
        football1_list.add(new Equipment(footballs3));
        football1_list.add(new Equipment(footballs4));
        football1_list.add(new Equipment(footballs5));
        football1_list.add(new Equipment(footballs6));

        football2_list.add(new Equipment(footballs1));
        football2_list.add(new Equipment(footballs2));
        football2_list.add(new Equipment(footballs3));
        football2_list.add(new Equipment(footballs4));
        football2_list.add(new Equipment(footballs5));
        football2_list.add(new Equipment(footballs6));

        football3_list.add(new Equipment(footballs1));
        football3_list.add(new Equipment(footballs2));
        football3_list.add(new Equipment(footballs3));
        football3_list.add(new Equipment(footballs4));
        football3_list.add(new Equipment(footballs5));
        football3_list.add(new Equipment(footballs6));

        football4_list.add(new Equipment(footballs1));
        football4_list.add(new Equipment(footballs2));
        football4_list.add(new Equipment(footballs3));
        football4_list.add(new Equipment(footballs4));
        football4_list.add(new Equipment(footballs5));
        football4_list.add(new Equipment(footballs6));

        football5_list.add(new Equipment(footballs1));
        football5_list.add(new Equipment(footballs2));
        football5_list.add(new Equipment(footballs3));
        football5_list.add(new Equipment(footballs4));
        football5_list.add(new Equipment(footballs5));
        football5_list.add(new Equipment(footballs6));


        badmintonEquipments.add(new BadmintonEquipment(1,rackets1));
        badmintonEquipments.add(new BadmintonEquipment(2,rackets2));
        badmintonEquipments.add(new BadmintonEquipment(3,rackets3));
        badmintonEquipments.add(new BadmintonEquipment(4,rackets4));
        badmintonEquipments.add(new BadmintonEquipment(5,rackets5));

        cricketEquipments.add(new CricketEquipment(1,batball1_list));
        cricketEquipments.add(new CricketEquipment(2,batball2_list));
        cricketEquipments.add(new CricketEquipment(3,batball3_list));
        cricketEquipments.add(new CricketEquipment(4,batball4_list));
        cricketEquipments.add(new CricketEquipment(5,batball5_list));

        footballEquipments.add(new FootballEquipment(1,football1_list));
        footballEquipments.add(new FootballEquipment(2,football2_list));
        footballEquipments.add(new FootballEquipment(3,football3_list));
        footballEquipments.add(new FootballEquipment(4,football4_list));
        footballEquipments.add(new FootballEquipment(5,football5_list));




    }
    public void FiletoArrayEquipment(){
        file_to_array_equip("badmintonEquipment.txt",badmintonEquipments);
        file_to_array_equip("footballEquipment.txt",footballEquipments);
        file_to_array_equip("cricketEquipment.txt",cricketEquipments);
    }
    public void initialize_updated_equipment(){
        initializeEquipment();
        FiletoArrayEquipment();
        initializeEquipmentFile();
    }


    public void initializeFile(){
        //badmintonCourt.txt file
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("badmintonCourt.txt"));
            for (int i=0;i<badmintonCourts.size();i++){

                bw.write(badmintonCourts.get(i).getId()+"\n");
                ArrayList<Slot> slots = badmintonCourts.get(i).getSlots();
                for (int j=0;j<slots.size();j++){

                    bw.write(slots.get(j).getSlotid()+" ");
                    bw.write(slots.get(j).getTime()+" ");
                    bw.write(slots.get(j).getAvailable()+" ");
                    bw.write(slots.get(j).getPerson()+"\n");
                }
            }
            bw.close();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        //cricketGround.txt file
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("cricketGround.txt"));
            for (int i=0;i<cricketGrounds.size();i++){

                bw.write(cricketGrounds.get(i).getId()+"\n");
                ArrayList<Slot> slots = cricketGrounds.get(i).getSlots();
                for (int j=0;j<slots.size();j++){

                    bw.write(slots.get(j).getSlotid()+" ");
                    bw.write(slots.get(j).getTime()+" ");
                    bw.write(slots.get(j).getAvailable()+" ");
                    bw.write(slots.get(j).getPerson()+"\n");
                }
            }
            bw.close();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        //footballGround.txt file
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("footballGround.txt"));
            for (int i=0;i<footballCourts.size();i++){

                bw.write(footballCourts.get(i).getId()+"\n");
                ArrayList<Slot> slots = footballCourts.get(i).getSlots();
                for (int j=0;j<slots.size();j++){

                    bw.write(slots.get(j).getSlotid()+" ");
                    bw.write(slots.get(j).getTime()+" ");
                    bw.write(slots.get(j).getAvailable()+" ");
                    bw.write(slots.get(j).getPerson()+"\n");
                }
            }
            bw.close();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
    public void initializeGrounds(){

        //Badminton courts initialized
        ArrayList<Slot> bad1slots = new ArrayList<>();
        ArrayList<Slot> bad2slots = new ArrayList<>();
        Slot slot1 = new Slot(1,"9-10",true,null);
        Slot slot2 = new Slot(2,"10-11",true,null);
        Slot slot3 = new Slot(3,"12-1",true,null);
        Slot slot4= new Slot(4,"1-2",true,null);
        Slot slot5 = new Slot(5,"2-3",true,null);

        bad1slots.add(new Slot(slot1));
        bad1slots.add(new Slot(slot2));
        bad1slots.add(new Slot(slot3));
        bad1slots.add(new Slot(slot4));
        bad1slots.add(new Slot(slot5));

        bad2slots.add(new Slot(slot1));
        bad2slots.add(new Slot(slot2));
        bad2slots.add(new Slot(slot3));
        bad2slots.add(new Slot(slot4));
        bad2slots.add(new Slot(slot5));
        badmintonCourts.add(new BadmintonCourt(1,bad1slots));
        badmintonCourts.add(new BadmintonCourt(2,bad2slots));

        //cricket Grounds initialized
        ArrayList<Slot> cric1slots = new ArrayList<>();
        ArrayList<Slot> cric2slots = new ArrayList<>();

        cric1slots.add(new Slot(slot1));
        cric1slots.add(new Slot(slot2));
        cric1slots.add(new Slot(slot3));
        cric1slots.add(new Slot(slot4));
        cric1slots.add(new Slot(slot5));

        cric2slots.add(new Slot(slot1));
        cric2slots.add(new Slot(slot2));
        cric2slots.add(new Slot(slot3));
        cric2slots.add(new Slot(slot4));
        cric2slots.add(new Slot(slot5));
        cricketGrounds.add(new CricketGround(1,cric1slots));
        cricketGrounds.add(new CricketGround(2,cric2slots));

        //football Grounds initialized
        ArrayList<Slot> foot1slots = new ArrayList<>();
        ArrayList<Slot> foot2slots = new ArrayList<>();

        foot1slots.add(new Slot(slot1));
        foot1slots.add(new Slot(slot2));
        foot1slots.add(new Slot(slot3));
        foot1slots.add(new Slot(slot4));
        foot1slots.add(new Slot(slot5));

        foot2slots.add(new Slot(slot1));
        foot2slots.add(new Slot(slot2));
        foot2slots.add(new Slot(slot3));
        foot2slots.add(new Slot(slot4));
        foot2slots.add(new Slot(slot5));
        footballCourts.add(new FootballCourt(1,foot1slots));
        footballCourts.add(new FootballCourt(2,foot2slots));

    }
    public void initializeSystem(){
        initializeGrounds();
        initializeFile();
        initializeEquipment();
        initializeEquipmentFile();
    }
    public void initializeUpdatedSystem(){
        initializeGrounds();
        FiletoArray();
        initializeFile();
    }
    public void FiletoArray(){
        //badminton court
        try{
            BufferedReader br = new BufferedReader(new FileReader("badmintonCourt.txt"));
            String  court;
            for (int i=0;i<badmintonCourts.size();i++){
                court = br.readLine();
                int courtId = Integer.parseInt(court);
                badmintonCourts.get(i).setId(courtId);
                ArrayList<Slot> slots = badmintonCourts.get(i).getSlots();
                String slotdata;
                for (int j=0;j<slots.size();j++){
                    slotdata = br.readLine();
                    String[] parts = slotdata.split(" ");
                    String available = parts[2];
                    if(available.equals( "true")){
                        slots.get(j).setAvailable(true);
                    }
                    else{
                        slots.get(j).setAvailable(false);
                    }
                    String person = parts[3];
                    slots.get(j).setPerson(person);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        //cricketground
        try{
            BufferedReader br = new BufferedReader(new FileReader("cricketGround.txt"));
            String  court;
            for (int i=0;i<cricketGrounds.size();i++){
                court = br.readLine();
                int courtId = Integer.parseInt(court);
                cricketGrounds.get(i).setId(courtId);
                ArrayList<Slot> slots = cricketGrounds.get(i).getSlots();
                String slotdata;
                for (int j=0;j<slots.size();j++){
                    slotdata = br.readLine();
                    String[] parts = slotdata.split(" ");
                    String available = parts[2];
                    if(available.equals( "true")){
                        slots.get(j).setAvailable(true);
                    }
                    else{
                        slots.get(j).setAvailable(false);
                    }
                    String person = parts[3];
                    slots.get(j).setPerson(person);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        //footballground
        try{
            BufferedReader br = new BufferedReader(new FileReader("footballGround.txt"));
            String  court;
            for (int i=0;i<footballCourts.size();i++){
                court = br.readLine();
                int courtId = Integer.parseInt(court);
                footballCourts.get(i).setId(courtId);
                ArrayList<Slot> slots = footballCourts.get(i).getSlots();
                String slotdata;
                for (int j=0;j<slots.size();j++){
                    slotdata = br.readLine();
                    String[] parts = slotdata.split(" ");
                    String available = parts[2];
                    if(available.equals( "true")){
                        slots.get(j).setAvailable(true);
                    }
                    else{
                        slots.get(j).setAvailable(false);

                    }
                    String person = parts[3];
                    slots.get(j).setPerson(person);


                }
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
protected void file_to_array_equip(String f,ArrayList<SportEquipment> sportEquipments){
    try{
        BufferedReader br = new BufferedReader(new FileReader(f));
        String  court;
        for (int i=0;i<sportEquipments.size();i++){
            court = br.readLine();
            int id = Integer.parseInt(court);
            sportEquipments.get(i).setId(id);
            ArrayList<Equipment> equip = sportEquipments.get(i).getEquipment();
            String slotdata;
            for (int j=0;j<equip.size();j++){
                slotdata = br.readLine();
                String[] parts = slotdata.split(" ");
                String available = parts[3];
                if(available.equals( "true")){
                    equip.get(j).setAvalaibility(true);
                }
                else{
                    equip.get(j).setAvalaibility(false);

                }
                String person = parts[4];
                equip.get(j).setPerson(person);


            }
        }
    }catch(Exception e){
        e.printStackTrace();
        System.out.println(e.getMessage());
    }
}
protected void initialize_equipment_file(String f, ArrayList<SportEquipment> sportEquipments){
    try{
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        for (int i=0;i<sportEquipments.size();i++){

            bw.write(sportEquipments.get(i).getId()+"\n");
            ArrayList<Equipment> equipment = sportEquipments.get(i).getEquipment();
            for (int j=0;j<equipment.size();j++){

                bw.write(equipment.get(j).getEquipment_id()+" ");
                bw.write(equipment.get(j).getEquipment_name()+" ");
                bw.write(equipment.get(j).getTime()+" ");
                bw.write(equipment.get(j).isAvalaibility()+" ");
                bw.write(equipment.get(j).getPerson()+"\n");
            }
        }
        bw.close();
    }catch(Exception e){
        e.printStackTrace();
        System.out.println(e.getMessage());
    }
}
    public  void footballEquipmentCancellation(User user){
        cancel_equipment_booking(user,footballEquipments);
    }
    public  void cricketEquipmentCancellation(User user){
        cancel_equipment_booking(user,cricketEquipments);
    }
    public  void badmintonEquipmentCancellation(User user){
        cancel_equipment_booking(user,badmintonEquipments);
    }
    public void badmintonCourtCancellation(User user){
        cancel_court_booking(user, badmintonCourts);
    }
    public void cricketGroundCancellation(User user){
        cancel_court_booking(user, cricketGrounds);
    }
    public void footballGroundCancellation(User user){
        cancel_court_booking(user, footballCourts);
    }


    void cancel_equipment_booking(User user, ArrayList<SportEquipment> sportEquipments){
        System.out.print("Enter Equipment ID : ");
        int equipmentID = myobj.nextInt();
        System.out.println("Enter Slot ID ");
        int id=myobj.nextInt();

        for (int i=0;i<sportEquipments.size();i++) {
            boolean found = false;
            if (sportEquipments.get(i).getId() == equipmentID) {
                ArrayList<Equipment> equipment = sportEquipments.get(i).getEquipment();
                for (int j = 0; j < equipment.size(); j++) {
                    if (equipment.get(j).getEquipment_id() == id && !equipment.get(j).isAvalaibility()  && equipment.get(j).getPerson().equalsIgnoreCase( user.getEmail())) {
                        found = true;

                        equipment.get(j).setAvalaibility(true);
                        equipment.get(j).setPerson(null);
                        System.out.println("Booking of " + equipment.get(j).getEquipment_name() + " for Slot " + equipment.get(j).getEquipment_id() + " ---- Time " + equipment.get(j).getTime() + " is cancelled");
                        initializeEquipmentFile();
                    }
                }
                if(found == false){
                    System.out.println("This slot is not booked by you . you can just cancel your own booking");
                }}}}
    void cancel_court_booking(User user, ArrayList<SportsFacility> sportsFacilities) {
        System.out.print("Enter Court ID : ");
        int courtId = myobj.nextInt();
        System.out.println("Enter Slot ID ");
        int slotId = myobj.nextInt();
        for (int i = 0; i < sportsFacilities.size(); i++) {
            boolean found = false;
            boolean canbook = false;
            if (sportsFacilities.get(i).getId() == courtId) {
                ArrayList<Slot> slots = sportsFacilities.get(i).getSlots();
                for (int j = 0; j < slots.size(); j++) {
                    if (slots.get(j).getSlotid() == slotId && !slots.get(j).getAvailable() && slots.get(j).getPerson().equalsIgnoreCase(user.getEmail())) {
                        found = true;
                            slots.get(j).setAvailable(true);
                            slots.get(j).setPerson(null);
                            System.out.println("Booking of Court ID" + courtId + ", slotID" + slotId + " is cancelled");
                            initializeFile();
                        }
                    }

                if (found == false) {
                    System.out.println("This slot is not booked by you . you can just cancel your own booking");
                }}}}




    public void cancelbooking(String opt, User user) {
        switch (opt){
            case "1":
                badmintonCourtCancellation(user);
                break;
            case "2":
                cricketGroundCancellation(user);
                break;
            case "3":
                footballGroundCancellation(user);
                break;
            case "4":
                badmintonEquipmentCancellation(user);
                break;
            case "5":
                cricketEquipmentCancellation(user);
                break;
            case "6":
                footballEquipmentCancellation(user);
                break;

        }
    }
}
