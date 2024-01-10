package fr.btsciel;

import jssc.SerialPortEvent;
import jssc.SerialPortException;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Application extends LiaisonSerie{
    public Application(){

    }
    public ArrayList<String> listDesComs(){
        return super.listerLesPorts();
    }
    public void serialEvent(SerialPortEvent spe){
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        byte[] laTrame;
        int longueur = spe.getEventValue();
        laTrame = lireTrame(longueur);

        for(byte b : laTrame){
            sb1.append((b&0xFF)+ " ");
        }
        for(byte b: laTrame){
            sb2.append(String.format("%02x ", b));
        }

        System.out.println("""
                bytes -> %s
                hexa -> %s
                ASCII -> %s
                """.formatted(sb1, sb2, new String(laTrame, StandardCharsets.US_ASCII)));

    }
    public void initialisation(String s) throws SerialPortException {
        initCom(s);
        configurerParametres(9600, 8, 0, 2);
    }
    public void deconnexionCapteur(){

        fermerPort();
    }
    public void ecrire(byte[] b){

    }
}

