import java.util.Scanner;

public class OnlineVotingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VotingSystem votingSystem = new VotingSystem();

        while (true) {
            System.out.println("\n--- Online Voting System ---");
            System.out.println("1. Register as Voter");
            System.out.println("2. Login as Voter");
            System.out.println("3. Login as Admin");
            System.out.println("4. Edit Voter Info");
            System.out.println("5. Delete Voter Info");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Voter Name: ");
                    String voterName = scanner.nextLine();
                    System.out.print("Enter Voter Age: ");
                    int voterAge = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Set Password: ");
                    String voterPassword = scanner.nextLine();
                    votingSystem.registerVoter(voterName, voterAge, voterPassword);
                    break;

                case 2:
                    System.out.print("Enter Voter Name: ");
                    String loginName = scanner.nextLine();
                    System.out.print("Enter Password: ");
                    String loginPassword = scanner.nextLine();
                    votingSystem.loginVoter(loginName, loginPassword);
                    break;

                case 3:
                    System.out.print("Enter Admin Password: ");
                    String adminPassword = scanner.nextLine();
                    votingSystem.loginAdmin(adminPassword);
                    break;

                case 4:
                    System.out.print("Enter Voter Name to Edit: ");
                    String editName = scanner.nextLine();
                    votingSystem.editVoterInfo(editName);
                    break;

                case 5:
                    System.out.print("Enter Voter Name to Delete: ");
                    String deleteName = scanner.nextLine();
                    votingSystem.deleteVoter(deleteName);
                    break;

                case 6:
                    System.out.println("Exiting... Thank you!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
