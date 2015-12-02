package app.services;

public class Crypt {
    private static int n = 17;

    public static String crypt(String password) {
        String cryptStr = "";
        for (char c : password.toCharArray()) {
            cryptStr += (char) ((int) c ^ n);
        }
        return cryptStr;
    }
}