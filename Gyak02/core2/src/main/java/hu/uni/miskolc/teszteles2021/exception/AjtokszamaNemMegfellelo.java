package hu.uni.miskolc.teszteles2021.exception;

public class AjtokszamaNemMegfellelo extends Exception {
    public AjtokszamaNemMegfellelo(int ajtokSzama) {
        super(String.valueOf(ajtokSzama));
    }
}
