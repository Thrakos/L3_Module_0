package IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GuestBook implements ActionListener {
	// Create a GUI with two buttons. One button reads "Add Name" and the other
	// button reads "View Names".
	// When the add name button is clicked, display an input dialog that asks
	// the user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked,
	// display a message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton addName = new JButton();
	JButton viewNames = new JButton();
	JButton deleteName = new JButton();

	String name = "";
	String names = "";

	ArrayList<String> guestList = new ArrayList<String>();

	public static void main(String[] args) {

		GuestBook g = new GuestBook();

		g.setup();

	}

	void setup() {
		frame.add(panel);
		panel.add(addName);
		panel.add(viewNames);
		panel.add(deleteName);
		addName.setText("Add Name");
		viewNames.setText("View Names");
		deleteName.setText("Delete Name");
		frame.setVisible(true);
		frame.pack();
		addName.addActionListener(this);
		viewNames.addActionListener(this);
		deleteName.addActionListener(this);
		guestList.add("Bob Banders");
		guestList.add("Sandy Summers");
		guestList.add("Greg Ganders");
		guestList.add("Donny Doners");
	}

	void addName() {
		String blah = JOptionPane.showInputDialog("Add Name:");
		if (blah != null && !blah.equals("") && nonSpaceChar(blah)) {
			guestList.add(blah);
		}
	}

	void viewNames() {
		for (int i = 0; i < guestList.size(); i++) {
			String j = guestList.get(i);
			names = names + "Guest #" + (i + 1) + ": " + j + "\n";
		}
		JOptionPane.showMessageDialog(null, names);
	}

	void deleteName() {
		for (int i = 0; i < guestList.size(); i++) {
			String j = guestList.get(i);
			names = names + "Guest #" + (i + 1) + ": " + j + "\n";
		}
		String delete = JOptionPane.showInputDialog(names + "\n Delete Name:");
		guestList.remove(delete);
	}
	
	boolean nonSpaceChar(String s) {
		for (int i = 0; i < s.length(); i++) { 
			if (s.charAt(i) != ' ') {
				return true;				
			}
		}
		return false;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addName) {
			addName();
		}
		if (e.getSource() == viewNames) {
			names = "";
			viewNames();
		}
		if (e.getSource() == deleteName) {
			names = "";
			deleteName();
		}

	}
}
