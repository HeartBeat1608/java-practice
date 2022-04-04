package codes;

public class Main {
    public static void main(String[] args) {
        String sep = "======================================================";

        StringPermutations stringPermutations = new StringPermutations();
        stringPermutations.makePermutations("TRUE");

        System.out.println(sep);

        DecimalToRoman decimalToRoman = new DecimalToRoman();
        String roman = decimalToRoman.toRoman(3549);
        System.out.println(roman);
        System.out.println(roman.equals("MMMDXLIX"));

        System.out.println(sep);

        Bodmass bodmass = new Bodmass();
        int result = bodmass.parse("2+(5*(2+2))");
        System.out.printf("Expression:\t2+(5*(2+2))\n%d", result);
    }
}
