/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetobanco;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Davyd
 */
public final class tAtribs extends javax.swing.JFrame {

    int pontos = 22;
    PersonPrincipal p = new PersonPrincipal();
    
    public tAtribs() {
        initComponents();
        this.desabilitar2();
    }
    
    
    public void desabilitar2(){
        m1.setEnabled(false);
        m2.setEnabled(false);
        m3.setEnabled(false);
        m4.setEnabled(false);
    }
    
    public void desabilitar(){
        M1.setEnabled(false);
        M2.setEnabled(false);
        M3.setEnabled(false);
        M4.setEnabled(false);
    }
    
    public void habilitar(){
        if(Integer.parseInt(I.getText())<10 ){
            M1.setEnabled(true);
        }
        if(Integer.parseInt(F.getText())<10){
            M2.setEnabled(true);
        }
        if(Integer.parseInt(H.getText())<10){
            M3.setEnabled(true);
        }
        if(Integer.parseInt(C.getText())<10){
            M4.setEnabled(true);
        }
    }
    
    public void attP(){
        P.setText(""+this.pontos);
    }
    
    
    //Se falar que a lógica não ta boa , mentiu d+
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        I = new javax.swing.JLabel();
        F = new javax.swing.JLabel();
        H = new javax.swing.JLabel();
        M1 = new javax.swing.JButton();
        m1 = new javax.swing.JButton();
        M2 = new javax.swing.JButton();
        m2 = new javax.swing.JButton();
        M3 = new javax.swing.JButton();
        m3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        C = new javax.swing.JLabel();
        M4 = new javax.swing.JButton();
        m4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        P = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        nomeP = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(580, 380));
        setMinimumSize(new java.awt.Dimension(580, 380));
        setPreferredSize(new java.awt.Dimension(580, 380));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 255, 102));
        jLabel1.setText("Inteligencia:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(270, 110, 100, 20);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 255, 102));
        jLabel3.setText("Finança:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(270, 150, 70, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 255, 102));
        jLabel4.setText("Humor:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(270, 190, 60, 20);

        I.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        I.setForeground(new java.awt.Color(102, 255, 102));
        I.setText("0");
        getContentPane().add(I);
        I.setBounds(380, 110, 10, 20);

        F.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        F.setForeground(new java.awt.Color(102, 255, 102));
        F.setText("0");
        getContentPane().add(F);
        F.setBounds(380, 150, 20, 20);

        H.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        H.setForeground(new java.awt.Color(102, 255, 102));
        H.setText("0");
        getContentPane().add(H);
        H.setBounds(380, 190, 20, 20);

        M1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        M1.setText("+");
        M1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                M1ActionPerformed(evt);
            }
        });
        getContentPane().add(M1);
        M1.setBounds(420, 110, 50, 30);

        m1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        m1.setText("-");
        m1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m1ActionPerformed(evt);
            }
        });
        getContentPane().add(m1);
        m1.setBounds(480, 110, 50, 30);

        M2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        M2.setText("+");
        M2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                M2ActionPerformed(evt);
            }
        });
        getContentPane().add(M2);
        M2.setBounds(420, 150, 50, 30);

        m2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        m2.setText("-");
        m2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m2ActionPerformed(evt);
            }
        });
        getContentPane().add(m2);
        m2.setBounds(480, 150, 50, 30);

        M3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        M3.setText("+");
        M3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                M3ActionPerformed(evt);
            }
        });
        getContentPane().add(M3);
        M3.setBounds(420, 190, 50, 30);

        m3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        m3.setText("-");
        m3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m3ActionPerformed(evt);
            }
        });
        getContentPane().add(m3);
        m3.setBounds(480, 190, 50, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 255, 102));
        jLabel5.setText("Carisma:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(270, 230, 80, 20);

        C.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        C.setForeground(new java.awt.Color(102, 255, 102));
        C.setText("0");
        getContentPane().add(C);
        C.setBounds(380, 230, 30, 20);

        M4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        M4.setText("+");
        M4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                M4ActionPerformed(evt);
            }
        });
        getContentPane().add(M4);
        M4.setBounds(420, 230, 50, 30);

        m4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        m4.setText("-");
        m4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m4ActionPerformed(evt);
            }
        });
        getContentPane().add(m4);
        m4.setBounds(480, 230, 50, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 255, 102));
        jLabel6.setText("Pontos restantes:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(330, 80, 140, 14);

        P.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        P.setForeground(new java.awt.Color(102, 255, 102));
        P.setText("22");
        getContentPane().add(P);
        P.setBounds(470, 80, 20, 14);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 255, 102));
        jLabel7.setText("Defina seus atributos");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(150, 0, 290, 60);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Confirmar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(220, 290, 110, 25);
        getContentPane().add(nomeP);
        nomeP.setBounds(30, 110, 180, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 255, 102));
        jLabel2.setText("Insira seu Nome:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 80, 140, 20);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FundoTeste.png"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(-6, -6, 590, 390);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void M1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_M1ActionPerformed
        
        I.setText( ""+( 1 + Integer.parseInt(I.getText()) ));
        this.pontos--;
        if(pontos ==0 || Integer.parseInt(I.getText()) == 10){
            this.M1.setEnabled(false);
        }
        m1.setEnabled(true);
        attP();
        if(pontos == 0){
            this.desabilitar();
        }
    }//GEN-LAST:event_M1ActionPerformed

    private void M2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_M2ActionPerformed
        F.setText( ""+( 1 + Integer.parseInt(F.getText()) ));
        this.pontos--;
        if(pontos ==0 || Integer.parseInt(F.getText()) == 10){
            this.M2.setEnabled(false);
        }
        m2.setEnabled(true);
        attP();
        if(pontos == 0){
            this.desabilitar();
        }
    }//GEN-LAST:event_M2ActionPerformed

    private void M3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_M3ActionPerformed
        H.setText( ""+( 1 + Integer.parseInt(H.getText()) ));
        this.pontos--;
        if(pontos ==0 || Integer.parseInt(H.getText()) == 10){
            this.M3.setEnabled(false);
        }
        m3.setEnabled(true);
        attP();
        if(pontos == 0){
            this.desabilitar();
        }
    }//GEN-LAST:event_M3ActionPerformed
    //REXPEITA O RATO
    
    private void M4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_M4ActionPerformed
        C.setText( ""+( 1 + Integer.parseInt(C.getText()) ));
        this.pontos--;
        if(pontos ==0 || Integer.parseInt(C.getText()) == 10){
            this.M4.setEnabled(false);
        }
        m4.setEnabled(true);
        attP();
        if(pontos == 0){
            this.desabilitar();
        }
        //VAGABUNDA NÃO FEZ NADA NO PROJETO DELA
        
    }//GEN-LAST:event_M4ActionPerformed

    private void m1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m1ActionPerformed
        I.setText( ""+(  Integer.parseInt(I.getText()) - 1 ));
        this.pontos++;
        if( Integer.parseInt(I.getText()) == 0){
            m1.setEnabled(false);
        }
        habilitar();
        attP();
    }//GEN-LAST:event_m1ActionPerformed
    //OH JOEL, DEUS É PAI OU É PADRASTO
    
    private void m2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m2ActionPerformed
        F.setText( ""+(  Integer.parseInt(F.getText()) - 1 ));
        this.pontos++;
        if( Integer.parseInt(F.getText()) == 0){
            m2.setEnabled(false);
        }
        habilitar();
        attP();
    }//GEN-LAST:event_m2ActionPerformed

    private void m3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m3ActionPerformed
        H.setText( ""+(  Integer.parseInt(H.getText()) - 1 ));
        this.pontos++;
        if( Integer.parseInt(H.getText()) == 0){
            m3.setEnabled(false);
        }
        habilitar();
        attP();
    }//GEN-LAST:event_m3ActionPerformed

    private void m4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m4ActionPerformed
        C.setText( ""+(  Integer.parseInt(C.getText()) - 1 ));
        this.pontos++;
        if( Integer.parseInt(C.getText()) == 0){
            m4.setEnabled(false);
        }
        habilitar();
        attP();
    }//GEN-LAST:event_m4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        tPergs1 tela2 = new tPergs1();
        
        this.p.setCarisma(Integer.parseInt(this.C.getText()));
        try {
            this.p.definirCaracteristicas(this.nomeP.getText(),Integer.parseInt(this.I.getText()),Integer.parseInt(this.F.getText()),Integer.parseInt(this.H.getText()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Nome não pode ser Nulo");
            return;
        }
        tela2.passar(this.p);
        
        tela2.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel C;
    private javax.swing.JLabel F;
    private javax.swing.JLabel H;
    private javax.swing.JLabel I;
    private javax.swing.JButton M1;
    private javax.swing.JButton M2;
    private javax.swing.JButton M3;
    private javax.swing.JButton M4;
    private javax.swing.JLabel P;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JButton m1;
    private javax.swing.JButton m2;
    private javax.swing.JButton m3;
    private javax.swing.JButton m4;
    private javax.swing.JTextField nomeP;
    // End of variables declaration//GEN-END:variables
}
