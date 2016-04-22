import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class WordCounter {

	public static void main(String[] args) {
	
			HashMap hm = new HashMap<String, Integer>();
		
		   try {
	            FileReader file = new FileReader("C:\\Users\\Kristinata\\Documents\\GitHub\\svs-talent\\WordCounter\\src\\Temp.txt");
	            BufferedReader buff = new BufferedReader(file);
	            boolean eof = false;
	            while (!eof) {
	                String line = buff.readLine();
	                if (line == null) {
	                    eof = true;

	                } else {
	                	String[] words = line.split(" ");
	                   for(int i = 0; i < words.length; i++){
	                	   String key = words[i].toLowerCase();
	                	   if(hm.containsKey(key)){
	                		   //value +1
	                		   int value = (int)hm.get(key);
	                		   hm.put(key, value+1);
	                	   }
	                	   else{
	                		   hm.put(key, 1);
	                	   }
	                   }
	                	
	                	// System.out.println(line);
	                }
	            }
	            buff.close();
	            

	        } catch (IOException e) {
	            System.out.println("Error — " + e.toString());

	        }
		   System.out.println(hm.entrySet());

	}

}
