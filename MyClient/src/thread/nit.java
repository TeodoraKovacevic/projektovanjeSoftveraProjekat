/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread;

import java.net.Socket;

/**
 *
 * @author teodo
 */
public class nit extends Thread {

    Socket s;

    public nit(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
//        while (true) {
//            System.out.println("aktivan");
//            
//            System.out.println("Bound" +s.isBound());
//            System.out.println("Connect"+s.isConnected());
//            System.out.println("Close"+s.isClosed());
//            
//        }
    }

}
