package model;

public class Login {
    private User registeredUser;
    private User currentUser;

    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password) {
        return password.length() >= 8 &&
               password.matches(".*[A-Z].*") &&
               password.matches(".*[0-9].*") &&
               password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
    }

    public boolean checkCellPhoneNumber(String number) {
        return number.matches("^\\+27\\d{9}$");
    }

    public String registerUser(String firstName, String lastName, String username, String password, String cell) {
        boolean userOk = checkUserName(username);
        boolean passOk = checkPasswordComplexity(password);
        boolean cellOk = checkCellPhoneNumber(cell);

        StringBuilder sb = new StringBuilder();

        if (!userOk)
            sb.append("username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.\n");
        else
            sb.append("username successfully captured.\n");

        if (!passOk)
            sb.append("password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number , and a special character.\n");
        else
            sb.append("password successfully captured\n");

        if (!cellOk)
            sb.append("cell phone number incorrectly formatted or does not contain international code.\n");
        else
            sb.append("cell phone number successfully added\n");

        if (userOk && passOk && cellOk) {
            registeredUser = new User(firstName, lastName, username, password, cell);
        }

        return sb.toString();
    }

    public boolean logInUser(String username, String password) {
        if (registeredUser != null && registeredUser.getUsername().equals(username) &&
            registeredUser.getPassword().equals(password)) {
            currentUser = registeredUser;
            return true;
        }
        return false;
    }

    public String returnLoginStatus() {
        if (currentUser != null)
            return "welcome " + currentUser.getFirstName() + ", " + currentUser.getLastName() + " it is great to see you again.";
        return "username or password incorrect, please try again.";
    }
}

