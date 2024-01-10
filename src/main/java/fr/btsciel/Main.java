package fr.btsciel;
import clavier.In;
import jssc.SerialPortException;

public class Main {
    public static void main(String[] args) {
        Application ap = new Application();

        ap.listDesComs().forEach(LesCom-> System.out.println(LesCom));
        System.out.println("quel est le port que vous voudriez utiliser ? ");
        try{
            ap.initialisation(In.readString());
            System.out.println("connexion réussit");
        }catch(SerialPortException e){
            System.err.println("pas de port ");
        }

        while(true){

        }

    }
}
