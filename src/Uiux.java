java
import javax.swing.*;
import java.awt.event.*;

class ParkingUI {

    ParkingManager pm = new ParkingManager();

    ParkingUI() {

        JFrame f = new JFrame("Parking System");

        JLabel l1 = new JLabel("Vehicle Number:");
        l1.setBounds(20, 20, 150, 30);

        JTextField t1 = new JTextField();
        t1.setBounds(170, 20, 150, 30);

        JLabel l2 = new JLabel("Priority:");
        l2.setBounds(20, 60, 150, 30);

        JTextField t2 = new JTextField();
        t2.setBounds(170, 60, 150, 30);

        JButton b1 = new JButton("Add Vehicle");
        b1.setBounds(20, 110, 140, 30);

        JButton b2 = new JButton("Remove (Stack)");
        b2.setBounds(180, 110, 140, 30);

        JButton b3 = new JButton("Search");
        b3.setBounds(20, 160, 140, 30);

        JButton b4 = new JButton("Display");
        b4.setBounds(180, 160, 140, 30);

        JTextArea area = new JTextArea();
        area.setBounds(20, 210, 300, 150);

        // ADD BUTTON
        b1.addActionListener(e -> {
            String num = t1.getText();
            int priority = Integer.parseInt(t2.getText());

            Vehicle v = new Vehicle(num, priority);

            pm.stack.push(num);              
            pm.heap.insert(num, priority);   
            pm.hash.insert(v);

            area.setText("Vehicle Added: " + num);
        });

        // REMOVE BUTTON
        b2.addActionListener(e -> {

            pm.stack.pop();   // 

            area.setText("Vehicle Removed (Stack)");
        });

        // SEARCH BUTTON
        b3.addActionListener(e -> {
            String num = t1.getText();
            pm.hash.search(num);
            area.setText("Check console for search result");
        });

        // DISPLAY BUTTON
        b4.addActionListener(e -> {
            pm.displayAll();
            area.setText("Displayed in console");
        });

        f.add(l1); f.add(t1);
        f.add(l2); f.add(t2);
        f.add(b1); f.add(b2);
        f.add(b3); f.add(b4);
        f.add(area);

        f.setSize(370, 420);
        f.setLayout(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new ParkingUI();
    }
}
