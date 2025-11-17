import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Service s = new Service();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Dodaj studenta");
            System.out.println("2 - Wyświetl listę studentów");
            System.out.println("0 - Wyjście");
            System.out.print("Wybierz opcję: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Nieprawidłowy wybór!");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Podaj imię: ");
                    String name = scanner.nextLine();

                    System.out.print("Podaj wiek: ");
                    int age;
                    try {
                        age = Integer.parseInt(scanner.nextLine());
                    } catch (Exception e) {
                        System.out.println("Błędny wiek!");
                        break;
                    }

                    try {
                        s.addStudent(new Student(name, age));
                        System.out.println("Dodano studenta.");
                    } catch (IOException e) {
                        System.out.println("Błąd zapisu: " + e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        var students = s.getStudents();
                        System.out.println("\n--- Lista studentów ---");
                        for (Student st : students) {
                            System.out.println(st.ToString());
                        }
                    } catch (IOException e) {
                        System.out.println("Błąd odczytu: " + e.getMessage());
                    }
                    break;

                case 0:
                    System.out.println("Koniec programu.");
                    running = false;
                    break;

                default:
                    System.out.println("Nie ma takiej opcji!");
                    break;
            }
        }

        scanner.close();
    }
}
