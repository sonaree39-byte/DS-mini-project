class ParkingStack {

    int MAXSTK = 10;
    String STACK[] = new String[MAXSTK];
    int TOP = -1;

    // PUSH Operation (Park Vehicle)
    void push(String ITEM) {

        // Check if parking is full
        if (TOP == MAXSTK - 1) {
            System.out.println("Overflow - Parking Full");
            return;
        }

        // Increase TOP
        TOP = TOP + 1;

        // Insert vehicle number
        STACK[TOP] = ITEM;

        System.out.println("Vehicle parked: " + ITEM);
    }

    // POP Operation (Remove Vehicle)
    void pop() {

        String ITEM;

        // Check if parking is empty
        if (TOP == -1) {
            System.out.println("Underflow - Parking Empty");
            return;
        }

        // Assign top element to 
        ITEM = STACK[TOP];

        // Decrease TOP
        TOP = TOP - 1;

        System.out.println("Vehicle removed: " + ITEM);
    }

    // DISPLAY Operation
    void display() {

        if (TOP == -1) {
            System.out.println("Parking is Empty");
            return;
        }

        System.out.println("Vehicles in Parking:");

        for (int i = TOP; i >= 0; i--) {
            System.out.println(STACK[i]);
        }
    }
}
