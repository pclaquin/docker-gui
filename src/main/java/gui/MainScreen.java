package gui;

import java.awt.EventQueue;

import guiController.MenuManager;
import parser.DockerParser;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainScreen extends JFrame {
	private JButton btnListImages;	
	private JButton btnListContainers;
	private JList<String> listContainers;
	private JList<String> listImages;
	DefaultListModel<String> listModelContainers;
	DefaultListModel<String> listModelImages;
	private MenuManager menuManager;
	
	/**
	 * Create the application.
	 */
	public MainScreen() {
		super();
		frameInit();
		initialize();
		this.setVisible(true);
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		getContentPane().setLayout(null);
		
		btnListImages = new JButton("List images");
		btnListImages.setBounds(341, 269, 136, 23);
		getContentPane().add(btnListImages);
		
		listModelContainers = new DefaultListModel<String>();
		
		btnListContainers = new JButton("List containers");
		btnListContainers.setBounds(62, 269, 136, 23);
		getContentPane().add(btnListContainers);
		
		listModelImages = new DefaultListModel<String>();
		
		menuManager = new MenuManager(this);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(341, 318, 256, 197);
		getContentPane().add(scrollPane);
		listImages = new JList<String>(listModelImages);
		scrollPane.setViewportView(listImages);
		listImages.addMouseListener( new MouseAdapter() {
		    public void mousePressed(MouseEvent e) {
		        if ( SwingUtilities.isRightMouseButton(e) ) {      
		           listImages.setSelectedIndex(listImages.locationToIndex(e.getPoint()));

		            JPopupMenu menu = new JPopupMenu();
		            JMenuItem itemRemove = new JMenuItem("Remove");
		            JMenuItem itemProperties = new JMenuItem("Properties");
		            itemRemove.addActionListener(new ActionListener() {
		                public void actionPerformed(ActionEvent e) {
		                    System.out.println("Remove the element in position " + listImages.getSelectedValue());

		                }
		            });
		            
		            itemProperties.addActionListener(new ActionListener() { 
						public void actionPerformed(ActionEvent e) {
						}
		            });
		            		
		     
		            menu.add(itemRemove);
		            menu.add(itemProperties);
		            menu.show(listImages, e.getPoint().x, e.getPoint().y);            
		        }
		    }
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(62, 318, 256, 197);
		getContentPane().add(scrollPane_1);
		listContainers = new JList<String>(listModelContainers);
		scrollPane_1.setViewportView(listContainers);
		
		this.setBounds(100, 100, 632, 526);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public JButton getButtonListImages() {
		return this.btnListImages;
	}
	
	public JButton getButtonListContainers() {
		return this.btnListContainers;
	}
	
	public void addContainerToList(String containerName) {
		this.listModelContainers.addElement(containerName);
	}


	public void addImageList(String imageName) {
		this.listModelImages.addElement(imageName);
		
	}
	
	public void freeImageList() {
		this.listModelImages.clear();
	}
	
	public void freeContainerList() {
		this.listModelContainers.clear();
	}
}
