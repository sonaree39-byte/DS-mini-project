import java.util.Scanner;

// ================= PARKING MANAGER =================
class ParkingManager {

    ParkingStack stack = new ParkingStack();   // for entry/exit
    MaxHeap heap = new MaxHeap(10);            // for priority
    HashModule hash = new HashModule(10);      // for search

    Scanner sc = new Scanner(System.in);

    // ================= ADD VEHICLE =================
    void addVehicle() {
        System.out.print("Enter Vehicle Number: ");
        String num = sc.nextLine();

        System.out.print("Enter Priority (1-VIP, 2-Car, 3-Bike): ");
        int priority = sc.nextInt();
        sc.nextLine();

        stack.push(num);     // add in stack
        heap.insert(num, priority);    // add in heap
        hash.insert(new Vehicle(num, priority));    // add in hash

        System.out.println("Vehicle Added Successfully\n");
    }

    // ================= REMOVE VEHICLE =================
    void removeVehicle() {

        System.out.println("1. Normal Exit (Stack)");
        System.out.println("2. Priority Exit (Heap)");
        int choice = sc.nextInt();

        if (choice == 1) {
            stack.pop();
        }
        else if (choice == 2) {
            heap.deleteRoot();
        }
    }

    // ================= SEARCH VEHICLE =================
    void searchVehicle() {
        System.out.print("Enter Vehicle Number to Search: ");
        String num = sc.nextLine();

        hash.search(num);
    }

    // ================= DISPLAY =================
    void displayAll() {

        System.out.println("\n--- Stack Data ---");
        stack.display();

        System.out.println("\n--- Heap Data ---");
        System.out.println("Displayed using Heap Module");   // ✅ only change

        System.out.println("\n--- Hash Data ---");
        hash.display();
    }

    // ================= MAIN MENU =================
    public static void main(String[] args) {

        ParkingManager pm = new ParkingManager();
        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n===== Parking Management System =====");
            System.out.println("1. Add Vehicle");
            System.out.println("2. Remove Vehicle");
            System.out.println("3. Search Vehicle");
            System.out.println("4. Display All");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    pm.addVehicle();
                    break;

                case 2:
                    pm.removeVehicle();
                    break;

                case 3:
                    pm.searchVehicle();
                    break;

                case 4:
                    pm.displayAll();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 5);
    }
}
