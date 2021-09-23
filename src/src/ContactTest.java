import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


public class ContactTest {
	public static void main(String[] args) throws IOException {
		//data paths
		Path dataFolder = Paths.get("src/src/data");
		Path filePath = Paths.get("src/src/data", "contacts.txt");

		//instantiate main menu loop
		MainMenu menu = new MainMenu();
		menu.mainMenu();
		System.out.println("Thank you for using our app.");

	}
}
