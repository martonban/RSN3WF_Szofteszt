package hun.uni.miskolc.teszteles;

import java.time.LocalDate;
import java.util.Map;

public class Auto implements HanggalRendelkezo {
    private String gyarto;
    private String motor;
    private Map<String, Integer> hengerTartalom; //Egy szöveghez, egy értéket rendel
    private String rendszam;
    private Uzemanyag uzemanyag;
    private LocalDate gyartasIdo;
    private String szin;
    private boolean korozes;
    private String forgalmiSzam;
    private String valto;
    private int ajtokszama;

    @Override
    public void dudal() {
        System.out.println("Tütü");
    }

    public String getGyarto() {
        return gyarto;
    }

    public void setGyarto(String gyarto) {
        this.gyarto = gyarto;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public Map<String, Integer> getHengerTartalom() {
        return hengerTartalom;
    }

    public void setHengerTartalom(Map<String, Integer> hengerTartalom) {
        this.hengerTartalom = hengerTartalom;
    }

    public String getRendszam() {
        return rendszam;
    }

    public void setRendszam(String rendszam) {
        this.rendszam = rendszam;
    }

    public Uzemanyag getUzemanyag() {
        return uzemanyag;
    }

    public void setUzemanyag(Uzemanyag uzemanyag) {
        this.uzemanyag = uzemanyag;
    }

    public LocalDate getGyartasIdo() {
        return gyartasIdo;
    }

    public void setGyartasIdo(LocalDate gyartasIdo) {
        this.gyartasIdo = gyartasIdo;
    }

    public String getSzin() {
        return szin;
    }

    public void setSzin(String szin) {
        this.szin = szin;
    }

    public boolean isKorozes() {
        return korozes;
    }

    public void setKorozes(boolean korozes) {
        this.korozes = korozes;
    }

    public String getForgalmiSzam() {
        return forgalmiSzam;
    }

    public void setForgalmiSzam(String forgalmiSzam) {
        this.forgalmiSzam = forgalmiSzam;
    }

    public String getValto() {
        return valto;
    }

    public void setValto(String valto) {
        this.valto = valto;
    }

    public int getAjtokszama() {
        return ajtokszama;
    }

    public void setAjtokszama(int ajtokszama) {
        this.ajtokszama = ajtokszama;
    }
}
