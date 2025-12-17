/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package carrellodellaspesa;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Utente
 */
public class MainApp {

    public static void main(String[] args) throws Exception {
        VettoreDinamico c = null;
        Configurazione config = new Configurazione();
        Carrello carrello = new Carrello();
        VettoreDinamico magazzino = new VettoreDinamico();
        creaFileBinario(magazzino);
     /* String codice = "P001";
        int quantita = 1;
        for(int i = 0; i < magazzino.lunghezza(); i++){
            Prodotto prodotto = magazzino.get(i);
            if(codice.equalsIgnoreCase(prodotto.getCodice())){
                Prodotto p = new Prodotto(codice, prodotto.getDescrizione(),quantita, prodotto.getPrezzo()); 
                carrello.aggiungiProdotto(prodotto);
                prodotto.setQuantita(prodotto.getQuantita() - 1);
            }
        }
        c = carrello.getProdotti();
        for (int k = 0; k < c.lunghezza(); k++) {
            System.out.println("Elemento " + k + " " + c.get(k).getCodice());
        } */
        menu(carrello, magazzino, c, config);
    }

    private static void creaFileBinario(VettoreDinamico v){
        try {
            File f = new File("prodotti.dat");

            Prodotto p1 = new Prodotto("P001", "Pasta Fusilli 500g", 120, 0.89);
            Prodotto p2 = new Prodotto("P002", "Riso Arborio 1kg", 80, 1.90);
            Prodotto p3 = new Prodotto("P003", "Passata di Pomodoro 700g", 150, 1.10);

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("prodotti.dat"));
            oos.writeObject(p1);
            oos.writeObject(p2);
            oos.writeObject(p3);
            oos.close();
            
            v.aggiungi(p1);
            v.aggiungi(p2);
            v.aggiungi(p3);

            System.out.println("File prodotti.dat creato!");
        } catch (Exception e) {
            System.out.println("Errore creazione file");
        }
    }

    private static void menu(Carrello carrello, VettoreDinamico magazzino, VettoreDinamico c, Configurazione config) throws InterruptedException, Exception {
        boolean rimosso = false;
        Ordine ordine;
        Tastiera tastiera = new Tastiera();
        String[] opzioni = new String[] {
            "\n--------------------\n",
            "1. Inserisci un prodotto\n",
            "2. Visualizza il tuo carrello\n",
            "3. Elimina un prodotto\n",
            "4. Crea l'ordine\n",
            "0. Esci dal programma\n"
        };
        Menu menu = new Menu(opzioni);
        int scelta = 0;
        int quantita;
        String codice;
        do{
            menu.visualizza();
            do{
                scelta = tastiera.inputInteroSeguito("Scelta: ", 4, 0);
            }while(scelta < 0 || scelta > 4);
            System.out.println("");
            switch(scelta){
                case 1:
                    codice = tastiera.inputStringa("Inserire il codice del prodotto" );
                    System.out.println("");
                    quantita = tastiera.inputIntero("Inserirne la quantita'", 900, 1);

                    if (quantita <= 0) {
                        System.out.println("La quantità deve essere maggiore di zero.");
                        break;
                    }

                    boolean trovato = false;

                    for (int i = 0; i < magazzino.lunghezza(); i++) {
                        Prodotto prodotto = magazzino.get(i);

                        if (codice.equalsIgnoreCase(prodotto.getCodice())) {
                            trovato = true;
                            System.out.println("");
                            if (prodotto.getQuantita() >= quantita) {
                                Prodotto p = new Prodotto(prodotto.getCodice(),prodotto.getDescrizione(), quantita,prodotto.getPrezzo());

                                carrello.aggiungiProdotto(p);
                                prodotto.setQuantita(prodotto.getQuantita() - quantita);
                                System.out.println("Prodotto aggiunto al carrello!");
                                Thread.sleep(2000);
                            } else {
                                System.out.println("Quantita' non disponibile in magazzino.");
                                Thread.sleep(2000);
                            }   
                            break; 
                        }
                    }

                    if (!trovato) {
                        System.out.println("Prodotto non trovato nel magazzino.");
                        Thread.sleep(2000);
                    }
                    break;
                case 2:
                    c = carrello.getProdotti();
                    System.out.println("+------------+---------------------------------+-----------+--------+");
                    System.out.printf("| %-10s | %-31s | %-5s | %-5s |\n", "Codice", "Descrizione", "Quantita'", "Prezzo");
                    for (int k = 0; k < c.lunghezza(); k++) {
                        System.out.println("+------------+---------------------------------+-----------+--------+");
                        System.out.printf("| %-10s | %-31s | %-9s | %-5s  |\n", c.get(k).getCodice(), c.get(k).getDescrizione(),c.get(k).getQuantita(), c.get(k).getPrezzo());   
                    }
                    System.out.println("+------------+---------------------------------+-----------+--------+");
                    if(c.lunghezza() == 0) System.out.println("Non ci sono prodotti");
                    break;
                case 3:
                    c = carrello.getProdotti();
                    System.out.println("+------------+---------------------------------+-----------+--------+");
                    System.out.printf("| %-10s | %-31s | %-5s | %-5s |\n", "Codice", "Descrizione", "Quantita'", "Prezzo");
                    for (int k = 0; k < c.lunghezza(); k++) {
                        System.out.println("+------------+---------------------------------+-----------+--------+");
                        System.out.printf("| %-10s | %-31s | %-9s | %-5s  |\n", c.get(k).getCodice(), c.get(k).getDescrizione(),c.get(k).getQuantita(), c.get(k).getPrezzo());   
                    }
                    System.out.println("+------------+---------------------------------+-----------+--------+");
                    if(c.lunghezza() == 0) System.out.println("Non ci sono prodotti");
                    codice = tastiera.inputStringaSeguito("Inserire il codice del prodotto da eliminare: ");
                    System.out.print("Caricamento");
                    for (int i = 0; i < 3; i++) {
                        Thread.sleep(500);
                        System.out.print(".");
                    }
                    System.out.println("");
                    rimosso = carrello.rimuoviProdotto(codice, magazzino);
                    if(!rimosso){
                        System.out.println("Prodotto non trovato");
                    } else {
                        System.out.println("Prodotto trovato!");
                    }
                case 4:
                    ordine = new Ordine(carrello, config);
                    ordine.salvaSuFile();
                    config.incrementoNumeroOrdine();
                    config.salvaConfigurazione();
                    c.svuota();
            }
        }while(scelta != 0);
        
    }
    
    
}
