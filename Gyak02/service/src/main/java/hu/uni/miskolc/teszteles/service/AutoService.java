package hu.uni.miskolc.teszteles.service;

import hu.uni.miskolc.testeles.exception.AutoNemTalalhato;
import hu.uni.miskolc.testeles.exception.RendszamMarFogalalt;
import hu.uni.miskolc.teszteles2021.Auto;
import hu.uni.miskolc.teszteles2021.dao.AutoDao;
import hu.uni.miskolc.teszteles2021.exception.RendszamNemMegfelelo;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;

import java.time.LocalDate;
import java.util.Collection;

import java.util.stream.Collectors;

public class AutoService {


    private AutoDao dao;

    public AutoService(AutoDao dao) {
        this.dao = dao;
    }



    public Collection<Auto> getAllAuto(){
        return dao.readAllAutos();
    };

    public Auto getAutoByRendszam(String rendszam) throws AutoNemTalalhato {
        return dao.readAutoById(rendszam);
    }


    public Collection<Auto> getAllKorozottAuto(){
        Collection<Auto> autos = getAllAuto();
        Collection<Auto> korozott = autos.stream().filter(a -> a.isKorozott()).collect(Collectors.toList());
        return korozott;
    }

    public void addAuto(Auto auto) throws RendszamMarFogalalt{
        try {
            dao.createAuto(auto);
        } catch (RendszamNemMegfelelo e) {
            e.printStackTrace();
        }
    }

    public void deleteAuto(Auto auto){
        dao.deleteAuto(auto);
    }

    public Collection<Auto> getAllAutoDatumKozott(LocalDate tol, LocalDate ig){
        Collection<Auto> autos = getAllAuto();
        Predicate<Auto> pred = a -> a.getGyartasiIdo().isAfter(tol) && a.getGyartasiIdo().isBefore(ig);
        CollectionUtils.filter(autos,pred);
        return autos;
    }

}
