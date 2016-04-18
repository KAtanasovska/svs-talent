
public class Word {

	private String word;
	private int occurance = 0;

	public Word(String w) {
		word = w;
		occurance += 1;
	}

	public void print() {
		System.out.println(word + " number of occurances " + occurance);

	}

	public boolean equals(String w) {

		if (word == w) {
			return true;
		} else {
			return false;
		}
	}
	
	public void increaseOccurance(){
		occurance+=1;
	}

}
