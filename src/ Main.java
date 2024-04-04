public class Main {
    public static void main(String[] args) {
        // Check if command line arguments are present
        if (args.length == 0) {
            System.out.println("No command-line arguments provided.");
        } else {
            System.out.println("Provided command-line arguments:");
            // Print out the provided command-line arguments
            for (int i = 0; i < args.length; i++) {
                System.out.println("Argument " + (i + 1) + ": " + args[i]);
            }
        }
    }
}