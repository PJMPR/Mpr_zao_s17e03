package domain.helpers;

public class PeselHelper {
    public static boolean checkPesel(String pesel) {
        if (pesel.length() != 11) {
            return false;
        }
        if (!pesel.matches("^[0-9]{11}$")) {
            return false;
        }
        return checkSum(pesel);
    }

    private boolean checkSum(String pesel) {
        int sum = (
                1 * pesel[0]
              + 3 * pesel[1]
              + 7 * pesel[2]
              + 9 * pesel[3]
              + 1 * pesel[4]
              + 3 * pesel[5]
              + 7 * pesel[6]
              + 9 * pesel[7]
              + 1 * pesel[8]
              + 3 * pesel[9]
        );
        sum %= 10;
        sum = 10 - sum;
        sum %= 10;

        return (sum == pesel[10]);
    }
}
