/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetobanco;

import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Davyd
 */
public class FinalSemana extends javax.swing.JFrame {

    tOpcoes t;
    PersonPrincipal P;
    Tempo Temp;
    /**
     * Creates new form FinalSemana
     */
    public FinalSemana() {
        initComponents();
        H.setText(25+"");
    }
    
    public void atualizar(){
        
            
    
    }
    
    public void verificar(){
        
        if(Integer.parseInt(this.H.getText()) == 0){
            this.ME.setEnabled(false);
            this.MS.setEnabled(false);
        }
        else{
            this.ME.setEnabled(true);
            this.MS.setEnabled(true);
        }
        
        if(Integer.parseInt(this.H.getText()) == 25){
            this.mE.setEnabled(false);
            this.mS.setEnabled(false);
        }
        
    }
    
    public void verificar2(){
        if(Integer.parseInt(this.HE.getText()) > 0){
            this.mE.setEnabled(true);
        }
        if(Integer.parseInt(this.HS.getText()) > 0){
            this.mS.setEnabled(true);
        }
        
        if(Integer.parseInt(this.HE.getText()) == 0){
            this.mE.setEnabled(false);
        }
        if(Integer.parseInt(this.HS.getText()) == 0){
            this.mS.setEnabled(false);
        }
    }
    
    
    public void passagem(tOpcoes tela , PersonPrincipal p,Tempo t){
        this.t = tela;
        P=p;
        this.Temp = t;
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        H = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        HE = new javax.swing.JLabel();
        HS = new javax.swing.JLabel();
        ME = new javax.swing.JButton();
        MS = new javax.swing.JButton();
        mE = new javax.swing.JButton();
        mS = new javax.swing.JButton();
        confirmar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(358, 376));
        setMinimumSize(new java.awt.Dimension(358, 376));
        setPreferredSize(new java.awt.Dimension(358, 376));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Horas Disponíveis:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(80, 100, 130, 17);

        H.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        H.setText("0");
        getContentPane().add(H);
        H.setBounds(220, 100, 29, 17);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Estudando:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 150, 80, 17);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Se Divertindo:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 180, 97, 17);

        HE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        HE.setText("0");
        getContentPane().add(HE);
        HE.setBounds(140, 150, 23, 17);

        HS.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        HS.setText("0");
        getContentPane().add(HS);
        HS.setBounds(140, 180, 18, 17);

        ME.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ME.setText("+");
        ME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MEActionPerformed(evt);
            }
        });
        getContentPane().add(ME);
        ME.setBounds(170, 150, 43, 25);

        MS.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        MS.setText("+");
        MS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MSActionPerformed(evt);
            }
        });
        getContentPane().add(MS);
        MS.setBounds(170, 180, 43, 25);

        mE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mE.setText("-");
        mE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mEActionPerformed(evt);
            }
        });
        getContentPane().add(mE);
        mE.setBounds(230, 150, 39, 25);

        mS.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mS.setText("-");
        mS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mSActionPerformed(evt);
            }
        });
        getContentPane().add(mS);
        mS.setBounds(230, 180, 39, 25);

        confirmar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        confirmar.setText("Confirmar");
        confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarActionPerformed(evt);
            }
        });
        getContentPane().add(confirmar);
        confirmar.setBounds(120, 280, 101, 25);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel4.setText("Final de Semana");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(70, 40, 190, 30);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Fds.png"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(-120, -20, 490, 460);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MEActionPerformed
        this.HE.setText(""+ (Integer.parseInt(this.HE.getText())+1));
        this.H.setText(""+ (Integer.parseInt(this.H.getText())-1));
        this.verificar();
        this.verificar2();
    }//GEN-LAST:event_MEActionPerformed

    private void MSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MSActionPerformed
        this.HS.setText(""+ (Integer.parseInt(this.HS.getText())+1));
        this.H.setText(""+ (Integer.parseInt(this.H.getText())-1));
        this.verificar();
        this.verificar2();
    }//GEN-LAST:event_MSActionPerformed

    private void mEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mEActionPerformed
        this.HE.setText(""+ (Integer.parseInt(this.HE.getText())-1));
        this.H.setText(""+ (Integer.parseInt(this.H.getText())+1));
        this.verificar();
        this.verificar2();
    }//GEN-LAST:event_mEActionPerformed

    private void mSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSActionPerformed
        this.HE.setText(""+ (Integer.parseInt(this.HE.getText())-1));
        this.H.setText(""+ (Integer.parseInt(this.H.getText())+1));
        this.verificar();
        this.verificar2();
    }//GEN-LAST:event_mSActionPerformed

    private void confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarActionPerformed
        
        this.P.Humor += (Integer.parseInt(this.HS.getText())- Integer.parseInt(this.HE.getText()));
        if(this.P.Humor >10){
            this.P.Humor=10;
        }
        if(this.P.Humor <0){
            this.P.Humor=0;
        }
        this.P.horasEstudadas += (Integer.parseInt((this.HE.getText()) )- (12-this.P.Humor) );
        try {
            Temp.passarDia();
        } catch (IOException ex) {
            Logger.getLogger(FinalSemana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(FinalSemana.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Temp.passarDia();
        } catch (IOException ex) {
            Logger.getLogger(FinalSemana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(FinalSemana.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        t.setVisible(true);
        t.exporInfos();
        this.setVisible(false);
        
        
    }//GEN-LAST:event_confirmarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FinalSemana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FinalSemana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FinalSemana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FinalSemana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FinalSemana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel H;
    private javax.swing.JLabel HE;
    private javax.swing.JLabel HS;
    private javax.swing.JButton ME;
    private javax.swing.JButton MS;
    private javax.swing.JButton confirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton mE;
    private javax.swing.JButton mS;
    // End of variables declaration//GEN-END:variables
}
