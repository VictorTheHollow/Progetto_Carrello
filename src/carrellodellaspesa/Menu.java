/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrellodellaspesa;

/**
 * La classe Menu rappresenta un menu testuale con diverse opzioni selezionabili.
 * Permette di visualizzare le opzioni, acquisire la scelta dell'utente e gestire
 * l'identificazione dell'opzione di uscita.
 * @author Utente
 */
public class Menu {
    private String[] opzioni;
    private int scelta;
    
    /**
     * Costruttore della classe Menu.
     * Crea un nuovo menu a partire da un array di stringhe contenenti le opzioni.
     * @param v Array di stringhe rappresentanti le opzioni del menu.
     * Ogni elemento dell'array corrisponde a una voce del menu.
     */
    public Menu(String[] v) {
        opzioni = new String[v.length];
        for (int i = 0; i < v.length; i++) {
            opzioni[i]=v[i];
        }
    }
    
    /**
     * Visualizza tutte le opzioni del menu sulla console.
     * Le opzioni vengono stampate in sequenza senza interruzioni di riga.
     */
    public void visualizza() {
        for (int i = 0; i < opzioni.length; i++) {
            System.out.printf(opzioni[i]);
        }
    }
    
    /**
     * Acquisisce la scelta dell'utente convertendo una stringa in un intero.
     * Il valore intero rappresenta l'indice dell'opzione selezionata.
     * @param s Stringa contenente il numero corrispondente all'opzione scelta.
     */
    public void inputScelta(String s) {
        int n = Integer.parseInt(s);
        scelta=n;
    }
    
    /**
     * Restituisce l'ultima scelta effettuata dall'utente.
     * @return Un intero rappresentante l'indice dell'opzione selezionata.
     */
    public int getScelta() {
        return scelta;
    }
    
    /**
     * Calcola e restituisce il numero dell'opzione di uscita.
     * L'opzione di uscita è considerata l'ultima opzione del menu.
     * @return Un intero rappresentante il numero dell'ultima opzione (opzione di uscita).
     */
    public int getExit() {
        int n=0;
        for (int i = 0; i < opzioni.length; i++) {
            n=i+1;
        }
        return n;
    }
}