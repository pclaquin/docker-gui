package container;

public class ContainerCreator{
	private String commandCreateContainer;
	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getContainerName() {
		return containerName;
	}

	public void setContainerName(String containerName) {
		this.containerName = containerName;
	}

	public String getArgument() {
		return argument;
	}

	public void setArgument(String argument) {
		this.argument = argument;
	}

	public Integer[] getPortsHost() {
		return portsHost;
	}

	public void setPortsHost(Integer[] portsHost) {
		this.portsHost = portsHost;
	}

	public Integer[] getPortsContainer() {
		return portsContainer;
	}

	public void setPortsContainer(Integer[] portsContainer) {
		this.portsContainer = portsContainer;
	}

	public String getCommandCreateContainer() {
		return commandCreateContainer;
	}

	private String imageName;
	private String containerName;
	private String argument;
	private Integer[] portsHost;
	private Integer[] portsContainer;
	
	

	
	public ContainerCreator(String imageName, String containerName, String argument,
			Integer[] portsHost, Integer[] portsContainer) {
		super();
		this.imageName = imageName;
		this.containerName = containerName;
		this.argument = argument;
		this.portsHost = portsHost;
		this.portsContainer = portsContainer;
		this.commandCreateContainer = "undefined";
	}
	
	private String createPortString(Integer[] portsHost, Integer[] portsContainer) {
		String ret = new String();
		for(int i = 0; portsHost[i] != null; i++) {
			ret = ret + "-p " + portsHost[i] + ":" + portsContainer[i] + " ";
		}
		return ret;
	}
	
	public String getcommandCreateContainer() {
		commandCreateContainer = "docker run -d "
                + "--name " + containerName + " "
                + createPortString(portsHost, portsContainer)
                + imageName + " "
                + argument + " ";
		return this.commandCreateContainer;
	}
}
