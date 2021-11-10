package hu.uni.miskolc.teszteles2021;

import hu.uni.miskolc.teszteles2021.enums.Kivitel;
import hu.uni.miskolc.teszteles2021.enums.Uzemanyag;
import hu.uni.miskolc.teszteles2021.enums.Valto;
import hu.uni.miskolc.teszteles2021.exception.AjtokszamaNemMegfellelo;
import hu.uni.miskolc.teszteles2021.exception.GyartasiIdoNemMegfelelo;
import hu.uni.miskolc.teszteles2021.exception.RendszamNemMegfelelo;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Auto implements HanggalRendelkezo {


    public static Map<String, Integer> hengerurtartalomErtekek;


    static {
        hengerurtartalomErtekek = new HashMap<>();
        hengerurtartalomErtekek.put("1.0", 998);
        hengerurtartalomErtekek.put("1.2", 1199);
        hengerurtartalomErtekek.put("1.4", 1390);
        hengerurtartalomErtekek.put("1.6", 1560);
    }



    //Adattagok
    private String gyarto;
    private String modell;
    private Integer hengerurtartalom;
    private String rendszam;
    private Uzemanyag uzemanyag;
    private LocalDate gyartasiIdo;
    private String szinHex;
    private boolean korozott;
    private String forgalmiSzama;
    private Valto valto;
    private Kivitel kivitel;
    private int ajtokSzama;

    @Override
    public void dudal() {
        System.out.println("Tütü");
    }

    public String getGyarto() {
        return gyarto;
    }

    protected void setGyarto(String gyarto) {
        this.gyarto = gyarto;
    }

    public String getModell() {
        return modell;
    }

    protected void setModell(String modell) {
        this.modell = modell;
    }

    public Integer getHengerurtartalom() {
        return hengerurtartalom;
    }

    public void setHengerurtartalom(Integer hengerurtartalom){
		this.hengerurtartalom = hengerurtartalom;
    }


    public void setHengerurtartalom(String hengerurtartalom){
        this.hengerurtartalom = hengerurtartalomErtekek.get(hengerurtartalom);
    }

    public String getRendszam() {
        return rendszam;
    }

    public void setRendszam(String rendszam) throws RendszamNemMegfelelo {
        String regex = "^([^a-z0-9Q]{3}-(?!000)[0-9]{3})$";
        if(!rendszam.matches(regex)){
            throw new RendszamNemMegfelelo(rendszam);
        }
        this.rendszam = rendszam;
    }

    public Uzemanyag getUzemanyag() {
        return uzemanyag;
    }

    public void setUzemanyag(Uzemanyag uzemanyag) {
        this.uzemanyag = uzemanyag;
    }

    public LocalDate getGyartasiIdo() {
        return gyartasiIdo;
    }

    protected void setGyartasiIdo(LocalDate gyartasiIdo) throws GyartasiIdoNemMegfelelo {
        if(gyartasiIdo.isAfter(LocalDate.now()) || gyartasiIdo.isBefore(LocalDate.of(1885,01,01))){
            throw new GyartasiIdoNemMegfelelo(gyartasiIdo);
        }
        this.gyartasiIdo = gyartasiIdo;
    }

    public String getSzinHex() {
        return szinHex;
    }

    public void setSzinHex(String szinHex) {
        this.szinHex = szinHex;
    }

    public boolean isKorozott() {
        return korozott;
    }

    public void setKorozott(boolean korozott) {
        this.korozott = korozott;
    }

    public String getForgalmiSzama() {
        return forgalmiSzama;
    }

    public void setForgalmiSzama(String forgalmiSzama) {
        this.forgalmiSzama = forgalmiSzama;
    }

    public Valto getValto() {
        return valto;
    }

    public void setValto(Valto valto) {
        this.valto = valto;
    }

    public Kivitel getKivitel() {
        return kivitel;
    }

    protected void setKivitel(Kivitel kivitel) {
        this.kivitel = kivitel;
    }

    public int getAjtokSzama() {
        return ajtokSzama;
    }

    protected void setAjtokSzama(int ajtokSzama) throws AjtokszamaNemMegfellelo {
        if(ajtokSzama < 0 || ajtokSzama > 5){
            throw new AjtokszamaNemMegfellelo(ajtokSzama);
        }
        this.ajtokSzama = ajtokSzama;
    }

    public Auto(String gyarto, String modell, Integer hengerurtartalom, String rendszam, Uzemanyag uzemanyag,
                LocalDate gyartasiIdo, String szinHex, boolean korozott, String forgalmiSzama, Valto valto, Kivitel kivitel,
                int ajtokSzama) throws AjtokszamaNemMegfellelo, GyartasiIdoNemMegfelelo, RendszamNemMegfelelo {
        super();
        setGyarto(gyarto);
        setModell(modell);
        setHengerurtartalom(hengerurtartalom);
        setRendszam(rendszam);
        setUzemanyag(uzemanyag);
        setGyartasiIdo(gyartasiIdo);
        setSzinHex(szinHex);
        setKorozott(korozott);
        setForgalmiSzama(forgalmiSzama);
        setValto(valto);
        setKivitel(kivitel);
        setAjtokSzama(ajtokSzama);
    }


    public Auto(String gyarto, String modell, String hengerurtartalom, String rendszam, Uzemanyag uzemanyag,
                LocalDate gyartasiIdo, String szinHex, boolean korozott, String forgalmiSzama, Valto valto, Kivitel kivitel,
                int ajtokSzama) throws AjtokszamaNemMegfellelo, GyartasiIdoNemMegfelelo, RendszamNemMegfelelo {
        super();
        setGyarto(gyarto);
        setModell(modell);
        setHengerurtartalom(hengerurtartalom);
        setRendszam(rendszam);
        setUzemanyag(uzemanyag);
        setGyartasiIdo(gyartasiIdo);
        setSzinHex(szinHex);
        setKorozott(korozott);
        setForgalmiSzama(forgalmiSzama);
        setValto(valto);
        setKivitel(kivitel);
        setAjtokSzama(ajtokSzama);
    }

    public Auto() {
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auto auto = (Auto) o;
        return korozott == auto.korozott && ajtokSzama == auto.ajtokSzama && gyarto.equals(auto.gyarto) && modell.equals(auto.modell) && hengerurtartalom.equals(auto.hengerurtartalom) && rendszam.equals(auto.rendszam) && uzemanyag == auto.uzemanyag && gyartasiIdo.equals(auto.gyartasiIdo) && szinHex.equals(auto.szinHex) && forgalmiSzama.equals(auto.forgalmiSzama) && valto == auto.valto && kivitel == auto.kivitel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gyarto, modell, hengerurtartalom, rendszam, uzemanyag, gyartasiIdo, szinHex, korozott, forgalmiSzama, valto, kivitel, ajtokSzama);
    }

    @Override
    public String toString() {
        return "Auto{" +
                "gyarto='" + gyarto + '\'' +
                ", modell='" + modell + '\'' +
                ", hengerurtartalom=" + hengerurtartalom +
                ", rendszam='" + rendszam + '\'' +
                ", uzemanyag=" + uzemanyag +
                ", gyartasiIdo=" + gyartasiIdo +
                ", szinHex='" + szinHex + '\'' +
                ", korozott=" + korozott +
                ", forgalmiSzama='" + forgalmiSzama + '\'' +
                ", valto=" + valto +
                ", kivitel=" + kivitel +
                ", ajtokSzama=" + ajtokSzama +
                '}';
    }
}
