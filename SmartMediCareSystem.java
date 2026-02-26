import java.util.*;
import java.io.*;

public class SmartMediCareSystem {
    private List<Doctor> doctors;
    private Scanner scanner;

    public SmartMediCareSystem() {
        doctors = FileManager.loadDoctors("doctors.txt");
        scanner = new Scanner(System.in);
    }

    public void menu() {
        while (true) {
            System.out.println("\n==== SmartMediCare System ====");
            System.out.println("1. Register Patient");
            System.out.println("2. View Doctors");
            System.out.println("3. Make Appointment");
            System.out.println("4. View Appointments");
            System.out.println("5. Pay Bill");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1": registerPatient(); break;
                case "2": viewDoctors(); break;
                case "3": makeAppointment(); break;
                case "4": viewFile("appointments.txt"); break;
                case "5": payBill(); break;
                case "6": doctors = FileManager.loadDoctors("doctors.txt"); break;
                case "0": System.out.println("Thank you! Exiting..."); return;
                default: System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void registerPatient() {
        try {
            System.out.print("Patient ID: ");
            String id = scanner.nextLine();
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Gender: ");
            String gender = scanner.nextLine();
            System.out.print("Age: ");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.print("Phone: ");
            String phone = scanner.nextLine();
            System.out.print("Number of symptoms: ");
            int count = Integer.parseInt(scanner.nextLine());

            List<String> symptoms = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                System.out.print("Symptom " + (i+1) + ": ");
                symptoms.add(scanner.nextLine().toLowerCase());
            }

            System.out.print("Date: ");
            String recordDate = scanner.nextLine();
            System.out.print("Description: ");
            String description = scanner.nextLine();
            System.out.print("Emergency Message (optional): ");
            String emergency = scanner.nextLine();

            Patient patient = new Patient(id, name, age, gender, phone, symptoms, recordDate, description, emergency);
            FileManager.writeToFile("patients.txt", patient.getDetails());
            System.out.println("Patient registered.");
        } catch (Exception e) {
            System.out.println("Registration Error: " + e.getMessage());
        }
    }

    private void viewDoctors() {
        System.out.println("=== Available Doctors ===");
        for (Doctor d : doctors) {
            System.out.println(d.getDetails());
        }
    }

    private void makeAppointment() {
        try {
            System.out.print("Enter Patient ID: ");
            String pid = scanner.nextLine();
            System.out.print("Enter doctor's specialization: ");
            String symptom = scanner.nextLine().toLowerCase();
            System.out.print("Enter today's day (sunday,monday,tuesday,wednesday,thursday): ");
            String today = scanner.nextLine().toLowerCase();

            Doctor matched = null;
            for (Doctor d : doctors) {
                if (d.getSpecialization().equalsIgnoreCase(symptom)
                        && d.getAvailableDays().contains(today)) {
                    matched = d;
                    break;
                }
            }

            if (matched == null) {
                System.out.println("No doctor available for that symptom today.");
                return;
            }

            System.out.println("Matched: " + matched.getDetails());
            System.out.print("Want to book? (yes/no): ");
            if (scanner.nextLine().equalsIgnoreCase("yes")) {
                Appointment appointment = new Appointment(pid, matched.id, today, matched.getAvailableTime());
                FileManager.writeToFile("appointments.txt", appointment.getDetails());
                System.out.println("SMS: Appointment confirmed with Dr. " + matched.name);
            }
        } catch (Exception e) {
            System.out.println("Appointment Error: " + e.getMessage());
        }
    }

    private void payBill() {
        try {
            System.out.print("Enter Patient ID: ");
            String id = scanner.nextLine();

            System.out.print("Enter Amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();

            if (amount <= 0) {
                System.out.println("Amount must be greater than 0.");
                return;
            }

            System.out.print("Payment method (cash/card): ");
            String method = scanner.nextLine();

            if (!method.equalsIgnoreCase("cash") && !method.equalsIgnoreCase("card")) {
                System.out.println("Invalid payment method.");
                return;
            }

            Bill bill = new Bill(id, amount, method, "Paid");
            FileManager.writeToFile("bills.txt", bill.getDetails());
            System.out.println("Payment Successful!");
        } catch (Exception e) {
            System.out.println("Billing Error: " + e.getMessage());
        }
    }

    private void viewFile(String filename) {
        try (Scanner file = new Scanner(new File(filename))) {
            while (file.hasNextLine()) {
                System.out.println(file.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Unable to view file: " + e.getMessage());
        }
    }
}
