package be.vdab.theorie.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class VeillingTest {


    @Test
    @DisplayName("Het hoogste bod van een nieuwe veilling is 0 euro")
    void hetHoogsteBodVanEenNieuweVeilleingIs0Euro() {
        assertThat(new Veilling().getHoogsteBod()).isZero();
    }

    @Test
    @DisplayName("Na een bod van 10 euro is het hoogtse bod 10 euro")
    void naEenBodVan10EuroIsHetHoogsteBod10Euro() {
        Veilling veilling = new Veilling();
        veilling.doeBod(BigDecimal.TEN);
        assertThat(veilling.getHoogsteBod()).isEqualByComparingTo("10");
    }

    @Test
    void naEenBodVan1€En10€En1€IsHetHoogsteBod10€() {
        var veiling = new Veilling();
        veiling.doeBod(BigDecimal.ONE);
        veiling.doeBod(BigDecimal.TEN);
        veiling.doeBod(BigDecimal.ONE);
        assertThat(veiling.getHoogsteBod()).isEqualByComparingTo(("10"));

    }
}