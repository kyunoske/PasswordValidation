import java.util.ArrayList;
import java.util.Scanner;

public class Password {

        public static void main(String[] args) {
            Scanner user = new Scanner(System.in);
            System.out.println("Enter a password");

            String yourPassword = user.nextLine();
            System.out.println(checkPassword(yourPassword));
        }
    public static int getLength(String password){
        int length = password.length();
        return length;
    }

    public static String checkPassword(String password){
        int length = getLength(password);
        String Message = null;
        boolean containsNumber = checkNumber(password);
        boolean containsUpAndLow = checkUpperCase(password);
        boolean containsBadPass = checkBadPasswords(password);

        if (containsBadPass) {
            Message = "Passwort ist vorboten";
        } else {
            if (length >= 8 && containsNumber && containsUpAndLow) {
                Message = "Passwort akzeptiert.";
            } else if (length >= 8 && !containsNumber && !containsUpAndLow) {
                Message = "Fehlende Zahl/ Groß-, Kleinschreibung im Passwort.";
            } else if (length >= 8 && !containsUpAndLow) {
                Message = "Fehlende Groß/ Kleinschreibung im Passwort.";
            } else if (length >= 8 && !containsNumber) {
                Message = "Fehlende Zahl im Passwort.";
            } else {
                Message = "Passwort zu kurz!";
            }
        }
        return Message;
    }

    public static boolean checkNumber(String password){
        boolean containsNumber = true;
        int number[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < number.length; i++) {
            if (password.contains(String.valueOf(number[i]))){
                containsNumber = true;
                break;
            }else{
                containsNumber = false;
            }
        }
        return containsNumber;
    }

    public static boolean checkUpperCase(String password) {
        char[] c = password.toCharArray();
        boolean containUp = false;
        boolean containLow = false;
        for (int i = 0; i < c.length; i++) {
            if (Character.isUpperCase(c[i])) {
                containUp = true;
            } else if (Character.isLowerCase(c[i])) {
                containLow = true;
            }
        }
        return containUp && containLow;
    }

    public static boolean checkBadPasswords(String password) {
        ArrayList<String> badPasswords = new ArrayList<String>();
        badPasswords.add("A12345678");
        badPasswords.add("passworD123");
        badPasswords.add("Password123");
        badPasswords.add("Qwerty123");
        boolean badPassword;
        if (badPasswords.contains(password)) {
            badPassword = true;
        } else {
            badPassword = false;
        }
        return badPassword;
    }
}