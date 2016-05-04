import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Member extends LibraryEntity{
	@OneToMany(mappedBy = "member")
	private Set<Loan>loans;
	private String email;
	private String name;
	
	
	public void printMember(){
		System.out.println("Id - " + id + " email - " + email + " name - " +name);
		
		
	}
	
	
}
