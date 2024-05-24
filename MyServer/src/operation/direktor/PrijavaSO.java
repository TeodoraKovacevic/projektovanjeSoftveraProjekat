/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.direktor;

import dbRepository.DatabaseConnectionFactory;
import domain.Direktor;
import java.sql.SQLException;
import operation.AbstractGenericOperation;

/**
 *
 * @author teodo
 */
public class PrijavaSO extends AbstractGenericOperation {

    Direktor d;

    public PrijavaSO() throws SQLException, Exception {
        super();
    }

    

    
    @Override
    protected void preconditions(Object param) throws Exception {
         if(!(param instanceof Direktor)){
           throw new Exception("Greška,direktor ne postoji u bazi.");
        }else{
            System.out.println("Nadjen direktor.");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
      d=(Direktor) repository.getOne((Direktor)param);
    }

    public Direktor getD() {
        return d;
    }
    
    
}
