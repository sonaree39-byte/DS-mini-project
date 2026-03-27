import java.util.Scanner;

// ======= PARKING MANAGER =======
class ParkingManager {

    StackModule stack = new StackModule(10);   // for entry/exit
    MaxHeap heap = new MaxHeap(10);            // for priority
    HashModule hash = new HashModule(10);      // for search

    Scanner sc = new Scanner(System.in);

    // ========= ADD VEHICLE ==========
    void addVehicle() {
        System.out.print("Enter Vehicle Number: ");
        String num = sc.nextLine();

        System.out.print("Enter Priority (1-VIP, 2-Car, 3-Bike): ");
        int priority = sc.nextInt();
        sc.nextLine();

        Vehicle v = new Vehicle(num, priority);

        stack.push(v);     // add in stack
        heap.insert(v);    // add in heap
        hash.insert(v);    // add in hash

        System.out.println("Vehicle Added Successfully\n");
    }

    // ========= REMOVE VEHICLE =========
    void removeVehicle() {

        System.out.println("1. Normal Exit (Stack)");
        System.out.println("2. Priority Exit (Heap)");
        int choice = sc.nextInt();

        if (choice == 1) {
            Vehicle v = stack.pop();

            if (v != null) {
                hash.delete(v.vehicleNumber);
                System.out.println("Removed (Stack): " + v.vehicleNumber);
            }
        }
        else if (choice == 2) {
            Vehicle v = heap.deleteRoot();

            if (v != null) {
                hash.delete(v.vehicleNumber);
                System.out.println("Removed (Heap): " + v.vehicleNumber);
            }
        }
    }

    // ========= SEARCH VEHICLE =========
    void searchVehicle() {
        System.out.print("Enter Vehicle Number to Search: ");
        String num = sc.nextLine();

        hash.search(num);
    }

    // ======== DISPLAY ========
    void displayAll() {

        System.out.println("\n--- Stack Data ---");
        stack.display();

        System.out.println("\n--- Heap Data ---");
        heap.display();

        System.out.println("\n--- Hash Data ---");
        hash.display();
    }

    // ======== MAIN MENU ==========
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
