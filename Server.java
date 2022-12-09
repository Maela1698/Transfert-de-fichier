package sock;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import sock.Transfert;

import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author othmane
 */
public class Server{
	ServerSocket serversock;
	Socket sock;
	int port;
	String path;
	
	public void setServersock()throws Exception{ 
		ServerSocket serversock = new ServerSocket(this.getPort());
		this.serversock = serversock;
	}
	
	public ServerSocket getServersock(){ return this.serversock; }
	
	public void setSock(Socket sock){ this.sock = sock; }
	public Socket getSock(){ return this.sock; }
	
	public void setPort(int port){ this.port = port; }
	public int getPort(){ return this.port; }
	
	public void setPath(String path){ this.path = path; }
	public String getPath(){ return this.path; }
	
	public Server(){}
	
	public Server(int port, String path)throws Exception{
		this.setPort(port);
		this.setPath(path);
	}
	
	public void startServer()throws Exception{
	// Ouverture d'une communication
		this.setServersock();
	}
	
	public void receive()throws Exception{
		System.out.println("tsisy olana");
		Socket sock = this.getServersock().accept();
		this.setSock(sock);
		ObjectInputStream in = new ObjectInputStream(this.getSock().getInputStream());
	
	// Reception de l'en-tete
		int n = in.readInt();
		String[] tab = new String[n];
		for (int i=0; i<n; i++)
			tab[i]=in.readUTF();
	
	// Reception du fichier
		Transfert.transfert(
			in,new FileOutputStream(new File(this.getPath())),true);
		
	}
}



