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
public class SacuvajProfilSO extends AbstractGenericOperation {

    Profil zaUnos;

    public SacuvajProfilSO() throws SQLException, Exception {
        super();
    }

    @Override
    protected void preconditions(Object param) throws Exception {
        if (param == null || !(param instanceof Profil)) {
            throw new Exception("Greska pri cuvanju podataka o profilu!");
        }

        Profil profil = (Profil) param;
        List<Profil> profili = new ArrayList<>();
        try {
            profili = (ArrayList< Profil>) (ArrayList<?>) repository.getAll(new Profil());
            System.out.println(profili);
        } catch (Exception ex) {
            ex.getMessage();
        } finally {

            if (profili.size() != 0) {
                for (Profil p : profili) {
                    if (p.getJMBG().equals(profil.getJMBG())) {
                        throw new Exception("Profil sa ovim jmbgom vec postoji!");
                    }
                }
            }
        }

    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        zaUnos = (Profil) param;
        repository.add((Profil) param);

    }

    public Profil getZaUnos() {
        return zaUnos;
    }

}
