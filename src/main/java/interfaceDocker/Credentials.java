package interfaceDocker;
import java.util.Scanner;

public class Credentials {
	
	public String user;
	public String host;
	public String password;
	
	public Credentials(String user, String host, String password) {
		super();
		this.user = user;
		this.host = host;
		this.password = password;
	}

	public Credentials() {
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Hote \n");
		this.host = reader.next();
		System.out.println("Nom d'utilisateur \n");
        this.user = reader.next();
		System.out.println("Mot de passe \n");
		this.password = reader.next();
		System.out.println(this.host + this.user + this.password);
		reader.close();
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
