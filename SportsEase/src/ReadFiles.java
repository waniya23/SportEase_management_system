import java.io.*;

public class ReadFiles {
    public void fileread() {
        File f2 = new File("haya.txt");
        try {

            if (f2.createNewFile()) {
                System.out.println("Created");
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(f2));
            bw.write("k230600@nu.edu.pk haya123");
            bw.close();
            System.out.println("written");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(f2));
            String data;
            while ((data = br.readLine()) != null) {
                System.out.println(data);
            }
            br.close();

        }catch(IOException e){
            System.out.println("File cannot read"+e.getMessage());
        }

    }

    public static void main(String[] args) {
        ReadFiles thisfile = new ReadFiles();
        thisfile.fileread();
    }
}
