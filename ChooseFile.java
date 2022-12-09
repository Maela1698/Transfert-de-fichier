package affichage;

import javax.swing.JFrame; 
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Dimension;

import listen.*;

public class ChooseFile extends JFrame {
    
    public ChooseFile() throws Exception{ 
    //JPanel caracteristics 
        JPanel jp = new JPanel();
        jp.setFocusable(true);
        int width = 500;
        int height = 250;
        Dimension dimension = new Dimension(width, height);
        jp.setPreferredSize(dimension);            
        jp.setLayout(null);
        
    //Boutton envoyer fichier
        JButton jb = new JButton("Send");
        jb.setBounds(210, 200, 100, 30);
        jp.add(jb);
    
    //JLabel pour IP
        JLabel jlab = new JLabel("IP :");
        jlab.setBounds(120, 20, 80, 30);
        jp.add(jlab);
        
    //JTextField pour ip
        JTextField jtext = new JTextField();
        jtext.setBounds(175, 20, 170, 30);
        jp.add(jtext);
        
    //JFileChooser: path pour choisir l'input fichier client
    
    
    //JFileChooser: path pour choisir l'output fichier serveur
        
        
    //JTextfield : pour afficher le path(String) du fichier a envoyer
        JTextField jtclient = new JTextField();
        jtclient.setBounds(130, 150, 120, 30);
        jp.add(jtclient);
    
    //JTextField : pour afficher le path(String) du fichier recu depuis le client 
        JTextField jtserveur = new JTextField();
        jtserveur.setBounds(260, 150, 120, 30);
        jp.add(jtserveur);
        
    //Listener Caracteristics
        int port = 1966;
        String entete = "Server";
        ListenerSend ecouteur = new ListenerSend(jtext, jtclient, jtserveur ,port,entete);
        jb.addActionListener(ecouteur);
        
        
     //Frame caracteristics
        this.add(jp);
        this.setVisible(true);
        this.setTitle("choose/send file");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();   
    }
}
