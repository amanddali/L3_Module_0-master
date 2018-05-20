package IntroToStacks;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TextUndoRedo implements KeyListener {
	JFrame frame;
	JPanel panel;
	JLabel label;
	String letter = "";
	static Stack<Character> character = new Stack<Character>();
	static Stack<Character> deleted = new Stack<Character>();

	public static void main(String[] args) {
		TextUndoRedo stuff = new TextUndoRedo();
		stuff.createUI();
	}

	public void createUI() {
		frame = new JFrame();
		panel = new JPanel();
		label = new JLabel();
		frame.setVisible(true);
		frame.addKeyListener(this);
		panel.setPreferredSize(new Dimension(300, 300));
		frame.add(panel);
		panel.add(label);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/*
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look
	 * like a basic text editor.
	 * 
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character
	 * is erased from the JLabel. Save that deleted character onto a Stack of
	 * Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed,
	 * the top Character is popped off the Stack and added back to the JLabel.
	 * 
	 */
	public void setLabel() {
		char car = '\0';
		letter = "";
		for (int i = 0; i < character.size(); i++) {
			car = character.pop();
			letter += car;
		}
		label.setText(label.getText() + letter);
	}

	public void delete() {
		if (character.size() > 0) {
			String s = label.getText();
			label.setText(s.substring(0, s.length() - 2));
			deleted.push(s.charAt(s.length() - 2));
		} else {
			JOptionPane.showMessageDialog(null, "Nothing to delete");
		}
	}

	public void undo() {
		if (deleted.size() > 0) {
			character.push(deleted.pop());
			setLabel();
		} else {
			JOptionPane.showMessageDialog(null, "Nothing to undo");
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		character.push(e.getKeyChar());
		setLabel();
		if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			delete();
		}
		if (e.getKeyCode() == KeyEvent.VK_DELETE) {
			undo();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
