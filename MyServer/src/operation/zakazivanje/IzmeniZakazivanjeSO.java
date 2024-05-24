/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.zakazivanje;

import domain.Zakazivanje;
import java.sql.SQLException;
import operation.AbstractGenericOperation;

/**
 *
 * @author teodo
 */
public class IzmeniZakazivanjeSO extends AbstractGenericOperation {

    public IzmeniZakazivanjeSO() throws SQLException, Exception {
        super();
    }

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.edit((Zakazivanje)param);
    }
    
}
