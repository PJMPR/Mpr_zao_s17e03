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
                1 * Integer.parseInt(Character.toString(pesel.charAt(0)))
              + 3 * Integer.parseInt(Character.toString(pesel.charAt(1)))
              + 7 * Integer.parseInt(Character.toString(pesel.charAt(2)))
              + 9 * Integer.parseInt(Character.toString(pesel.charAt(3)))
              + 1 * Integer.parseInt(Character.toString(pesel.charAt(4)))
              + 3 * Integer.parseInt(Character.toString(pesel.charAt(5)))
              + 7 * Integer.parseInt(Character.toString(pesel.charAt(6)))
              + 9 * Integer.parseInt(Character.toString(pesel.charAt(7)))
              + 1 * Integer.parseInt(Character.toString(pesel.charAt(8)))
              + 3 * Integer.parseInt(Character.toString(pesel.charAt(9)))
        );
        sum %= 10;
        sum = 10 - sum;
        sum %= 10;

        return (sum == Integer.parseInt(Character.toString(pesel.charAt(10))));
    }
}
