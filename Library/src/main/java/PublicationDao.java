import java.util.List;

public interface PublicationDao<T extends Publication> {
	public void add(T publication);
	public void update(T publication);
	public void delete(T publication);
	public List<T> list();
}
