/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrellodellaspesa;

/**
 * La classe gestisce l'inserimento dei dati da tastiera tramite un oggetto.
 * Fornisce metodi per leggere numeri interi, numeri decimali e stringhe,
 * con controllo sui valori inseriti.
 * @author Utente
 */
import java.util.Scanner;


public class Tastiera {
    private Scanner scanner;
    private String riga;
    /**
     * Costruttore della classe Tastiera.
     * Inizializza lo scanner per la lettura da tastiera.
     */
    public Tastiera() {
        scanner = new Scanner(System.in);
    }

    /**
     * Legge un numero intero mostrando il messaggio sulla stessa riga.
     * @param msg messaggio da visualizzare
     * @param vMax valore massimo accettabile
     * @param vMin valore minimo accettabile
     * @return numero intero inserito
     */
    public int inputInteroSeguito(String msg, int vMax, int vMin) {
        System.out.printf(msg);
        int n = scanner.nextInt();
        if (n > vMax || n < vMin)
            throw new RuntimeException(
                "Valori non accettabili, il valore deve essere compreso tra " + vMin + " e " + vMax
            );
        return n;
    }

    /**
     * Legge un numero intero mostrando il messaggio su una nuova riga.
     * @param msg messaggio da visualizzare
     * @param vMax valore massimo accettabile
     * @param vMin valore minimo accettabile
     * @return numero intero inserito
     */
    public int inputIntero(String msg, int vMax, int vMin) {
        System.out.println(msg);
        int n = scanner.nextInt();
        if (n > vMax || n < vMin)
            throw new RuntimeException(
                "Valori non accettabili, il valore deve essere compreso tra " + vMin + " e " + vMax
            );
        return n;
    }

    /**
     * Legge un numero decimale (double) da tastiera.
     * @param msg messaggio da visualizzare
     * @param vMax valore massimo accettabile
     * @param vMin valore minimo accettabile
     * @return numero decimale inserito
     */
    public double inputDouble(String msg, double vMax, double vMin) {
        System.out.println(msg);
        double n = scanner.nextDouble();
        if (n > vMax || n < vMin)
            throw new RuntimeException(
                "Valori non accettabili, il valore deve essere compreso tra " + vMin + " e " + vMax
            );
        return n;
    }

    /**
     * Legge una stringa mostrando il messaggio sulla stessa riga.
     * @param msg messaggio da visualizzare
     * @return stringa inserita dall'utente
     */
    public String inputStringaSeguito(String msg) {
        System.out.printf(msg);
        scanner.nextLine();
        riga = scanner.nextLine();
        return riga;
    }

    /**
     * Legge una stringa mostrando il messaggio su una nuova riga.
     * @param msg messaggio da visualizzare
     * @return stringa inserita dall'utente
     */
    public String inputStringa(String msg) {
        System.out.println(msg);
        scanner.nextLine(); // pulizia buffer
        riga = scanner.nextLine();
        return riga;
    }
}
