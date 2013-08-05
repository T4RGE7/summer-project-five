import java.io.File;
import java.io.FileNotFoundException;
import java.util.Dictionary;
import java.util.Scanner;

/**
 * 
 * @author James Roberts jpr242
 *
 */
public class JavaDictionaryImporter {

	public JavaDictionaryImporter() {
		
	}
	
	public BSTDictionary getDictionaryFromText() {
		Scanner fin = null;
		try {
			fin = new Scanner(new File("dictionary.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BSTDictionary toReturn = new BSTDictionary();
		
		while(fin.hasNextLine()) {
			String line = fin.nextLine();
			String split[] = line.split("%");
			toReturn.add(new Word(split[0], split[1], split[2]));
		}
		fin.close();
		
		return toReturn;
	}
	
}
