package projetobanco;

import java.sql.*;

public class FuncoesBanco {
    public Connection connect(){
        Connection conn = null;
        String url = "jdbc:sqlite:ifal.db";
        try{            
            conn= DriverManager.getConnection(url);
        } catch(SQLException e){
            System.out.println("ERRO: "+e.getMessage());
        }
        return conn;
    }  
    
   //=--==--= CRIAR TABELA =-=-=-=-
    
    public void createMateria(){
        Statement stmt = null;
        String sql = "CREATE TABLE materia("+
                "nome VARCHAR(50) PRIMARY KEY,"+
                "dificuldade INTEGER NOT NULL,"+
                "faltas INTEGER,"+
                "notab1 DOUBLE,"+
                "notab2 DOUBLE,"+
                "notab3 DOUBLE,"+
                "notab4 DOUBLE,"+
                "media DOUBLE,"+
                "professor_nome VARCHAR(50),"+
                "FOREIGN KEY (professor_nome) REFERENCES professor (nome)"+
                ");";
        try(Connection conn = this.connect()){
            stmt = conn.createStatement();
            stmt.execute(sql);
            //stmt.close();
            //conn.close();
        } catch(SQLException e){
            System.out.println("ERRO: "+e.getMessage());
        }
    }
    
    public  void createProfessor(){
        Statement stmt = null;
        String url = "jdbc:sqlite:ifal.db";
        String sql = "CREATE TABLE professor("+
                "nome VARCHAR(50) PRIMARY KEY,"+
                "afeto INTEGER,"+
                "desafeto INTEGER"+
                ");";
        try(Connection conn = this.connect()){
            stmt = conn.createStatement();
            stmt.execute(sql);
            //stmt.close();
            //conn.close();
        } catch(SQLException e){
            System.out.println("ERRO: "+e.getMessage());
        }
    }
    
    public void createTempo(){
        Statement stmt = null;
        String sql = "CREATE TABLE tempo("+
                "data_atual VARCHAR(50) PRIMARY KEY,"+
                "dia_semana INTEGER,"+
                "bimestre INTEGER"+
                ");";
        try(Connection conn = this.connect()){
            stmt = conn.createStatement();
            stmt.execute(sql);
            //stmt.close();
            //conn.close();
        } catch(SQLException e){
            System.out.println("ERRO: "+e.getMessage());
        }
    }
    
    public void createPersonPrincipal(){
        Statement stmt = null;
        String sql = "CREATE TABLE personagem("+
                "nome VARCHAR(50) PRIMARY KEY,"+
                "carisma INTEGER,"+
                "humor INTEGER,"+
                "financa INTEGER,"+
                "inteligencia INTEGER,"+
                "dinheiro DOUBLE,"+
                "horas INTEGER"+
                ");";
        try(Connection conn = this.connect()){
            stmt = conn.createStatement();
            stmt.execute(sql);
            //stmt.close();
            //conn.close();
        } catch(SQLException e){
            System.out.println("ERRO: "+e.getMessage());
        }
    }
    
    //=--=-=-=-=-=-=-=-=-=-=-= INSERIR -==--=-=-=
    
