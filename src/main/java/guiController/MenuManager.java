package guiController;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import gui.MainScreen;

public class MenuManager {
	private JMenuBar menuBar;
	private JMenu menu;
	private ItemQuit item1;
	private MainScreen mainScreen;
	
	public MenuManager(MainScreen mainScreen) {
		this.mainScreen = mainScreen;
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 5000, 30);
		mainScreen.getContentPane().add(menuBar);
		
	}
}
