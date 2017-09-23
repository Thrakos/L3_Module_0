package IntroToHashMaps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class RosettaStone implements ActionListener {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();

	JButton button = new JButton();
	HashMap<String, String> dictionary = new HashMap<String, String>();

	public static void main(String[] args) {
		RosettaStone RS = new RosettaStone();
		RS.setup();
	}

	String getRandomKey(HashMap<String, String> map) {
		String[] keysAsArray = map.keySet().toArray(new String[0]);
		int randomness = new Random().nextInt(map.size());
		return keysAsArray[randomness];
	}

	void setup() {
		dictionary.put("Hola", "Hello");
		dictionary.put("Adiós", "Bye");
		dictionary.put("Caminar", "Walk");
		dictionary.put("El", "The");
		dictionary.put("Sí", "Yes");
		dictionary.put("No", "No");
		dictionary.put("Él", "He");
		dictionary.put("Ella", "She");
		dictionary.put("Azul", "Blue");
		dictionary.put("Rojo", "Red");

		frame.add(panel);
		frame.setVisible(true);
		panel.add(button);
		button.setText(getRandomKey(dictionary));
		frame.pack();
		button.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			JOptionPane.showMessageDialog(null, dictionary.get(button.getText()));
			button.setText(getRandomKey(dictionary));
		}
	}
}
