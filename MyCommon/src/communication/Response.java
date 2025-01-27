/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communication;

import java.io.Serializable;
import java.util.logging.Logger;

/**
 *
 * @author Jelena
 */
public class Response implements Serializable{
    private Object odgovor;
    private Exception exception;
    private StatusOdgovora status;
    
    public Response() {
    }
    public Response(Object odgovor, Exception exception, StatusOdgovora status) {
        this.odgovor = odgovor;
        this.exception = exception;
        this.status = status;
    }

    public Object getOdgovor() {
        return odgovor;
    }

    public void setOdgovor(Object odgovor) {
        this.odgovor = odgovor;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public void setStatus(StatusOdgovora status) {
        this.status = status;
    }

    public StatusOdgovora getStatus() {
        return status;
    }

   

   
    
}
