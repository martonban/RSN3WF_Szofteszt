package hu.uni.miskolc.teszteles2021.dao;

import hu.uni.miskolc.testeles.exception.AutoNemTalalhato;
import hu.uni.miskolc.teszteles2021.Auto;
import hu.uni.miskolc.teszteles2021.exception.RendszamNemMegfelelo;

import java.util.Collection;

public interface AutoDao {

    /*
    DAO = Data Acces Object
   m Auto nincs bent ilyenkor a pom.xml
     */

    public Collection<Auto> readAllAutos();

    public Auto readAutoById(String rendszam) throws AutoNemTalalhato;

    public void createAuto(Auto auto) throws RendszamNemMegfelelo;

    public void updateAuto(Auto auto);

    public void deleteAuto(Auto auto);

    public void deleteAutoById(String rendszam);


}
