/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.jezik;

import domain.GenericEntity;
import domain.Jezik;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author teodo
 */
public class SacuvajJezikSO extends AbstractGenericOperation {

    Jezik zaUnos;

    public SacuvajJezikSO() throws SQLException, Exception {
        super();
    }

    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Jezik)) {
            throw new Exception("Greska pri cuvanju podataka o jeziku!");
        }
        Jezik je = (Jezik) param;
        List<Jezik> jezici = new ArrayList<>();
        try {
            jezici = (ArrayList< Jezik>) (ArrayList<?>) repository.getAll((GenericEntity) param);
            System.out.println(jezici);
            } catch (Exception ex) {
            ex.getMessage();
        }finally{
            if(jezici.size()!=0){
            for (Jezik j : jezici) {
                if (j.getNaziv().equals(je.getNaziv())) {
                    throw new Exception("Uneti jezik vec postoji u bazi ! ");

                }
            }}
        }
            

        
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        zaUnos = (Jezik) param;
        repository.add((Jezik) param);
    }

    public Object getZaUnos() {
        return zaUnos;
    }

}
