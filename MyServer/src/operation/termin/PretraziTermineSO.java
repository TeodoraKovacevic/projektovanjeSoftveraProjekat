/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.termin;

import domain.GenericEntity;
import domain.Termin;
import java.sql.SQLException;
import java.util.ArrayList;
import operation.AbstractGenericOperation;

/**
 *
 * @author teodo
 */
public class PretraziTermineSO extends AbstractGenericOperation{

    ArrayList<Termin> termini;
    public PretraziTermineSO() throws SQLException, Exception {
        super();
    }

    
    @Override
    protected void preconditions(Object param) throws Exception {
         if (!(param instanceof Termin)) {
            throw new Exception("Objekat nije instanca klase Termin");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
         ArrayList<GenericEntity> lista= (ArrayList<GenericEntity>) repository.getPoUslovu((GenericEntity) param);
        termini=(ArrayList<Termin>)(ArrayList<?>) lista;
        
    }

    public ArrayList<Termin> getTermini() {
        return termini;
    }
    
}
