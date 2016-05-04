import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.DiscriminatorType;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
public abstract class Publication extends LibraryEntity {
	@Column(name = "title")
	protected String title;
	@OneToMany(mappedBy = "publication")
	private Set<Loan>loans;
	
	public void setTitle(String title){
		this.title = title;
	}
	public String getTitle(){
		return title;
	}

	
	
}
