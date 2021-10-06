package hu.uni.miskolc.teszteles2021;

import hu.uni.miskolc.teszteles2021.exception.AjtokszamaNemMegfellelo;
import org.junit.Test;

import static org.junit.Assert.fail;

public class AutoTest {

    //4-es importáld ne a 3-ast, mert különben nem lesz jó.
    //Azt szeretnénk, hogy az ajtók száma nem lehessen negatív
    @Test
    public void testAjtokSzamaMegfelflo() throws AjtokszamaNemMegfellelo {
        Auto auto= new Auto();
        auto.setAjtokSzama(3);
    }

    @Test(expected =  AjtokszamaNemMegfellelo.class)
    public void testAjtokSzamaTulAlacsony() throws AjtokszamaNemMegfellelo{
        Auto auto= new Auto();
        auto.setAjtokSzama(-1);
    }

    @Test(expected =  AjtokszamaNemMegfellelo.class)
    public void testAjtokSzamaTulMagas() throws AjtokszamaNemMegfellelo{
        Auto auto= new Auto();
        auto.setAjtokSzama(1000);
    }

}