package IntroToHashMaps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LogSearch implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton b1 = new JButton("Add Entry");
	JButton b2 = new JButton("Search by ID");
	JButton b3 = new JButton("View List");
	JButton b4 = new JButton("Remove Entry");
	String newID;
	String newName;
	Integer number;
	String existingID;
	HashMap<Integer, String> students = new HashMap<>();

	public static void main(String[] args) {
		LogSearch stuff = new LogSearch();
		stuff.createGUI();
	}

	public void createGUI() {
		frame.setVisible(true);
		frame.add(panel);
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b4);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/*
	 * Crate a HashMap of Integers for the keys and Strings for the values. Create a
	 * GUI with three buttons. Button 1: Add Entry When this button is clicked, use
	 * an input dialog to ask the user to enter an ID number. After an ID is
	 * entered, use another input dialog to ask the user to enter a name. Add this
	 * information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID When this button is clicked, use an input dialog to
	 * ask the user to enter an ID number. If that ID exists, display that name to
	 * the user. Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List When this button is clicked, display the entire list in a
	 * message dialog in the following format: ID: 123 Name: Harry Howard ID: 245
	 * Name: Polly Powers ID: 433 Name: Oliver Ortega etc...
	 * 
	 * When this is complete, add a fourth button to your window. Button 4: Remove
	 * Entry When this button is clicked, prompt the user to enter an ID using an
	 * input dialog. If this ID exists in the HashMap, remove it. Otherwise, notify
	 * the user that the ID is not in the list.
	 *
	 */
	public void addEntry() {
		newID = JOptionPane.showInputDialog("Enter a new ID number");
		newName = JOptionPane.showInputDialog("Enter a new name");
		newName = newName.toUpperCase();
		number = Integer.parseInt(newID);
		students.put(number, newName);
	}

	public void searchID() {
		boolean random = false;
		existingID = JOptionPane.showInputDialog("Enter existing ID");
		number = Integer.parseInt(existingID);
		for (Integer ID : students.keySet()) {
			System.out.println(ID);
			System.out.println(number);
			if (number.equals(ID)) {
				random = true;
				JOptionPane.showMessageDialog(null, students.get(number));
			}
		}
		if (random == false) {
			JOptionPane.showMessageDialog(null, "This ID does not exist");
		}
	}

	public void viewList() {
		String view = "";
		for (Integer ID : students.keySet()) {
			String list = "ID: " + ID + " Name: " + students.get(ID) + "\n";
			view += list;
		}
		JOptionPane.showMessageDialog(null, view);
	}

	public void removeEntry() {
		boolean random = false;
		existingID = JOptionPane.showInputDialog("Enter existing ID");
		number = Integer.parseInt(existingID);
		for (Integer ID : students.keySet()) {
			if (number.equals(ID)) {
				random = true;
				students.remove(number);
				JOptionPane.showMessageDialog(null, "ID number " + number + " has been removed");
			}
		}
		if (random == false) {
			JOptionPane.showMessageDialog(null, "This ID does not exist");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(b1)) {
			addEntry();
		}
		if (e.getSource().equals(b2)) {
			searchID();
		}
		if (e.getSource().equals(b3)) {
			viewList();
		}
		if (e.getSource().equals(b4)) {
			removeEntry();
		}
	}

}
