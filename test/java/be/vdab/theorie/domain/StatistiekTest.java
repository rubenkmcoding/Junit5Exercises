package be.vdab.theorie.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

class StatistiekTest {

    @Test
    void herGemiddeldeVan0En10Is5(){
      assertThat(Statistiek.getGemiddelde(new BigDecimal[]{BigDecimal.ZERO,BigDecimal.TEN})).isEqualByComparingTo("5");
    }
    @Test
    void hetGimiddeldeVanEenGetalIsDatGetal(){
        var enigGetal = BigDecimal.valueOf(1.13);
        assertThat(Statistiek.getGemiddelde(new BigDecimal[]{ enigGetal}))
                .isEqualByComparingTo(enigGetal);
    }
    @Test
    void hetGemiddeldeVanEenLegeVerzamelingKanJeNietBerekenen(){
        assertThatIllegalArgumentException().isThrownBy(() -> Statistiek.getGemiddelde(new BigDecimal[]{}));
    }
    @Test
    void hetGemiddeldeVanNullKanJeNietBerekenen() {
        assertThatNullPointerException().isThrownBy(
                () -> Statistiek.getGemiddelde(null));
    }
    @Test
    void eenArrayElementMagNietNullBevatten() {
        assertThatNullPointerException().isThrownBy(
                () -> Statistiek.getGemiddelde(new BigDecimal[]{null}));

    }

    }