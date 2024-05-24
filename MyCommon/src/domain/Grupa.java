/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author teodo
 */
public class Grupa extends GenericEntity implements Serializable {

    private long grupaId;
    private int brojKorisnika;
    private String nazivGrupe;
    private Jezik jezik;

    public Grupa() {
    }

    public Grupa(long grupaId, int brojKorisnika, String nazivGrupe, Jezik jezik) {
        this.grupaId = grupaId;
        this.brojKorisnika = brojKorisnika;
        this.nazivGrupe = nazivGrupe;
        this.jezik = jezik;
    }

    public Jezik getJezik() {
        return jezik;
    }

    public void setJezik(Jezik jezik) {
        this.jezik = jezik;
    }

    public long getGrupaId() {
        return grupaId;
    }

    public void setGrupaId(long grupaId) {
        this.grupaId = grupaId;
    }

    public int getBrojKorisnika() {
        return brojKorisnika;
    }

    public void setBrojKorisnika(int brojKorisnika) {
        this.brojKorisnika = brojKorisnika;
    }

    public String getNazivGrupe() {
        return nazivGrupe;
    }

    public void setNazivGrupe(String nazivGrupe) {
        this.nazivGrupe = nazivGrupe;
    }

    @Override
    public String toString() {
        return nazivGrupe;
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
        final Grupa other = (Grupa) obj;
        if (this.grupaId != other.grupaId) {
            return false;
        }
        return Objects.equals(this.nazivGrupe, other.nazivGrupe);
    }

    @Override
    public String getTableName() {
        return "grupa";
    }

    @Override
    public String getColumnNameForInsert() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getInserValues() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<GenericEntity> dodajNovi(ResultSet rs) throws Exception {
        List<GenericEntity> lista = new ArrayList<>();

        while (rs.next()) {
            Grupa grupa = new Grupa();
            Jezik jezik = new Jezik();
            jezik.setJezikId(rs.getLong("j.jezikId"));
            jezik.setNaziv(rs.getString("j.naziv"));
            grupa.setBrojKorisnika(rs.getInt("g.brojKorisnika"));
            grupa.setGrupaId(rs.getLong("g.grupaId"));
            grupa.setJezik(jezik);
            grupa.setNazivGrupe(rs.getString("g.nazivGrupe"));
            lista.add(grupa);
        }
        System.out.println(lista);
        return lista;
    }

    @Override
    public String getJoinTable() {

        return "jezik j";
    }

    @Override
    public String getKriterijumZaJoin() {
        return "g.jezikId=j.jezikId";
    }

    @Override
    public String getKriterijumZaJednog() {
        return "nazivGrupe = '" + nazivGrupe + "' ";
    }

    @Override
    public GenericEntity dodajJednog(ResultSet rs) throws SQLException, Exception {

        if (rs.next()) {
            grupaId = rs.getInt("grupaId");
            brojKorisnika = rs.getInt("brojKorisnika");
            nazivGrupe = rs.getString("nazivGrupe");
            Jezik j = new Jezik();
            j.setJezikId(rs.getInt("jezikId"));

            this.jezik = j;

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
        return " g";
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
        return " g join jezik j on g.jezikId=j.jezikId";
    }

}
