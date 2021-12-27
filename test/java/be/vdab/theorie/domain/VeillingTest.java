package be.vdab.theorie.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class VeillingTest {

    private Veilling veilling;

    @BeforeEach
    void BeforeEach() {
        veilling = new Veilling();
    }

    @Test
    @DisplayName("Het hoogste bod van een nieuwe veilling is 0 euro")
    void hetHoogsteBodVanEenNieuweVeilleingIs0Euro() {
        assertThat(new Veilling().getHoogsteBod()).isZero();
    }

    @Test
    @DisplayName("Na een bod van 10 euro is het hoogtse bod 10 euro")
    void naEenBodVan10EuroIsHetHoogsteBod10Euro() {
        veilling.doeBod(BigDecimal.TEN);
        assertThat(veilling.getHoogsteBod()).isEqualByComparingTo("10");
    }

    @Test
    void naEenBodVan1€En10€En1€IsHetHoogsteBod10€() {
       veilling.doeBod(BigDecimal.ONE);
       veilling.doeBod(BigDecimal.TEN);
       veilling.doeBod(BigDecimal.ONE);
        assertThat(veilling.getHoogsteBod()).isEqualByComparingTo(("10"));

    }
}