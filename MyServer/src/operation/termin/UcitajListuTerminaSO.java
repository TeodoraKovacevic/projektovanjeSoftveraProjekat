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
public class UcitajListuTerminaSO extends AbstractGenericOperation  {

    List<Termin> listaTermina;
    public UcitajListuTerminaSO() throws SQLException, Exception {
        super();
    }

    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
         ArrayList<GenericEntity> prof=(ArrayList<GenericEntity>) repository.getAll((GenericEntity) param);
       listaTermina=(ArrayList < Termin >) (ArrayList < ? >)prof;
    }

    public List<Termin> getListaTermina() {
        return listaTermina;
    }
    
}
