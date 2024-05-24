/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form.models;

import domain.Direktor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author teodo
 */
public class tmDirektori extends AbstractTableModel{
    String[] naziviKolona = {"Ime i prezime", "Korisničko ime"};
    private List<Direktor> direktori;

    
    public tmDirektori(){
        direktori=new ArrayList<>();
    }
    
   
    public tmDirektori(List<Direktor> direktori) {
        this.direktori= direktori;
    }

    @Override
    public int getRowCount() {
        return direktori.size();
    }

    @Override
    public int getColumnCount() {
        return naziviKolona.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Direktor b = direktori.get(row);
        switch (column) {
            case 0:
                return b.getIme() + " " + b.getPrezime();
            case 1:
                return b.getKorisnickoIme();
           
            default:
                return "\n";
        }
    }

    @Override
    public String getColumnName(int i) {
        return naziviKolona[i];
    }

    public List<Direktor> getBibliotekari() {
        return direktori;
    }

    public void setBibliotekari(ArrayList<Direktor> direktori) {
        this.direktori = direktori;
    }

    public void dodaj(Direktor b) {
        direktori.add(b);
        fireTableDataChanged();
    }

    public void obrisi(Direktor b) {
         direktori.remove(b);
        fireTableDataChanged();
    }

    public void odjaviSe(Direktor b) {
        direktori.remove(b);
        fireTableDataChanged();
    }

    public void obrisiSve() {
        this.direktori = new ArrayList<>();
    }

}
