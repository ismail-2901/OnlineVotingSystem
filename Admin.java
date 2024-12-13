public class Admin extends User {
    private static final String ADMIN_PASSWORD = "admin123";

    public Admin() {
        super("Admin");
    }

    public boolean authenticate(String password) {
        return ADMIN_PASSWORD.equals(password);
    }

    @Override
    public void performRole() {
        System.out.println("I am the admin. I manage the voting system.");
    }
}
