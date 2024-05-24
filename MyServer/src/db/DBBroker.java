/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import dbRepository.DatabaseConnectionFactory;
import domain.GenericEntity;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author teodo
 */
public class DBBroker {

    private final Connection connection;

    public DBBroker(Connection connection) {
        this.connection = connection;
    }

    public void add(GenericEntity param) throws Exception {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("insert into ")
                    .append(param.getTableName())
                    .append(" (").append(param.getColumnNameForInsert()).append(")").append(" values (")
                    .append(param.getInserValues())
                    .append(")");

            String upit = sb.toString();
            System.out.println(upit);
            Statement statement = connection.createStatement();
            statement.executeUpdate(upit, Statement.RETURN_GENERATED_KEYS);
            ResultSet rsKey = statement.getGeneratedKeys();
            if (rsKey.next()) {
                Long id = rsKey.getLong(1);
                param.setId(id);
            }
            System.out.println(param);

            statement.close();
            rsKey.close();
        } catch (SQLException ex) {
            throw ex;
        }
    }

    public void edit(GenericEntity param) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ")
                .append(param.getTableName())
                .append(" SET ").append(param.getVrednostZaEdit()).append(" ")
                .append("WHERE ")
                .append(param.getPrimarniKljuc());

        System.out.println(sb);
        Statement s = connection.createStatement();
        s.executeUpdate(sb.toString());
    }

    public int delete(GenericEntity param) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM ")
                .append(param.getTableName())
                .append(" WHERE ").append(param.getKriterijumZaBrisanje());
        String upit = sb.toString();
        System.out.println(upit);

        Statement s = connection.createStatement();
        int number=s.executeUpdate(upit);
        return number;

    }
//
//   
    public List<GenericEntity> getAll(GenericEntity param) throws Exception {
        List<GenericEntity> data = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM ")
                .append(param.getTableName()).append(param.getJoinText());

        System.out.println(sb.toString());
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sb.toString());
        data = param.dodajNovi(rs);

        rs.close();
        st.close();
        if (data.size() == 0) {
            throw new Exception("Nema podataka u bazi.");
        }

        return data;

    }

    public GenericEntity getOne(GenericEntity param) throws Exception {

        GenericEntity jedan;
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT * FROM ")
                .append(param.getTableName())
                .append(" WHERE ")
                .append(param.getKriterijumZaJednog());
        String query = sb.toString();
        System.out.println(query + "getOne");
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);
        jedan = param.dodajJednog(rs);

        rs.close();
        st.close();

        return jedan;
    }

    public List<GenericEntity> getPoUslovu(GenericEntity param) throws Exception {
        List<GenericEntity> data = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM ")
                .append(param.getTableName()).append(param.getJoinText()).append(" WHERE ")
                .append(param.getKriterijumZaJednog());
        String query = sb.toString();
        System.out.println(query);

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);

        data = param.dodajNovi(rs);
        rs.close();
        statement.close();
        System.out.println(data);
        return data;
    }
//
//    
//    

    public Connection getConnection() {
        return connection;
    }

    public void commit() throws SQLException {
        connection.commit();
    }
    
    
}
