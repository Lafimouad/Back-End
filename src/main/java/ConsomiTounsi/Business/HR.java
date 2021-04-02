package ConsomiTounsi.Business;

import ConsomiTounsi.Service.AdminManagerInterface;
import ConsomiTounsi.Service.ClientManagerInterface;
import ConsomiTounsi.Service.DelivererManagerInterface;
import ConsomiTounsi.Service.UserManagerInterface;
import ConsomiTounsi.entities.Admin;
import ConsomiTounsi.entities.Deliverer;
import ConsomiTounsi.repository.AdminRepository;
import ConsomiTounsi.repository.DelivererRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HR {
    @Autowired
    UserManagerInterface UserS;

    @Autowired
    AdminManagerInterface AdminS;

    @Autowired
    ClientManagerInterface ClientS;

    @Autowired
    DelivererManagerInterface DelivereS;

    @Autowired
    AdminRepository ar;

    @Autowired
    DelivererRepository dr;

    public void Abscent(String id){
        Admin a = AdminS.FindAdminById(id);
        a.setNbabsenceAdmin( a.getNbabsenceAdmin() +1); }

   public void resetAbsence(){
        ar.resetAbsence(0);
    }

    public void salaireAvecPrime(Deliverer D){
        D.setSalary(D.getBonusDeliverer() + D.getSalary()); }

    public double SalaireDeliveres(){
        return dr.SommeSaliareDelivere();
    }

    public double SommeSalaire(){
        return AdminS.getNbAdmin() * 1000 + SalaireDeliveres() ;
    }

    //prime delivere
    //deliverer of the month ( % prime deliverer)

}
