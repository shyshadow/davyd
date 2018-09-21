/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetobanco;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Arthur
 */
public class tOpcoes extends javax.swing.JFrame {
    FuncoesBanco DAO = new FuncoesBanco();
    public tOpcoes() {
     
        initComponents();
        this.Nada.setEnabled(false);
    }
    int mês = 2;
    int hora=0;
    ArrayList nomesH = new ArrayList();
    ArrayList nomesM = new ArrayList();
    PersonPrincipal p = new PersonPrincipal();
    Tempo tempo = new Tempo();
    ArrayList diasSemana = new ArrayList();
    ArrayList<Horário> horario = new ArrayList();
    
    
    public void pegarHorario() throws FileNotFoundException, IOException{
        File arquivo = new File("");
        File b = new File(arquivo.getAbsolutePath()+"\\src\\Textos","Horarios.txt");
        FileReader c = new FileReader(b);
        BufferedReader d = new BufferedReader(c);
        String s;
        for(int i=0;i<5;i++){
            Horário temp = new Horário();
            for(int o=0;o<6;o++){
                temp.Horario.add(d.readLine());
                temp.index.add((Integer.parseInt(d.readLine()))-1);
            }
            this.horario.add(temp);
        }
        
    }
    
    public void definirDias(){
        this.diasSemana.add("Segunda-Feira");
        this.diasSemana.add("Terça-Feira");
        this.diasSemana.add("Quarta-Feira");
        this.diasSemana.add("Quinta-Feira");
        this.diasSemana.add("Sexta-Feira");
    }
    
    public void passar(PersonPrincipal passagem) throws IOException, SQLException{
        this.p = passagem;
        try{
            tempo.novaData();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }
        this.definirMaterias();
        this.definirDias();
        this.hora = 0;
        this.pegarHorario();
        //Limpando o banco
        FuncoesBanco DAO = new FuncoesBanco();
        ArrayList professores = new ArrayList();
        for(int i = 0 ; i <15 ; i ++){
            professores.add(DAO.nomePf(i+1));
        }
        
        
        for(int i = 0 ; i <15 ; i ++){
            professores.add(DAO.nomePf(i+1));
        }
            DAO.deletarProfessor();
        DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
        String nomeP = DAO.nomeP();
        DAO.deletarPersonagem();
        DAO.deletarTempo();
        
        DAO.createPersonPrincipal();
        DAO.createTempo();
        DAO.createProfessor();
        //Agora Salvar as infos atuais
        
        for(int i = 0 ; i <15 ; i ++){
            DAO.inserirProfessor(this.p.Materias.get(i).professor.Nome, this.p.Materias.get(i).professor.afetividade,this.p.Materias.get(i).professor.desafeto);
        }

        DAO.inserirTempo(tempo.df.format(tempo.dt1), tempo.diaSemana, tempo.bimestre);
        DAO.inserirPersonagem(this.p.Nome,this.p.carisma,this.p.Humor,this.p.Finança,this.p.Inteligencia,(double) this.p.money,this.p.horasEstudadas);
        
        ArrayList<Materia> temp = new ArrayList();
        temp = p.Materias;
        for(int i = 0 ; i <15 ; i ++){
            DAO.updateFaltas(temp.get(i).Nome,temp.get(i).faltas);
            DAO.updateNotaB1(temp.get(i).getNome(), temp.get(i).Notasbimestrais[0]);
            DAO.updateNotaB2(temp.get(i).getNome(), temp.get(i).Notasbimestrais[1]);
            DAO.updateNotaB3(temp.get(i).getNome(), temp.get(i).Notasbimestrais[2]);
            DAO.updateNotaB4(temp.get(i).getNome(), temp.get(i).Notasbimestrais[3]);
            DAO.updateMateriaProfessor(temp.get(i).getNome(), temp.get(i).professor.Nome);
        }
        
    }
    
