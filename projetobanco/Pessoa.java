package projetobanco;

public abstract class Pessoa {
    
    String Nome;
    int Inteligencia;
    int Finança;
    int Humor;

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public int getInteligencia() {
        return Inteligencia;
    }

    public void setInteligencia(int Inteligencia) {
        this.Inteligencia = Inteligencia;
    }

    public int getFinança() {
        return Finança;
    }

    public void setFinança(int Finança) {
        this.Finança = Finança;
    }

    public int getHumor() {
        return Humor;
    }

    public void setHumor(int Humor) {
        this.Humor = Humor;
    }
    
    public abstract void definirCaracteristicas(String nome,int Inteligencia,int Finança, int Humor)throws Exception;
    
}
