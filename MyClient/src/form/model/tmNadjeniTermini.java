/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form.model;

import communication.Communication;
import domain.Termin;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author teodo
 */
public class tmNadjeniTermini extends AbstractTableModel {

    public List<Termin> termini;

    public tmNadjeniTermini() {
        termini = new ArrayList<>();
    }

    String[] naziviKolona = {"dan", "vreme", "grupa"};

    public tmNadjeniTermini(List<Termin> termini) {
        this.termini = termini;
    }

    @Override
    public int getRowCount() {
        if (termini == null) {
            return 0;
        }
        return termini.size();
    }

    @Override
    public int getColumnCount() {
        return naziviKolona.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Termin t = termini.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return t.getDan();
            case 1:
                return t.getVreme();
            case 2:
                return t.getGrupa();

            default:
                throw new AssertionError();
        }
    }

    public List<Termin> getTermini() {
        return termini;
    }

    @Override
    public String getColumnName(int column) {
        return naziviKolona[column];
    }

    public void dodajTermin(Termin t) {

        termini.add(t);
        fireTableDataChanged();
    }

    public boolean sadrzi(Termin t) {
        for (Termin te : termini) {
            if (te.getDan().equals(t.getDan()) && te.getVreme().equals(t.getVreme())) {
                return true;
            } else {
                return false;
            }

        }return false;

    }

    public void osvezi(Termin te) {
        try {
            termini=Communication.getInstance().vratiTerminePoUslovu(te);
            System.out.println("osvezi" +termini);
            fireTableDataChanged();
        } catch (Exception ex) {
            Logger.getLogger(tmNadjeniTermini.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean sadrzi2(Termin t) {
       if(termini.size()!=0){
       if(!termini.get(0).getGrupa().equals(t.getGrupa())){
       return false;
       }
       }
       return true;
    }
}
