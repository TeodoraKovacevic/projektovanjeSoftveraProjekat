/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbRepository;

import constant.MyServerConstants;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author student2
 */
public class DatabaseConnectionFactory {

    private List<Connection> connectionPool;

    private static DatabaseConnectionFactory instance;

    private DatabaseConnectionFactory() throws SQLException, IOException {
        connectionPool = new ArrayList<>();
        for (int i = 0; i < 100; i++) {

            try {
                Properties properties = new Properties();
                properties.load(new FileInputStream("config/dbconfig.properties"));
                String url = properties.getProperty(MyServerConstants.DB_URL);
                String user = properties.getProperty(MyServerConstants.DB_USER);
                String password = properties.getProperty(MyServerConstants.DB_PASSWORD);
                Connection connection = DriverManager.getConnection(url, user, password);
                System.out.println("Konekcija sa bazom podataka uspesno uspostavljena!");
                connection.setAutoCommit(false);

                connectionPool.add(connection);
            } catch (SQLException ex) {
                System.out.println("Greska! Konekcija sa bazom nije uspesno uspostavljena!\n" + ex.getMessage());
                ex.printStackTrace();
                throw ex;
            }
        }
    }

    public static DatabaseConnectionFactory getInstance() throws SQLException, IOException {
        if (instance == null) {
            instance = new DatabaseConnectionFactory();
        }
        return instance;
    }

    public synchronized void push(Connection connection) {
        connectionPool.add(connection);
    }

    public synchronized Connection pop() throws Exception {

        if (connectionPool.isEmpty()) {
            throw new Exception("Nema slobodne konekcije");
        }
        Connection connection = connectionPool.get(0);
        connectionPool.remove(0);
        return connection;
    }

}
