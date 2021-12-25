import be.vdab.theorie.domain.Converter;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class ConverterTest {

    @Test
    void eenInchIs2Komma54Centimeters(){
        assertThat(new Converter().incheNaarCentimeters(BigDecimal.ONE)).isEqualByComparingTo("2.54");
    }
    @Test
    void tweehonderdInchIs508Centimeters(){
        assertThat(new Converter().incheNaarCentimeters(BigDecimal.valueOf(200))).isEqualByComparingTo("508");
    }


}
