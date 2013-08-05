/**
 * 
 * @author James Roberts jpr242
 *
 */
public class Word implements Comparable<Word>{

	private String word, partOfSpeach, definition;
	
	public Word(String word, String partOfSpeach, String definition) {
		this.word = word;
		this.partOfSpeach = partOfSpeach;
		this.definition = definition;
	}
	
	
	
	/**
	 * @return the word
	 */
	public String getWord() {
		return word;
	}



	/**
	 * @param word the word to set
	 */
	public void setWord(String word) {
		this.word = word;
	}



	/**
	 * @return the partOfSpeach
	 */
	public String getPartOfSpeach() {
		return partOfSpeach;
	}



	/**
	 * @param partOfSpeach the partOfSpeach to set
	 */
	public void setPartOfSpeach(String partOfSpeach) {
		this.partOfSpeach = partOfSpeach;
	}



	/**
	 * @return the definition
	 */
	public String getDefinition() {
		return definition;
	}



	/**
	 * @param definition the definition to set
	 */
	public void setDefinition(String definition) {
		this.definition = definition;
	}



	@Override
	public int compareTo(Word toCompare) {
		return this.word.compareToIgnoreCase(toCompare.getWord());
	}
	
	
	public String toString() {
		return this.word + "-" + this.partOfSpeach + "-" + this.definition;
	}
}
