// ================= VEHICLE CLASS =================
// This class stores vehicle details used in all modules (Stack, Heap, Hash)
class Vehicle {
    String vehicleNumber;   // stores vehicle number (unique ID)
    int priority;           // stores priority (used in heap)

    // Constructor to initialize vehicle object
    Vehicle(String vehicleNumber, int priority) {
        this.vehicleNumber = vehicleNumber;
        this.priority = priority;
    }
}


// ================= HASH MODULE =================
// This class implements Hashing for fast search of vehicles
class HashModule {

    Vehicle[] table;   // Array to store vehicles (Hash Table)
    int size;          // Size of hash table

    // Constructor to initialize hash table
    HashModule(int size) {
        this.size = size;
        table = new Vehicle[size];   // create array of given size
    }

    // ================= HASH FUNCTION =================
    // Converts vehicle number into an index
    int hashFunction(String key) {
        int sum = 0;

        // Add ASCII values of each character
        for (int i = 0; i < key.length(); i++) {
            sum = sum + key.charAt(i);
        }

        // Return index within array size
        return sum % size;
    }

    // ================= INSERT FUNCTION =================
    // Adds vehicle into hash table
    void insert(Vehicle v) {

        // Get index using hash function
        int index = hashFunction(v.vehicleNumber);

        // Handle collision using linear probing
        while (table[index] != null) {
            index = (index + 1) % size;   // move to next index
        }

        // Insert vehicle
        table[index] = v;

        System.out.println("Vehicle Inserted at index: " + index);
    }

    // ================= SEARCH FUNCTION =================
    // Searches vehicle using vehicle number
    void search(String vehicleNumber) {

        int index = hashFunction(vehicleNumber);
        int start = index;   // to avoid infinite loop

        // Traverse until empty slot
        while (table[index] != null) {

            // Check if vehicle matches
            if (table[index].vehicleNumber.equals(vehicleNumber)) {
                System.out.println("Vehicle Found: " + vehicleNumber +
                                   " Priority: " + table[index].priority);
                return;
            }

            // Move to next index (linear probing)
            index = (index + 1) % size;

            // Stop if we return to starting index
            if (index == start) break;
        }

        System.out.println("Vehicle Not Found");
    }

    // ================= DELETE FUNCTION =================
    // Removes vehicle from hash table
    void delete(String vehicleNumber) {

        int index = hashFunction(vehicleNumber);
        int start = index;

        // Traverse table
        while (table[index] != null) {

            // If found, delete it
            if (table[index].vehicleNumber.equals(vehicleNumber)) {
                table[index] = null;
                System.out.println("Vehicle Deleted");
                return;
            }

            // Move to next index
            index = (index + 1) % size;

            if (index == start) break;
        }

        System.out.println("Vehicle Not Found");
    }

    // ================= DISPLAY FUNCTION =================
    // Displays all vehicles in hash table
    void display() {

        for (int i = 0; i < size; i++) {

            if (table[i] != null) {
                System.out.println("Index " + i + ": " +
                        table[i].vehicleNumber +
                        " Priority: " + table[i].priority);
            } else {
                System.out.println("Index " + i + ": Empty");
            }
        }
    }
}
