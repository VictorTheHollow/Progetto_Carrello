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
public class Carrello implements Serializable{
    private VettoreDinamico prodotti;

    public Carrello() {
        prodotti = new VettoreDinamico();
    }
    public void aggiungiProdotto(Prodotto p) {
        boolean trovato = false;
        for(int i = 0; i < prodotti.lunghezza() && !trovato; i++){
            if(prodotti.get(i).getCodice().equalsIgnoreCase(p.getCodice())){
                prodotti.get(i).setQuantita(prodotti.get(i).getQuantita() + p.getQuantita());
                trovato = true;
            }
        }
        if(!trovato){
            prodotti.aggiungi(p);
        }
    }
    
    public boolean rimuoviProdotto(String codice, VettoreDinamico magazzino){
        boolean trovato = false;
        for (int i = 0; i < prodotti.lunghezza(); i++) {
            if(prodotti.get(i).getCodice().equalsIgnoreCase(codice)){
                magazzino.get(i).setQuantita(magazzino.get(i).getQuantita() + prodotti.get(i).getQuantita());
                prodotti.elimina(i);
                trovato = true;
            }
        }
        return trovato;
    }    
    public VettoreDinamico getProdotti() {
        return prodotti;
    }
}
