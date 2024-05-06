import java.util.*;

class Notebook {
    String model;
    int ram;
    int storage;
    String os;
    String color;

    public Notebook(String model, int ram, int storage, String os, String color) {
        this.model = model;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Model: " + model + ", RAM: " + ram + ", Hard disk capacity: " + storage + ", Operating system: " + os + ", Color: " + color;
    }
}

public class Main {
    public static void main(String[] args) {
        Set<Notebook> notebooks = new HashSet<>();
        notebooks.add(new Notebook("Dell XPS", 16, 512, "Windows", "Silver"));
        notebooks.add(new Notebook("MacBook Pro", 8, 256, "macOS", "Space Gray"));
        notebooks.add(new Notebook("HP Pavilion", 12, 1024, "Windows", "Black"));

        filterNotebooks(notebooks);
    }

    public static void filterNotebooks(Set<Notebook> notebooks) {
        Scanner scanner = new Scanner(System.in);
        int criterion;

        do {
            System.out.println("Enter the number that meets the required criterion:\n" +
                    "1 - RAM\n" +
                    "2 - Hard disk capacity\n" +
                    "3 - Operating system\n" +
                    "4 - Color");
            System.out.print("Select filter criteria (number from 1 to 4, 0 to complete): ");
            criterion = scanner.nextInt();

            switch (criterion) {
                case 1:
                    System.out.print("Enter the minimum value for RAM: ");
                    int minRam = scanner.nextInt();
                    filterByRam(notebooks, minRam);
                    break;
                case 2:
                    System.out.print("Enter the minimum value for the hard disk: ");
                    int minStorage = scanner.nextInt();
                    filterByStorage(notebooks, minStorage);
                    break;
                case 3:
                    System.out.print("Enter operating system: ");
                    scanner.nextLine(); // очистка буфера
                    String os = scanner.nextLine();
                    filterByOS(notebooks, os);
                    break;
                case 4:
                    System.out.print("Enter the color: ");
                    scanner.nextLine(); // очистка буфера
                    String color = scanner.nextLine();
                    filterByColor(notebooks, color);
                    break;
            }
        } while (criterion != 0);
    }

    public static void filterByRam(Set<Notebook> notebooks, int minRam) {
        for (Notebook notebook : notebooks) {
            if (notebook.ram >= minRam) {
                System.out.println(notebook);
            }
        }
    }

    public static void filterByStorage(Set<Notebook> notebooks, int minStorage) {
        for (Notebook notebook : notebooks) {
            if (notebook.storage >= minStorage) {
                System.out.println(notebook);
            }
        }
    }

    public static void filterByOS(Set<Notebook> notebooks, String os) {
        for (Notebook notebook : notebooks) {
            if (notebook.os.equals(os)) {
                System.out.println(notebook);
            }
        }
    }

    public static void filterByColor(Set<Notebook> notebooks, String color) {
        for (Notebook notebook : notebooks) {
            if (notebook.color.equals(color)) {
                System.out.println(notebook);
            }
        }
    }
}


