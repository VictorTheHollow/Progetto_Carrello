/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrellodellaspesa;

/**
 *
 * @author Utente
 */
import java.util.Scanner;


public class Tastiera {
    private Scanner scanner;
    private String riga;
    
    public Tastiera() {
        scanner = new Scanner(System.in);
    }
    public int inputIntero(String msg, int vMax, int vMin) {
        System.out.println(msg);
        int n = scanner.nextInt();
        if (n > vMax || n < vMin) throw new RuntimeException("Valori non accettabili, il valore deve essere compreso tra "+vMin+" e "+vMax);
        return n;
    }
    public double inputDouble(String msg, double vMax, double vMin) {
        System.out.println(msg);
        double n = scanner.nextDouble();
        if (n > vMax || n < vMin) throw new RuntimeException("Valori non accettabili, il valore deve essere compreso tra "+vMin+" e "+vMax);
        return n;
    }
    public String inputStringa(String msg, int vMax, int vMin) {
        System.out.println(msg);
        riga = scanner.nextLine();
        return riga;        
    }
}
