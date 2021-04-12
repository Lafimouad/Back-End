package ConsomiTounsi.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Feedback implements Serializable {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id_feedback;
	
	private float note ;
	
	private String description_feedback;

	public int getId_feedback() {
		return id_feedback;
	}

	public void setId_feedback(int id_feedback) {
		this.id_feedback = id_feedback;
	}

	public String getDescription_feedback() {
		return description_feedback;
	}

	public void setDescription_feedback(String description_feedback) {
		this.description_feedback = description_feedback;
	}
	public float getNote() {
		return note;
	}

	public void setNote(float note) {
		this.note = note;
	}
	@OneToOne
	Product product;

}
