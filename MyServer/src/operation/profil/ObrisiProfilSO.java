/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.profil;

import domain.GenericEntity;
import java.sql.SQLException;
import operation.AbstractGenericOperation;

/**
 *
 * @author teodo
 */
public class ObrisiProfilSO extends AbstractGenericOperation{

    int number=-1;
    public ObrisiProfilSO() throws SQLException, Exception {
        super();
    }
    
    

    @Override
    protected void preconditions(Object param) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        number=repository.delete((GenericEntity) param);
    }

    public int getNumber() {
        return number;
    }
    
}
