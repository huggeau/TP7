package fr.btsciel;
import clavier.In;
import jssc.SerialPortException;

import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        Application ap = new Application();
        int menu;
        String saisie;

        ap.listDesComs().forEach(LesCom-> System.out.println(LesCom));
        System.out.println("quel est le port que vous voudriez utiliser ? ");
        try{
            ap.initialisation(In.readString());
            System.out.println("connexion réussit");

        }catch(SerialPortException e){
            System.err.println("pas de port ");
        }

        while(true){
            System.out.println("veuillez saisir quelque chose ( v euillez noter exit si vous voulez sortir du programme");
            saisie = In.readString();
            if (saisie.trim().equalsIgnoreCase("exit")){
                ap.fermerPort();
                break;
            }
            ap.ecrire(saisie.getBytes(StandardCharsets.US_ASCII));
        }
        System.out.println("fermeture du port et donc fin du programme");

    }
}
