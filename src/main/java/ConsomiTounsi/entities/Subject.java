package ConsomiTounsi.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
public class Subject implements Serializable {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id_subject;
	
	private boolean redendant_subject;
	private boolean featured_subject;
	private String description_subject;
	private int likes_subject;

	public int getId_subject() {
		return id_subject;
	}

	public void setId_subject(int id_subject) {
		this.id_subject = id_subject;
	}

	public boolean isRedendant_subject() {
		return redendant_subject;
	}

	public void setRedendant_subject(boolean redendant_subject) {
		this.redendant_subject = redendant_subject;
	}

	public boolean isFeatured_subject() {
		return featured_subject;
	}

	public void setFeatured_subject(boolean featured_subject) {
		this.featured_subject = featured_subject;
	}

	public String getDescription_subject() {
		return description_subject;
	}

	public void setDescription_subject(String description_subject) {
		this.description_subject = description_subject;
	}

	public int getLikes_subject() {
		return likes_subject;
	}

	public void setLikes_subject(int likes_subject) {
		this.likes_subject = likes_subject;
	}
	@ManyToOne
	User user;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="subject")
	private Set<Comment> comment;
}