    public void definirNotas(){
        
        for(int i =0;i<15;i++){
            this.p.calcularNota(i,this.tempo.bimestre-1);
        }
        
    }
    
    public void passarDia() throws IOException{
        String n;
        n=tempo.df.format(tempo.dt1);
        n = (n.charAt(3)+""+n.charAt(4));
        if(this.mês < Integer.parseInt(n)){
            this.p.mesada();
            this.mês ++;
        }
        
        if(this.tempo.df.format(this.tempo.dt1).equals(this.tempo.df.format(this.tempo.dt2))){
            this.definirNotas();
        }
        
         if ( this.tempo.df.format(this.tempo.dt1).equals(this.tempo.df.format(this.tempo.dt2)) && this.tempo.bimestre == 4){
            
            JOptionPane.showMessageDialog(null,"Fim Do Ano Letivo ^^ \nVamos Verificar Suas Notas!");
            
            this.setVisible(false);
            int cont=0;
            String a="";
            JOptionPane.showMessageDialog(null,"Matérias E Suas Respectivas Aprovações\nTrue=Aprovado\nFalse=Reprovado");
            for(int i =0;i<15;i++){
                a=(a+"\n"+this.p.Materias.get(i).getNome()+": "+this.p.Materias.get(i).aprovação());
                if(!this.p.Materias.get(i).aprovação()){
                    cont++;
                }
            }
            JOptionPane.showMessageDialog(null, a);
            
            if (cont > 3 ){
                JOptionPane.showMessageDialog(null,"Você Reprovou De Ano :/ \nDeveria Ter Estudado Mais \nTalvez Da Proxima vez ^^");
                System.exit(0);
            }
            else if(cont <3 && cont >0){
                
                JOptionPane.showMessageDialog(null, "hummm... Você Reprovou Em Poucas Matérias\nTalvez na Proxima Versão Você Consiga ^^\n(Ainda não temos Recuperações)");
                System.exit(0);
            }else{
                JOptionPane.showMessageDialog(null,"UAU Você Conseguiu Passar de ano\nTire uma foto disto e mostre para o branco que você ganhará um P1...");
                JOptionPane.showMessageDialog(null, "Brincadeira kk\nParabéns , pois Este jogo foi feito para reprovar pessoas !\nvocê é esperto^^");
                JOptionPane.showMessageDialog(null, "Até A Proxima!!");
                System.exit(0);
            }
            
            
        }
        
        
            try {
                this.tempo.passarDia();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(tOpcoes.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(tOpcoes.class.getName()).log(Level.SEVERE, null, ex);
            }
            
      
        
        if(tempo.diaSemana>5){
            FinalSemana temp = new FinalSemana();
            temp.passagem(this, p, tempo);
            this.setVisible(false);
            temp.setVisible(true);
        }
        else{
            this.exporInfos();
        }
        
        
    }
    
    public void adicionarNomesH() throws FileNotFoundException, IOException{
         File arquivo = new File("");
         File b = new File(arquivo.getAbsolutePath()+"\\src\\Textos","NomesHomens.txt");
         FileReader c = new FileReader(b);
         BufferedReader d = new BufferedReader(c);
         String nome=d.readLine();
         for(int i=0;i<30;i++){
             this.nomesH.add(nome);
             nome = d.readLine();
         }
    }
    
    
    //Tu pode mecher a vontade nesse método q assim q ele começar ele vai chamar esse método , vc faz oq quiser
    //vc apaga e cria uma nova aqui dentro desse metodo pq sempre q ele criar novo jogo ele vem pra k , tu vai manjar q eu sei
    public void metodoBanco(){
    
    
    }
    
    
    
    
    
    public void recuperarInfos(Tempo temp ,PersonPrincipal P){
        this.definirDias();
        this.p = P;
        this.tempo = temp;
        String n;
        n=tempo.df.format(tempo.dt1);
        n = (n.charAt(3)+""+n.charAt(4));
        this.mês = Integer.parseInt(n);
        this.definirDias();
        try {
            this.pegarHorario();
        } catch (IOException ex) {
            Logger.getLogger(tOpcoes.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null,this.tempo.df.format(temp.dt1) + "   " + temp.diaSemana);
        this.exporInfos();
        
        
    }
    
    public void exporInfos(){
        money.setText(""+p.getMoney()+"");
        this.data.setText(this.tempo.df.format(this.tempo.dt1));
        this.diaSemana.setText((String) this.diasSemana.get(this.tempo.diaSemana-1));
        this.Hora.setText((String) this.horario.get(this.tempo.diaSemana-1).Horario.get(this.hora));
        
    }
    
    public void intervalo(){
        this.irPraAula.setEnabled(false);
        this.interagir.setEnabled(false);
        this.Nada.setEnabled(true);
        this.Hora.setText("15:30 - 15:50");
    }
    
    public void adicionarNomesM() throws FileNotFoundException, IOException{
         File arquivo = new File("");
         File b = new File(arquivo.getAbsolutePath()+"\\src\\Textos","NomesMulheres.txt");
         FileReader c = new FileReader(b);
         BufferedReader d = new BufferedReader(c);
         String nome=d.readLine();
         for(int i=0;i<30;i++){
             this.nomesM.add(nome);
             nome = d.readLine();
         }
             
    }
    
    public void definirMaterias() throws FileNotFoundException, IOException{
        this.adicionarNomesH();
        this.adicionarNomesM();
        
        File arquivo = new File("");
        File b = new File(arquivo.getAbsolutePath()+"\\src\\Textos","Materias.txt");
        FileReader c = new FileReader(b);
        BufferedReader d = new BufferedReader(c);
        String nome;
        int index;
        Random a = new Random();
        for(int i=0 ; i <15 ; i++){
            if(a.nextInt(2) == 0){
                index = a.nextInt(this.nomesM.size());
                String s = d.readLine();
                int m = Integer.parseInt(d.readLine());
                this.p.adicionarMatéria(s, m, (String) this.nomesM.get(index));
                nomesM.remove(index);
            }
            else{
                index = a.nextInt(this.nomesH.size());
                String s = d.readLine();
                int m = Integer.parseInt(d.readLine());
                this.p.adicionarMatéria(s, m, (String) this.nomesH.get(index));
                nomesH.remove(index);
            }
            
            
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Hora = new javax.swing.JLabel();
        diaSemana = new javax.swing.JLabel();
        data = new javax.swing.JLabel();
        opcoesText = new javax.swing.JLabel();
        bimValor = new javax.swing.JLabel();
        bimText = new javax.swing.JLabel();
        money = new javax.swing.JLabel();
        valorText = new javax.swing.JLabel();
        salvarJogo = new javax.swing.JButton();
        irPraAula = new javax.swing.JButton();
        IrLanchar = new javax.swing.JButton();
        interagir = new javax.swing.JButton();
        IrCasa = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        Nada = new javax.swing.JButton();
        Boletim = new javax.swing.JButton();
        vDataNova = new javax.swing.JLabel();
        vDataNova1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Fundoo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(580, 380));
        setMinimumSize(new java.awt.Dimension(580, 380));
        setPreferredSize(new java.awt.Dimension(580, 380));
        getContentPane().setLayout(null);

        Hora.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Hora.setText("Hora");
        getContentPane().add(Hora);
        Hora.setBounds(340, 50, 140, 40);

        diaSemana.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        diaSemana.setText("Dia");
        getContentPane().add(diaSemana);
        diaSemana.setBounds(80, 80, 140, 20);

        data.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        data.setText("Data");
        getContentPane().add(data);
        data.setBounds(90, 60, 219, 19);

        opcoesText.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        opcoesText.setText("Opções:");
        getContentPane().add(opcoesText);
        opcoesText.setBounds(140, 120, 80, 17);

        bimValor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bimValor.setText("1");
        getContentPane().add(bimValor);
        bimValor.setBounds(410, 80, 20, 20);

        bimText.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bimText.setText("Bimestre:");
        getContentPane().add(bimText);
        bimText.setBounds(340, 80, 90, 20);

        money.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        money.setText("0");
        getContentPane().add(money);
        money.setBounds(380, 100, 50, 20);

        valorText.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        valorText.setText("R$:");
        getContentPane().add(valorText);
        valorText.setBounds(340, 100, 50, 20);

        salvarJogo.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        salvarJogo.setText("Salvar Jogo");
        salvarJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarJogoActionPerformed(evt);
            }
        });
        getContentPane().add(salvarJogo);
        salvarJogo.setBounds(360, 260, 110, 25);

