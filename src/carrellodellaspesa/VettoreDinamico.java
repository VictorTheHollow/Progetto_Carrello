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
public class VettoreDinamico implements Serializable{
    private static final int MAX_DEFAULT = 100;
    private Prodotto[] v;
    private int numero;
    
    public VettoreDinamico() {
        this(MAX_DEFAULT);        
    }
    
    public VettoreDinamico(int dimensione) {
        if (dimensione < 0) 
            dimensione=-dimensione;
        if (dimensione == 0) dimensione = 1;        
        v=new Prodotto[dimensione];
        numero=0;
    }
    
    public void aggiungi(Prodotto p) {
        if (numero >= v.length) {
            aumentaVettore();            
        }
        v[numero] = p;
        numero++;        
    }

    public int lunghezza() {
        return numero;
    }
    
    public boolean isEmpty() {
        return numero==0;
    }
    
    /**
     * Ritorna la stringa in una certa posizione
     * @param posizione Posizione della stringa
     * @return String in quella posizione
     */
    public Prodotto get(int posizione) {
        if (posizione < 0 || posizione >= numero)
            throw new ArrayIndexOutOfBoundsException("Posizione errata!");
        return v[posizione];
    }
    
    private void aumentaVettore() {
        Prodotto[] vNew = new Prodotto[v.length*2];
        for (int i = 0; i < v.length; i++) {                
            vNew[i]=v[i];                
        }
        v=vNew;    
    }
    /**
     * Elimina una stringa in una determinata posizione
     * 
     * @param posizione Posizione in cui eliminare la stringa
     */
    public void elimina(int posizione) {
        if(posizione >= numero || posizione < 0){
            throw new ArrayIndexOutOfBoundsException("Posizione errata!");
        }
        for (int i = posizione; i < numero-1; i++) {
            v[i] = v[i+1];
        }
        v[numero - 1] = null;
        numero--;
    }
    
    public void svuota() {
        for (int i = 0; i < numero; i++) {
            v[i] = null;
        }
        numero = 0;
    }
}



