/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.profil;

import domain.GenericEntity;
import domain.Profil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author teodo
 */
public class UcitajListuProfilaSO extends AbstractGenericOperation {

    List<Profil> profili;
    public UcitajListuProfilaSO() throws SQLException, Exception {
        super();
    }

    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        ArrayList<GenericEntity> prof=(ArrayList<GenericEntity>) repository.getAll((GenericEntity) param);
       profili=(ArrayList < Profil >) (ArrayList < ? >)prof;
    }

    public List<Profil> getProfili() {
        return profili;
    }
    
    
}
