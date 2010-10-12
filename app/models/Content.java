package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Lob;

import play.db.jpa.Model;

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
