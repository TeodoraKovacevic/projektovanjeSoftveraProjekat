/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package form;

import communication.Response;
import domain.Profil;
import domain.Termin;
import domain.Zakazivanje;
import exception.ClassException;
import form.model.TmNadjenaZakazivanja;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/**
 *
 * @author teodo
 */
public class FrmZakazivanja extends javax.swing.JDialog {

    FrmRezervisanja f;
    TableModel tm;
    Profil p;

    /**
     * Creates new form FrmZakazivanja
     */
    public FrmZakazivanja(java.awt.Frame parent, boolean modal, Profil p, FrmRezervisanja f) throws Exception {
        super(parent, modal);
        initComponents();
        this.p = p;
        this.f = f;
        txtIme.setText(p.getIme());
        txtPrezime.setText(p.getPrezime());
        txtGrupa.setText(p.getGrupa().getNazivGrupe());
        txtIme.setEditable(false);
        txtPrezime.setEditable(false);
        txtGrupa.setEditable(false);
        Termin t = new Termin();
        t.setGrupa(p.getGrupa());
        List<Termin> termini = communication.Communication.getInstance().vratiTerminePoUslovu(t);
        for (Termin te : termini) {
            cmbTermin.addItem(te);
            tblZakazivanja.setModel(new TmNadjenaZakazivanja());
        }

    }

    public void setTm(TableModel tm) {
        this.tm = tm;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIme = new javax.swing.JTextField();
        txtPrezime = new javax.swing.JTextField();
        txtGrupa = new javax.swing.JTextField();
        cmbTermin = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblZakazivanja = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Ime:");

        jLabel2.setText("Prezime:");

        jLabel3.setText("Grupa:");

        jLabel4.setText("Termin:");

        jLabel5.setText("Datum od");

        jButton1.setText("Dodaj");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tblZakazivanja.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblZakazivanja);

        jButton2.setText("Sacuvaj");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obrisi");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(42, 42, 42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addGap(35, 35, 35)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(btnObrisi))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtIme)
                                .addComponent(txtPrezime)
                                .addComponent(txtGrupa)
                                .addComponent(cmbTermin, 0, 162, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(jButton2)))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtGrupa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbTermin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(btnObrisi))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jButton2)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        Termin t = (Termin) cmbTermin.getSelectedItem();
        Zakazivanje z = new Zakazivanje();
        Date datum = jCalendar1.getDate();

        z.setProfil(p);
        z.setGrupa(p.getGrupa());
        z.setTermin(t);
        z.setDatumZakazivanja(datum);
//        try {
//            communication.Communication.getInstance().dodajZakazivanje(z);
//            JOptionPane.showMessageDialog(this, "Uspesno zakazano");
//            f.addZak(z);
//            // TODO add your handling code here:
//        } catch (Exception ex) {
//            Logger.getLogger(FrmZakazivanja.class.getName()).log(Level.SEVERE, null, ex);
//        }

        TmNadjenaZakazivanja tnz = (TmNadjenaZakazivanja) tblZakazivanja.getModel();
        System.out.println(tnz.getZakazivanja()+"pre dodavanja");
        if(!tnz.sadrzi(z)){
            System.out.println("");
        tnz.dodajZakazivanje(z);
            System.out.println("posle dodavanja"+tnz.getZakazivanja());
        }else{
        JOptionPane.showMessageDialog(this, "Vec ste dodali ovo zakazivanje");
        }
//        List<Zakazivanje> lista = tnz.getZakazivanja();
//      //  if(tnz.getZakazivanja().size()!=0)}
//      if(lista.size()!=0){
//        for (Zakazivanje za : lista) {
//            if (za.getTermin().equals(z.getTermin())) {
//                JOptionPane.showMessageDialog(this, "Dodali ste vec to zakazivanje");
//            } else {
//                tnz.addZakazivanje(z);
//            }
//        }}
//      else{
//                          tnz.addZakazivanje(z);
//
//      }
        

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try {
            TmNadjenaZakazivanja model = (TmNadjenaZakazivanja) tblZakazivanja.getModel();
            List<Zakazivanje> zakazivanja = model.getZakazivanja();
            System.out.println(zakazivanja + "kad kliknem sacuvaj");
            Response rs=(Response) communication.Communication.getInstance().dodajZakazivanje(zakazivanja);
            if (rs.getException()== null) {
                f.osvezi(p);
                int o=JOptionPane.showConfirmDialog(this, "Usepsno ste kreirali termine!/n Da li zelite da unesete jos termina");
      
                if(o==0){
                TmNadjenaZakazivanja tm=new TmNadjenaZakazivanja(new ArrayList<>());
                tblZakazivanja.setModel(tm);
                }else{
                this.dispose();
                }
               }else{
            JOptionPane.showMessageDialog(this, "Neuspesno ste kreirali termin");
            }
            } catch (ClassException e) {
            JOptionPane.showMessageDialog(this, "Soket je zatvoren " + e.getMessage());
            this.dispose();
            // TODO add your handling code here:
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Greska prilikom cuvanja");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed

         int red=tblZakazivanja.getSelectedRow();
        if(red==-1){
        JOptionPane.showMessageDialog(this, "Selektujte red");
        }else{
            TmNadjenaZakazivanja t=(TmNadjenaZakazivanja) tblZakazivanja.getModel();
            t.getZakazivanja().remove(red);
            t.fireTableDataChanged();
    
    }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnObrisiActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnObrisi;
    private javax.swing.JComboBox<Termin> cmbTermin;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblZakazivanja;
    private javax.swing.JTextField txtGrupa;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtPrezime;
    // End of variables declaration//GEN-END:variables
}
