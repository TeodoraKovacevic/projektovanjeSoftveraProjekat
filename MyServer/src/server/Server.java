/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import constant.MyServerConstants;
import dbRepository.DatabaseConnectionFactory;
import domain.Direktor;
import form.frmMainServer;
import form.models.tmDirektori;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import threads.ClientHandler;

/**
 *
 * @author teodo
 */
public class Server extends Thread {

    ServerSocket serverSocket;
    private List<ClientHandler> klijenti;
    private List<Direktor> direktori;

    public boolean signal = true;
    private frmMainServer serverskaForma;

    public Server(frmMainServer aThis) {
        klijenti = new ArrayList<>();
        direktori = new ArrayList<>();
        serverskaForma = aThis;
        try {
            int port=getPort();
            serverSocket = new ServerSocket(port);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void run() {
        while (signal) {
            
                System.out.println("Ceka se uspostavljanje konekcije...");
                while (true) {
                    try {
                        
                        Socket socket = serverSocket.accept();
                        System.out.println("Klijent se povezao.");
                        handleClient(socket);
                    } catch (Exception ex) {
                        System.out.println("Server je zaustavljen");
                    }
                }
           
        }

    }

    private void handleClient(Socket socket) {
        ClientHandler clientHandler = new ClientHandler(socket);
        clientHandler.setServer(this);
        klijenti.add(clientHandler);

        clientHandler.start();

    }

    public void stopServer() throws SQLException, IOException {
        serverSocket.close();
        serverSocket=null;
       // signal=false;

        for (ClientHandler c : klijenti) {

            c.stopHandler();
        }

        klijenti = new ArrayList<>();
        direktori = new ArrayList<>();

      
    }

    public List<Direktor> getKlijenti() {

        List<Direktor> lista = new ArrayList<>();
        for (ClientHandler ch : klijenti) {
            if (ch.getSocket() != null) {
                lista.add(ch.getD());
            }
        }
        return lista;
    }

    public List<Direktor> getDirektori() {
        return direktori;
    }

    public boolean nijeUlogovan(Direktor direktor) {

        for (ClientHandler klijent : klijenti) {
            if (direktor.equals(klijent.getD())) {
                return false;
            }
        }
//        for (Direktor d : direktori) {
//            if (d.equals(direktori)) {
//                direktori.remove(d);
//            }
//        }
        return true;
    }

    public void osvezi() {
        serverskaForma.osveziListu();
    }

    public void removeUser(ClientHandler aThis) {
        klijenti.remove(aThis);
        direktori.remove(aThis.getD());
        ((tmDirektori) serverskaForma.getTblDirektori().getModel()).obrisi(aThis.getD());

    }

    public void dodajDirektora(Direktor d) {
        direktori.add(d);
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    private int getPort() throws FileNotFoundException, IOException {
        Properties properties=new Properties();
        properties.load(new FileInputStream("config/dbconfig.properties"));
        return Integer.valueOf(properties.getProperty(MyServerConstants.PORT));
        
    }

}
