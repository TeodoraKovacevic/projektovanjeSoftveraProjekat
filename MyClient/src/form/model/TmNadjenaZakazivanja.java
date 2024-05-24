/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form.model;

import domain.Profil;
import domain.Termin;
import domain.Zakazivanje;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author teodo
 */
public class TmNadjenaZakazivanja extends  AbstractTableModel {

    List<Zakazivanje> zakazivanja;
    List<Termin> listaTermina;
    private Class[] klase = new Class[]{Object.class, Object.class, Object.class};
    private DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    String[] naziviKolona = {"Termin", "Datum Zakazivanja", "Datum otkazivanja"};

    public TmNadjenaZakazivanja() {
        zakazivanja=new ArrayList<>();
    }

    public TmNadjenaZakazivanja(List<Zakazivanje> zakazivanja) {
        this.zakazivanja = zakazivanja;
    }
    

    public TmNadjenaZakazivanja(List<Zakazivanje> zakazivanja, List<Termin> listaTermina) {
        this.zakazivanja = zakazivanja;
        this.listaTermina = listaTermina;
    }

    @Override
    public int getRowCount() {
        if (zakazivanja == null) {
            return 0;
        }
        return zakazivanja.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Zakazivanje z = zakazivanja.get(rowIndex);
        switch (columnIndex) {
            case 0:
                if (z.getTermin() == null) {
                    return null;
                }
                return z.getTermin().getDan() + " " + z.getTermin().getVreme();
            case 1:
                if (z.getDatumZakazivanja() == null) {
                    return null;
                }
                return df.format(z.getDatumZakazivanja());
            case 2:
                if (z.getDatumOtkazivanja() == null) {
                    return null;
                }
                return df.format(z.getDatumOtkazivanja());

            default:
                return "\n";
        }

    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Zakazivanje z = zakazivanja.get(rowIndex);
        switch (columnIndex) {
            case 0:
                z.setTermin((Termin) aValue);

                break;
            case 1:
                z.setDatumZakazivanja((Date) aValue);
            case 2:
                z.setDatumOtkazivanja((Date) aValue);
                break;

        }
    }

    @Override
    public String getColumnName(int column) {
        return naziviKolona[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return klase[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        //editable je samo poslednji dodati red
//        if((columnIndex==2 && signalZaZaduzi) && rowIndex==zakazivanja.size()-1)return false;
//        else if(((columnIndex==1 || columnIndex==0) && signalZaRazduzi))return false;
//        return true;
        return false;
    }

    public List<Zakazivanje> getZakazivanja() {
        return zakazivanja;
    }

    public Zakazivanje getZakazivanjeAt(int row) {

        return zakazivanja.get(row);
    }

    public void addZakazivanje(Zakazivanje novo) {

        zakazivanja.add(novo);
        fireTableDataChanged();
    }

    

    public void updateZakazivanje(Zakazivanje za) {
        for(Zakazivanje z:zakazivanja){
        
            if(z.equals(za)){
                z.setDatumOtkazivanja(za.getDatumOtkazivanja());
            }
        }
        fireTableDataChanged();
    }

    public boolean sadrzi(Zakazivanje z) {
        for(Zakazivanje za:zakazivanja){
        if(z.getTermin().getDan().equals(za.getTermin().getDan()) && z.getTermin().getVreme().equals(za.getTermin().getVreme()) ){
        return true;
        }}
        return false;
    }

    public void dodajZakazivanje(Zakazivanje z) {
        zakazivanja.add(z);
        fireTableDataChanged();
    }

    public void osvezi(Profil p) {
        try {
            Zakazivanje z=new Zakazivanje();
            z.setProfil(p);
            zakazivanja=communication.Communication.getInstance().vratiZakazivanjaPoUslovu(z);
            fireTableDataChanged();
        } catch (Exception ex) {
            Logger.getLogger(TmNadjenaZakazivanja.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

}
