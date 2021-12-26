package be.vdab.theorie.domain;

import java.math.BigDecimal;

public class Veilling {

    private BigDecimal hoogsteBod = BigDecimal.ZERO;

    public void doeBod(BigDecimal bedrag){
       if (bedrag.compareTo(hoogsteBod) > 0){
           hoogsteBod = bedrag;
       }
    }

    public BigDecimal getHoogsteBod(){
        return hoogsteBod;
    }


}
