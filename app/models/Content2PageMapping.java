package models;

//@author Sven Malvik

import play.db.jpa.*;
import java.util.*;
import javax.persistence.*;

@Entity
public class Content2PageMapping extends Model {
	
	Content content;
	Page page;
	
	public Content2PageMapping(Content content, Page page) {
		this.content = content;
		this.page = page;
	}
}