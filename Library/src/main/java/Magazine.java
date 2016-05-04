import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("magazine")
public class Magazine extends Publication {
	@Column(name = "issn")
	private String issn;
	
	public Magazine(String title, String issn){
		this.title = title;
		this.issn = issn;
		
				
	}
	public Magazine() {

	}
	
	

	public String getIssn() {
		return issn;
	}

	

	public void setIssn(String issn) {
		this.issn = issn;

	}
	
	public void printMagazine(){
		System.out.println("Id - " + id + " Title - " + title + " isbn - " +issn);
		
		
	}
	
}
