package IntroToHashMaps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LogSearch implements ActionListener {
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

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton addEntry = new JButton();
	JButton searchByID = new JButton();
	JButton viewList = new JButton();
	JButton removeName = new JButton();

	String namees = "";

	HashMap<Integer, String> names = new HashMap<Integer, String>();

	public static void main(String[] args) {
		LogSearch ls = new LogSearch();

		ls.setup();

	}

	void setup() {
		frame.add(panel);
		frame.setVisible(true);
		panel.add(addEntry);
		panel.add(searchByID);
		panel.add(viewList);
		panel.add(removeName);
		addEntry.setText("Add Entry");
		searchByID.setText("Search By ID");
		viewList.setText("View List");
		removeName.setText("Remove Name");
		frame.pack();
		addEntry.addActionListener(this);
		searchByID.addActionListener(this);
		viewList.addActionListener(this);
		removeName.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addEntry) {
			int number = Integer.parseInt(JOptionPane.showInputDialog("Input an ID: "));
			String name = JOptionPane.showInputDialog("Input a name: ");

			names.put(number, name);
		}

		if (e.getSource() == searchByID) {
			int number = Integer.parseInt(JOptionPane.showInputDialog("Enter an ID: "));
			String namee = names.get(number);
			if (names.containsKey(number)) {
				JOptionPane.showMessageDialog(null, namee);
			} else {
				JOptionPane.showMessageDialog(null, "This ID does not exist");
			}
		}

		if (e.getSource() == viewList) {
				namees = "";			
			for (Integer i : names.keySet()) {
				namees = namees + "ID: " + i + " Name: " + names.get(i) + "\n";
			}
			JOptionPane.showMessageDialog(null, namees);
		}
		
		if (e.getSource() == removeName) {
			int number = Integer.parseInt(JOptionPane.showInputDialog("Enter an ID: "));
			if (names.containsKey(number)) {
				names.remove(number);
			}
			else {
				JOptionPane.showMessageDialog(null, "This ID does not exist");
			}
		}

	}
}
