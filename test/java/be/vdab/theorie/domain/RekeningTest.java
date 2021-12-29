package be.vdab.theorie.domain;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


class RekeningTest {

        private Rekening rekening;
        private static final BigDecimal TWEE = BigDecimal.valueOf(2);

        @BeforeEach
        void beforEach(){
            rekening = new Rekening();
        }
        @Test
        void hetSaldoVanEenNieuweRekeningIs0€() {
            assertThat(rekening.getSaldo()).isZero();
        }
        @Test
        void nadatJe10€StortIsHetSaldo10€() {
            rekening.stort(BigDecimal.TEN);
            assertThat(rekening.getSaldo()).isEqualByComparingTo("10");
        }
        @Test
        void nadatJe10€En1€StortIsHetSaldo11€() {
            rekening.stort(BigDecimal.TEN);
            rekening.stort(BigDecimal.ONE);
            assertThat(rekening.getSaldo()).isEqualByComparingTo("11");
        }
        @Test
        void hetGestortBedragMegNietNulZijn(){
            assertThatIllegalArgumentException().isThrownBy(() -> rekening.stort(BigDecimal.ZERO));
        }

        @Test
        void hetGestortBedagMagNietNegatiefZijn(){
            assertThatIllegalArgumentException().isThrownBy(() -> rekening.stort(BigDecimal.valueOf(-1)));
        }
//        @Test
//        void stortenMetNulKanNiet(){
//            assertThatIllegalArgumentException().isThrownBy(()-> rekening.stort(null));
//        }
        @Test
        void eenNieuweRekeningHeeftGeenStortingen(){
            assertThat(rekening.getStortingen()).isEmpty();
        }
        @Test
        void naDatJe10EuroStortIsErEenStortingVan10Euro(){
            rekening.stort(BigDecimal.TEN);
            assertThat(rekening.getStortingen()).containsOnly(BigDecimal.TEN);
        }
        @Test
        void nadatJe10EuroEn1EuroStortZijnDeStortingen10EuroEn1euro(){
            rekening.stort(BigDecimal.TEN);
            rekening.stort(BigDecimal.ONE);
            rekening.stort(TWEE);
            assertThat(rekening.getStortingenGesorteerd()).isSorted().containsExactly(BigDecimal.ONE,TWEE,BigDecimal.TEN);
        }
    }