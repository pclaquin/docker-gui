package interfaceDocker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
 
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
 
 
public class JSchConnection {
	private Session session;
	private Properties config;
	private Channel channel;
	
	public void connect(Credentials creds) {
		try{            
            JSch jsch = new JSch();
            session = jsch.getSession(creds.user, creds.host, 22);
            config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.setPassword(creds.password);
            session.connect();
            
		}catch(Exception ex){
			System.out.println(ex);
        }
	}
	
	public void disconnect() {
        session.disconnect();
	}
	
    public String command(String command){
    	  String retString = new String();
        try{            
            channel = session.openChannel("exec");
            ((ChannelExec)channel).setCommand(command);
            channel.setInputStream(null);
            ((ChannelExec)channel).setErrStream(System.err);
             
            InputStream input = channel.getInputStream();
            channel.connect();
             
            try{
                InputStreamReader inputReader = new InputStreamReader(input);
                BufferedReader bufferedReader = new BufferedReader(inputReader);
                String line = null;
                 
                while((line = bufferedReader.readLine()) != null){
                    retString += line;
                }
                bufferedReader.close();
                inputReader.close();
        		channel.disconnect();
                return retString;
            }catch(IOException ex){
                ex.printStackTrace();
                return null;
            }
             
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
    
	public boolean test() {
		if(session.isConnected()) return true;
		else return false;
	}
    
}