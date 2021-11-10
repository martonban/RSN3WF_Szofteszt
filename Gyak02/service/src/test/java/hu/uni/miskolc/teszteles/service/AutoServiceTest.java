package hu.uni.miskolc.teszteles.service;

import hu.uni.miskolc.testeles.exception.AutoNemTalalhato;
import hu.uni.miskolc.testeles.exception.RendszamMarFoglalt;
import hu.uni.miskolc.teszteles2021.Auto;
import hu.uni.miskolc.teszteles2021.dao.AutoDao;
import hu.uni.miskolc.teszteles2021.enums.Kivitel;
import hu.uni.miskolc.teszteles2021.enums.Uzemanyag;
import hu.uni.miskolc.teszteles2021.enums.Valto;
import hu.uni.miskolc.teszteles2021.exception.AjtokszamaNemMegfellelo;
import hu.uni.miskolc.teszteles2021.exception.GyartasiIdoNemMegfelelo;
import hu.uni.miskolc.teszteles2021.exception.RendszamNemMegfelelo;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.AdditionalMatchers;
import org.hamcrest.Matchers;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.times;

import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;

public class AutoServiceTest {


    private AutoService service;
    private Collection<Auto> autok;
    private static AutoDao mock;

    @Before
    public void setUp() throws AutoNemTalalhato, RendszamNemMegfelelo, RendszamMarFoglalt, AjtokszamaNemMegfellelo, GyartasiIdoNemMegfelelo {
        mock = Mockito.mock(AutoDao.class);
        service = new AutoService(mock);
        Auto auto = new Auto("Opel","Astra","1.2" , "ABC-123", Uzemanyag.BENZIN, LocalDate.of(2017, 5,12),
                "#dedede",	false, "123456EE", Valto.MANUALIS_5_FOKOZAT, Kivitel.KOMBI, 5);
        Auto auto2 = new Auto("Kia","Picanto","1.0" , "ABC-222", Uzemanyag.BENZIN, LocalDate.of(2012, 8,30),
                "#ffffff",	true, "121212EE", Valto.MANUALIS_5_FOKOZAT, Kivitel.HATCHBACK, 4);
        Auto auto3 = new Auto("Renault","Thalia","1.2" , "ABC-333", Uzemanyag.DIESEL, LocalDate.of(2009, 12,24),
                "#000000",	false, "987654AA", Valto.AUTOMATA, Kivitel.SEDAN, 4);
        autok = new ArrayList();
        autok.add(auto);
        autok.add(auto2);
        autok.add(auto3);


        Mockito.when(mock.readAutoById(org.mockito.Matchers.anyString())).
                thenThrow(new AutoNemTalalhato());
        Mockito.doReturn(auto).when(mock).readAutoById("ABC-123");
        Mockito.doReturn(auto2).when(mock).readAutoById("ABC-222");
        Mockito.doReturn(auto3).when(mock).readAutoById("ABC-333");
        Mockito.when(mock.readAllAutos()).thenReturn(autok);
        Mockito.doThrow(RendszamNemMegfelelo.class).when(mock).readAutoById(
                AdditionalMatchers.not(Mockito.matches("\\w\\w\\w-\\d\\d\\d")));
        Mockito.doThrow(RendszamMarFoglalt.class).when(mock).createAuto(auto);
        Mockito.doThrow(RendszamMarFoglalt.class).when(mock).createAuto(auto2);
        Mockito.doThrow(RendszamMarFoglalt.class).when(mock).createAuto(auto3);
    }

    @Test
    public void test() {
        assertEquals(service.getAllAuto().size(), 3);
        for (Auto a : autok) {
            MatcherAssert.assertThat(autok, Matchers.hasItem(a));
        }
    }

    @Test
    public void testVanKorozottAuto() {
        assertNotEquals(service.getAllKorozottAuto().size(),0);
        Mockito.verify(mock, atLeast(1)).readAllAutos();
    }

    @Test
    public void testAutoMasolat() throws RendszamNemMegfelelo, AjtokszamaNemMegfellelo, GyartasiIdoNemMegfelelo {
        Auto auto = new Auto("Opel","Astra","1.2" , "ABC-123", Uzemanyag.BENZIN, LocalDate.of(2017, 5,12),
                "#dedede",	false, "123456EE", Valto.MANUALIS_5_FOKOZAT, Kivitel.KOMBI, 5);
        MatcherAssert.assertThat(autok, Matchers.hasItem(auto));
    }
    @Test
    public void testAutoByRendszam() throws AutoNemTalalhato, RendszamNemMegfelelo {
        service.getAutoByRendszam("ABC-123");

    }
    @Test(expected = RendszamNemMegfelelo.class)
    public void testRosszRendszamLekerdezes() throws AutoNemTalalhato, RendszamNemMegfelelo {
        service.getAutoByRendszam("kiscica");
    }

    @Test(expected = RendszamMarFoglalt.class)
    public void testDuplum() throws RendszamMarFoglalt, RendszamNemMegfelelo, AjtokszamaNemMegfellelo, GyartasiIdoNemMegfelelo {
        Auto auto = new Auto("Opel","Astra","1.2" , "ABC-123", Uzemanyag.BENZIN, LocalDate.of(2017, 5,12),
                "#dedede",	false, "123456EE", Valto.MANUALIS_5_FOKOZAT, Kivitel.KOMBI, 5);
        service.addAuto(auto);
    }
    @Test
    public void testMegNemFelvittAuto() throws RendszamMarFoglalt, RendszamNemMegfelelo, AjtokszamaNemMegfellelo, GyartasiIdoNemMegfelelo {
        Auto auto = new Auto("Opel","Astra","1.2" , "AAA-123", Uzemanyag.DIESEL, LocalDate.of(2016, 11,12),
                "#ffffff",	false, "123789SD", Valto.MANUALIS_5_FOKOZAT, Kivitel.KOMBI, 5);
        service.addAuto(auto);
        Mockito.verify(mock, times(1)).createAuto(auto);
    }


}