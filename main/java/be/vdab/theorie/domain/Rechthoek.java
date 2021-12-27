package be.vdab.theorie.domain;

public class Rechthoek {

    private final int lengte;
    private final int breedte;

    public Rechthoek(int lengte, int breedte) {
        if (lengte < 1 || breedte < 1 || lengte < breedte){
            throw new IllegalArgumentException();
        }
        this.lengte = lengte;
        this.breedte = breedte;
    }

    public int getOppervlakte() {
        return lengte * breedte;
    }
    public int getOmtrek() {
        return (lengte + breedte) * 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rechthoek rechthoek = (Rechthoek) o;

        if (lengte != rechthoek.lengte) return false;
        return breedte == rechthoek.breedte;
    }

    @Override
    public int hashCode() {
        int result = lengte;
        result = 31 * result + breedte;
        return result;
    }


}
