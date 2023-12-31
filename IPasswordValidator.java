import java.util.regex.Pattern;

/**
 * This class should be implemented to provide password validation capabilities.
 * <p>
 * Objective:
 * Implement a method to check the validity of a given password based on certain criteria.
 * A valid password must:
 * - Be at least 8 characters long
 * - Include at least one uppercase letter
 * - Include at least one number
 * - Include at least one special character (e.g., !, @, #, etc.)
 * <p>
 * Example:
 * isValid("Password1!") should return true
 * isValid("password") should return false
 * isValid("Password1") should return false
 */
public class IPasswordValidator {

    public boolean isValid(String password) {
        boolean val = false;
        Pattern patternForUpperCaseLetter = Pattern.compile("[A-Z]");
        Pattern patternForDigit = Pattern.compile("[0-9]");
        Pattern patternForSpecialCharacter = Pattern.compile("[$&+,:;=\\\\?@#|/'<>.^*(){}~_ `%!-]");

        if (password != null) {
            if (password.length() >= 8) {
                if ((patternForUpperCaseLetter.matcher(password).find() && patternForDigit.matcher(password).find())
                        && patternForSpecialCharacter.matcher(password).find()) {
                    val = true;
                }
            }
        }
        return val;
    }


    //solution without regex
    public boolean isValid(String password) {
        boolean val = false;
        boolean dig = false, spec = false, upper = false;
        String special = "$&+,:;=?@#|/ '<>.^*(){}~_`%!-";

        if (password != null) {
            char[] array = password.toCharArray();
            if (password.length() >= 8) {
                for (int counter = 0; counter < array.length; counter++) {
                    if (Character.isDigit(array[counter])) {
                        dig = true;
                    }
                    if (Character.isLetter(array[counter]) && Character.isUpperCase(array[counter])) {
                        upper = true;
                    }
                    if (special.indexOf(array[counter]) != -1) {
                        spec = true;
                    }
                }
            }
        }
        if ((dig && upper) && spec) {
            val = true;
        }
        return val;
    }
}