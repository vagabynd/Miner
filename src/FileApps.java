import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileApps {
    private String time;
    public void fileWriter(int time) {
        try(FileWriter writer = new FileWriter("rec.txt", false))
        {
            // запись всей строки
            String text = "" + time;
            writer.write(text);
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    public int fileReader() {
        try {
            final DataInputStream dis = new DataInputStream(
                    new FileInputStream( "rec.txt"));
            final byte[] bytes = new byte[dis.available()];
            dis.readFully(bytes);
            final String fileContents = new String(bytes, 0, bytes.length);
            int k = Integer.parseInt(fileContents);
            return k;

        } catch (FileNotFoundException ex) {
            return 0;

        } catch (IOException ex) {
            return 0;
        }
    }

}
