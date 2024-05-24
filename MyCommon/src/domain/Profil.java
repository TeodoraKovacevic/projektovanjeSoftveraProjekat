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
public class Profil extends GenericEntity implements Serializable {

    private long profilId;
    private String ime;
    private String prezime;
    private String JMBG;
    private int godiste;
    private Grupa grupa;

    public Profil() {
    }

    public Profil(long profilId, String ime, String prezime, String JMBG, int godiste, Grupa grupa) {
        this.profilId = profilId;
        this.ime = ime;
        this.prezime = prezime;
        this.JMBG = JMBG;
        this.godiste = godiste;
        this.grupa = grupa;
    }

    public long getProfilId() {
        return profilId;
    }

    public void setProfilId(long profilId) {
        this.profilId = profilId;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getJMBG() {
        return JMBG;
    }

    public void setJMBG(String JMBG) {
        this.JMBG = JMBG;
    }

    public int getGodiste() {
        return godiste;
    }

    public void setGodiste(int godiste) {
        this.godiste = godiste;
    }

    public Grupa getGrupa() {
        return grupa;
    }

    public void setGrupa(Grupa grupa) {
        this.grupa = grupa;
    }

    @Override
    public String toString() {
        return "Profil{" + "profilId=" + profilId + ", ime=" + ime + ", prezime=" + prezime + ", JMBG=" + JMBG + ", godiste=" + godiste + ", grupa=" + grupa + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Profil other = (Profil) obj;
        return Objects.equals(this.JMBG, other.JMBG);
    }

    @Override
    public String getTableName() {
        return "profil";
    }

    @Override
    public String getColumnNameForInsert() {
        return "ime,prezime,godiste,grupa,jmbg";
    }

    @Override
    public String getInserValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(ime).append("', ")
                .append("'").append(prezime).append("',")
                .append(" '").append(godiste).append("',")
                .append(grupa.getGrupaId()).append(",")
                .append("'").append(JMBG).append("'");
        return sb.toString();
    }

    @Override
    public void setId(Long id) {
        this.profilId = id;
    }

    @Override
    public List<GenericEntity> dodajNovi(ResultSet rs) throws Exception {
        List<GenericEntity> profili = new ArrayList<>();
        while (rs.next()) {
            Profil p = new Profil();
            p.setId(rs.getLong("p.profilId"));
            p.setIme(rs.getString("p.ime"));
            p.setPrezime(rs.getString("p.prezime"));
            p.setJMBG(rs.getString("p.jmbg"));
            p.setGodiste(rs.getInt("p.godiste"));
            Grupa g = new Grupa();
            g.setBrojKorisnika(rs.getInt("g.brojKorisnika"));
            g.setGrupaId(rs.getInt("g.grupaId"));
            g.setNazivGrupe(rs.getString("g.nazivGrupe"));
            //g.setJezik(rs.getLong("g.jezikId"));
            p.setGrupa(g);
            profili.add(p);
        }
        return profili;
    }

    @Override
    public String getJoinTable() {
        return "grupa g";
    }

    @Override
    public String getKriterijumZaJoin() {
        return "g.grupaId=p.grupa";
    }

    @Override
    public String getKriterijumZaJednog() {
        return "ime = '" + ime + "' ";
    }

    @Override
    public GenericEntity dodajJednog(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getKriterijumZaBrisanje() {
        return "profilId = " + profilId;
    }

    @Override
    public String getAlijas() {
        return " p ";
    }

    @Override
    public String getVrednostZaEdit() {

        return "ime=" + "'" + ime + "'" + ",prezime='" + prezime + "'" + ",jmbg='" + JMBG + "'" + ",godiste='" + godiste + "'" + ",grupa='" + grupa.getGrupaId() + "'";
    }

    @Override
    public String getPrimarniKljuc() {
        return "profilId= " + profilId;

    }

    @Override
    public String getJoinText() {
        return  " p join grupa g on g.grupaId=p.grupa";
    }

}
