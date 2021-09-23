import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class MainMenu {
	//data paths
	Path dataFolder = Paths.get("src/src/data");
	Path filePath = Paths.get("src/src/data", "contacts.txt");

	//list to write to text file
	public List<String> stringContact = new ArrayList<>();

	//display contacts in console when view contacts is called
	public void outputContacts (Path pathToFile) {
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

	//write contact objects and adds them to the list.
	public void objectToList(Contact contact){
		String stringToAdd = contact.getName() + ", " + contact.getNumber();
		stringContact.add(stringToAdd);
	}

	//searches list for object specified
	private void searchContact(String contact) throws IOException {
		List<String> lines = Files.readAllLines(filePath);
		for (String line : lines) {
			if (line.contains(contact)) {
				System.out.println(line);
			}
		}
	}

	//console menu
	public void mainMenu() throws IOException {
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
			//option 1 view contacts
			if (userRequest == 1) {
				outputContacts(filePath);
				System.out.println("");
				mainMenu();
			}
			//option 2 add a new contact
			else if (userRequest == 2){
				System.out.println("Okay, let's make a new contact! Enter the name first.");
				String newContactName = sc.next() + sc.nextLine();
				System.out.println("Okay, now enter the phone number without any spaces");
				String newContactNumber = sc.nextLine();
				Contact customContact = new Contact(newContactName, newContactNumber);
				objectToList(customContact);
				Files.write(filePath, stringContact, StandardOpenOption.APPEND);
				System.out.println("Your new contact has been added to the list.");
				System.out.println("");
				mainMenu();
			}
			//option 3 search for a contact
			else if (userRequest == 3){
				System.out.println("Which contact would you like to search for?");
				String userContactSearch = sc.next() + sc.nextLine();
				searchContact(userContactSearch);
				System.out.println("");
				mainMenu();
			}
			//option 4 delete a contact
			else if (userRequest == 4){
				System.out.println("Which contact would you like to delete?");
				String contactToDelete = sc.next() + sc.nextLine();
			}
		} else if (userRequest >= 6) {
			System.out.println("You entered an invalid number choice. Please pick a correct number.");
			System.out.println("");
			mainMenu();
		}
//		System.out.println("Thank you for using our app.");

	}

}
