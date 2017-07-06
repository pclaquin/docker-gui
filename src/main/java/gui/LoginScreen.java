package gui;

import interfaceDocker.*;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JProgressBar;

public class LoginScreen extends JFrame {
	private JTextField host;
	private JTextField username;
	private JPasswordField password;
	private JButton btnLogin;
	private JProgressBar progressBarConnection;
	private JLabel lblProgression;
	/**
	 * Create the application.
	 */
	public LoginScreen() {
		super();
		frameInit();
		initialize();
		this.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(75, 80, 83, 14);
		this.getContentPane().add(lblUsername);
		
		JLabel lblHost = new JLabel("Host");
		lblHost.setBounds(75, 55, 46, 14);
		this.getContentPane().add(lblHost);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(75, 108, 46, 14);
		this.getContentPane().add(lblPassword);
		
		host = new JTextField();
		host.setBounds(155, 49, 200, 20);
		this.getContentPane().add(host);
		host.setColumns(10);
		
		username = new JTextField();
		username.setBounds(155, 77, 200, 20);
		this.getContentPane().add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(155, 105, 200, 20);
		this.getContentPane().add(password);
		
		btnLogin = new JButton("New button");
		btnLogin.setBounds(155, 175, 134, 23);
		getContentPane().add(btnLogin);
		
		progressBarConnection = new JProgressBar();
		progressBarConnection.setBounds(155, 209, 134, 14);
		getContentPane().add(progressBarConnection);
		
		lblProgression = new JLabel("");
		lblProgression.setBounds(155, 234, 134, 14);
		getContentPane().add(lblProgression);
		
		//TODO : ONLY for testing
		username.setText("administrateur");
		host.setText("srvinfradec2");
		password.setText("L9jbZkc6tp");
	}
		
		public void setProgressBarConnection(int n) {
			this.progressBarConnection.setValue(n);
		}
		
		public JButton getButtonLogin() {
			return this.btnLogin;
		}
		
		public void setLabelProgression(String string) {
			this.lblProgression.setText(string);
		}
		
		public Credentials getCredentials() {
			Credentials credentials;
			credentials = new Credentials(username.getText(), host.getText(), password.getText());
			return credentials;
		}
}

