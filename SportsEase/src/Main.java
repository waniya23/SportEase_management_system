import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner myobj = new Scanner(System.in);
        ManagementSystem sports = new ManagementSystem();
        EventManagement eventManagement = new EventManagement();
        //sports.initializeSystem();
        sports.initializeUpdatedSystem();
        sports.initialize_updated_equipment();

        boolean exit = false;
        String opt;
        System.out.println("\n");
        System.out.println("1) Admin");
        System.out.println("2) User");
        System.out.println("3) Exit");
        System.out.print("Enter option: ");
        opt = myobj.nextLine();
        //myobj.nextLine();
            switch(opt) {
                case "1":
                    //clearScreen();
                    exit = false;
                    System.out.println("\n");
                    System.out.println("----------Admin----------");
                    Admin admin = new Admin();
                    boolean authenticate = AdminLogin(admin);
                    while (exit != true && authenticate==true) {
                            System.out.println("\n");
                            System.out.println("1)View All Bookings");
                            System.out.println("2)Remove Booking");
                            System.out.println("3) Add events");
                            System.out.println("4) Delete events");
                            System.out.println("5) Exit");
                            System.out.println("Select option: ");
                            String a=myobj.nextLine();
                             if(a.equals("1") ){// viewbookings
                                admin.viewBooking(sports);


                            }
                            else if(a.equals("2") ){//remove bookings
                                 System.out.println("1) Remove Court Booking");
                                 System.out.println("2) Remove Equipment Booking");
                                 String c = myobj.nextLine();
                                 if(c.equals("1")){
                                     admin.cancelCourtBookingBooking(sports);

                                 } else if (c.equals("2")) {
                                     admin.cancelEquipmentBooking(sports);

                                 }

                             }
                            else if(a.equals("3")) { // add events
                                System.out.print("Enter event name: ");
                                String name = myobj.nextLine();
                                System.out.print("Enter event description: ");
                                String description = myobj.nextLine();
                                System.out.print("Enter event date: ");
                                String date = myobj.nextLine();
                                eventManagement.addEvent(name, description, date);

                            }
                            else if (a.equals("4")) {
                                eventManagement.displayEvents();
                                System.out.print("Enter the index of the event to delete: ");
                                int deleteIndex = myobj.nextInt();
                                int c= deleteIndex-1;
                                myobj.nextLine();
                                eventManagement.deleteEvent((c));


                                // delete events
                            }

                            else if(a.equals("5") ){
                                exit=true;
                                System.out.println("Thanks for visiting....");
                                System.out.println("Exiting....");
                            }
                            else {
                                System.out.println("invalid input");
                            }

                        if(exit!=true){
                            System.out.println("\n");
                            System.out.println("----------Admin----------");
                        }
                    }


                    break;
                case "2":
                   // clearScreen();
                    exit = false;
                    System.out.println("\n");
                    System.out.println("----------User----------");
                    User user = new RegularUser();
                    boolean authenticate2 = UserLogin(user);
                    while(exit!=true && authenticate2 == true) {
                            System.out.println("\n");
                            System.out.println("1)View Booking");
                            System.out.println("2)Booking ");
                            System.out.println("3)Cancel Booking");
                            System.out.println("4)View Events");
                            System.out.println("5)Exit");
                            System.out.print("Select option: ");
                            String opt1 = myobj.nextLine();
                            if (opt1.equals("1") ) {//View booking
                                user.viewBooking(sports);


                            }
                            else if (opt1.equals("2") ) {//booking
                                boolean thisexit = false;
                                displayOptions();
                                String  opt2 = myobj.nextLine();
                                if(opt2.equals("0") ){ //gong back
                                    thisexit = true;
                                }
                                else if (opt2.equals("1") ) { // badminton
                                    System.out.println("\n");
                                    System.out.println("1)Badminton Court");
                                    System.out.println("2)Racket and Shuttle");
                                    System.out.print("Select option: ");
                                    String  opt3 = myobj.nextLine();
                                    if (opt3.equals("1") ) {
                                        sports.badmintonCourtBooking(user);


                                    }
                                    else if(opt3.equals("2") ){//racket and shuttle
                                        sports.badmintonEquipmentBooking(user);
                                    }
                                    else {
                                        System.out.println("Invalid input. Try again.");
                                    }
                                } else if (opt2.equals("2") ) { //Cricket
                                    System.out.println("\n");
                                    System.out.println("1)Cricket Ground");
                                    System.out.println("2)Bat and ball");
                                    System.out.print("Select option: ");
                                    String opt3 = myobj.nextLine();
                                    if (opt3.equals("1") ) {//Ground booking
                                        sports.cricketGroundBooking(user);


                                    }
                                    else if(opt3.equals("2") ){//bat ball booking
                                         sports.cricketEquipmentBooking(user);
                                    }
                                    else{
                                        System.out.println("Invalid input. Try again");
                                    }

                                } else if (opt2.equals("3") ) {//football
                                    System.out.println("\n");
                                    System.out.println("1)Football Ground");
                                    System.out.println("2)Football");
                                    System.out.print("Select option: ");
                                    String opt3 = myobj.nextLine();
                                    if (opt3.equals("1") ) {//Ground booking
                                        sports.footballCourtBooking(user);


                                    }
                                    else if(opt3.equals("2") ){//football booking
                                        sports.footballEquipmentBooking(user);
                                    }
                                    else{
                                        System.out.println("Invalid input. try again");
                                    }

                                }


                            }
                            else if (opt1.equals("3") ) {//cancel booking

                                System.out.println("select the option in which u want to cancel your booking:");
                                displaycanceloptions();
                               String a=myobj.nextLine();
                               sports.cancelbooking(a,user);
                            }
                            else if (opt1.equals("4")) {
                                // view events
                                eventManagement.displayEvents();
                            }
                            else if(opt1.equals("5") ){
                                exit =true;
                                System.out.println("Thanks for visitng..");
                                System.out.println("Exiting...");
                            }
                            else{
                                System.out.println("Wrong input. Try again");
                            }
                        if(exit!=true){
                            System.out.println("\n");
                            System.out.println("----------User----------");
                        }
                    }


                    break;
                case "3":
                   // clearScreen();
                    System.out.println("Thanks for visiting");
                    System.exit(0);

                default:
                    System.out.println("Wrong input. Try again");
                    break;
            }
        }

    private static void displaycanceloptions() {
        System.out.println("1-badminton court");
        System.out.println("2-cricket ground");
        System.out.println("3-football ground");
        System.out.println("4-badminton equipment");
        System.out.println("5-cricket equipment");
        System.out.println("6-football equipment");
    }

    public static void displayOptions(){
        System.out.println("\n");
        System.out.println("1)Badminton");
        System.out.println("2)Cricket");
        System.out.println("3)Football");
        System.out.println("4)Basketball");
        System.out.println("5)Gaming Room");
        System.out.println("6)Gym");
        System.out.println("Press 0(zero) to go back");
        System.out.print("Select option: ");

    }

    public  static boolean AdminLogin(User admin){
        Scanner obj = new Scanner(System.in);
        boolean authenticate = admin.authenticateUser();
        return authenticate;
    }
    public  static boolean UserLogin(User user){
        Scanner obj = new Scanner(System.in);
        boolean authenticate = user.authenticateUser();
        return authenticate;
    }

    private static void clearScreen() {
        // Print enough newline characters to clear the screen
        for (int i = 0; i < 25; ++i) {
            System.out.println();
        }
    }

    private static void waitForEnter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine(); // Wait for the user to press Enter
    }
}