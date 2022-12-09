import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ReadAndWrite {
    public static void write(ArrayList<Student> accounts) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("students.csv");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(accounts);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Student> read() {
        try {
            FileInputStream fileInputStream = new FileInputStream("students.csv");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (ArrayList<Student>) objectInputStream.readObject();
        } catch (Exception e) {

            return new ArrayList<>();
        }
    }
}
