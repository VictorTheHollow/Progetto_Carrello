/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrellodellaspesa;

import java.io.Serializable;

/**
 * La classe VettoreDinamico implementa una struttura dati
 * (array dinamico) per oggetti di tipo Prodotto.
 * Il vettore aumenta automaticamente la sua dimensione quando
 * lo spazio disponibile termina.
 * 
 * @author Utente
 */
public class VettoreDinamico implements Serializable {
    private static final int MAX_DEFAULT = 100;
    private Prodotto[] v;
    private int numero;
    /**
     * Costruttore di default.
     * Inizializza il vettore con dimensione predefinita.
     */
    public VettoreDinamico() {
        this(MAX_DEFAULT);
    }

    /**
     * Costruttore con dimensione specificata.
     * @param dimensione dimensione iniziale del vettore
     */
    public VettoreDinamico(int dimensione) {
        if (dimensione < 0)
            dimensione = -dimensione;
        if (dimensione == 0)
            dimensione = 1;

        v = new Prodotto[dimensione];
        numero = 0;
    }

    /**
     * Aggiunge un prodotto al vettore.
     * Se il vettore è pieno, la sua dimensione viene aumentata.
     * @param p prodotto da aggiungere
     */
    public void aggiungi(Prodotto p) {
        if (numero >= v.length) {
            aumentaVettore();
        }
        v[numero] = p;
        numero++;
    }

    /**
     * Restituisce il numero di elementi presenti nel vettore.
     * @return numero di elementi
     */
    public int lunghezza() {
        return numero;
    }

    /**
     * Verifica se il vettore è vuoto.
     * @return true se il vettore è vuoto, false altrimenti;
     */
    public boolean isEmpty() {
        return numero == 0;
    }

    /**
     * Restituisce il prodotto presente in una certa posizione.
     * @param posizione posizione dell'elemento
     * @return prodotto nella posizione indicata
     */
    public Prodotto get(int posizione) {
        if (posizione < 0 || posizione >= numero)
            throw new ArrayIndexOutOfBoundsException("Posizione errata!");
        return v[posizione];
    }

    /**
     * Raddoppia la dimensione del vettore quando è pieno.
     */
    private void aumentaVettore() {
        Prodotto[] vNew = new Prodotto[v.length * 2];
        for (int i = 0; i < v.length; i++) {
            vNew[i] = v[i];
        }
        v = vNew;
    }

    /**
     * Elimina il prodotto presente in una determinata posizione.
     * @param posizione posizione dell'elemento da eliminare
     */
    public void elimina(int posizione) {
        if (posizione >= numero || posizione < 0) {
            throw new ArrayIndexOutOfBoundsException("Posizione errata!");
        }
        for (int i = posizione; i < numero - 1; i++) {
            v[i] = v[i + 1];
        }
        v[numero - 1] = null;
        numero--;
    }

    /**
     * Svuota completamente il vettore eliminando tutti gli elementi.
     */
    public void svuota() {
        for (int i = 0; i < numero; i++) {
            v[i] = null;
        }
        numero = 0;
    }
}



