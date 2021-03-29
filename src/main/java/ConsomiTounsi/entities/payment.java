package ConsomiTounsi.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class payment implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private   Long payment_id;

    private   Long payment_customer_id;
    @Temporal(TemporalType.DATE)
    private Date payment_date;
    private double payment_amount;
    private  String payment_description;
}
