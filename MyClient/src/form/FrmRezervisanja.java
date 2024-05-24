/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package form;

import com.toedter.calendar.JDateChooserCellEditor;
import communication.Communication;
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
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;

/**
 *
 * @author teodo
 */
public class FrmRezervisanja extends javax.swing.JDialog {

    List<Zakazivanje> listaZakazivanja;
    Profil p;

    /**
     * Creates new form FrmRezervisanja
     */
    public FrmRezervisanja(java.awt.Frame parent, boolean modal, Profil p) throws Exception {
        super(parent, modal);
        this.p = p;
        initComponents();
        try {
            txtIme.setEnabled(false);
            txtPrezime.setEnabled(false);
            txtIme.setText(p.getIme());
            txtPrezime.setText(p.getPrezime());

            Termin t = new Termin();
            t.setGrupa(p.getGrupa());
            List<Termin> listaTermina = new ArrayList<>();

            listaTermina = communication.Communication.getInstance().vratiTerminePoUslovu(t);

            Zakazivanje z = new Zakazivanje();
            z.setGrupa(p.getGrupa());
            z.setProfil(p);

            listaZakazivanja = communication.Communication.getInstance().vratiZakazivanjaPoUslovu(z);

            TmNadjenaZakazivanja tnz = new TmNadjenaZakazivanja(listaZakazivanja, listaTermina);
            tblZakazivanja.setModel(tnz);

            if (listaZakazivanja.size() == 0) {
                JOptionPane.showMessageDialog(this, "Za profil nije kreirano nijedno zakazivanje");
            }

            //dodavanje combo boxeva i date pikera
            TableColumn tcNazivTermina = tblZakazivanja.getColumnModel().getColumn(0);
            JComboBox cbTermini = new JComboBox(listaTermina.toArray());
            tcNazivTermina.setCellEditor(new DefaultCellEditor(cbTermini));

            TableColumn tcDatumOd = tblZakazivanja.getColumnModel().getColumn(1);
            tcDatumOd.setCellEditor(new JDateChooserCellEditor());

            TableColumn tcDatumDo = tblZakazivanja.getColumnModel().getColumn(2);
            tcDatumDo.setCellEditor(new JDateChooserCellEditor());
        } catch (ClassException e) {
            JOptionPane.showMessageDialog(this, "Soket je zatvoren " + e.getMessage());
            this.dispose();
        }
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
        txtIme = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblZakazivanja = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtPrezime = new javax.swing.JTextField();
        btnOtkazi = new javax.swing.JButton();
        btnZakazi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Ime:");

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

        jLabel2.setText("Prezime:");

        txtPrezime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrezimeActionPerformed(evt);
            }
        });

        btnOtkazi.setText("Otkazi");
        btnOtkazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtkaziActionPerformed(evt);
            }
        });

        btnZakazi.setText("Zakazi");
        btnZakazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZakaziActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(btnOtkazi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnZakazi)
                .addGap(55, 55, 55))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOtkazi)
                    .addComponent(btnZakazi))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPrezimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrezimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrezimeActionPerformed

    private void btnZakaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZakaziActionPerformed

//        TmNadjenaZakazivanja model = (TmNadjenaZakazivanja) tblZakazivanja.getModel();
//        model.setSignalZaZaduzi(true);
//        model.setSignalZaRazduzi(false);
//        Zakazivanje novo = new Zakazivanje();
//        novo.setProfil(p);
//        model.addZakazivanje(novo);
        FrmZakazivanja fz;
        try {
            fz = new FrmZakazivanja(null, true, p, this);
            fz.setVisible(true);
            fz.setTm(tblZakazivanja.getModel());
        } catch (ClassException e) {
            JOptionPane.showMessageDialog(this, "Soket je zatvoren " + e.getMessage());
            this.dispose();
        } catch (Exception ex)
    {
            Logger.getLogger(FrmRezervisanja.class.getName()).log(Level.SEVERE, null, ex);
    }

    // TODO add your handling code here:
    }//GEN-LAST:event_btnZakaziActionPerformed

    private void btnOtkaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtkaziActionPerformed

        int z = tblZakazivanja.getSelectedRow();
        if (z == -1) {
            JOptionPane.showMessageDialog(this, "Neuspesno otkazivanje");
        }
        TmNadjenaZakazivanja model = (TmNadjenaZakazivanja) tblZakazivanja.getModel();
        Zakazivanje za = model.getZakazivanjeAt(z);
        if (za.getDatumOtkazivanja() == null) {
            za.setProfil(p);
            za.setGrupa(p.getGrupa());
            za.setDatumOtkazivanja(new Date());
            model.updateZakazivanje(za);
            try {
                communication.Communication.getInstance().updateZakazivanje(za);
                JOptionPane.showMessageDialog(this, "Uspesno otkazivanje");
//        

// TODO add your handling code here:
 } catch (ClassException e) {
            JOptionPane.showMessageDialog(this, "Soket je zatvoren " + e.getMessage());
            this.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Neuspesno" + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Zakazivanje je vec otkazano");

        }
    }//GEN-LAST:event_btnOtkaziActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOtkazi;
    private javax.swing.JButton btnZakazi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblZakazivanja;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtPrezime;
    // End of variables declaration//GEN-END:variables

    void addZak(Zakazivanje z) {
        TmNadjenaZakazivanja tm = (TmNadjenaZakazivanja) tblZakazivanja.getModel();
        tm.addZakazivanje(z);
    }

    void osvezi(Profil p) {
        TmNadjenaZakazivanja tm = (TmNadjenaZakazivanja) tblZakazivanja.getModel();
        tm.osvezi(p);
    }
}