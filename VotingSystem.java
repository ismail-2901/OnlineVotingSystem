import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VotingSystem {
    private List<Voter> voters;
    private List<Candidate> candidates;
    private Admin admin;

    public VotingSystem() {
        voters = new ArrayList<>();
        candidates = new ArrayList<>();
        admin = new Admin();
        initializeCandidates();
    }

    private void initializeCandidates() {
        candidates.add(new Candidate("BAL"));
        candidates.add(new Candidate("BNP"));
        candidates.add(new Candidate("BJI"));
    }

    public void registerVoter(String name, int age, String password) {
        if (age < 18) {
            System.out.println("Voter must be at least 18 years old.");
            return;
        }
        voters.add(new Voter(name, age, password));
        System.out.println("Voter registered successfully!");
    }

    public void loginVoter(String name, String password) {
        for (Voter voter : voters) {
            if (voter.getName().equals(name) && voter.getPassword().equals(password)) {
                System.out.println("Login successful! Welcome, " + name);
                castVote(voter);
                return;
            }
        }
        System.out.println("Invalid credentials. Please try again.");
    }

    private void castVote(Voter voter) {
        if (voter.hasVoted()) {
            System.out.println("You have already voted.");
            return;
        }

        System.out.println("Available candidates:");
        for (int i = 0; i < candidates.size(); i++) {
            System.out.println((i + 1) + ". " + candidates.get(i).getName());
        }

        System.out.print("Enter the number of the candidate you want to vote for: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if (choice < 1 || choice > candidates.size()) {
            System.out.println("Invalid choice. Vote not cast.");
            return;
        }

        candidates.get(choice - 1).addVote();
        voter.vote();
    }

    public void loginAdmin(String password) {
        if (!admin.authenticate(password)) {
            System.out.println("Invalid admin password.");
            return;
        }

        System.out.println("Login successful! Welcome, Admin.");
        viewResults();
    }

    private void viewResults() {
        System.out.println("Election Results:");
        for (Candidate candidate : candidates) {
            System.out.println(candidate.getName() + ": " + candidate.getVoteCount() + " votes");
        }
    }

    // Edit Voter Information
    public void editVoterInfo(String name) {
        for (Voter voter : voters) {
            if (voter.getName().equals(name)) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Edit Voter Info - " + name);

                System.out.print("Enter new age: ");
                int newAge = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                System.out.print("Enter new password: ");
                String newPassword = scanner.nextLine();

                voter = new Voter(voter.getName(), newAge, newPassword);
                System.out.println("Voter information updated successfully!");
                return;
            }
        }
        System.out.println("Voter not found.");
    }

    // Delete Voter Information
    public void deleteVoter(String name) {
        for (Voter voter : voters) {
            if (voter.getName().equals(name)) {
                voters.remove(voter);
                System.out.println("Voter " + name + " deleted successfully.");
                return;
            }
        }
        System.out.println("Voter not found.");
    }
}
