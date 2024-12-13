public class Voter extends User {
    private int age;
    private String password;
    private boolean hasVoted;

    public Voter(String name, int age, String password) {
        super(name);
        this.age = age;
        this.password = password;
        this.hasVoted = false;
    }

    public int getAge() {
        return age;
    }

    public String getPassword() {
        return password;
    }

    public boolean hasVoted() {
        return hasVoted;
    }

    public void vote() {
        if (!hasVoted) {
            hasVoted = true;
            System.out.println("Vote cast successfully by " + getName());
        } else {
            System.out.println("You have already voted!");
        }
    }

    @Override
    public void performRole() {
        System.out.println("I am a voter. My name is " + getName());
    }
}
