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
		Contact contact1 = new Contact("bob", "1234567890");
		Contact contact2 = new Contact("bob", "1234567890");
		Contact contact3 = new Contact("bob", "1234567890");
//		String TestContact = String.valueOf(contact.getName());
		MainMenu menu = new MainMenu();
		menu.objectToString(contact2);
		menu.objectToString(contact3);
//		menu.mainMenu();
		Path dataFolder = Paths.get("src/src/data");
		Path filePath = Paths.get("src/src/data", "contacts.txt");
//		List<String> contactList = Arrays.asList(contact.getNumber());
//		try{
//			Files.write(filePath, contactList);
//		} catch (IOException ioe){
//			ioe.printStackTrace();
//		}
		List<Contact> users = new ArrayList<Contact>();
		Contact user1 = new Contact ("1","Eric");

		Contact user2 = new Contact ("2","John");
		Contact user3 = new Contact ("3","Ram");

		users.add(contact1);
		users.add(contact2);
		users.add(contact3);
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
}



// try {
//		 Files.write(pathToOurFile, imperials);
//		 } catch (IOException ioe){
//		 ioe.printStackTrace();
//		 }
