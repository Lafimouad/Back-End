package ConsomiTounsi.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity

public class Comment implements Serializable {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id_comment;
	
	private int likes_comment;
	private boolean prohibitedDict_comment;
	private boolean mostPertinat_comment;


	public int getId_comment() {
		return id_comment;
	}

	public void setId_comment(int id_comment) {
		this.id_comment = id_comment;
	}

	public int getLikes_comment() {
		return likes_comment;
	}

	public void setLikes_comment(int likes_comment) {
		this.likes_comment = likes_comment;
	}

	public boolean isProhibitedDict_comment() {
		return prohibitedDict_comment;
	}

	public void setProhibitedDict_comment(boolean prohibitedDict_comment) {
		this.prohibitedDict_comment = prohibitedDict_comment;
	}

	public boolean isMostPertinat_comment() {
		return mostPertinat_comment;
	}

	public void setMostPertinat_comment(boolean mostPertinat_comment) {
		this.mostPertinat_comment = mostPertinat_comment;
	}
}
