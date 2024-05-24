/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation;

import db.DBBroker;
import dbRepository.DatabaseConnectionFactory;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author teodo
 */
public abstract class AbstractGenericOperation {
 protected final DBBroker repository;
 
    public AbstractGenericOperation() throws SQLException, Exception {
        this.repository = new DBBroker(DatabaseConnectionFactory.getInstance().pop());
    }
    
     public final void execute(Object param) throws Exception {
        try {
            preconditions(param);
            startTransaction();
            executeOperation(param);
            commitTransaction();
        } catch (Exception ex) {
            System.out.println("Greska");
            rollbackTransaction();
            throw ex;
        } finally {
            DatabaseConnectionFactory.getInstance().push(repository.getConnection());
            disconnect();
        }
    }

    // Operation-specific method
    protected abstract void preconditions(Object param) throws Exception;
     private void startTransaction() throws Exception {

         repository.getConnection();
        
    }

    // Operation-specific method
    protected abstract void executeOperation(Object param) throws Exception;

    private void commitTransaction() throws Exception {
       repository.commit();
       
    }

    private void rollbackTransaction() throws Exception {
          repository.getConnection().rollback();

    }

    private void disconnect() throws Exception {
       
        repository.getConnection().close();
     
    }
}
