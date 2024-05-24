/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.zakazivanje;

import domain.GenericEntity;
import domain.Profil;
import domain.Zakazivanje;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author teodo
 */
public class DodajZakazivanjaSO extends AbstractGenericOperation {

    List<Zakazivanje> zaUnos;
    public DodajZakazivanjaSO() throws SQLException, Exception {
        super();
    }

    @Override
    protected void preconditions(Object param) throws Exception {
        if (param == null) {
            throw new Exception("Zakazivanje ne moze biti prazno!");
        }
        ArrayList<GenericEntity> za = (ArrayList<GenericEntity>) param;
        ArrayList<Zakazivanje> zak = (ArrayList<Zakazivanje>) (ArrayList<?>) za;

        List<Zakazivanje> lista = new ArrayList<>();
        lista = (ArrayList< Zakazivanje>) (ArrayList< ?>) repository.getPoUslovu(zak.get(0));

        System.out.println("Iz baze " + lista);
        System.out.println("Iz forme " + zak);

        
        for(Zakazivanje x:lista){
       for(Zakazivanje y:zak){
           System.out.println(x.getDatumOtkazivanja());
       if(x.getProfil().equals(y.getProfil()) &&  x.getTermin().getDan().equals(y.getTermin().getDan()) && x.getTermin().getVreme().equals(y.getTermin().getVreme())){
           throw new Exception("Postoje u bazi");
       
       }
       }
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        ArrayList<GenericEntity> za = (ArrayList<GenericEntity>) param;
        ArrayList<Zakazivanje> zak = (ArrayList<Zakazivanje>) (ArrayList<?>) za;
        zaUnos=zak;
        for (Zakazivanje z : zak) {
            repository.add((Zakazivanje) z);
        }

    }

    public List<Zakazivanje> getZaUnos() {
        return zaUnos;
    }
    

}
