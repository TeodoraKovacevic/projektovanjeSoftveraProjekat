/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.jezik;

import domain.GenericEntity;
import domain.Jezik;
import java.sql.SQLException;
import operation.AbstractGenericOperation;

/**
 *
 * @author teodo
 */
public class PretraziJezikSO extends AbstractGenericOperation  {

    Jezik j;
    public PretraziJezikSO() throws SQLException, Exception {
        super();
    }

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        j=(Jezik) repository.getOne((GenericEntity) param);
    }

    public Jezik getJ() {
        return j;
    }
    
}
