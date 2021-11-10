package hu.uni.miskolc.teszteles2021;

import hu.uni.miskolc.teszteles2021.dao.AutoDao;

import hu.uni.miskolc.teszteles2021.enums.Kivitel;
import hu.uni.miskolc.teszteles2021.enums.Uzemanyag;
import hu.uni.miskolc.teszteles2021.enums.Valto;
import hu.uni.miskolc.teszteles2021.exception.AjtokszamaNemMegfellelo;
import hu.uni.miskolc.teszteles2021.exception.GyartasiIdoNemMegfelelo;
import hu.uni.miskolc.teszteles2021.exception.RendszamNemMegfelelo;
import org.junit.Test;


import java.time.LocalDate;

import static org.junit.Assert.*;

public class AutoDaoMongoTest {

    @Test
    public void testDatabase() throws RendszamNemMegfelelo, AjtokszamaNemMegfellelo, GyartasiIdoNemMegfelelo {
        AutoDao dao = new AutoDaoMongo("mongodb+srv://test:test@szoftverteszteles2021.bqwgi.mongodb.net/myFirst",
        "testRSN3WF", "autokRSN3WF");

        Auto auto = new Auto("Opel","Astra","1.2" , "ABC-123", Uzemanyag.BENZIN, LocalDate.of(2017, 5,12),
                "#dedede",	false, "123456EE", Valto.MANUALIS_5_FOKOZAT, Kivitel.KOMBI, 5);

        System.out.println(dao.readAllAutos());
        System.out.println(dao.readAutoById("ABC-123"));
    }


}