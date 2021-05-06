package ConsomiTounsi.controllers.accounts;

import ConsomiTounsi.Service.AdminManagerInterface;
import ConsomiTounsi.entities.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ressources/admin")
@CrossOrigin(origins = "*")
@RestController
public class AdminRessources {
    @Autowired
    AdminManagerInterface cs;

    @GetMapping("/all")
    public ResponseEntity<List<Admin>> getAllEmployees () {
        List<Admin> employees = cs.retrieveAllAdmin();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Admin> addEmployee(@RequestBody Admin employee) {
        Admin newEmployee = cs.AddAdmin(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Admin> getEmployeeById (@PathVariable("id") Long id) {
        Admin employee = cs.FindAdminById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Admin> updateEmployee(@RequestBody Admin employee) {
        Admin updateEmployee = cs.updateAdmin(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        cs.deleteAdminById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
