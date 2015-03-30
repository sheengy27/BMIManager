import java.util.Scanner;

/**
 * App - main control class for the BMI Manager
 * Created by Jason on 13/03/2015.
 */
public class App {
    public static void main(String[] args) {
        System.out.println("BMI Manager");

        Patients patients = new Patients();
        running:
        while (true) {
            System.out.println("Please select from the " +
                    "following menu options:\n" +
                    "\t1. Add new patient\n" +
                    "\t2. View patients\n" +
                    "\t3. Update patient\n"+
                    "\t4. Exit\n");

            System.out.print("Enter choice: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: {
                    patients.add(createPatient(scanner));
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
                case 3:{
                    updatePatient(patients,scanner);
                    break;
                }
                case 4: {
                    System.out.println("Good bye!");
                    break running;
                }
            }
        }
    }

    private static void updatePatient(Patients patients, Scanner scanner) {
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        for (Patient patient : patients.records){
            if(patient.getName().equals(name)){
                System.out.println("Enter the age: ");
                int age = scanner.nextInt();
                System.out.println("Enter the height: ");
                double height = scanner.nextDouble();
                System.out.println("Enter the weight: ");
                double weight = scanner.nextDouble();
                patient.setAge(age);
                patient.setHeight(height);
                patient.setWeight(weight);
                break;
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
