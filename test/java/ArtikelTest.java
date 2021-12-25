import be.vdab.theorie.domain.Artikel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class ArtikelTest {
    @Test
    @DisplayName("Prijs inclusief BTW.")
    void prijsExclusiefBtw30enBtwPercentage6Moet31komma8PrijsInclusiefZijn(){
        Artikel artikel = new Artikel(BigDecimal.valueOf(30),BigDecimal.valueOf(6));
        assertThat(artikel.getPrijsInclusiefBtw()).isEqualByComparingTo("31.8");
    }

}
