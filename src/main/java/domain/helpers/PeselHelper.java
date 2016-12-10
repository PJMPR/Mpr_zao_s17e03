package domain.helpers;

public class PeselHelper {
    public static boolean checkPesel(String pesel) {
        if (pesel.length() != 11) {
            return false;
        }
        if (!pesel.matches("^[0-9]{11}$")) {
            return false;
        }
        return checksum(pesel);
    }

    private static boolean checksum(String pesel) {
        int sum = (
                1 * Integer.parseInt(pesel.codePointAt(0))
              + 3 * Integer.parseInt(pesel.codePointAt(1))
              + 7 * Integer.parseInt(pesel.codePointAt(2))
              + 9 * Integer.parseInt(pesel.codePointAt(3))
              + 1 * Integer.parseInt(pesel.codePointAt(4))
              + 3 * Integer.parseInt(pesel.codePointAt(5))
              + 7 * Integer.parseInt(pesel.codePointAt(6))
              + 9 * Integer.parseInt(pesel.codePointAt(7))
              + 1 * Integer.parseInt(pesel.codePointAt(8))
              + 3 * Integer.parseInt(pesel.codePointAt(9))
        );
        sum %= 10;
        sum = 10 - sum;
        sum %= 10;

        return (sum == Integer.parseInt(pesel.codePointAt(10)));
    }
}
