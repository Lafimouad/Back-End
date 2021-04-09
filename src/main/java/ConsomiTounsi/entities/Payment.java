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
public class Payment implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private   Long id;

    private   Long customerId;
    @Temporal(TemporalType.DATE)
    private Date date;
    private String description;
    @OneToOne
    Order order;
}
