import java.util.Scanner;

/**
 * App - main control class for the BMI Manager
 * Created by Jason on 13/03/2015.
 */
public class App {
    public static void main(String[] args) {
        System.out.println("BMI Manager");

        Patient patient = new Patient();
        running:
        while (true) {
            System.out.println("Please select from the " +
                    "following menu options:\n" +
                    "\t1. Add new patient\n" +
                    "\t2. View patient\n" +
                    "\t3. Exit\n");

            System.out.print("Enter choice: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: {
                    addPatient(patient, scanner);
                    break;
                }
                case 2: {
                    viewPatient(patient);
                    break;
                }
                case 3: {
                    System.out.println("Good bye!");
                    break running;
                }
            }
        }
    }

    private static void viewPatient(Patient patient) {
        String message = String.format("Name: %s Age: %d BMI: %.2f",
                patient.getName(), patient.getAge(), patient.getBMI());
        System.out.println(message);
    }

    private static void addPatient(Patient patient, Scanner scanner) {
        System.out.print("Enter name: ");
        patient.setName(scanner.nextLine());

        System.out.print("Enter age: ");
        patient.setAge(scanner.nextInt());

        System.out.print("Enter height: ");
        double height = scanner.nextDouble();

        System.out.print("Enter weight: ");
        double weight = scanner.nextDouble();

        patient.setDetails(height, weight);
    }
}
