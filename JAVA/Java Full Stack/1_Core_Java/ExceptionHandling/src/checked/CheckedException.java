package checked;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CheckedException {

	void readFile() throws FileNotFoundException{
			FileInputStream fis = new FileInputStream("");
		
	}

	public static void main(String[] args) throws FileNotFoundException{

		CheckedException ce = new CheckedException();
		ce.readFile();

	}

}
