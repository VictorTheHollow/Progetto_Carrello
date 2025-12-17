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
    private double percentualeIVA;
    private int NumeroUltimoOrdine;
    private final String nomeFile = "configurazione.txt";
    public Configurazione() throws FileNotFoundException, IOException, Exception{
        File file = new File(nomeFile);

        if (!file.exists()) {
            percentualeIVA = 22.0;
            NumeroUltimoOrdine = 0;
            salvaConfigurazione();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String r1 = br.readLine();
            String r2 = br.readLine();

            String v1 = r1.split(":")[1].trim();
            String v2 = r2.split(":")[1].trim();

            NumeroUltimoOrdine = (int) Double.parseDouble(v2);
            percentualeIVA = Double.parseDouble(v1);

        } catch (Exception e) {
            throw new RuntimeException("Errore in lettura configurazione", e);
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

    public void setNumeroUltimoOrdine(int NumeroUltimoOrdine) {
        this.NumeroUltimoOrdine = NumeroUltimoOrdine;
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
