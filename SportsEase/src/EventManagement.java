import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EventManagement {
    private List<Event> events;
    public EventManagement() {
        events = new ArrayList<Event>();
        readEventsFromFile();
    }

    private void readEventsFromFile() {
        events.clear();
        try  {
            BufferedReader br = new BufferedReader(new FileReader("events.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String name = parts[0];
                    String description = parts[1];
                    String date = parts[2];
                    events.add(new Event(name, description, date));
                }
            }
            br.close();
        } catch (IOException e) {
            System.err.println("Error reading events file: " + e.getMessage());
        }
    }

    private void writeEventsToFile() {
        try  {
            BufferedWriter bw = new BufferedWriter(new FileWriter("events.txt",true));
            int i=0;
            for (Event event : events) {
                bw.write(event.getName() + "," + event.getDescription() + "," + event.getDate() + "\n");
            }
            bw.close();
        } catch (IOException e) {
            System.err.println("Error writing events file: " + e.getMessage());
        }
    }

    public void displayEvents() {
        for (int i = 0; i < events.size(); i++) {
            System.out.println((i + 1) + ". Name : " + events.get(i).getName()+"| Description : "+events.get(i).getDescription()+"| Date : "+events.get(i).getDate());
        }
    }

    public void addEvent(String name, String description, String date) {
        events.add(new Event(name, description, date));
        writeEventsToFile();
        System.out.println("Event added successfully.");
    }

    public void updateEvent(int index, String name, String description, String date) {
        if (index >= 0 && index < events.size()) {
            events.get(index).setName(name);
            events.get(index).setDescription(description);
            events.get(index).setDate(date);
            writeEventsToFile();
            System.out.println("Event updated successfully.");
        } else {
            System.out.println("Invalid event index.");
        }
    }

    public void deleteEvent(int index) {
        if (index >= 0 && index < events.size()) {
            events.remove(index);
            writeEventsToFile();
            System.out.println("Event deleted successfully.");
        } else {
            System.out.println("Invalid event index.");
        }
    }
}
