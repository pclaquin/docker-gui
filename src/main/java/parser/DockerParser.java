package parser;

import interfaceDocker.*;
import container.*;

import java.io.StringReader;
import java.io.BufferedReader;
import java.util.*;
import java.io.*;
import com.google.gson.*;

public class DockerParser {
	private JSchConnection connection;
	
	public DockerParser(JSchConnection connection) {
		this.connection = connection;
	}
	
	public ContainerState getContainerState(String containerName) {
		return null;
	}
	
	public String[] getContainerList() {
		String containerName;
		
		/*BufferedReader containerPs = new BufferedReader(new StringReader(connection.command("docker ps --format '{{json .Names}}'")));
		try {
				containerName = containerPs.readLine();
				while (containerName!=null){
					containerList.add(containerName);
					containerName = containerPs.readLine();
				}
		    }
	catch (IOException e) {
		System.out.println("Error during String retrieval");
	}*/
		containerName = connection.command("docker ps --format '{{json .Names}}'");
		containerName = containerName.replace('"', '\n');
		containerName = containerName.replaceAll("\n\n", "\n");
		String[] tab = containerName.split("\n");
		return tab;
	}
	
	public String[] getImageList() {
		String imageName;
		imageName = connection.command("docker images --format '{{json .Repository}}' | grep -v none");
		imageName = imageName.replace('"', '\n');
		imageName = imageName.replaceAll("\n\n", "\n");
		String[] tab = imageName.split("\n");
		return tab;
	}
	
	public ContainerState getContainerStateFromName(String containerName) {
		Gson gson = new Gson();
		ContainerState state = new ContainerState();
		state = gson.fromJson(connection.command("docker inspect " + containerName).replaceAll("\n", "\r\n"), ContainerState.class);
		return state;
	}
	
	public String getJson(String containerName) {
		return connection.command("docker inspect " + containerName);
	}
	
	public void createContainer (ContainerCreator dockerCommand) {
		connection.command(dockerCommand.getcommandCreateContainer());
	}
	
	public void deleteContainer (String containerName) {
		connection.command("docker rm -f " + containerName);
		
	}
	
	/*public Gson getJsonOutputInspect (String containerName) {
		Gson gson = new Gson();
		gson.toJson(connection.command("docker inspect " + containerName));
		return gson;
		
	}*/
	
}
