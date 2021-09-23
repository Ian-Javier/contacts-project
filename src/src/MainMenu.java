import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

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
		System.out.println("Name  |  Phone number");
		System.out.println("---------------");
		for (String line : linesInTheFile){

			System.out.println(Arrays.toString(line.split(",")));
		}
	}

	public void writeContactsToFile(List<Contact> users){
		StringBuilder sb = new StringBuilder();

		for(Contact user:users){
			sb.append(user.getName()).append(",");
			sb.append(user.getNumber()).append("\n");
		}
		String commaDelimeterString=sb.toString();
		if( commaDelimeterString.length() > 0 )
			commaDelimeterString = commaDelimeterString.substring(0, commaDelimeterString.length() - 1);

		try{
			Files.write(filePath, Collections.singleton(commaDelimeterString));
		} catch (IOException ioe){
			ioe.printStackTrace();
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
			if (userRequest == 1) {
				readFileAndOutput(filePath);
				mainMenu();
			} else if (userRequest == 2){
				System.out.println("Okay, let's make a new contact! Enter the name first.");
				String newContactName = sc.nextLine();
				System.out.println("Okay, now enter the phone number without any spaces");
				String newContactNumber = sc.next() + sc.nextLine();
				Contact customContact = new Contact(newContactName, newContactNumber);
				System.out.println("Your new contact has been added to the list.");
				mainMenu();
			}
			System.out.println("Thank you for using our app.");
		} else if (userRequest >= 6){
			System.out.println("You entered an invalid number choice. Please pick a correct number.");
			mainMenu();
		}

	}

}
