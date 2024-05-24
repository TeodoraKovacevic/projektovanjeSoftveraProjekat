/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import communication.Response;
import communication.StatusOdgovora;
import db.DBBroker;
import domain.Direktor;
import domain.Grupa;
import domain.Jezik;
import domain.Profil;
import domain.Termin;
import domain.Zakazivanje;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import operation.direktor.PrijavaSO;
import operation.grupa.PretraziGrupuSO;
import operation.grupa.UcitajListuGrupaSO;
import operation.jezik.PretraziJezikSO;
import operation.jezik.SacuvajJezikSO;
import operation.profil.IzmeniProfilSO;
import operation.profil.ObrisiProfilSO;
import operation.profil.PretraziProfilSO;
import operation.profil.SacuvajProfilSO;
import operation.profil.UcitajListuProfilaSO;
import operation.termin.IzmeniTerminSO;
import operation.termin.PretraziTermineSO;
import operation.termin.SacuvajTerminSO;
import operation.termin.UcitajListuTerminaSO;
import operation.zakazivanje.DodajZakazivanjaSO;
import operation.zakazivanje.IzmeniZakazivanjeSO;
import operation.zakazivanje.PretraziZakazivanjaSO;
import threads.ClientHandler;

/**
 *
 * @author teodo
 */
public class Controller {
    //  private final Repository repositoryGeneric;

    private static Controller controller;
    private ArrayList<ClientHandler> aktivniKorisnici;
    ArrayList<Direktor> aktivniDirektori;
    
    public Controller() {
//       repositoryGeneric = new RepositoryDbGeneric();
        aktivniKorisnici = new ArrayList<>();
        aktivniDirektori = new ArrayList<>();
    }
    
    public static Controller getInstance() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }
    
    public Object login(Object obj) throws Exception {
        PrijavaSO login = new PrijavaSO();
        System.out.println(obj.toString());
        login.execute(obj);
        System.out.println(obj.toString());
        //   System.out.println(login.getBibliotekar().toString());
        aktivniDirektori.add(login.getD());
        return login.getD();
    }
    
    public boolean vecJeUlogovan(Direktor d) {
        for (ClientHandler klijent : aktivniKorisnici) {
            if (klijent.getD().equals(d)) {
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<ClientHandler> getAktivniKorisnici() {
        return aktivniKorisnici;
    }
    
    public List<Grupa> vratiGrupe() throws Exception {
        UcitajListuGrupaSO ula = new UcitajListuGrupaSO();
        ula.execute(new Grupa());
        return ula.getGrupe();
    }
    
    public Object sacuvajProfil(Profil p) throws Exception {
        SacuvajProfilSO sp = new SacuvajProfilSO();
        
        
            sp.execute(p);
            return sp.getZaUnos();
       
    }
    
    public List<Profil> vratiProfilePoUslovu(Profil profil) throws Exception {
        PretraziProfilSO pp = new PretraziProfilSO();
        pp.execute(profil);
        
        return pp.getProfili();
        
    }
    
    public Object obrisiProfil(Profil p1) throws Exception {
        ObrisiProfilSO op = new ObrisiProfilSO();
        op.execute(p1);
        return op.getNumber();
    }
    
    public Object izmeniProfil(Profil profil) throws Exception {
        IzmeniProfilSO ip = new IzmeniProfilSO();
        ip.execute(profil);
        return StatusOdgovora.OK.toString();
    }
    
    public Object sacuvajJezik(Jezik j) throws Exception {
        SacuvajJezikSO sj = new SacuvajJezikSO();
        
            sj.execute(j);
            return sj.getZaUnos();
       
    }
    
    public Object sacuvajTermin(List<Termin> t) throws Exception {
        SacuvajTerminSO st = new SacuvajTerminSO();
        try {
            st.execute(t);
            return st.getZaUnos();
        } catch (Exception ex) {
            System.out.println("Neuspseno");
//ex.printStackTrace();
            return ex;
        }
    }
    
    public Grupa vratiGrupuPoUslovu(Grupa g) throws Exception {
        PretraziGrupuSO pg = new PretraziGrupuSO();
        pg.execute(g);
        return pg.getGrupa();
    }
    
    public List<Termin> vratiTerminePoUslovu(Termin te) throws Exception {
        PretraziTermineSO pt = new PretraziTermineSO();
        pt.execute(te);
        return pt.getTermini();
    }
    
    public Jezik vratiJezikPoUslovu(Jezik je) throws Exception {
        PretraziJezikSO pj = new PretraziJezikSO();
        pj.execute(je);
        return pj.getJ();
    }
    
    public Object izmeniTermin(Termin termin) throws Exception {
        IzmeniTerminSO it = new IzmeniTerminSO();
        it.execute(termin);
        return StatusOdgovora.OK.toString();
        
    }
    
    public List<Zakazivanje> vratiZakazivanjaPoUslovu(Zakazivanje za) throws Exception {
        PretraziZakazivanjaSO pz = new PretraziZakazivanjaSO();
        pz.execute(za);
        return pz.getZakazivanja();
    }
    
    public Object dodajZakazivanje(List<Zakazivanje> zakazivanje) throws Exception {
        DodajZakazivanjaSO dz = new DodajZakazivanjaSO();
        try {
        
            dz.execute(zakazivanje);
            
            return dz.getZaUnos();
        } catch (Exception ex) {
            System.out.println("Greska prilikom cuvanja zakazivanja");
            return ex;
        }
    }
    
    public Object izmeniZakazivanje(Zakazivanje zakazivanje) throws Exception {
        IzmeniZakazivanjeSO iz = new IzmeniZakazivanjeSO();
        iz.execute(zakazivanje);
        
        return StatusOdgovora.OK.toString();
    }
    
    public List<Profil> vratiProfile() throws Exception {
        UcitajListuProfilaSO ulp = new UcitajListuProfilaSO();
        ulp.execute(new Profil());
        return ulp.getProfili();
    }
    
    public void logout(Direktor d) throws IOException {
        for (ClientHandler c : aktivniKorisnici) {
            if (d.equals(c.getD())) {
                System.out.println("jednaki su");
                c.getSocket().close();
                aktivniKorisnici.remove(c);
                System.out.println("izlogovan je");
            }
        }
        for (Direktor direktor : aktivniDirektori) {
            
            if (d.equals(direktor)) {
                aktivniDirektori.remove(d);
            }
        }
        
    }

    public Object vratiTermine() throws Exception {
        UcitajListuTerminaSO ula = new UcitajListuTerminaSO();
        ula.execute(new Termin());
        return ula.getListaTermina();
    }
    
}
