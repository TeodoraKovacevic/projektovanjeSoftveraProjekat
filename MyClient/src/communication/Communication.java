/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communication;

import domain.Direktor;
import domain.Grupa;
import domain.Profil;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import constant.MyServerConstants;
import domain.Jezik;
import domain.Termin;
import domain.Zakazivanje;
import exception.ClassException;
import java.io.FileInputStream;
import java.util.Properties;
import thread.nit;

/**
 *
 * @author teodo
 */
public class Communication {

    private static Communication instance;
    Socket socket;
    Sender sender;
    Receiver receiver;

    private Communication() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("config/dbconfig.properties"));

        int port = Integer.valueOf(properties.getProperty(MyServerConstants.DB_PORT));
        socket = new Socket("127.0.0.1", port);
        sender = new Sender(socket);
        receiver = new Receiver(socket);

    }

    public static Communication getInstance() throws Exception {
        if (instance == null) {
            instance = new Communication();
        }
        return instance;
    }

    public Direktor login(String korisnicko, String lozinka) throws Exception {
        Direktor d = new Direktor();
        d.setKorisnickoIme(korisnicko);
        d.setLozinka(lozinka);
        Request request = new Request(Operation.LOGOVANJE, d);
        sender.send(request);

        Response response = (Response) receiver.receive();
        if (response.getStatus() == StatusOdgovora.OK) {
            if (socket != null) {
                nit n = new nit(socket);

                n.start();
            }
            return (Direktor) response.getOdgovor();

        } else {
            throw response.getException();
        }

    }

    public List<Grupa> vratiGrupe() throws Exception {
        List<Grupa> grupe = new ArrayList<>();
        Request request = new Request(Operation.VRATI_GRUPE, grupe);
        sender.send(request);
        Response response = (Response) receiver.receive();
        return (List<Grupa>) response.getOdgovor();
    }

    public Object sacuvajProfil(Profil p) throws ClassException, Exception {
        Request request = new Request(Operation.SACUVAJ_PROFIL, p);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return response;
        } else {
            throw response.getException();
        }
    }

    public List<Profil> vratiProfilePoUslovu(Profil p) throws Exception {
        Request request = new Request(Operation.PRETRAZI_PROFIL, p);
        sender.send(request);
        Response response = (Response) receiver.receive();
        System.out.println(response.getOdgovor());
        return  (List<Profil>) response.getOdgovor();
       
    }

    public int obrisiClana(Profil p) throws Exception {
        Request request = new Request(Operation.OBRISI_PROFIL, p);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (int) response.getOdgovor();
        } else {
            throw response.getException();
        }
    }

    public void izmeniProfil(Profil p) throws Exception {
        Request request = new Request(Operation.IZMENI_PROFIL, p);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (!response.getOdgovor().equals(StatusOdgovora.OK.toString()) || response.getException() != null) {
            throw response.getException();
        }
    }

    public Object kreirajJezik(Jezik j) throws Exception {
        Request request = new Request(Operation.SACUVAJ_JEZIK, j);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return response;
        } else {
            return response.getException();
        }
    }

    public Object sacuvajTermin(List<Termin> t) throws Exception {
        Request request = new Request(Operation.SACUVAJ_TERMIN, t);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return response;
        } else {
            throw response.getException();
        }
    }

    public List<Termin> vratiTerminePoUslovu(Termin termin) throws Exception {
        Request request = new Request(Operation.PRETRAZI_TERMIN, termin);
        sender.send(request);
        Response response = (Response) receiver.receive();
        List<Termin> termini = (List<Termin>) response.getOdgovor();
        System.out.println(termini + "Communication");
        return termini;
    }

    public Grupa vratiGrupuPoUslovu(Grupa grupa) throws Exception {
        Request request = new Request(Operation.VRATI_GRUPU, grupa);
        sender.send(request);
        Response response = (Response) receiver.receive();
        Grupa g = (Grupa) response.getOdgovor();
        System.out.println(g + "Communication");
        return g;
    }

    public Jezik vratiJezikPoUslovu(Jezik jezik) throws Exception {
        Request request = new Request(Operation.VRATI_JEZIK, jezik);
        sender.send(request);
        Response response = (Response) receiver.receive();
        Jezik g = (Jezik) response.getOdgovor();
        System.out.println(g + "Communication");
        return g;
    }

    public void izmeniTermin(Termin te) throws Exception {
        Request request = new Request(Operation.IZMENI_TERMIN, te);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (!response.getOdgovor().equals(StatusOdgovora.OK.toString()) || response.getException() != null) {
            throw response.getException();
        }
    }

    public List<Zakazivanje> vratiZakazivanjaPoUslovu(Zakazivanje z) throws Exception {
        Request request = new Request(Operation.PRETRAZI_ZAKAZIVANJA, z);
        sender.send(request);
        Response response = (Response) receiver.receive();
        List<Zakazivanje> zakazivanja = (List<Zakazivanje>) response.getOdgovor();
        System.out.println(zakazivanja + "Communication");
        return zakazivanja;
    }

    public Object dodajZakazivanje(List<Zakazivanje> nova) throws Exception {
        Request request = new Request(Operation.DODAJ_ZAKAZIVANJA, nova);
        sender.send(request);
        Response response = (Response) receiver.receive();
//        if (response.getException() != null) {
//            throw new Exception(response.getException().getMessage());
//        }
        if (response.getException() == null) {
            return response;
        } else {
            return response.getException();
        }
    }

    public void updateZakazivanje(Zakazivanje za) throws Exception {
        Request request = new Request(Operation.IZMENI_ZAKAZIVANJE, za);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (!response.getOdgovor().equals(StatusOdgovora.OK.toString()) || response.getException() != null) {
            throw response.getException();
        }
    }

    public List<Profil> vratiProfile() throws Exception {
        List<Profil> profili = new ArrayList<>();
        Request request = new Request(Operation.VRATI_PROFILE,null);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if(response.getStatus()==StatusOdgovora.OK){
        return (List<Profil>) response.getOdgovor();}
        else{
        throw response.getException();
        }
    
    }

    public void logout(Direktor ulogovani) throws Exception {
        Request request = new Request(Operation.IZLOGUJ, ulogovani);
        System.out.println(ulogovani);
        sender.send(request);
//        Response response = (Response) receiver.receive();
        // return (Direktor) response.getOdgovor();
    }

    public List<Termin> vratiTermine() throws Exception {
        List<Termin> termini = new ArrayList<>();
        Request request = new Request(Operation.VRATI_TERMINE, termini);
        sender.send(request);
        Response response = (Response) receiver.receive();
        return (List<Termin>) response.getOdgovor();
    }
}
