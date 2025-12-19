/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrellodellaspesa;

import java.io.Serializable;

/**
 * La classe Carrello rappresenta un carrello della spesa.
 * Gestisce un insieme di prodotti, permettendo di aggiungerli,
 * rimuoverli e consultarli. 
 * @author Utente
 */
public class Carrello implements Serializable {

    /** Vettore dinamico che contiene i prodotti del carrello */
    private VettoreDinamico prodotti;

    /**
     * Costruttore della classe Carrello.
     * Inizializza il carrello come vuoto.
     */
    public Carrello() {
        prodotti = new VettoreDinamico();
    }

    /**
     * Aggiunge un prodotto al carrello.
     * Se il prodotto è già presente (stesso codice),
     * viene aggiornata la quantità.
     * @param p prodotto da aggiungere
     */
    public void aggiungiProdotto(Prodotto p) {
        boolean trovato = false;
        for (int i = 0; i < prodotti.lunghezza() && !trovato; i++) {
            if (prodotti.get(i).getCodice().equalsIgnoreCase(p.getCodice())) {
                prodotti.get(i).setQuantita(
                        prodotti.get(i).getQuantita() + p.getQuantita()
                );
                trovato = true;
            }
        }
        if (!trovato) {
            prodotti.aggiungi(p);
        }
    }

    /**
     * Rimuove un prodotto dal carrello in base al codice.
     * 
     * La quantità del prodotto rimosso viene restituita al magazzino.
     * 
     * @param codice codice del prodotto da rimuovere
     * @param magazzino vettore dei prodotti presenti in magazzino
     * @return true se il prodotto è stato rimosso,
     *         false se non è stato trovato
     */
    public boolean rimuoviProdotto(String codice, VettoreDinamico magazzino) {
        boolean trovato = false;
        for (int i = 0; i < prodotti.lunghezza(); i++) {
            if (prodotti.get(i).getCodice().equalsIgnoreCase(codice)) {
                for (int k = 0; k < magazzino.lunghezza(); k++) {
                    if (magazzino.get(k).getCodice().equalsIgnoreCase(codice)) {
                        magazzino.get(k).setQuantita(
                                magazzino.get(k).getQuantita()
                                + prodotti.get(i).getQuantita()
                        );
                    }
                }
                prodotti.elimina(i);
                trovato = true;
            }
        }
        return trovato;
    }

    /**
     * Restituisce l'elenco dei prodotti presenti nel carrello.
     * @return vettore dinamico dei prodotti
     */
    public VettoreDinamico getProdotti() {
        return prodotti;
    }
}
