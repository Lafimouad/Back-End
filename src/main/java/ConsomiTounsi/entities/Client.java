package ConsomiTounsi.entities;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity

public class Client extends User implements Serializable {

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private double Latitude;
	private double Longitude;



    public double getLatitude() {
		return Latitude;
	}



	public void setLatitude(double latitude) {
		Latitude = latitude;
	}



	public double getLongitude() {
		return Longitude;
	}



	public void setLongitude(double longitude) {
		Longitude = longitude;
	}

	@ManyToOne
    Message message;

}
