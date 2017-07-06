package interfaceDocker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;

import gui.*;


public class ConnectionControler {
	private JSchConnection connection;
	private LoginScreen loginScreen;
	private Credentials credentials;
	private final Action action = new SwingAction();
	
	public ConnectionControler() {
		loginScreen = new LoginScreen();
		this.loginScreen.getButtonLogin().setAction(action);
		connection = new JSchConnection();
	}
	
	public boolean isConnected() {
		if(connection.test()) return true;
		else return false;
	}
	
	public JSchConnection getConnection() {
		return this.connection;
	}
	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			credentials = loginScreen.getCredentials();
			if(credentials.host.equals("") || credentials.user.equals("") || credentials.password.equals("")) {
				loginScreen.setLabelProgression("Renseignez les champs");
			}
			
			else {
				
				connection.connect(credentials);
				loginScreen.setLabelProgression("Récupération des identifiants");
				loginScreen.setProgressBarConnection(10);
				if(connection.test()) {
					loginScreen.setLabelProgression("Connexion réussie");
					loginScreen.setProgressBarConnection(100);
					JOptionPane.showMessageDialog(loginScreen, "Connection Successful");;
					loginScreen.dispose();
					DockerControler dockerControler = new DockerControler(getConnection());
				}
				else {
					loginScreen.setLabelProgression("Connexion échouée");
				}
			}

			
		}
	}
}
