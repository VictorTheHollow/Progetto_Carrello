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
 * La classe {@code Configurazione} gestisce i parametri di configurazione
 * dell'applicazione, come la percentuale IVA e il numero dell'ultimo ordine.
 * <p>
 * I dati vengono salvati e letti da un file di testo per mantenere
 * la persistenza tra le esecuzioni del programma.
 * </p>
 * 
 * @author Utente
 */
public class Configurazione implements Serializable {
    private double percentualeIVA;
    private int NumeroUltimoOrdine;
    private final String nomeFile = "configurazione.txt";

    /**
     * Costruttore della classe Configurazione.
     * Se il file di configurazione non esiste, viene creato con
     * valori di default.
     */
    public Configurazione() throws IOException, Exception {
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
            percentualeIVA = Double.parseDouble(v1);
            NumeroUltimoOrdine = (int) Double.parseDouble(v2);

        } catch (Exception e) {
            throw new RuntimeException("Errore in lettura configurazione", e);
        }
    }

    /**
     * Salva i parametri di configurazione nel file.
     */
    public void salvaConfigurazione() throws IOException, Exception {
        try (PrintWriter pw = new PrintWriter(new FileWriter(nomeFile))) {
            pw.println("Percentuale IVA: " + percentualeIVA);
            pw.println("Numero dell'ultimo ordine: " + NumeroUltimoOrdine);
        } catch (Exception e) {
            throw new Exception("Errore in scrittura configurazione");
        }
    }

    /**
     * Imposta il numero dell'ultimo ordine.
     * 
     * @param NumeroUltimoOrdine nuovo numero dell'ultimo ordine
     */
    public void setNumeroUltimoOrdine(int NumeroUltimoOrdine) {
        this.NumeroUltimoOrdine = NumeroUltimoOrdine;
    }

    /**
     * Incrementa di uno il numero dell'ultimo ordine.
     */
    public void incrementoNumeroOrdine() {
        NumeroUltimoOrdine++;
    }

    /**
     * Restituisce il numero dell'ultimo ordine.
     * @return numero dell'ultimo ordine
     */
    public int getNumeroUltimoOrdine() {
        return NumeroUltimoOrdine;
    }

    /**
     * Restituisce la percentuale IVA.
     * @return percentuale IVA
     */
    public double getPercentualeIVA() {
        return percentualeIVA;
    }
}