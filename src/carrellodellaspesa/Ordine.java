/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrellodellaspesa;

import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Utente
 */
/**
 * La classe {@code Ordine} rappresenta un ordine effettuato
 * a partire da un carrello della spesa.
 * <p>
 * Un ordine contiene il numero identificativo, la data,
 * l'elenco dei prodotti acquistati e i valori economici
 * (imponibile, IVA e totale).
 * </p>
 * 
 * @author Utente
 */
public class Ordine {
    private int numero;
    private String data;
    private VettoreDinamico prodotti;
    private double imponibile;
    private double iva;
    private double totale;

    /**
     * Costruttore della classe Ordine.
     * Crea un nuovo ordine a partire dal carrello e dalla configurazione.
     * @param carrello carrello contenente i prodotti acquistati
     * @param config configurazione dell'applicazione
     */
    public Ordine(Carrello carrello, Configurazione config) {
        numero = config.getNumeroUltimoOrdine() + 1;

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        data = LocalDate.now().format(format);

        prodotti = carrello.getProdotti();
        imponibile = calcolaImponibile();

        iva = Math.round(imponibile * config.getPercentualeIVA()) / 100.0;
        totale = Math.round((imponibile + iva) * 100) / 100.0;
    }

    /**
     * Calcola l'imponibile dell'ordine sommando
     * il prezzo dei prodotti per la rispettiva quantità.
     * @return imponibile dell'ordine
     */
    public double calcolaImponibile() {
        imponibile = 0;
        for (int i = 0; i < prodotti.lunghezza(); i++) {
            Prodotto p = prodotti.get(i);
            imponibile += p.getPrezzo() * p.getQuantita();
        }
        return imponibile;
    }

    /**
     * Salva i dati dell'ordine in un file di testo.
     * Il nome del file corrisponde al numero dell'ordine.
     * @throws Exception se si verifica un errore durante il salvataggio
     */
    public void salvaSuFile() throws Exception {
        String nome = numero + ".txt";

        try (PrintWriter pw = new PrintWriter(nome)) {

            pw.println("ORDINE N° " + numero);
            pw.println("Data: " + data);
            pw.println("Prodotti:");

            for (int i = 0; i < prodotti.lunghezza(); i++) {
                pw.println("- " + prodotti.get(i).getDescrizione()
                        + " x" + prodotti.get(i).getQuantita());
            }

            pw.println("Imponibile: " + imponibile);
            pw.println("IVA: " + iva);
            pw.println("Totale: " + totale);

        } catch (Exception e) {
            throw new Exception("Errore nel salvataggio");
        }
    }

    /**
     * Restituisce il numero dell'ordine.
     * @return numero dell'ordine
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Restituisce la data dell'ordine.
     * @return data dell'ordine
     */
    public String getData() {
        return data;
    }

    /**
     * Restituisce i prodotti dell'ordine.
     * @return vettore dei prodotti
     */
    public VettoreDinamico getProdotti() {
        return prodotti;
    }

    /**
     * Restituisce l'imponibile dell'ordine.
     * @return imponibile
     */
    public double getImponibile() {
        return imponibile;
    }

    /**
     * Restituisce l'importo IVA dell'ordine.
     * @return IVA
     */
    public double getIva() {
        return iva;
    }

    /**
     * Restituisce il totale dell'ordine.
     * @return totale
     */
    public double getTotale() {
        return totale;
    }
}
