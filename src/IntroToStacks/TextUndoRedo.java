package IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TextUndoRedo implements KeyListener {
	/*
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look
	 * like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character
	 * is erased from the JLabel. Save that deleted character onto a Stack of
	 * Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed,
	 * the top Character is popped off the Stack and added back to the JLabel.
	 * 
	 */

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();

	Stack<String> text = new Stack<String>();

	public static void main(String[] args) {
		TextUndoRedo TUR = new TextUndoRedo();

		TUR.setup();
	}

	void setup() {
		frame.add(panel);
		panel.add(label);
		frame.setVisible(true);
		frame.setSize(500, 50);
		frame.addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() != KeyEvent.VK_BACK_SPACE) {
			if (e.getKeyCode() != KeyEvent.VK_SHIFT) {
				if (e.getKeyCode() != KeyEvent.VK_CONTROL) {
					String label1 = label.getText();
					label.setText(label1 + e.getKeyChar());	
				}
				
			}

		}
		if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			String toUndo = "" + label.getText().charAt(label.getText().length() - 1);
			text.push(toUndo);
			label.setText(label.getText().substring(0, label.getText().length() - 1));
		}
		if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
			label.setText(label.getText() + text.pop());
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
