package projetobanco;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PersonPrincipal extends Pessoa{
    
    int sorte;
    int coragem;
    int carisma;
    int horasEstudadas;
    float money =0;
    ArrayList <Materia> Materias= new ArrayList();

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }
    
    public boolean verificarCompra(float valor){
        if(this.money < valor){
            JOptionPane.showMessageDialog(null,"Dinheiro Insuficiente");
            return false;
        }
        else{
            this.money-=valor;
            JOptionPane.showMessageDialog(null,"Compra Realizada");
            return true;
        }
    }

    public void setMaterias(ArrayList<Materia> Materias) {
        this.Materias = Materias;
    }

    public void mesada(){
        this.setMoney((this.getMoney() + (this.Finança*20)));
    }
    
    public void setMoneyInicio(){
        this.setMoney(this.getFinança() * 20);
    }
    
    
    public int getSorte() {
        return sorte;
    }

    public void setSorte(int sorte) {
        this.sorte = sorte;
    }

    public int getCoragem() {
        return coragem;
    }

    public void setCoragem(int coragem) {
        this.coragem = coragem;
    }

    public int getCarisma() {
        return carisma;
    }

    public void setCarisma(int carisma) {
        this.carisma = carisma;
    }

    public int getHorasEstudadas() {
        return horasEstudadas;
    }

    public void setHorasEstudadas(int horasEstudadas) {
        this.horasEstudadas = horasEstudadas;
    }
    
    public void adicionarMatéria(String nome , int dificuldade , String nomeProf) throws FileNotFoundException{
        Materia temp = new Materia();
        temp.setNome(nome);
        temp.setDificuldade(dificuldade);
        temp.definirProfessor(nomeProf);
        this.Materias.add(temp);
        
    }

    @Override
    public void definirCaracteristicas(String nome,  int Inteligencia, int Finança, int Humor) throws Exception{

        if(nome.equals("")){
            throw new Exception();
        }
        
        this.setNome(nome);
        this.setInteligencia(Inteligencia);
        this.setFinança(Finança);
        this.setHumor(Humor);
        
    }
    
    public void calcularNota(int indiceMateria , int indiceNota){
    
        float nota = ((this.getHorasEstudadas()/this.Materias.size()*this.getInteligencia())/this.Materias.get(indiceMateria).getDificuldade() - (this.Materias.get(indiceMateria).professor.getDesafeto()/this.Materias.get(indiceMateria).professor.getHumor()));
        
        if(nota < 0){
            nota = 0;
        }
        if(nota > 10){
            nota = 10;
        }
        
        this.Materias.get(indiceMateria).setNotasbimestrais(indiceNota, nota);
        
        
    }
    
    
}
