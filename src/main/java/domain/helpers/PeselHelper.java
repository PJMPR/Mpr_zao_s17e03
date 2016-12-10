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
                1 * pesel.codePointAt(0)
              + 3 * pesel.codePointAt(1)
              + 7 * pesel.codePointAt(2)
              + 9 * pesel.codePointAt(3)
              + 1 * pesel.codePointAt(4)
              + 3 * pesel.codePointAt(5)
              + 7 * pesel.codePointAt(6)
              + 9 * pesel.codePointAt(7)
              + 1 * pesel.codePointAt(8)
              + 3 * pesel.codePointAt(9)
        );
        sum %= 10;
        sum = 10 - sum;
        sum %= 10;

        return (sum == pesel[10]);
    }
}
