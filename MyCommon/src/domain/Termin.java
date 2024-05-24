/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author teodo
 */
public class Termin extends GenericEntity implements Serializable{
    private long terminId;
    private String dan;
    private String vreme;
    private Grupa grupa; 

   
    public Termin() {
    }

    public Termin(long terminId, String dan, String vreme, Grupa grupa) {
        this.terminId = terminId;
        this.dan = dan;
        this.vreme = vreme;
        this.grupa = grupa;
    }


    public long getTerminId() {
        return terminId;
    }

    public void setTerminId(long terminId) {
        this.terminId = terminId;
    }

    public String getDan() {
        return dan;
    }

    public void setDan(String dan) {
        this.dan = dan;
    }

    public String getVreme() {
        return vreme;
    }

    public void setVreme(String vreme) {
        this.vreme = vreme;
    }

    

    public Grupa getGrupa() {
        return grupa;
    }

    public void setGrupa(Grupa grupa) {
        this.grupa = grupa;
    }

    @Override
    public String getTableName() {
        return "termin";
    }

    @Override
    public String getColumnNameForInsert() {
       return "dan,vreme,grupaID";
    }

    @Override
    public String getInserValues() {
        StringBuilder sb=new StringBuilder();
        sb.append("'").append(dan).append("', ")
                .append("'").append(vreme).append("',")
                .append(" '").append(grupa.getGrupaId()).append("'");
              
         return sb.toString();
    }

    @Override
    public void setId(Long id) {
        this.terminId=id;
    }

    @Override
    public List<GenericEntity> dodajNovi(ResultSet rs) throws Exception {
         List<GenericEntity> termini = new ArrayList<>();
        while(rs.next()){
            Termin t = new Termin();
            t.setTerminId(rs.getLong("t.terminId"));
            t.setDan(rs.getString("t.dan"));
            t.setVreme(rs.getString("t.vreme"));
            
            Grupa g=new Grupa();
            g.setBrojKorisnika(rs.getInt("g.brojKorisnika"));
            g.setGrupaId(rs.getInt("g.grupaId"));
            g.setNazivGrupe(rs.getString("g.nazivGrupe"));
            Jezik j=new Jezik();
            j.setJezikId(rs.getLong("g.jezikId"));
            g.setJezik(j);
          t.setGrupa(g);
           termini.add(t);
        }
        return termini;
    }

    @Override
    public String getJoinTable() {
        return " grupa g";
    }

    @Override
    public String getKriterijumZaJoin() {
        return "g.grupaId=t.grupaId";
    }

    @Override
    public String getKriterijumZaJednog() {
        return " t.grupaID="+grupa.getGrupaId();
    }

    @Override
    public GenericEntity dodajJednog(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getKriterijumZaBrisanje() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getAlijas() {
        return " t";
    }

    
    @Override
    public String getVrednostZaEdit() {
         return "dan="+"'"+dan+"'"+",vreme='"+vreme+"'"+",grupaId='"+grupa.getGrupaId()+"'";
    }

    @Override
    public String getPrimarniKljuc() {
        return "terminId= "+terminId;
    }

    @Override
    public String toString() {
        return dan+" "+vreme;
    }

    @Override
    public String getJoinText() {
        return " t join grupa g on g.grupaId=t.grupaId";
    }
    
    
}
