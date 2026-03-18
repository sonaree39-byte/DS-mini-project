// Vehicle class to store vehicle number and priority
class Vehicle {

    String vehicleNumber;
    int priority;

    // Constructor
    Vehicle(String vehicleNumber, int priority) {
        this.vehicleNumber = vehicleNumber;
        this.priority = priority;
    }
}

// MaxHeap class
class MaxHeap {

    Vehicle[] heap;
    int size;
    int capacity;

    // Constructor
    MaxHeap(int capacity) {
        this.capacity = capacity;
        heap = new Vehicle[capacity];
        size = 0;
    }

    // Insert vehicle into heap
    void insert(String vehicleNumber, int priority) {

        if (size == capacity) {
            System.out.println("Heap is Full");
            return;
        }

        Vehicle newVehicle = new Vehicle(vehicleNumber, priority);

        heap[size] = newVehicle;

        int i = size;
        size++;

        // Upward adjustment
        while (i > 0) {

            int parent = (i - 1) / 2;

            if (heap[parent].priority < heap[i].priority) {

                Vehicle temp = heap[parent];
                heap[parent] = heap[i];
                heap[i] = temp;

                i = parent;

            } else {
                break;
            }
        }

        System.out.println("Vehicle Inserted");
    }

    // Display highest priority vehicle
    void peek() {

        if (size == 0) {
            System.out.println("Heap is Empty");
            return;
        }

        System.out.println("Highest Priority Vehicle: "
                + heap[0].vehicleNumber
                + " Priority: "
                + heap[0].priority);
    }

    // Display all vehicles
    void display() {

        if (size == 0) {
            System.out.println("Heap is Empty");
            return;
        }

        System.out.println("Vehicles in Heap:");

        for (int i = 0; i < size; i++) {

            System.out.println(heap[i].vehicleNumber +
                    " Priority: " + heap[i].priority);
        }
    }

    // Heapify function (Downward adjustment)
    void heapify(int i) {

        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && heap[left].priority > heap[largest].priority)
            largest = left;

        if (right < size && heap[right].priority > heap[largest].priority)
            largest = right;

        if (largest != i) {

            Vehicle temp = heap[i];
            heap[i] = heap[largest];
            heap[largest] = temp;

            heapify(largest);
        }
    }

    // Remove highest priority vehicle
    void deleteRoot() {

        if (size == 0) {
            System.out.println("Heap is Empty");
            return;
        }

        Vehicle removedVehicle = heap[0];

        heap[0] = heap[size - 1];

        size--;

        heapify(0);

        System.out.println("Removed Vehicle: "
                + removedVehicle.vehicleNumber +
                " Priority: "
                + removedVehicle.priority);
    }
}
