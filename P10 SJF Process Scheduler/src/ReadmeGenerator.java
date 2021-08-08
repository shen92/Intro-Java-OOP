import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ReadmeGenerator {

  public static void main(String[] args) throws FileNotFoundException {
    File file = new File("Readme.txt");
    PrintWriter printWriter = new PrintWriter("Readme.txt");
    Scanner sc = new Scanner(System.in);
    System.out.print("User input: ");
      String input = sc.nextLine();
      printWriter.println(input);
    System.out.println("Readme.txt created.");
    printWriter.close();
  }
}
