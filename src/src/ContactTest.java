import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ContactTest {
	public static void main(String[] args) throws IOException {
		//data paths
		Path dataFolder = Paths.get("src/src/data");
		Path filePath = Paths.get("src/src/data", "contacts.txt");

		//instantiate main menu loop
		MainMenu menu = new MainMenu();

		//initial contact creation
		Contact contact1 = new Contact("Jeff Davis", "2104444444");
		Contact contact2 = new Contact("Jenny", "8675309");
		Contact contact3 = new Contact("John Doe", "2105555355");

		//moves contacts to list
		List<Contact> users = new ArrayList<>();
		users.add(contact1);
		users.add(contact2);
		users.add(contact3);
		//Turn contacts into strings and adds them to file
		menu.writeContactsToFile(users);

		//displays main menu
		menu.mainMenu();




	}
}



// try {
//		 Files.write(pathToOurFile, imperials);
//		 } catch (IOException ioe){
//		 ioe.printStackTrace();
//		 }