        irPraAula.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        irPraAula.setText("Ir para a aula");
        irPraAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                irPraAulaActionPerformed(evt);
            }
        });
        getContentPane().add(irPraAula);
        irPraAula.setBounds(40, 150, 250, 25);

        IrLanchar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        IrLanchar.setText("Ir lanchar");
        IrLanchar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IrLancharActionPerformed(evt);
            }
        });
        getContentPane().add(IrLanchar);
        IrLanchar.setBounds(40, 180, 250, 25);

        interagir.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        interagir.setText("Interagir (faltar)");
        interagir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                interagirActionPerformed(evt);
            }
        });
        getContentPane().add(interagir);
        interagir.setBounds(40, 210, 250, 25);

        IrCasa.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        IrCasa.setText("Faltar e ir pra casa");
        IrCasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IrCasaActionPerformed(evt);
            }
        });
        getContentPane().add(IrCasa);
        IrCasa.setBounds(40, 240, 250, 25);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton1.setText("Horarios");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(330, 150, 170, 25);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton2.setText("Profs. e Matérias");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(330, 180, 170, 25);

        Nada.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Nada.setText("Sem ação (passar aula/dia)");
        Nada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NadaActionPerformed(evt);
            }
        });
        getContentPane().add(Nada);
        Nada.setBounds(40, 270, 250, 25);

        Boletim.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Boletim.setText("Boletim");
        Boletim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoletimActionPerformed(evt);
            }
        });
        getContentPane().add(Boletim);
        Boletim.setBounds(330, 210, 170, 25);

        vDataNova.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        vDataNova.setText("Dia:");
        getContentPane().add(vDataNova);
        vDataNova.setBounds(50, 80, 70, 20);

        vDataNova1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        vDataNova1.setText("Data:");
        getContentPane().add(vDataNova1);
        vDataNova1.setBounds(50, 60, 70, 17);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Dia de Aula Comum");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(180, 20, 180, 22);

        Fundoo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FSaula.jpg"))); // NOI18N
        getContentPane().add(Fundoo);
        Fundoo.setBounds(-220, -380, 880, 840);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void interagirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_interagirActionPerformed
       
       if(this.p.Materias.get((int) this.horario.get(this.tempo.diaSemana-1).index.get(this.hora)).professor.desafeto < 10){
           this.p.Materias.get((int) this.horario.get(this.tempo.diaSemana-1).index.get(this.hora)).professor.desafeto++;
       }
       JOptionPane.showMessageDialog(null,"Você Faltou A Aula De "+this.p.Materias.get((int) this.horario.get(this.tempo.diaSemana-1).index.get(this.hora)).Nome+" Do Professor "+this.p.Materias.get((int) this.horario.get(this.tempo.diaSemana-1).index.get(this.hora)).professor.getNome()+
       "\n(+1 Falta Nesta Matéria E +1 Ponto De Desafeto Com Este Professor)");
       Random a = new Random();
       
       if(a.nextBoolean()){
           if(a.nextBoolean()){
               JOptionPane.showMessageDialog(null,"E Sua Interação Foi Como O Esperado Por Você\n(+1 Pònto De Humor)");
               this.p.Humor++;
               
           }
           else{
               JOptionPane.showMessageDialog(null,"Você Interagiu , Mas não Foi Como O Esperado");
           }
       }
       else{
           JOptionPane.showMessageDialog(null,"Você Interagiu , Mas não Foi Como O Esperado");
       }
       
       if(hora == 2){
            JOptionPane.showMessageDialog(null,"hora do intervalo!");
            this.intervalo();
        }
        else if (hora == 5){
            JOptionPane.showMessageDialog(null,"Fim Do Dia ^^");
            this.hora = 0;
           try {
               this.passarDia();
           } catch (IOException ex) {
               Logger.getLogger(tOpcoes.class.getName()).log(Level.SEVERE, null, ex);
           }
        }else{
            this.hora++;
            this.exporInfos();
        }
       
       
       
       
    }//GEN-LAST:event_interagirActionPerformed

    private void irPraAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_irPraAulaActionPerformed
        JOptionPane.showMessageDialog(null,"Você Assistiu A Aula de"+this.p.Materias.get((int) this.horario.get(this.tempo.diaSemana-1).index.get(this.hora)).getNome()+"");
        Random a = new Random();
        ArrayList b = new ArrayList();
        for(int i = 0;i <((this.p.carisma * this.p.Humor) - (this.p.Materias.get((int) this.horario.get(this.tempo.diaSemana-1).index.get(this.hora)).professor.desafeto * 5));i++){
            b.add(""+a.nextInt(1000));
        }
        if(b.contains(a.nextInt(1000)+"")){
            JOptionPane.showMessageDialog(null,"Professor "+this.p.Materias.get((int) this.horario.get(this.tempo.diaSemana-1).index.get(this.hora)).professor.Nome+" Gostou de Você \n(-1 Ponto Desafeto)");
            if(this.p.Materias.get((int) this.horario.get(this.tempo.diaSemana-1).index.get(this.hora)).professor.desafeto > 0){
                this.p.Materias.get((int) this.horario.get(this.tempo.diaSemana-1).index.get(this.hora)).professor.desafeto -=1;
            }
        }
        if(hora == 2){
            JOptionPane.showMessageDialog(null,"hora do intervalo!");
            this.intervalo();
        }
        else if (hora == 5){
            JOptionPane.showMessageDialog(null,"Fim Do Dia ^^");
            this.hora = 0;
            try {
                this.passarDia();
            } catch (IOException ex) {
                Logger.getLogger(tOpcoes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            this.hora++;
            this.exporInfos();
        }
        
    }//GEN-LAST:event_irPraAulaActionPerformed

    private void IrLancharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IrLancharActionPerformed
        int i;
        try{
           i=Integer.parseInt(JOptionPane.showInputDialog("O que Deseja Comprar:\n1-Salgado R$:3,00 (+1 Humor)\n2-Refrigerante R$:3,00 (+1 Humor) \n3-Gula R$:2,50 (+1 Carisma) "));
           if(i<1 || i > 3){
               throw new Exception("ex");
           }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Indice Da Comida Incorreto ");
            return;
        }
        if(i == 1 || i == 2){
            if(this.p.verificarCompra((float) 3.00)){
                JOptionPane.showMessageDialog(null,"(+1 ponto de Humor)");
            }
            else{
                return;
            }
            
        }
        else{
            if(this.p.verificarCompra((float) 2.50)){
                JOptionPane.showMessageDialog(null,"(+1 Ponto Carisma)");
            }
            else{
                return;
            }
        }
        if(!this.irPraAula.isEnabled()){
            if(this.p.Materias.get((int) this.horario.get(this.tempo.diaSemana-1).index.get(this.hora)).professor.desafeto < 10){
                this.p.Materias.get((int) this.horario.get(this.tempo.diaSemana-1).index.get(this.hora)).professor.desafeto++;
                JOptionPane.showMessageDialog(null, "Você Faltou A Aula De "+this.p.Materias.get((int) this.horario.get(this.tempo.diaSemana-1).index.get(this.hora)).Nome+" Do Professor "+this.p.Materias.get((int) this.horario.get(this.tempo.diaSemana-1).index.get(this.hora)).professor.getNome()+
                "\n(+1 Falta Nesta Matéria E +1 Ponto De Desafeto Com Este Professor)");
            }
        }
        
        this.irPraAula.setEnabled(true);
        this.interagir.setEnabled(true);
        this.Nada.setEnabled(false);
        
        if(hora == 2){
            JOptionPane.showMessageDialog(null,"hora do intervalo!");
            this.intervalo();
        }
        else if (hora == 5){
            JOptionPane.showMessageDialog(null,"Fim Do Dia ^^");
            this.hora = 0;
            try {
                this.tempo.passarDia();
            } catch (IOException ex) {
                Logger.getLogger(tOpcoes.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(tOpcoes.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.exporInfos();
        }else{
            this.hora++;
            this.exporInfos();
        }
    }//GEN-LAST:event_IrLancharActionPerformed

    private void NadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NadaActionPerformed
        this.irPraAula.setEnabled(true);
        this.interagir.setEnabled(true);
        this.hora++;
        this.exporInfos();
        this.Nada.setEnabled(false);
    }//GEN-LAST:event_NadaActionPerformed

    
    //DOUG Não meche nos nomes de variaveis plz
    
    
    
    
    private void IrCasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IrCasaActionPerformed
        JOptionPane.showMessageDialog(null,"Você Faltou Todas As Aulas Que Restavam");
        for(int i =6; i>this.hora;i--){
            this.p.Materias.get((int) this.horario.get(this.tempo.diaSemana-1).index.get(i-1)).faltas++;
            if(this.p.Materias.get((int) this.horario.get(this.tempo.diaSemana-1).index.get(i-1)).professor.desafeto < 10){
                this.p.Materias.get((int) this.horario.get(this.tempo.diaSemana-1).index.get(i-1)).professor.desafeto++;
            }
        }
        this.irPraAula.setEnabled(true);
        this.interagir.setEnabled(true);
        this.Nada.setEnabled(false);
        this.hora = 0;
        try {
            this.passarDia();
        } catch (IOException ex) {
            Logger.getLogger(tOpcoes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_IrCasaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String a="";
        for(int o =0;o<5;o++){
            a = (a+"\n"+this.diasSemana.get(o));
            for(int i = 0 ; i<6;i++){
                a=(a+"\n"+this.horario.get(o).Horario.get(i)+":"+this.p.Materias.get((int) this.horario.get(o).index.get(i)).Nome);
            }
            JOptionPane.showMessageDialog(null,a);
            a="";
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String a="";
        String b = "";
        for(int i=0;i<15;i++){
            if (i<8){
                a = (a+"\n"+this.p.Materias.get(i).Nome+":\nDificuldade:"+this.p.Materias.get(i).dificuldade+"\nProfessor:"+this.p.Materias.get(i).professor.getNome());
                a = a+"\n";
            }
            else{
                b = (b+"\n"+this.p.Materias.get(i).Nome+":\nDificuldade:"+this.p.Materias.get(i).dificuldade+"\nProfessor:"+this.p.Materias.get(i).professor.getNome());
                b = b+"\n";
            }
        
        }
        JOptionPane.showMessageDialog(null, a);
        JOptionPane.showMessageDialog(null, b);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void BoletimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoletimActionPerformed
        String a="";
        String b="";
        String c="";
        for(int i=0;i<15;i++){
            if(i<6){
                a = (a+"\n"+this.p.Materias.get(i).Nome+":\nN1: "+this.p.Materias.get(i).getNotasbimestrais(0)+"\nN2: "+this.p.Materias.get(i).getNotasbimestrais(1)+"\nN3: "+this.p.Materias.get(i).getNotasbimestrais(2)+"\nN4: "+this.p.Materias.get(i).getNotasbimestrais(3));
                a=a+"\n";
            }
            else if (i>5 && i <11){
                b = (b+"\n"+this.p.Materias.get(i).Nome+"\nN1: "+this.p.Materias.get(i).getNotasbimestrais(0)+"\nN2: "+this.p.Materias.get(i).getNotasbimestrais(1)+"\nN3: "+this.p.Materias.get(i).getNotasbimestrais(2)+"\nN4: "+this.p.Materias.get(i).getNotasbimestrais(3));
                b=b+"\n";
            }
            else{
                c = (c+"\n"+this.p.Materias.get(i).Nome+"\nN1: "+this.p.Materias.get(i).getNotasbimestrais(0)+"\nN2: "+this.p.Materias.get(i).getNotasbimestrais(1)+"\nN3: "+this.p.Materias.get(i).getNotasbimestrais(2)+"\nN4: "+this.p.Materias.get(i).getNotasbimestrais(3));
                c=c+"\n";
            }
            
            
        }
        JOptionPane.showMessageDialog(null, a);
        JOptionPane.showMessageDialog(null, b);
        JOptionPane.showMessageDialog(null, c);
        
        
    }//GEN-LAST:event_BoletimActionPerformed

    private void salvarJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarJogoActionPerformed
       //Aqui tu salva no banco (update) , pode brincar a vontade , só n muda nome de variavel de botão se n fodeu
       
       for(int i = 0 ; i <15 ; i ++){
            DAO.updateFaltas(this.p.Materias.get(i).getNome(),this.p.Materias.get(i).faltas);
            DAO.updateNotaB1(this.p.Materias.get(i).Nome, this.p.Materias.get(i).Notasbimestrais[0]);
            DAO.updateNotaB2(this.p.Materias.get(i).Nome, this.p.Materias.get(i).Notasbimestrais[1]);
            DAO.updateNotaB3(this.p.Materias.get(i).Nome, this.p.Materias.get(i).Notasbimestrais[2]);
            DAO.updateNotaB4(this.p.Materias.get(i).Nome, this.p.Materias.get(i).Notasbimestrais[3]);
        }
       for(int i = 0 ; i <15 ; i ++){
            DAO.updateAfeto(this.p.Materias.get(i).professor.Nome, this.p.Materias.get(i).professor.afetividade);
            DAO.updateAfeto(this.p.Materias.get(i).professor.Nome, this.p.Materias.get(i).professor.desafeto);
        }
       JOptionPane.showMessageDialog(null,tempo.df.format(tempo.dt1));
       
       
       
      
       DAO.updateTempo(tempo.df.format(tempo.dt1), tempo.diaSemana,tempo.bimestre);
       
       
       
       
       DAO.updateDinheiro(this.p.Nome,this.p.money);
       DAO.updateHumor(this.p.Nome,this.p.Humor);
       JOptionPane.showMessageDialog(null,"Jogo Salvo!");
    }//GEN-LAST:event_salvarJogoActionPerformed

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
            java.util.logging.Logger.getLogger(tOpcoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tOpcoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tOpcoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tOpcoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tOpcoes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Boletim;
    private javax.swing.JLabel Fundoo;
    private javax.swing.JLabel Hora;
    private javax.swing.JButton IrCasa;
    private javax.swing.JButton IrLanchar;
    private javax.swing.JButton Nada;
    private javax.swing.JLabel bimText;
    private javax.swing.JLabel bimValor;
    private javax.swing.JLabel data;
    private javax.swing.JLabel diaSemana;
    private javax.swing.JButton interagir;
    private javax.swing.JButton irPraAula;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel money;
    private javax.swing.JLabel opcoesText;
    private javax.swing.JButton salvarJogo;
    private javax.swing.JLabel vDataNova;
    private javax.swing.JLabel vDataNova1;
    private javax.swing.JLabel valorText;
    // End of variables declaration//GEN-END:variables
}
