/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.termin;

import domain.GenericEntity;
import domain.Termin;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author teodo
 */
public class SacuvajTerminSO extends AbstractGenericOperation {

    List<Termin> zaUnos;

    public SacuvajTerminSO() throws SQLException, Exception {
        super();
    }

    @Override
    protected void preconditions(Object param) throws Exception {

        List<Termin> termini = new ArrayList<>();
        ArrayList<GenericEntity> za = (ArrayList<GenericEntity>) param;
        ArrayList<Termin> zak = (ArrayList<Termin>) (ArrayList<?>) za;
        for (Termin t : zak) {
            if (!(t instanceof Termin)) {
                throw new Exception("Greska pri cuvanju podataka o knjizi!");
            }
            try {
                termini = (ArrayList< Termin>) (ArrayList< ?>) repository.getAll(new Termin());

            } catch (Exception ex) {
                ex.getMessage();
            }
            for (Termin te : termini) {
                if (te.getDan().equals(t.getDan()) && te.getGrupa().equals(t.getGrupa()) && te.getVreme().equals(t.getVreme())) {
                    throw new Exception("Uneti termin vec postoji u bazi ! ");

                }
            }

        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        ArrayList<GenericEntity> za = (ArrayList<GenericEntity>) param;
        zaUnos = (ArrayList<Termin>) (ArrayList<?>) za;
        for (Termin t : zaUnos) {

            repository.add(t);
        }
    }

    public Object getZaUnos() {
        return zaUnos;

    }

}
