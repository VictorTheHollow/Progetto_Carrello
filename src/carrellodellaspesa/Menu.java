/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrellodellaspesa;

/**
 *
 * @author Utente
 */
public class Menu {
    private String[] opzioni;
    private int scelta;
    
    public Menu(String[] v) {
        for (int i = 0; i < v.length; i++) {
            opzioni[i]=v[i];
        }
    }
    public void visualizza() {
        for (int i = 0; i < opzioni.length; i++) {
            System.out.println(opzioni[i]);
        }
    }
    public void inputScelta(String s) {
        int n = Integer.parseInt(s);
        scelta=n;
    }
    public int getScelta() {
        return scelta;
    }
    public int getExit() {
        int n=0;
        for (int i = 0; i < opzioni.length; i++) {
            n=i+1;
        }
        return n;
    }
}