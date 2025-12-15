/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrellodellaspesa;
import java.io.Serializable;

/**
 *
 * @author Utente
 */
public class Prodotto implements Serializable{
    private String codice;
    private String descrizione;
    private int quantita;
    private double prezzo;

    public Prodotto(String codice, String descrizione, int quantita, double prezzo) {
        this.codice = codice;
        this.descrizione = descrizione;
        this.quantita = quantita;
        this.prezzo = prezzo;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public String getCodice() {
        return codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public int getQuantita() {
        return quantita;
    }

    public double getPrezzo() {
        return prezzo;
    } 
}
