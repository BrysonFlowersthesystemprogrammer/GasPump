import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // We use LinkedHashMap to keep the students in the order they were entered
    Map<String, String> students = new LinkedHashMap<>();

    System.out.println("Please provide the student names and then q to quit");

    // 1. Collect Names
    while (true) {
      System.out.print("> ");
      String input = scanner.nextLine().trim();
      if (input.equalsIgnoreCase("q")) {
        break;
      }
      if (!input.isEmpty()) {
        students.put(input, "N"); // Default status is 'N'
      }
    }

    // 2. Validate early exit
    if (students.isEmpty()) {
      System.out.println("No students were provided");
      return;
    }

    // 3. Action Menu
    while (true) {
      System.out.print("[check] sign ins, [sign] in, or [q]uit: ");
      String action = scanner.nextLine().trim().toLowerCase();

      if (action.equals("q")) {
        break;
      } else if (action.equals("check")) {
        // Print each student and their status
        for (Map.Entry<String, String> entry : students.entrySet()) {
          System.out.println("> " + entry.getKey() + ": " + entry.getValue());
        }
      } else if (action.equals("sign")) {
        System.out.print("> ");
        String nameToSign = scanner.nextLine().trim();
        if (students.containsKey(nameToSign)) {
          students.put(nameToSign, "Y");
        } else {
          System.out.println("Student not found.");
        }
      }
    }
  }
}