    public void inserirProfessor(String nome, int afeto, int desafeto){
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO professor(nome,afeto,desafeto) VALUES(?,?,?);";
        
        try(Connection conn = this.connect()){
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nome);
            pstmt.setInt(2, afeto);
            pstmt.setInt(3, desafeto);
            pstmt.executeUpdate();
            //pstmt.close();
            //conn.close();

            
        } catch(SQLException e){
            System.out.println("ERRO: "+e.getMessage());
        }
    }
    
    public void inserirTempo(String data_atual, int dia_semana, int bimestre){
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO tempo(data_atual,dia_semana,bimestre) VALUES(?,?,?);";
        try(Connection conn = this.connect()){
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, data_atual);
            pstmt.setInt(2, dia_semana);
            pstmt.setInt(3, bimestre);
            pstmt.executeUpdate();
            //pstmt.close();
            //conn.close();
            
                    
        } catch(SQLException e){
            System.out.println("ERRO: "+e.getMessage());
        }
    }
    
    public void inserirPersonagem(String nome, int carisma, int humor, int financa, int inteligencia, double dinheiro, int horas){
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO personagem(nome,carisma,humor,financa,inteligencia,dinheiro,horas) VALUES(?,?,?,?,?,?,?);";
        try(Connection conn = this.connect()){
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nome);
            pstmt.setInt(2, carisma);
            pstmt.setInt(3, humor);
            pstmt.setInt(4, financa);
            pstmt.setInt(5, inteligencia);
            pstmt.setDouble(6, dinheiro);
            pstmt.setInt(7, horas);
            pstmt.executeUpdate();
            //pstmt.close();
            //conn.close();
            
            } catch(SQLException e){
                System.out.println("ERRO: "+e.getMessage());
            }
    }
    
    //-==-=--==-=-=-UPDATE-=--=
    
    //Banco de Dados Matéria
    public void updateFaltas(String nome, int faltas){
        PreparedStatement pstmt = null;
        String sql = "UPDATE materia SET faltas = ?"
                + "WHERE nome = ?;";
        
        try(Connection conn = this.connect()){
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, faltas);
            pstmt.setString(2, nome);
            pstmt.executeUpdate();
            //pstmt.close();
            //conn.close();            
        } catch(SQLException e){
            System.out.println("ERRO: "+e.getMessage());
        }
    }
    
    public void updateNotaB1(String nome, double notab1){
        PreparedStatement pstmt = null;
        String sql = "UPDATE materia SET notab1 = ?"+
                "WHERE nome = ?;";
        try(Connection conn = this.connect()){
            pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, notab1);
            pstmt.setString(2, nome);
            pstmt.executeUpdate();
            //pstmt.close();
            //conn.close();
            
        } catch (SQLException e){
            System.out.println("ERRO: "+e.getMessage());
        }
    }
    
    public void updateNotaB2(String nome, double notab2){
        PreparedStatement pstmt = null;
        String sql = "UPDATE materia SET notab2 = ?"+
                "WHERE nome = ?;";
        try(Connection conn = this.connect()){
            pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, notab2);
            pstmt.setString(2, nome);
            pstmt.executeUpdate();
            //pstmt.close();
            //conn.close();
            
        } catch (SQLException e){
            System.out.println("ERRO: "+e.getMessage());
        }
    }
    
    public void updateNotaB3(String nome, double notab3){
        PreparedStatement pstmt = null;
        String sql = "UPDATE materia SET notab3 = ?"+
                "WHERE nome = ?;";
        try(Connection conn = this.connect()){
            pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, notab3);
            pstmt.setString(2, nome);
            pstmt.executeUpdate();
            //pstmt.close();
            //conn.close();
            
        } catch (SQLException e){
            System.out.println("ERRO: "+e.getMessage());
        }
    }
    
    public void updateNotaB4(String nome, double notab4){
        PreparedStatement pstmt = null;
        String sql = "UPDATE materia SET notab4 = ?"+
                "WHERE nome = ?;";
        try(Connection conn = this.connect()){
            pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, notab4);
            pstmt.setString(2, nome);
            pstmt.executeUpdate();
            //pstmt.close();
            //conn.close();
            
        } catch (SQLException e){
            System.out.println("ERRO: "+e.getMessage());
        }
    }
    
    public void updateMedia(String nome, double media){
        PreparedStatement pstmt = null;
        String sql = "UPDATE materia SET media = ?"+
                "WHERE nome = ?;";
        try(Connection conn = this.connect()){
            pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, media);
            pstmt.setString(2, nome);
            pstmt.executeUpdate();
            //pstmt.close();
            //conn.close();
            
        } catch (SQLException e){
            System.out.println("ERRO: "+e.getMessage());
        }
    }
    
    public void updateMateriaProfessor(String nome, String professor_nome){
        PreparedStatement pstmt = null;
        String sql = "UPDATE materia SET professor_nome = ?"+
                "WHERE nome = ?;";
        try(Connection conn = this.connect()){
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, professor_nome);
            pstmt.setString(2, nome);
            pstmt.executeUpdate();
            //pstmt.close();
            //conn.close();
            
        } catch (SQLException e){
            System.out.println("ERRO: "+e.getMessage());
        }
    }
    
    //-==-=-Banco de Dados do Professor
    
    public void updateAfeto(String nome, int afeto){
        PreparedStatement pstmt = null;
        String sql = "UPDATE professor SET afeto = ?"+
                "WHERE nome = ?;";
        try(Connection conn = this.connect()){
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, afeto);
            pstmt.setString(2, nome);
            pstmt.executeUpdate();
            //pstmt.close();
            //conn.close();
            
        } catch (SQLException e){
            System.out.println("ERRO: "+e.getMessage());
        }
    }
    
    public void updateDesafeto(String nome, int desafeto){
        PreparedStatement pstmt = null;
        String sql = "UPDATE professor SET desafeto = ?"+
                "WHERE nome = ?;";
        try(Connection conn = this.connect()){
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, desafeto);
            pstmt.setString(2, nome);
            pstmt.executeUpdate();
            //pstmt.close();
            //conn.close();
            
        } catch (SQLException e){
            System.out.println("ERRO: "+e.getMessage());
        }
    }
    
    //-==-Banco de Dados de Tempo
    
    public void updateTempo(String dt_atual, int dia_semana, int bimestre){
        PreparedStatement pstmt = null;
        String sql = "UPDATE tempo SET data_atual = ?,"+
                "dia_semana = ?,"+
                "bimestre = ?"+
                "WHERE data_atual = ?;";
        try(Connection conn = this.connect()){
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dt_atual);
            pstmt.setInt(2, dia_semana);
            pstmt.setInt(3, bimestre);
            pstmt.setString(4, this.data_atualT());
            pstmt.executeUpdate();
            //pstmt.close();
            //conn.close();
            
        } catch (SQLException e){
            System.out.println("ERRO: "+e.getMessage());
        }
    }
    
   // =-=--=-==- Banco de Dados Personagem
    
    public void updateDinheiro(String nome, double dinheiro){
        PreparedStatement pstmt = null;
        String sql = "UPDATE personagem SET dinheiro = ?"+
                "WHERE nome = ?;";
        try(Connection conn = this.connect()){
            pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, dinheiro);
            pstmt.setString(2, nome);
            pstmt.executeUpdate();
            //pstmt.close();
            //conn.close();
            
        } catch (SQLException e){
            System.out.println("ERRO: "+e.getMessage());
        }
    }
    
    public void updateHumor(String nome, int humor){
        PreparedStatement pstmt = null;
        String sql = "UPDATE personagem SET humor = ?"+
                "WHERE nome = ?;";
        try(Connection conn = this.connect()){
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, humor);
            pstmt.setString(2, nome);
            pstmt.executeUpdate();
            //pstmt.close();
            //conn.close();
            
        } catch (SQLException e){
            System.out.println("ERRO: "+e.getMessage());
        }
    }
    
    
    public void updateHoras(String nome, int horas){
        PreparedStatement pstmt = null;
        String sql = "UPDATE personagem SET horas = ?"+
                "WHERE nome = ?;";
        try(Connection conn = this.connect()){
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, horas);
            pstmt.setString(2, nome);
            pstmt.executeUpdate();
            //pstmt.close();
            //conn.close();
            
        } catch (SQLException e){
            System.out.println("ERRO: "+e.getMessage());
        }
    }
    
    //-==-=-=-=-=-DELETAR=--=-=-=-=
    
    public void deletarProfessor(){
        Statement stmt = null;
        String sql = "DROP TABLE professor;";
        
        try(Connection conn = this.connect()){
            stmt = conn.createStatement();
            stmt.execute(sql);
            //stmt.close();
            //conn.close();
        } catch (SQLException e){
            System.out.println("ERRO: "+e.getMessage());
        }
    }
    
    public void deletarTempo(){
        Statement stmt = null;
        String sql = "DROP TABLE tempo;";
        
        try(Connection conn = this.connect()){
            stmt = conn.createStatement();
            stmt.execute(sql);
            //stmt.close();
            //conn.close();
            
        } catch (SQLException e){
            System.out.println("ERRO: "+e.getMessage());
        }
    }
    
    public void deletarPersonagem(){
        Statement stmt = null;
        String sql = "DROP TABLE personagem;";
        
        try(Connection conn = this.connect()){
            stmt = conn.createStatement();
            stmt.execute(sql);
            //stmt.close();
            //conn.close();
        } catch (SQLException e){
            System.out.println("ERRO: "+e.getMessage());
        }
    }
    
    public void deletarMateria(String nome){
        PreparedStatement pstmt = null;
        String sql = "UPDATE materia SET faltas = ?,"
                + "notab1 = ?,"
                + "notab2 = ?,"
                + "notab3 = ?,"
                + "notab4 = ?,"
                + "media = ?,"
                + "professor_nome = ?"
                + "WHERE nome = ?;";
        
        try(Connection conn = this.connect()){
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 0);
            pstmt.setDouble(2, 0);
            pstmt.setDouble(3, 0);
            pstmt.setDouble(4, 0);
            pstmt.setDouble(5, 0);
            pstmt.setDouble(6, 0);
            pstmt.setString(7, null);
            pstmt.setString(8, nome);
            pstmt.executeUpdate();
            //pstmt.close();
            //conn.close();
        } catch (SQLException e){
            System.out.println("ERRO: "+e.getMessage());
        }
    }
    
    //-=-=-==-=--==- CARREGAR-=-==--=-=
    
    public String nomeP(){
        Statement stmt = null;
        ResultSet rs = null;
        String nome = null;
        String sql = "SELECT nome FROM personagem;";
        
        try(Connection conn = connect()){
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            nome = rs.getString("nome");
            rs.close();
            //stmt.close();
            //conn.close();
                       
        } catch(SQLException e){
            System.out.println("ERRO: "+e.getMessage());
        }
        
        return nome;
    }
    
    public int carismaP(){
        Statement stmt = null;
        ResultSet rs = null;
        int carisma = 0;
        String sql = "SELECT carisma FROM personagem;";
        
        try(Connection conn = connect()){
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            carisma = rs.getInt("carisma");
            rs.close();
            //stmt.close();
            //conn.close();
                       
        } catch(SQLException e){
            System.out.println("ERRO: "+e.getMessage());
        }
        
        return carisma;
    }
    
    public int humorP(){
        Statement stmt = null;
        ResultSet rs = null;
        int humor = 0;
        String sql = "SELECT humor FROM personagem;";
        
        try(Connection conn = connect()){
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            humor = rs.getInt("humor");
            rs.close();
            //stmt.close();
            //conn.close();
                       
        } catch(SQLException e){
            System.out.println("ERRO: "+e.getMessage());
        }
        
        return humor;
    }

    public int financaP(){
        Statement stmt = null;
        ResultSet rs = null;
        int financa = 0;
        String sql = "SELECT financa FROM personagem;";
        
        try(Connection conn = connect()){
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            financa = rs.getInt("financa");
            rs.close();
            //stmt.close();
            //conn.close();
                       
        } catch(SQLException e){
            System.out.println("ERRO: "+e.getMessage());
        }
        
        return financa;
    }

    public int inteligenciaP(){
        Statement stmt = null;
        ResultSet rs = null;
        int inteligencia = 0;
        String sql = "SELECT inteligencia FROM personagem;";
        
        try(Connection conn = connect()){
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            inteligencia = rs.getInt("inteligencia");
            rs.close();
            //stmt.close();
            //conn.close();
                       
        } catch(SQLException e){
            System.out.println("ERRO: "+e.getMessage());
        }
        
        return inteligencia;
    }
    
    public double dinheiroP(){
        Statement stmt = null;
        ResultSet rs = null;
        double dinheiro = 0;
        String sql = "SELECT dinheiro FROM personagem;";
        
        try(Connection conn = connect()){
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            dinheiro = rs.getInt("dinheiro");
            rs.close();
            //stmt.close();
            //conn.close();
                       
        } catch(SQLException e){
            System.out.println("ERRO: "+e.getMessage());
        }
        
        return dinheiro;
    }
    
    public int horasP(){
        Statement stmt = null;
        ResultSet rs = null;
        int horas = 0;
        String sql = "SELECT horas FROM personagem;";
        
        try(Connection conn = connect()){
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            horas = rs.getInt("horas");
            rs.close();
            //stmt.close();
            //conn.close();
                       
        } catch(SQLException e){
            System.out.println("ERRO: "+e.getMessage());
        }
        
        return horas;
    }
    
    public String data_atualT(){
        Statement stmt = null;
        ResultSet rs = null;
        String data_atual = "";
        String sql = "SELECT data_atual FROM tempo;";
        
        try(Connection conn = connect()){
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            data_atual = rs.getString("data_atual");
            rs.close();
            //stmt.close();
            //conn.close();
                       
        } catch(SQLException e){
            System.out.println("ERRO: "+e.getMessage());
        }
        
        return data_atual;
    }
    
    public int dia_semanaT(){
        Statement stmt = null;
        ResultSet rs = null;
        int dia_semana = 0;
        String sql = "SELECT dia_semana FROM tempo;";
        
        try(Connection conn = connect()){
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            dia_semana = rs.getInt("dia_semana");
            rs.close();
            //stmt.close();
            //conn.close();
                       
        } catch(SQLException e){
            System.out.println("ERRO: "+e.getMessage());
        }
        
        return dia_semana;
    }
    
    public int bimestreT(){
        Statement stmt = null;
        ResultSet rs = null;
        int bimestre = 0;
        String sql = "SELECT bimestre FROM tempo;";
        
        try(Connection conn = connect()){
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            bimestre = rs.getInt("bimestre");
            rs.close();
            //stmt.close();
            //conn.close();
                       
        } catch(SQLException e){
            System.out.println("ERRO: "+e.getMessage());
        }
        
        return bimestre;
    }
    
    public String nomePf(int cont){
        Statement stmt = null;
        ResultSet rs = null;
        String nome= null;
        String sql = "SELECT nome FROM professor;";
        
        try(Connection conn = connect()){
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            for(int i=1; i<=cont;i++){
                rs.next();
                if(i==cont){      
                    nome = rs.getString("nome");
                }
            }
            rs.close();
            //stmt.close();
            //conn.close();
                       
        } catch(SQLException e){
            System.out.println("ERRO: "+e.getMessage());
        }
        
        return nome;
    }
    
    public int afetoPf(int cont){
        Statement stmt = null;
        ResultSet rs = null;
        int afeto= 0;
        String sql = "SELECT afeto FROM professor;";
        
        try(Connection conn = connect()){
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            for(int i=1; i<=cont;i++){
                rs.next();
                if(i==cont){      
                    afeto = rs.getInt("afeto");
                }
            }
            rs.close();
            //stmt.close();
            //conn.close();
                       
        } catch(SQLException e){
            System.out.println("ERRO: "+e.getMessage());
        }
        
        return afeto;
    }
    
    public int desafetoPf(int cont){
        Statement stmt = null;
        ResultSet rs = null;
        int desafeto= 0;
        String sql = "SELECT desafeto FROM professor;";
        
        try(Connection conn = connect()){
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            for(int i=1; i<=cont;i++){
                rs.next();
                if(i==cont){      
                    desafeto = rs.getInt("desafeto");
                }
            }
            rs.close();
            //stmt.close();
            //conn.close();
                       
        } catch(SQLException e){
            System.out.println("ERRO: "+e.getMessage());
        }
        
        return desafeto;
    }
    
    public int faltasM(int cont){
        Statement stmt = null;
        ResultSet rs = null;
        int faltas= 0;
        String sql = "SELECT faltas FROM materia;";
        
        try(Connection conn = connect()){
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            for(int i=1; i<=cont;i++){
                rs.next();
                if(i==cont){      
                    faltas = rs.getInt("faltas");
                }
            }
            rs.close();
            //stmt.close();
            //conn.close();
                       
        } catch(SQLException e){
            System.out.println("ERRO: "+e.getMessage());
        }
        
        return faltas;
    }
    
    public double notab1M(int cont){
        Statement stmt = null;
        ResultSet rs = null;
        double notab1= 0;
        String sql = "SELECT notab1 FROM materia;";
        
        try(Connection conn = connect()){
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            for(int i=1; i<=cont;i++){
                rs.next();
                if(i==cont){      
                    notab1 = rs.getDouble("notab1");
                }
            }
            rs.close();
            //stmt.close();
            //conn.close();
                       
        } catch(SQLException e){
            System.out.println("ERRO: "+e.getMessage());
        }
        
        return notab1;
    }
    
    public double notab2M(int cont){
        Statement stmt = null;
        ResultSet rs = null;
        double notab2= 0;
        String sql = "SELECT notab2 FROM materia;";
        
        try(Connection conn = connect()){
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            for(int i=1; i<=cont;i++){
                rs.next();
                if(i==cont){      
                    notab2 = rs.getDouble("notab2");
                }
            }
            rs.close();
            //stmt.close();
            //conn.close();
                       
        } catch(SQLException e){
            System.out.println("ERRO: "+e.getMessage());
        }
        
        return notab2;
    }
    
    public double notab3M(int cont){
        Statement stmt = null;
        ResultSet rs = null;
        double notab3= 0;
        String sql = "SELECT notab3 FROM materia;";
        
        try(Connection conn = connect()){
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            for(int i=1; i<=cont;i++){
                rs.next();
                if(i==cont){      
                    notab3 = rs.getDouble("notab3");
                }
            }
            rs.close();
            //stmt.close();
            //conn.close();
                       
        } catch(SQLException e){
            System.out.println("ERRO: "+e.getMessage());
        }
        
        return notab3;
    }
    
    public double notab4M(int cont){
        Statement stmt = null;
        ResultSet rs = null;
        double notab4= 0;
        String sql = "SELECT notab4 FROM materia;";
        
        try(Connection conn = connect()){
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            for(int i=1; i<=cont;i++){
                rs.next();
                if(i==cont){      
                    notab4 = rs.getDouble("notab4");
                }
            }
            rs.close();
            //stmt.close();
            //conn.close();
                       
        } catch(SQLException e){
            System.out.println("ERRO: "+e.getMessage());
        }
        
        return notab4;
    }
    
    public double mediaM(int cont){
        Statement stmt = null;
        ResultSet rs = null;
        double media = 0;
        String sql = "SELECT media FROM materia;";
        
        try(Connection conn = connect()){
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            for(int i=1; i<=cont;i++){
                rs.next();
                if(i==cont){      
                    media = rs.getDouble("media");
                }
            }
            rs.close();
            //stmt.close();
            //conn.close();
                       
        } catch(SQLException e){
            System.out.println("ERRO: "+e.getMessage());
        }
        
        return media;
    }
    
    public String professorM(int cont){
        Statement stmt = null;
        ResultSet rs = null;
        String professor_nome = null;
        String sql = "SELECT professor_nome FROM materia;";
        
        try(Connection conn = connect()){
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            for(int i=1; i<=cont;i++){
                rs.next();
                if(i==cont){      
                    professor_nome = rs.getString("professor_nome");
                }
            }
            rs.close();
            //stmt.close();
            //conn.close();
                       
        } catch(SQLException e){
            System.out.println("ERRO: "+e.getMessage());
        }
        
        return professor_nome;
    }
    
    // --> EXECUTE APENAS UMA VEZ, SÓ PARA ADICIONAR O TEMPO EM PERSONAGEM
    
    
}
