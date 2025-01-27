/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package form;

import communication.Operation;
import communication.Request;
import communication.Response;
import domain.Grupa;
import domain.Termin;
import exception.ClassException;
import form.model.tmNadjeniProfili;
import form.model.tmNadjeniTermini;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author teodo
 */
public class FrmKreiranjeTermin extends javax.swing.JDialog {

    /**
     * Creates new form FrmTermin
     */
    public FrmKreiranjeTermin(FrmPretrazivanjeTermina parent, boolean modal) {
        super(parent, modal);
        initComponents();
        napuniComboBox();
        tblTermini.setModel(new tmNadjeniTermini());
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
        jButton1 = new javax.swing.JButton();
        cmbVreme = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cmbGrupa = new javax.swing.JComboBox<>();
        cmbDan = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTermini = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Dan");

        jLabel2.setText("Vreme");

        jButton1.setText("Dodaj");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cmbVreme.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10:15h", "12:15h", "14:15h", "16:15h" }));

        jLabel3.setText("Grupa:");

        cmbGrupa.setToolTipText("");

        cmbDan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ponedeljak", "utorak", "sreda", "cetvrtak", "petak", "subota" }));
        cmbDan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDanActionPerformed(evt);
            }
        });

        tblTermini.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblTermini);

        jButton2.setText("Sacuvaj");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Obrisi");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbDan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbVreme, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbGrupa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3)
                            .addComponent(jButton1))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(234, 234, 234))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cmbGrupa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbVreme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbDan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(29, 29, 29)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String dan=(String) cmbDan.getSelectedItem();
        String v=(String) cmbVreme.getSelectedItem();
        Grupa g=(Grupa) cmbGrupa.getSelectedItem();
        
        Termin t=new Termin();
        t.setDan(dan);
        t.setGrupa(g);
        t.setVreme(v);
//        try {
//            Response rs=(Response) communication.Communication.getInstance().sacuvajTermin(t);
//            if(rs.getOdgovor()!=null){
//                JOptionPane.showMessageDialog(this, "Usepsno ste kreirali termin");
//            }else{
//
//               JOptionPane.showMessageDialog(this, "Neuspesno kreiran termin");
//
//            }
//            // TODO add your handling code here:
//        } catch (Exception ex) {
//            Logger.getLogger(FrmKreiranjeTermin.class.getName()).log(Level.SEVERE, null, ex);
//        }

        tmNadjeniTermini model=(tmNadjeniTermini) tblTermini.getModel();
        if(model.sadrzi2(t)){
        if(!model.sadrzi(t)){
        model.dodajTermin(t);
        }else{
        JOptionPane.showMessageDialog(this, "Vec ste dodali ovaj termin");
        }
        }else{
        JOptionPane.showMessageDialog(this, "Trenutno dodajete termine za jednu grupu");
        
        
        
        }
        
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        tmNadjeniTermini model=(tmNadjeniTermini) tblTermini.getModel();
        tmNadjeniTermini tm;
        Response rs=new Response();
        try {
            rs=(Response) communication.Communication.getInstance().sacuvajTermin( model.getTermini());
            if (rs.getException()== null) {
                int o=JOptionPane.showConfirmDialog(this, "Usepsno ste kreirali termine!/n Da li zelite da unesete jos termina");
                if(o==0){
                tm=new tmNadjeniTermini(new ArrayList<>());
                tblTermini.setModel(tm);
                }else{
                this.dispose();
                }
               }else{
            JOptionPane.showMessageDialog(this, "Neuspesno ste kreirali termine");
            }

        }catch(ClassException e){
        JOptionPane.showMessageDialog(this, "Soket je zatvoren");
        this.dispose();
        } // TODO add your handling code here:
         catch (Exception ex) {
           // Logger.getLogger(FrmKreiranjeTermin.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(this, "Neuspesno kreiranje termina");
           tm=new tmNadjeniTermini(new ArrayList<>());
                tblTermini.setModel(tm);
           
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        int red=tblTermini.getSelectedRow();
        if(red==-1){
        JOptionPane.showMessageDialog(this, "Selektujte red");
        }else{
            tmNadjeniTermini t=(tmNadjeniTermini) tblTermini.getModel();
            t.getTermini().remove(red);
            t.fireTableDataChanged();
    
    }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cmbDanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbDanActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbDan;
    private javax.swing.JComboBox<Grupa> cmbGrupa;
    private javax.swing.JComboBox<String> cmbVreme;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTermini;
    // End of variables declaration//GEN-END:variables

    private void napuniComboBox() {
        try {
            Request request = new Request(Operation.VRATI_GRUPE, FRAMEBITS);

            List<Grupa> grupe = communication.Communication.getInstance().vratiGrupe();
            for (Grupa g : grupe) {
                cmbGrupa.addItem(g);
            }
        } catch (Exception ex) {
            Logger.getLogger(FrmKreiranjeProfila.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
