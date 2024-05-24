/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author teodo
 */
public class Jezik extends GenericEntity implements Serializable{
    private long jezikId;
    private String naziv;

    public Jezik() {
    }

    
    public Jezik(long jezikId, String naziv) {
        this.jezikId = jezikId;
        this.naziv = naziv;
    }

    public long getJezikId() {
        return jezikId;
    }

    public void setJezikId(long jezikId) {
        this.jezikId = jezikId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jezik other = (Jezik) obj;
        return Objects.equals(this.naziv, other.naziv);
    }
    

   

    

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String getTableName() {
        return "jezik";
    }

    @Override
    public String getColumnNameForInsert() {
        return "naziv";
    }

    @Override
    public String getInserValues() {
        StringBuilder sb=new StringBuilder();
        sb.append("'").append(naziv).append("'");
                
         return sb.toString();
    }

    @Override
    public void setId(Long id) {
        this.jezikId=id;
    }

    @Override
    public List<GenericEntity> dodajNovi(ResultSet rs) throws Exception {
        List<GenericEntity> jezici = new ArrayList<>();
        while(rs.next()){
            Jezik j=new Jezik();
            j.setNaziv(rs.getString("naziv"));
            
           jezici.add(j);
        }
        return jezici;
    }

    @Override
    public String getJoinTable() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getKriterijumZaJoin() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getKriterijumZaJednog() {
        return " jezikId="+jezikId;
    }

    @Override
    public GenericEntity dodajJednog(ResultSet rs) throws Exception {
        if(rs.next()){
            jezikId = rs.getInt("jezikId");
            naziv = rs.getString("naziv");
            
            return this;
            
        }
        throw new Exception("Grupa ne postoji u bazi!");
    }

    @Override
    public String getKriterijumZaBrisanje() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getAlijas() {
        return "";
    }

    @Override
    public String getVrednostZaEdit() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getPrimarniKljuc() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getJoinText() {
        return "";
    }
    
    
}
