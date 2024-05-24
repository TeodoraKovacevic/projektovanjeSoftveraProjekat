/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.profil;

import domain.Profil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author teodo
 */
public class IzmeniProfilSO extends AbstractGenericOperation{

    public IzmeniProfilSO() throws SQLException, Exception {
        super();
    }
 
    @Override
    protected void preconditions(Object param) throws Exception {
        if (param == null || !(param instanceof Profil)) {
            throw new Exception("Greska pri cuvanju podataka o profilu!");
        }
       
        
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.edit((Profil)param);
    }

   
    
}
