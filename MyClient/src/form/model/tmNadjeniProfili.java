/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form.model;

import communication.Communication;
import domain.Profil;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author teodo
 */
public class tmNadjeniProfili extends AbstractTableModel {

   
    public tmNadjeniProfili(List<Profil> profili1) {
        this.profili=profili1;
    }

    public List<Profil> profili;
    private final String[] naziviKolona = new String[]{"ID profila", "Ime", "Prezime", "JMBG", "Grupa"};

    
    @Override
    public int getRowCount() {
        if (profili == null) {
            return 0;
        }
        return profili.size();
    }

    @Override
    public int getColumnCount() {
        return naziviKolona.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Profil p = profili.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getProfilId();
            case 1:
                return p.getIme();
            case 2:
                return p.getPrezime();
            case 3:
                return p.getJMBG();
            case 4:
                
                return p.getGrupa().getNazivGrupe();

            default:
                throw new AssertionError();
        }
    }

    @Override
    public String getColumnName(int column) {
        return naziviKolona[column];
    }

    public List<Profil> getProfili() {
        return profili;
    }

    public void osvezi(Profil p1){
        try {
            profili=Communication.getInstance().vratiProfilePoUslovu(p1);
            System.out.println("osvezi" +profili);
            fireTableDataChanged();
        } catch (Exception ex) {
            Logger.getLogger(tmNadjeniProfili.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
