import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Loan extends LibraryEntity {
	@ManyToOne
	private Member member;
	@ManyToOne
	private Publication publication;
	private Date endDate;
	private Date startDate;

	public Loan(Member member, Publication publication, Date StartDate, Date endDate) {
		this.member = member;
		this.publication = publication;
		this.startDate = startDate;
		this.endDate = endDate;
	}
}
