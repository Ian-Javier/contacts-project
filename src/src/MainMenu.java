import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
	Path dataFolder = Paths.get("src/src/data");
	Path filePath = Paths.get("src/src/data", "contacts.txt");

	public void readFileAndOutput (Path pathToFile) {
		List<String> linesInTheFile = new ArrayList<>();
		try {
			linesInTheFile = Files.readAllLines(pathToFile);
		} catch (IOException ioe){
			ioe.printStackTrace();
		}
		for (String line : linesInTheFile){
			System.out.println(line);
		}
	}
	public void mainMenu() {
		System.out.println("Hello, what would you like to do today?");
		System.out.println("1. View Contacts");
		System.out.println("2. Add a new contact");
		System.out.println("3. Search a contact by name");
		System.out.println("4. Delete an existing contact");
		System.out.println("5. Exit");
		System.out.println("Please pick a number 1-5 and nothing more");
		Scanner sc = new Scanner(System.in);
		int userRequest = sc.nextInt();
		if (userRequest < 6) {
			while (userRequest != 5) {
				if (userRequest == 1) {
					readFileAndOutput(filePath);
				}
			}
			System.out.println("Thank you for using our app.");
		} else if (userRequest >= 6){
			System.out.println("You entered an invalid number choice. Please pick a correct number.");
			mainMenu();
		}
	}
}
