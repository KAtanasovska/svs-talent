import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class LibraryEntity {
	@Id
	@GeneratedValue
	protected Long id;
	public Long getId(){
		return id;
	}
}
