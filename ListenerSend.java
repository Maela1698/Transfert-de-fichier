package listen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

import javax.swing.JTextField;

import sock.Client;

import sock.Server;

public class ListenerSend implements ActionListener {
    String ip;
    String entete;
    int port;
    String pathclient;
    String pathserver;
    Client client;
    Server server;
    JTextField jtip;
    JTextField jtclient;
    JTextField jtserver;
    
    public void setJtip(JTextField jtip){ this.jtip = jtip; }
    public JTextField getJtip(){ return this.jtip; }
    
    public void setJtclient(JTextField jtclient){ this.jtclient = jtclient; }
    public JTextField getJtclient(){ return this.jtclient; }
    
    public void setJtserver(JTextField jtserver){ this.jtserver = jtserver; }
    public JTextField getJtserver(){ return this.jtserver; }
    
    public void setIp(String ip){ this.ip = ip; }
    public String getIp(){ return this.ip; }
    
    public void setEntete(String entete){ this.entete = entete; }
    public String getEntete(){ return this.entete; }
    
    public void setPort(int port){ this.port = port; }
    public int getPort(){ return this.port; }
    
    public void setPathclient(String pathclient){ this.pathclient = pathclient; }
    public String getPathclient(){ return this.pathclient; }
    
    public void setPathserver(String pathserver){ this.pathserver = pathserver; }
    public String getPathserver(){ return this.pathserver; }
    
    public void setClient(Client client){ this.client = client; }
    public Client getClient(){ return this.client; }
    
    public void setServer(Server server){ this.server = server; }
    public Server getServer(){ return this.server; }
    
    public ListenerSend(){ }
    
    public ListenerSend(JTextField jip, JTextField jclient, JTextField jserver, int port, String entete)throws Exception{
        this.setPort(port);
        this.setEntete(entete);
        
        this.setJtip(jip);
        this.setJtclient(jclient);
        this.setJtserver(jserver);    
    }
    
    public void actionPerformed(ActionEvent e){
        //essai
        String ip = this.getJtip().getText();
        String pathclient = this.getJtclient().getText();
        String pathserver = this.getJtserver().getText();
        
        this.setIp(ip);
        this.setPathclient(pathclient);
        this.setPathserver(pathserver);
     
        Server server = new Server();
        Client client = new Client();
        this.setClient(client);
        this.setServer(server);
        try{
            server.setPath(pathserver);
            server.setPort(this.getPort());
            client.setIp(ip);
            client.setEntete(this.getEntete());
            client.setPort(this.getPort());
            client.setPathname(pathclient);
            
            this.getServer().startServer();
            this.getClient().send();
            this.getServer().receive();
        }
        catch(Exception exep ){
            System.out.println(exep.getMessage());
        }
        finally{
            try{
                this.getClient().getSock().close();
                this.getServer().getSock().close(); 
            }
            catch(Exception j){ }
            
        }
    }


}