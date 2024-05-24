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
public class PretraziProfilSO extends AbstractGenericOperation {

    ArrayList<Profil> profili;
    public PretraziProfilSO() throws SQLException, Exception {
        super();
    }

    
    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Profil)) {
            throw new Exception("Objekat nije instanca klase Klijent");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        ArrayList<GenericEntity> lista= (ArrayList<GenericEntity>) repository.getPoUslovu((GenericEntity) param);
        profili=(ArrayList<Profil>)(ArrayList<?>) lista;
    }

    public List<Profil> getProfili() {
        return profili;
    }
    
}
