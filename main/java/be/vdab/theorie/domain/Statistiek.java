package be.vdab.theorie.domain;

import java.math.BigDecimal;
import java.util.Arrays;

public class Statistiek {

    public static BigDecimal getGemiddelde(BigDecimal[] getalllen){
        if (getalllen.length == 0){
            throw new IllegalArgumentException("lege array");
        }
        return Arrays.stream(getalllen)
                .reduce(BigDecimal.ZERO,(vorigTotaal,getal) -> vorigTotaal.add(getal))
                .divide(BigDecimal.valueOf(getalllen.length));

    }
}
