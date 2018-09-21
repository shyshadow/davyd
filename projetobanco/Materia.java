package projetobanco;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;


public class Materia {
    
    String Nome;
    int dificuldade;
    int faltas=0;
    float[] Notasbimestrais = new float[4];
    float[] NotasMedias = new float[4];
    Professor professor = new Professor();
    
    public void definirProfessor(String nome) throws FileNotFoundException{
        Professor temp = new Professor();
        
        temp.gerarCaracteristicas(nome);
        this.professor = temp;
    }

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    
    
    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public int getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(int dificuldade) {
        this.dificuldade = dificuldade;
    }


    public float getNotasbimestrais(int indice) {
        return Notasbimestrais[indice];
    }

    public void setNotasbimestrais(int indice ,float valor) {
        this.Notasbimestrais[indice] = valor;
    }

    public float getNotasMedias(int indice) {
        return NotasMedias[indice];
    }

    public void setNotasMedias(int indice , float valor1 ) {
        this.NotasMedias[indice] = valor1;
    }
    
    public boolean aprovação(){
    
        float mediaFinal=0;
        
        for(int i=0 ;i < 4 ; i++){
            
            mediaFinal += this.getNotasbimestrais(i);
            
        }
        mediaFinal/=4;
        
        return mediaFinal>=6;
    }
    
    
}
