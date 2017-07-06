package guiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

import gui.MainScreen;

public class ItemQuit implements ItemListener{
	private JMenuItem itemQuit;
	private MenuManager menuManager;
	
	public ItemQuit(MenuManager menuManager) {
		super();
		this.menuManager = menuManager;
		addListener();
		
	}
	
	public void addListener() {
		itemQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainScreen.dispose();
			}
		});
	}
}
