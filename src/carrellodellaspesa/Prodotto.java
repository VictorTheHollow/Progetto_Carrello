/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrellodellaspesa;
import java.io.Serializable;

/**
 * Classe bean che si occupa di rappresentare un singolo articolo 
 * @author Utente
 */
public class Prodotto implements Serializable{
    private String codice;
    private String descrizione;
    private int quantita;
    private double prezzo;
    /**
     * Costruttore della classe Prodotto.
     * 
     * @param codice codice del prodotto
     * @param descrizione descrizione del prodotto
     * @param quantita quantità del prodotto
     * @param prezzo prezzo unitario del prodotto
     */
    public Prodotto(String codice, String descrizione, int quantita, double prezzo) {
        this.codice = codice;
        this.descrizione = descrizione;
        this.quantita = quantita;
        this.prezzo = prezzo;
    }
    /**
     * Imposta il codice del prodotto.
     * @param codice nuovo codice del prodotto
     */

    public void setCodice(String codice) {
        this.codice = codice;
    }

    /**
     * Imposta la descrizione del prodotto.
     * @param descrizione nuova descrizione del prodotto
     */
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    /**
     * Imposta la quantità del prodotto.
     * @param quantita nuova quantità del prodotto
     */
    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    /**
     * Imposta il prezzo del prodotto.
     * @param prezzo nuovo prezzo del prodotto
     */
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    /**
     * Restituisce il codice del prodotto.
     * @return codice del prodotto
     */
    public String getCodice() {
        return codice;
    }

    /**
     * Restituisce la descrizione del prodotto.
     * @return descrizione del prodotto
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     * Restituisce la quantità del prodotto.
     * @return quantità del prodotto
     */
    public int getQuantita() {
        return quantita;
    }

    /**
     * Restituisce il prezzo del prodotto.
     * @return prezzo del prodotto
     */
    public double getPrezzo() {
        return prezzo;
    }
}
