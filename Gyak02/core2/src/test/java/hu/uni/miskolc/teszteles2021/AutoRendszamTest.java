package hu.uni.miskolc.teszteles2021;

import hu.uni.miskolc.teszteles2021.exception.RendszamNemMegfelelo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(Parameterized.class)
public class AutoRendszamTest {

    @Parameterized.Parameters
    public static Collection data(){
        List data = new ArrayList();
        data.add(new Object[]{"AAAA-123"});
        data.add(new Object[]{"AAAA123"});
        data.add(new Object[]{"AAAA-1233"});
        data.add(new Object[]{"AAQ-123"});
        data.add(new Object[]{"AAA-AAA"});
        data.add(new Object[]{"123-123"});
        return data;
    }

    String rendszam;

    public AutoRendszamTest(String rendszam){
        this.rendszam = rendszam;
    }

    @Test(expected = RendszamNemMegfelelo.class)
    public void testRosszRendszam() throws RendszamNemMegfelelo{
        Auto auto = new Auto();
        auto.setRendszam(rendszam);
    }

}
