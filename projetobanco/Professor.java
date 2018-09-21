
package projetobanco;

import java.util.Random;


public class Professor extends Pessoa implements CaracteristicasExtras{
    
    int afetividade;
    int desafeto;
    boolean aprovado = false;

    public int getAfetividade() {
        return afetividade;
    }

    public void setAfetividade(int afetividade) {
        this.afetividade = afetividade;
    }

    public int getDesafeto() {
        return desafeto;
    }

    public void setDesafeto(int desafeto) {
        this.desafeto = desafeto;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }

    @Override
    public void definirCaracteristicas(String nome, int Inteligencia, int Finança, int Humor) {
        
        this.setNome(nome);
        this.setInteligencia(Inteligencia);
        this.setFinança(Finança);
        this.setHumor(Humor);
        
    }

    @Override
    public void gerarCaracteristicas(String nome) {
        Random gerador = new Random();
        
        this.definirCaracteristicas(nome, gerador.nextInt(10)+1, gerador.nextInt(10)+1, gerador.nextInt(10)+1);
        this.setAfetividade(gerador.nextInt(10)+1);
        this.setDesafeto(gerador.nextInt(3)+1);
        
        
    }
    
}
