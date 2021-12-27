package be.vdab.theorie.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RechthoekTest {


    @Test
    void deOppervlakteVanEenRechtHoekVan5Op3Is15() {
        assertThat(new Rechthoek(5, 3).getOppervlakte()).isEqualTo(15);
    }
    @Test
    void deOmtrekVanEenRechtHoekVan5Op3Is16() {
        assertThat(new Rechthoek(5, 3).getOmtrek()).isEqualTo(16);
    }

    @Test
    void deLengteVanRechthoekMagNietNegatiefZijn(){
        assertThatIllegalArgumentException().isThrownBy(() -> new Rechthoek(-1,3));
    }
    @Test
    void eenNegatiefBreedteKanNiet(){
        assertThatIllegalArgumentException().isThrownBy(() -> new Rechthoek(5,-1));
    }

    @Test
    void deLengteMoetMinstensdeBreedteZijn(){
        assertThatIllegalArgumentException().isThrownBy(() -> new Rechthoek(2,3));
    }




}