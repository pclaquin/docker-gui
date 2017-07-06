package interfaceDocker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.Action;

import container.ContainerState;

import java.util.*;
import gui.*;
import parser.*;

public class DockerControler {
	private JSchConnection connection;
	private MainScreen mainScreen;
	private final Action actionListContainers = new SwingAction();
	private final Action actionListImages = new SwingAction();
	private DockerParser dockerParser;
	
	public DockerControler(JSchConnection connection) {
		mainScreen = new MainScreen();
		this.mainScreen.getButtonListImages().setAction(actionListImages);
		this.mainScreen.getButtonListContainers().setAction(actionListContainers);
		this.mainScreen.getButtonListImages().setActionCommand("PrintImages");
		this.mainScreen.getButtonListContainers().setActionCommand("PrintContainers");
		this.connection = connection;
		dockerParser = new DockerParser(connection);
	}
	
	private void addContainerList(String[] containerList) {
		mainScreen.freeContainerList();
		for(int i = 0; i < containerList.length; i++) {
			mainScreen.addContainerToList(containerList[i]);
		}
	}
	
	
	
	private void addImageList(String[] imageList) {
		mainScreen.freeImageList();
		for(int i = 0; i < imageList.length; i++) {
			mainScreen.addImageList(imageList[i]);
		}
	}
	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Liste");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		
		public void actionPerformed(ActionEvent e) {
			System.out.println(dockerParser.getJson("jenkins"));
				if("PrintImages".equals(e.getActionCommand())) addImageList(dockerParser.getImageList());
				if("PrintContainers".equals(e.getActionCommand())) addContainerList(dockerParser.getContainerList());
		}
	}
}
