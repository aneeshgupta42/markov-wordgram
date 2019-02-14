
/**
 * A WordGram represents a sequence of strings
 * just as a String represents a sequence of characters
 * 
 * @author Aneesh Gupta
 *
 */
public class WordGram {
	
	private String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Create WordGram (add comments)
	 * @param source
	 * @param start
	 * @param size
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		for(int i =0; i<size; i++) {
			myWords[i]=source[start+i];
		}
		myToString = "";
		myHash = 5;
		
		// TODO: initialize myWords and others as needed
	}

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * Complete this comment
	 * @return
	 */
	public int length(){
		// TODO: change this
		int len = this.myWords.length;
		return len;
	}


	@Override
	public boolean equals(Object o) {
		if (! (o instanceof WordGram) || o == null){
			return false;
		}
		WordGram other = (WordGram) o;
		if(this.myWords.length != other.myWords.length) {
			return false;
		}
		
		for (int i=0; i<this.myWords.length; i++) {
			if(!this.myWords[i].equals(other.myWords[i])) {
				return false;
			}
		}

	    // TODO: complete this method
		return true;
	}

	@Override
	public int hashCode(){
		// TODO: complete this method
		if (myHash == 5) {
			myHash = this.toString().hashCode();
		}
		return myHash;
	}
	

	/**
	 * Create and complete this comment
	 * @param last is last String of returned WordGram
	 * @return
	 */
	public WordGram shiftAdd(String last) {
		int start=1;
		String[] temp= new String[myWords.length];
		for (int i=0;i<myWords.length - 1;i++) {
			temp[i]= this.myWords[start+i];
		}
		temp[myWords.length - 1]= last;
		WordGram wg = new WordGram(temp,0,myWords.length);
		// TODO: Complete this method
		return wg;
	}

	@Override
	public String toString(){
		// TODO: Complete this method
		if (myToString.equals("")) {
			myToString = String.join(" ", myWords);	
		}
		return myToString;
	}
}
