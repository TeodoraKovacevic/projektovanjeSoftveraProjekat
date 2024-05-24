/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.grupa;

import domain.GenericEntity;
import domain.Grupa;
import java.sql.SQLException;
import operation.AbstractGenericOperation;

/**
 *
 * @author teodo
 */
public class PretraziGrupuSO extends AbstractGenericOperation{

    Grupa grupa;
    public PretraziGrupuSO() throws SQLException, Exception {
        super();
    }

    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        grupa=(Grupa) repository.getOne((GenericEntity) param);
        
    }

    public Grupa getGrupa() {
        return grupa;
    }
    
    
}
