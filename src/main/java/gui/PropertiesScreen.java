package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSeparator;

public class PropertiesScreen {

	private JFrame frmProperties;

	public PropertiesScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProperties = new JFrame();
		frmProperties.setTitle("Properties");
		frmProperties.setBounds(100, 100, 450, 500);
		frmProperties.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProperties.getContentPane().setLayout(null);
	}
}
