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
import java.util.Objects;

/**
 *
 * @author teodo
 */
public class Zakazivanje extends GenericEntity implements Serializable {

    private int brojRez;
    private Date datumZakazivanja;
    private Date datumOtkazivanja;
    private Termin termin;
    private Profil profil;
    private Grupa grupa;
    

    public Zakazivanje() {
    }

    public Zakazivanje(int brojRez, Date datumZakazivanja, Date datumOtkazivanja, Termin termin, Profil profil, Grupa grupa) {
        this.brojRez = brojRez;
        this.datumZakazivanja = datumZakazivanja;
        this.datumOtkazivanja = datumOtkazivanja;
        this.termin = termin;
        this.profil = profil;
        this.grupa = grupa;
    }

    public Grupa getGrupa() {
        return grupa;
    }

    public void setGrupa(Grupa grupa) {
        this.grupa = grupa;
    }

    public int getBrojRez() {
        return brojRez;
    }

    public void setBrojRez(int brojRez) {
        this.brojRez = brojRez;
    }

    public Date getDatumZakazivanja() {
        return datumZakazivanja;
    }

    public void setDatumZakazivanja(Date datumZakazivanja) {
        this.datumZakazivanja = datumZakazivanja;
    }

    public Date getDatumOtkazivanja() {
        return datumOtkazivanja;
    }

    public void setDatumOtkazivanja(Date datumOtkazivanja) {
        this.datumOtkazivanja = datumOtkazivanja;
    }

    public Termin getTermin() {
        return termin;
    }

    public void setTermin(Termin termin) {
        this.termin = termin;
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    @Override
    public String getTableName() {
        return "zakazivanje";
    }

    @Override
    public String getColumnNameForInsert() {
        return "brojRez,datumZakazivanja,datumOtkazivanja,termin,profil,grupa";
    }

    @Override
    public String getInserValues() {
        if(datumOtkazivanja!=null){
        StringBuilder sb=new StringBuilder();
        sb.append("'").append(brojRez).append("', ")
                .append("'").append(new java.sql.Date(datumZakazivanja.getTime())).append("',")
                .append(" '").append(new java.sql.Date(datumOtkazivanja.getTime())).append("',")
                .append(termin.getTerminId()).append(",")
                .append("'").append(profil.getProfilId()).append("',").append("'").append(grupa.getGrupaId()).append("'");
         return sb.toString();
        }else{
        StringBuilder sb=new StringBuilder();
        sb.append("'").append(brojRez).append("', ")
                .append("'").append(new java.sql.Date(datumZakazivanja.getTime())).append("',").append("NULL").append(", ")
                .append(termin.getTerminId()).append(",")
                .append("'").append(profil.getProfilId()).append("',").append("'").append(grupa.getGrupaId()).append("'");
         return sb.toString();
        }
    }

    @Override
    public void setId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<GenericEntity> dodajNovi(ResultSet rs) throws Exception {
         List<GenericEntity> zakazivanja = new ArrayList<>();
        while(rs.next()){
            Zakazivanje z = new Zakazivanje();
            z.setBrojRez(rs.getInt("z.brojRez"));
            z.setDatumZakazivanja(rs.getDate("z.datumZakazivanja"));
            z.setDatumOtkazivanja(rs.getDate("z.datumOtkazivanja"));
            
            Profil p=new Profil();
            p.setId(rs.getLong("p.profilId"));
            p.setIme(rs.getString("p.ime"));
            p.setPrezime(rs.getString("p.prezime"));
            p.setJMBG(rs.getString("p.jmbg"));
            
            Grupa g=new Grupa();
            g.setGrupaId(rs.getLong("p.grupa"));
            p.setGrupa(g);
            
            Termin t=new Termin();
            t.setDan(rs.getString("t.dan"));
            t.setVreme(rs.getString("t.vreme"));
            t.setTerminId(rs.getLong("t.terminId"));
            z.setTermin(t);
            z.setProfil(p);
            z.setGrupa(g);
            zakazivanja.add(z);
        }
        return zakazivanja;
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
        return "profil="+profil.getProfilId();
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
        return " z ";
    }

    @Override
    public String getVrednostZaEdit() {
        return "datumOtkazivanja= '"+new java.sql.Date(datumOtkazivanja.getTime())+"'";
    }

    @Override
    public String getPrimarniKljuc() {
        return "termin="+termin.getTerminId()+" and grupa="+grupa.getGrupaId()+" and profil= "+profil.getProfilId();
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Zakazivanje other = (Zakazivanje) obj;
        if (!Objects.equals(this.termin, other.termin)) {
            return false;
        }
        if (!Objects.equals(this.profil, other.profil)) {
            return false;
        }
        return Objects.equals(this.grupa, other.grupa);
    }

    

    

    @Override
    public String toString() {
        return "Zakazivanje{" + "termin=" + termin + ", profil=" + profil + ", grupa=" + grupa + '}';
    }

    @Override
    public String getJoinText() {
        return " z join profil p on z.profil=p.profilId join termin t on z.termin=t.terminId join grupa g on z.grupa=g.grupaId";
    }

   

}
