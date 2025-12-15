/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrellodellaspesa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

/**
 *
 * @author Utente
 */
public final class Configurazione implements Serializable{
    private double percentualeIVA;   ;
    private int NumeroUltimoOrdine;
    private final String nomeFile = "configurazione.txt";
    public Configurazione() throws FileNotFoundException, IOException, Exception{
        File file = new File(nomeFile);
        
        if(!file.exists()){
            percentualeIVA = 22;
            NumeroUltimoOrdine = 0;
            salvaConfigurazione();    
        } else {
            try(BufferedReader br = new BufferedReader(new FileReader(file))){
                String l1 = br.readLine();
                NumeroUltimoOrdine = Integer.parseInt(l1);
                String l2 = br.readLine();
                percentualeIVA = Double.parseDouble(l2);
            } catch(Exception e) {
                throw new RuntimeException("Errore in lettura!!");
            }
        }
    }
    public void salvaConfigurazione() throws IOException, Exception {
        try (PrintWriter pw = new PrintWriter(new FileWriter(nomeFile))) {
            pw.println("Percentuale IVA: " + percentualeIVA);
            pw.println("Numero dell'ultimo ordine: " + NumeroUltimoOrdine);
        } catch(Exception e) {
            throw new Exception("Errore in lettura");
        }
    }

    public void incrementoNumeroOrdine(){
        NumeroUltimoOrdine++;
    }
    
    public int getNumeroUltimoOrdine() {
        return NumeroUltimoOrdine;
    }

    public double getPercentualeIVA() {
        return percentualeIVA;
    }
    
}
