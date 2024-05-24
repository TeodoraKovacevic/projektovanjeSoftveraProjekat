/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.grupa;

import domain.GenericEntity;
import domain.Grupa;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author teodo
 */
public class UcitajListuGrupaSO extends AbstractGenericOperation{

    private List<Grupa> grupe;

    public UcitajListuGrupaSO() throws SQLException, Exception {
        super();
    }

    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        //grupe=dbb.vratiGrupe();
        ArrayList<GenericEntity> grup=(ArrayList<GenericEntity>) repository.getAll((GenericEntity) param);
       grupe=(ArrayList < Grupa >) (ArrayList < ? >)grup;
    }

    public List<Grupa> getGrupe() {
        return grupe;
    }
    
}
