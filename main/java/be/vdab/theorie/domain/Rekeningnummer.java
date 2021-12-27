package be.vdab.theorie.domain;

import java.util.regex.Pattern;

public class Rekeningnummer {

    private static final Pattern PATTERN = Pattern.compile("\"^BE(\\\\d{2})(\\\\d{12})$\"");

    private final String nummer;

    public Rekeningnummer(String nummer) {
        var matcher = PATTERN.matcher(nummer);
        if (! matcher.matches()){
            throw new IllegalArgumentException("Verkeerd formaat");
        }
        var controleGetal = Integer.valueOf(matcher.group(1));
        if (controleGetal<2 || controleGetal > 98){
            throw new IllegalArgumentException("1° of 2° cijfer verkeerd");
        }
        var teControlerenNummer= Long.valueOf(matcher.group(2) + "1114" + matcher.group(1));
        if (teControlerenNummer % 97 != 1){
            throw  new IllegalArgumentException("Nummer bevat verkeerde cijfers");
        }
        this.nummer = nummer;
    }

    @Override
    public String toString() {
                                                                                                    ;
    }
}
