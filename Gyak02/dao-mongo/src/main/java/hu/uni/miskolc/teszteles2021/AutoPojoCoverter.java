package hu.uni.miskolc.teszteles2021;

import hu.uni.miskolc.teszteles2021.exception.AjtokszamaNemMegfellelo;
import hu.uni.miskolc.teszteles2021.exception.GyartasiIdoNemMegfelelo;
import hu.uni.miskolc.teszteles2021.exception.RendszamNemMegfelelo;

public class AutoPojoCoverter {

    public static AutoPojo autoPojoConvert(Auto auto){
        AutoPojo pojo = new AutoPojo(auto.getGyarto(), auto.getModell(), auto.getHengerurtartalom(),
                auto.getRendszam(), auto.getUzemanyag(), auto.getGyartasiIdo(), auto.getSzinHex(),
                auto.isKorozott(), auto.getForgalmiSzama(), auto.getValto(), auto.getKivitel(),
                auto.getAjtokSzama());
        return pojo;
    }


    public static Auto pojoToAutoConvert(AutoPojo pojo)  {
        Auto auto = null;
        try {
            auto = new Auto(pojo.getGyarto(), pojo.getModell(), pojo.getHengerurtartalom(),
                    pojo.getRendszam(), pojo.getUzemanyag(), pojo.getGyartasiIdo(), pojo.getSzinHex(),
                    pojo.isKorozott(), pojo.getForgalmiSzama(), pojo.getValto(), pojo.getKivitel(),
                    pojo.getAjtokSzama());
        } catch (AjtokszamaNemMegfellelo e) {
            e.printStackTrace();
        } catch (GyartasiIdoNemMegfelelo e) {
            e.printStackTrace();
        } catch (RendszamNemMegfelelo e) {
            e.printStackTrace();
        }
        return auto;


    }

}
