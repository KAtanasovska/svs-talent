
public class Numbers {

	public static void main(String[] args) {
	
		if(args.length < 1){
			System.out.println("You should put some arguments");
			return;
		}
		
		if(args.length>=10){
			System.out.println("This number is too big to be integer");
			return;
		}
		
		int theInteger = 0;
		for(int i = 0; i < args.length; i++){
			args[i]=args[i].toLowerCase();
			switch(args[i]){
			case "one":
				
				theInteger*=10;
				theInteger+=1;
				break;
			case "two":
				theInteger*=10;
				theInteger+=2;
				break;	
			case "three":
				theInteger*=10;
				theInteger+=3;
				break;
			case "four":
				theInteger*=10;
				theInteger+=4;
				break;
			case "five":
				theInteger*=10;
				theInteger+=5;
				break;	
			case "six":
				theInteger*=10;
				theInteger+=6;
				break;	
			case "seven":
				theInteger*=10;
				theInteger+=7;
				break;
			case "eight":
				theInteger*=10;
				theInteger+=8;
				break;	
			case "nine":
				theInteger*=10;
				theInteger+=9;
				break;	
			case "zero":
				theInteger*=10;
				break;
			default:
				break;
			}
			
		}
		System.out.println(theInteger);
			
		}	

	}


