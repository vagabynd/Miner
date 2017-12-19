import java.io.*;
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
    public void fileReader() {
        try(FileReader reader = new FileReader("rec.txt"))
        {
            // читаем посимвольно
            int c;
            while((c=reader.read())!=-1){
                System.out.print((char)c);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

}
