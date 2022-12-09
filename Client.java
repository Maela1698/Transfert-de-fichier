package sock;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import sock.Transfert;

/**
 *
 * @author othmane
 */
public class Client{
	Socket sock;
	String ip;
	int port;
	String entete;
	String pathname;

	
	public void setSock(Socket sock)throws Exception{ this.sock = sock; }
	
	public Socket getSock(){ return this.sock; }
	
	public void setIp(String ip){ this.ip = ip; }
	public String getIp(){ return this.ip; }
	
	public void setPort(int port){ this.port = port; }
	public int getPort(){ return this.port; } 
	
	public void setEntete(String entete){ this.entete = entete; }
	public String getEntete(){ return this.entete; }
	
	public void setPathname(String pathname){ this.pathname = pathname; }
	public String getPathname(){ return this.pathname; }
	
	public Client(){}
	
	public Client(String ip, int port, String entete, String pathname)throws Exception{
		this.setIp(ip);
		this.setPort(port);
		this.setEntete(entete);
		this.setPathname(pathname);
	}
	
	public void send()throws Exception{
	// Ouverture de la communication
		Socket sock = new Socket(this.getIp(), this.getPort());
		this.setSock(sock);
		ObjectOutputStream out = new ObjectOutputStream(sock.getOutputStream());
	//Envoi de l'en-tete
		out.writeInt(1);
		out.writeUTF(this.getEntete());
	//Envoi du fichier
		Transfert.transfert(new FileInputStream(new File(this.getPathname())), out, true);
	}
}
	




