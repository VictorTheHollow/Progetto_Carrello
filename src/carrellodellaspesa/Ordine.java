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
public class Ordine {
    private int numero;
    private String data;
    private VettoreDinamico prodotti;
    private double imponibile;
    private double iva;
    private double totale;

    public Ordine(Carrello carrello, Configurazione config) {      
        numero = config.getNumeroUltimoOrdine() + 1;
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        data = LocalDate.now().format(format);
        prodotti = carrello.getProdotti();
        imponibile = calcolaImponibile(); 
        iva = imponibile * config.getPercentualeIVA() / 100.0;
        totale =  imponibile + iva;
    }
    public double calcolaImponibile(){
        imponibile = 0;
        for (int i = 0; i < prodotti.lunghezza(); i++) {
            Prodotto p = prodotti.get(i);
            imponibile += p.getPrezzo() * p.getQuantita();
        } 
        return imponibile;
    }
    public void salvaSuFile() throws Exception {
        String nome = numero + ".txt";

        try (PrintWriter pw = new PrintWriter(nome)) {

            pw.println("ORDINE N° " + numero);
            pw.println("Data: " + data);
            pw.println("Prodotti:");

            for (int i = 0; i < prodotti.lunghezza(); i++) {
                pw.println("- " + prodotti.get(i).getDescrizione());
            }
            pw.println("Imponibile: " + imponibile);
            pw.println("IVA: " + iva);
            pw.println("Totale: " + totale);

        } catch (Exception e) {
            throw new Exception("Errore nel salvataggio");
        }
    }

    public int getNumero() {
        return numero;
    }

    public String getData() {
        return data;
    }

    public VettoreDinamico getProdotti() {
        return prodotti;
    }

    public double getImponibile() {
        return imponibile;
    }

    public double getIva() {
        return iva;
    }

    public double getTotale() {
        return totale;
    }
}
