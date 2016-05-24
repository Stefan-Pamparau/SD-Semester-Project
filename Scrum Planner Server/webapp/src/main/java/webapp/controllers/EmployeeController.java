package webapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import model.planner.user.Employee;
import service.EmployeeService;
import service.exception.ServiceException;

/**
 * Controller mapped to respond to employee specificc requests.
 *
 * @author Stefan Pamparau
 */
@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(path = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<Employee> getEmployeeForId(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity<>(employeeService.getEmployee(id), new HttpHeaders(), HttpStatus.ACCEPTED);
        } catch (ServiceException e) {
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/get", method = RequestMethod.GET)
    public ResponseEntity<Employee> getEmployeeForCNP(@RequestParam("CNP") String CNP) {
        try {
            return new ResponseEntity<>(employeeService.findEmployeeByCNP(CNP), new HttpHeaders(), HttpStatus.ACCEPTED);
        } catch (ServiceException e) {
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/insert", method = RequestMethod.POST)
    public ResponseEntity<?> insertEmployee(@RequestBody Employee employee) {
        try {
            employeeService.insertEmployee(employee);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setLocation(ServletUriComponentsBuilder
                    .fromCurrentRequest().path("/{id}")
                    .buildAndExpand(employee.getId()).toUri());

            return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
        } catch (ServiceException e) {
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateEmployee(@RequestBody Employee employee) {
        try {
            employeeService.updateEmployee(employee);
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.ACCEPTED);
        } catch (ServiceException e) {
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/delete", method = RequestMethod.PUT)
    public ResponseEntity<Void> deleteEmployee(@RequestBody Employee employee) {
        try {
            employeeService.deleteEmployee(employee);
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.ACCEPTED);
        } catch (ServiceException e) {
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
