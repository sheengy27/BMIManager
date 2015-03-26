import java.util.Scanner;

/**
 * App - main control class for the BMI Manager
 * Created by Jason on 13/03/2015.
 */
public class App {
    public static void main(String[] args) {
        System.out.println("BMI Manager");

        Patients patients = new Patients(10);
        running:
        while (true) {
            System.out.println("Please select from the " +
                    "following menu options:\n" +
                    "\t1. Add new patient\n" +
                    "\t2. View patients\n" +
                    "\t3. Exit\n");

            System.out.print("Enter choice: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: {
                    if (patients.isFull()) {
                        System.out.println("Database is full");
                    } else {
                        patients.add(createPatient(scanner));
                    }
                    break;
                }
                case 2: {
                    if (patients.isEmpty()) {
                        System.out.println("Database is empty");
                    } else {
                        viewPatients(patients);
                    }
                    break;
                }
                case 3: {
                    System.out.println("Good bye!");
                    break running;
                }
            }
        }
    }

    private static void viewPatients(Patients patients) {
        for (int i = 0; i < patients.count(); ++i) {
            Patient patient = patients.get(i);
            String message = String.format("Name: %s Age: %d BMI: %.2f",
                    patient.getName(), patient.getAge(), patient.getBMI());
            System.out.println(message);
        }
    }

    private static Patient createPatient(Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();

        System.out.print("Enter height: ");
        double height = scanner.nextDouble();

        System.out.print("Enter weight: ");
        double weight = scanner.nextDouble();

        return new Patient(name, age, height, weight);
    }
}
