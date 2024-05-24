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
public class IzmeniTerminSO extends AbstractGenericOperation{

    public IzmeniTerminSO() throws SQLException, Exception {
        super();
    }

    @Override
    protected void preconditions(Object param) throws Exception {
        List<Termin> termini = new ArrayList<>();
       Termin t=(Termin)param;
        
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

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.edit((Termin)param);
    }
    
}
