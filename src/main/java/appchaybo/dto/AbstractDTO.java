package appchaybo.dto;

public class AbstractDTO<T> {
	
	public void setId(Long id) {
		this.id = id;
	}

	private Long id;

	public Long getId() {
		return id;
	}	
}
