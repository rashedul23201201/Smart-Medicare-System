import java.io.*;
import java.util.*;

public class FileManager {

    public static void writeToFile(String filename, String content) {
        try (FileWriter fw = new FileWriter(filename, true)) {
            fw.write(content + "\n------------------------------------------------------------\n");
        } catch (IOException e) {
            System.out.println("File Write Error: " + e.getMessage());
        }
    }

    public static List<Doctor> loadDoctors(String filename) {
        List<Doctor> doctors = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",");
                if (parts.length == 7) {
                    String id = parts[0];
                    String name = parts[1];
                    int age = Integer.parseInt(parts[2]);
                    String specialization = parts[3];
                    String time = parts[4];
                    String days = parts[5];
                    double fee = Double.parseDouble(parts[6]);
                    doctors.add(new Doctor(id, name, age, specialization, time, days, fee));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading doctor file: " + e.getMessage());
        }
        return doctors;
    }
}
