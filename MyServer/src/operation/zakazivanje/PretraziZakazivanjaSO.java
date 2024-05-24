/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.zakazivanje;

import domain.GenericEntity;
import domain.Zakazivanje;
import java.sql.SQLException;
import java.util.ArrayList;
import operation.AbstractGenericOperation;

/**
 *
 * @author teodo
 */
public class PretraziZakazivanjaSO extends AbstractGenericOperation {

    ArrayList<Zakazivanje> zakazivanja=new ArrayList<>();
    public PretraziZakazivanjaSO() throws SQLException, Exception {
        super();
    }

    
    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Zakazivanje)) {
            throw new Exception("Objekat nije instanca klase Zakazivanje");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
         ArrayList<GenericEntity> lista= (ArrayList<GenericEntity>) repository.getPoUslovu((GenericEntity) param);
        zakazivanja=(ArrayList<Zakazivanje>)(ArrayList<?>) lista;
    }

    public ArrayList<Zakazivanje> getZakazivanja() {
        return zakazivanja;
    }
    
}
