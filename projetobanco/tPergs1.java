/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetobanco;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Arthur
 */
public class tPergs1 extends javax.swing.JFrame {

    
    
    public tPergs1() {
        initComponents();
    }
    PersonPrincipal p;
    public void passar(PersonPrincipal passagem){
        this.p = passagem;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel3 = new javax.swing.JLabel();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        C = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Fundoo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(580, 380));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Teste de Inteligência");
        jLabel3.setToolTipText("");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(140, 10, 270, 30);

        buttonGroup1.add(jRadioButton5);
        jRadioButton5.setText("A - Algum conhecido morreu");
        jRadioButton5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jRadioButton5);
        jRadioButton5.setBounds(30, 150, 410, 30);

        buttonGroup1.add(jRadioButton6);
        jRadioButton6.setText("B - Estão preparando uma surpresa para você");
        jRadioButton6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jRadioButton6);
        jRadioButton6.setBounds(30, 180, 410, 30);

        buttonGroup1.add(jRadioButton7);
        jRadioButton7.setText("C - Você está com cancer");
        jRadioButton7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jRadioButton7);
        jRadioButton7.setBounds(30, 210, 410, 30);

        buttonGroup1.add(C);
        C.setText("D - Nenhuma das alternativas");
        C.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(C);
        C.setBounds(30, 240, 410, 30);

        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        jScrollPane1.setFocusable(false);
        jScrollPane1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPane1.setHorizontalScrollBar(null);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("Você está caminhando na rua e de repente recebe 3 ligações. \nA primeira é da sua namorada que estava desesperada, \npedindo pra você ir imediatamente falar com ela. \nOutra ligação é da sua mãe dizendo que precisa \nfalar urgentemente com você. \nE por fim a última ligação é do seu melhor amigo, \ne ele também fala que tem algo pra te falar pessoalmente. \nAnalisando essa situação, o que você acha que ocorreu?");
        jTextArea1.setToolTipText("");
        jTextArea1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextArea1.setMaximumSize(new java.awt.Dimension(500, 500));
        jTextArea1.setMinimumSize(new java.awt.Dimension(100, 100));
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 50, 410, 100);

        jButton1.setText("Confirmar");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(150, 270, 160, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Ele é corno, mas é meu amigo. By: Tiririca");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 320, 290, 20);

        Fundoo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FundoPerg.JPG"))); // NOI18N
        getContentPane().add(Fundoo);
        Fundoo.setBounds(-6, -6, 590, 390);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setEnabled(false);
        if(C.isSelected()){
            JOptionPane.showMessageDialog(null,"Já sabe que é corno , você é esperto\n+1 Ponto Em Inteligência!");
            this.p.setInteligencia(this.p.getInteligencia()+1);
            tOpcoes tela2 = new tOpcoes();
            try {
                tela2.passar(this.p);
            } catch (IOException ex) {
                Logger.getLogger(tPergs1.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(tPergs1.class.getName()).log(Level.SEVERE, null, ex);
            }
            tela2.exporInfos();
            tela2.setVisible(true);
            this.setVisible(false);
        
        }
        else{
            JOptionPane.showMessageDialog(null,"Não aceita que é corno , isso é triste :c\nVocê não ganhou o ponto extra de inteligencia ");
            tOpcoes tela2 = new tOpcoes();
            try {
                tela2.passar(this.p);
            } catch (IOException ex) {
                Logger.getLogger(tPergs1.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(tPergs1.class.getName()).log(Level.SEVERE, null, ex);
            }
            tela2.metodoBanco();
            tela2.exporInfos();
            tela2.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    //PROF DA UM 10 AI NA MORAL, DEU TRABALHO
    //EU DEIXEI DE VER DBS QUANDO LANÇOU
    
    /**
     * @param args the command line arguments
     */
    //OH MÃE, EU VOU NÉ, MAS EU VOU BEBER

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton C;
    private javax.swing.JLabel Fundoo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
