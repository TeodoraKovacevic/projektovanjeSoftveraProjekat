/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.Sender;
import communication.StatusOdgovora;
import controller.Controller;
import domain.Direktor;
import domain.GenericEntity;
import domain.Grupa;
import domain.Jezik;
import domain.Profil;
import domain.Termin;
import domain.Zakazivanje;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

import server.Server;

/**
 *
 * @author Jelena
 */
public class ClientHandler extends Thread {

    Socket socket;
    Sender sender;
    Receiver receiver;
    boolean kraj = false;
    private Direktor d;
    Server server;

    public ClientHandler(Socket socket) {
        this.socket = socket;
        sender = new Sender(socket);
        receiver = new Receiver(socket);
    }

    @Override
    public void run() {
        try {
        while (!kraj) {
            
                Request request = (Request) receiver.receive();
                Response response = new Response(null,null,StatusOdgovora.OK);
                try {
                    switch (request.getOperacija()) {
                        case LOGOVANJE:
                            Direktor direktor = (Direktor) request.getArgument();

                            boolean aktivan = server.nijeUlogovan(direktor);

                            System.out.println(aktivan);
                            if (!aktivan) {

                                response.setOdgovor(null);
                                response.setStatus(StatusOdgovora.GRESKA);
                                response.setException(new Exception("Korisnik je već ulogovan."));

                            } else {

                                d = (Direktor) Controller.getInstance().login(direktor);
                                server.dodajDirektora(d);
                                response.setOdgovor(d);
                                response.setStatus(StatusOdgovora.OK);
                                Controller.getInstance().getAktivniKorisnici().add(this);
                                server.osvezi();
                            }

                            break;
                        case VRATI_GRUPE:
                            response.setOdgovor(Controller.getInstance().vratiGrupe());
                            server.osvezi();

                            break;

                        case SACUVAJ_PROFIL:
                            Profil c = (Profil) request.getArgument();
                            Object odgovor = Controller.getInstance().sacuvajProfil(c);
                            System.out.println("Dosao je profil");
                            response=new Response(odgovor, null, null);
//                            if (!(odgovor instanceof Profil)) {
//                                response.setException((Exception) odgovor);
//                            } else {
//                                response.setOdgovor(odgovor);
//                            }
                            break;

                        case PRETRAZI_PROFIL:

                            Profil p = (Profil) request.getArgument();
                            List<Profil> profili = (List<Profil>) Controller.getInstance().vratiProfilePoUslovu(p);
                            System.out.println("Client"+profili);
                            response.setOdgovor(profili);
                            break;
                        case OBRISI_PROFIL:
                            Profil p1 = (Profil) request.getArgument();
                            response.setOdgovor(Controller.getInstance().obrisiProfil(p1));
                            break;
                        case IZMENI_PROFIL:
                            response.setOdgovor(Controller.getInstance().izmeniProfil((Profil) request.getArgument()));
                            
                            break;
                        case SACUVAJ_JEZIK:
                            Jezik j = (Jezik) request.getArgument();
                            
//                            try{
                             Object od= Controller.getInstance().sacuvajJezik(j);
                             System.out.println("Dosao je jezik");
                            response=new Response(od, null, null);
                            
                            
//                            if (!(od instanceof Jezik)) {
//                                response.setException((Exception) od);
//                            } else {
//                                response.setOdgovor(od);
//
//                              
//                            }
//                            }catch(Exception e){
//                                response=new Response(null, e, StatusOdgovora.GRESKA);
//                            }
                            break;
                        case SACUVAJ_TERMIN:

                            List<Termin> op = (List<Termin>) Controller.getInstance().sacuvajTermin((List<Termin>) request.getArgument());
                            System.out.println("Dosao je jezik");
                            for (Termin o : op) {
                                if (!(o instanceof Termin)) {
                                    response.setException((Exception) op);
                                } else {
                                    response.setOdgovor(o);

                                    break;
                                }
                            }

                            break;
                        case VRATI_GRUPU:
                            Grupa g = (Grupa) request.getArgument();
                            g = Controller.getInstance().vratiGrupuPoUslovu(g);
                            System.out.println("ClientHendler" + g);
                            response.setOdgovor(g);
                            break;

                        case PRETRAZI_TERMIN:
                            Termin te = (Termin) request.getArgument();
                            List<Termin> termini = Controller.getInstance().vratiTerminePoUslovu(te);
                            System.out.println(termini);
                            response.setOdgovor(termini);
                            break;
                        case VRATI_JEZIK:
                            Jezik je = (Jezik) request.getArgument();
                            je = Controller.getInstance().vratiJezikPoUslovu(je);
                            System.out.println(je);
                            response.setOdgovor(je);
                            break;

                        case IZMENI_TERMIN:
                            response.setOdgovor(Controller.getInstance().izmeniTermin((Termin) request.getArgument()));
                            break;

                        case PRETRAZI_ZAKAZIVANJA:
                            Zakazivanje za = (Zakazivanje) request.getArgument();
                            List<Zakazivanje> zakazivanja = Controller.getInstance().vratiZakazivanjaPoUslovu(za);
                            System.out.println(zakazivanja);
                            response.setOdgovor(zakazivanja);
                            break;
                        case DODAJ_ZAKAZIVANJA:
                            
                            List<Zakazivanje> lista= (List<Zakazivanje>) Controller.getInstance().dodajZakazivanje((List<Zakazivanje>) request.getArgument());
                            //System.out.println(zakazivanje+"Zakazivanja");
                            
                            for (Zakazivanje z : lista) {
                                if (!(z instanceof Zakazivanje)) {
                                    response.setException((Exception) lista);
                                } else {
                                    response.setOdgovor(lista);

                                    break;
                                }
                            }
                            break;

                        case IZMENI_ZAKAZIVANJE:
                            response.setOdgovor(Controller.getInstance().izmeniZakazivanje((Zakazivanje) request.getArgument()));
                            sender.send(response);
                            break;

                        case VRATI_PROFILE:
                            List<Profil> pro=(List<Profil>) Controller.getInstance().vratiProfile();
                            response.setOdgovor(pro);

                            System.out.println("Profili u client hendler " + pro);
                            break;
                        case IZLOGUJ:
                            System.out.println("usao u kejs izloguj");
                            server.removeUser(this);

                            response = new Response("Uspesno ste se odjavili", null, StatusOdgovora.OK);
                            kraj = true;

                            break;
                        case VRATI_TERMINE:
                            response.setOdgovor(Controller.getInstance().vratiTermine());
                            server.osvezi();
                            break;
                    }

                } catch (Exception ex) {
                    //System.out.println("Soket je zatvoren");
                    //ex.printStackTrace();ć
                   response.setStatus(StatusOdgovora.GRESKA);
                    response.setException(ex);
                }
                                    sender.send(response);

        }
            } catch (Exception ex) {
               // System.out.println("SOket je zatvoren");
               // Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
            

        }
    }

    public void stopHandler() throws IOException {
        if (this.socket != null) {
            if (!this.socket.isClosed()) {
                this.socket.close();
                kraj = true;
                this.socket = null;
            }
        }

    }

    public Socket getSocket() {
        return socket;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public Direktor getD() {
        return d;
    }

    public void setD(Direktor d) {
        this.d = d;
    }

}
