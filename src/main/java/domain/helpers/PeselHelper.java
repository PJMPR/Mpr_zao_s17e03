package domain.helpers;

public class PeselHelper {
    public static boolean checkPesel(String pesel) {
        if (pesel.length() != 11) {
            return false;
        }
        return true;
    }
}
