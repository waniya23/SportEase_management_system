import java.util.ArrayList;

interface Manage {
    void badmintonCourtBooking(User user);

    void cricketGroundBooking(User user);

    void footballCourtBooking(User user);

    void badmintonEquipmentBooking(User user);

    void footballEquipmentBooking(User user);

    void initializeEquipmentFile();

    void initializeEquipment();

    void FiletoArrayEquipment();

    void initialize_updated_equipment();

    void initializeFile();

    void initializeGrounds();

    void initializeSystem();

    void initializeUpdatedSystem();

    void FiletoArray();
    void footballEquipmentCancellation(User user);
    void cricketEquipmentCancellation(User user);
    void badmintonEquipmentCancellation(User user);

    void badmintonCourtCancellation(User user);
    void cricketGroundCancellation(User user);
    void footballGroundCancellation(User user);
    public void cancelbooking(String opt, User user);



}


