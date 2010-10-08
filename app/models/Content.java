package models;

import play.db.jpa.*;
import java.util.*;
import javax.persistence.*;

// @author Sven Malvik

@Entity
public class Content extends Model {
	
	@Lob
	public String content;
	public Date createdAt;
	public Date modifiedAt;

	public Content(String content) {
		this.content = content;
		createdAt = new Date();
		modifiedAt = createdAt;
	}
}
