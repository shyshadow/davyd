
package projetobanco;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;



public class Tempo {
    
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    Date dt1;
    Date dt2;
    Calendar cal = Calendar.getInstance();
    int diaSemana ;
    int bimestre;
    public Tempo(){
    }
    
    public void recolocar(String d1 , int dia , int bimestre) throws ParseException, FileNotFoundException, IOException{
        this.dt1 = (this.df.parse(""+d1));
        this.diaSemana=dia;
        this.bimestre=bimestre;
        File arquivo = new File("");
        File a = new File(arquivo.getAbsolutePath()+"\\src\\Textos","Bimestre"+this.bimestre+".txt");
        FileReader c = new FileReader(a);
        BufferedReader b = new BufferedReader(c);
        this.dt1=this.df.parse(d1);
        String s = b.readLine();
        this.dt2 = this.df.parse(b.readLine());
        cal.setTime(dt1);

        
    } 
    
    public void novaData() throws IOException, ParseException{
        this.bimestre=1;
        this.diaSemana=1;
        File arquivo = new File("");
        File a = new File(arquivo.getAbsolutePath()+"\\src\\Textos","Bimestre"+this.bimestre+".txt");
        FileReader c = new FileReader(a);
        BufferedReader b = new BufferedReader(c);
        this.dt1 = this.df.parse(b.readLine());
        this.dt2 = this.df.parse(b.readLine());
        cal.setTime(dt1);

        
        
        
        
    }
    
    public void passarDia() throws FileNotFoundException, IOException, ParseException{
        if(!this.df.format(this.dt1).equals(this.df.format(this.dt2))){
            this.cal.add(Calendar.DATE,+1);
            this.dt1 = this.cal.getTime();
            if(this.diaSemana==7){
                this.diaSemana=1;
            }
            else{
                this.diaSemana++;
            }
        }
        else{
            this.bimestre++;
            this.diaSemana=1;
            if(this.bimestre>4){
                return;
            }
            File arquivo = new File("");
            File a = new File(arquivo.getAbsolutePath()+"\\src\\Textos","Bimestre"+this.bimestre+".txt");
            FileReader c = new FileReader(a);
            BufferedReader b = new BufferedReader(c);
            this.dt1 = this.df.parse(b.readLine());
            this.dt2 = this.df.parse(b.readLine());
            cal.setTime(dt1);
            JOptionPane.showMessageDialog(null,+(this.bimestre-1)+"º bimestre acabou começando o Proximo");
        }
    }

    
    
    

    
    
}
