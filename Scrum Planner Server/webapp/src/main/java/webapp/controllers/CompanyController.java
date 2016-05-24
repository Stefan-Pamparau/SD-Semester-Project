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

import model.planner.user.Company;
import service.CompanyService;
import service.exception.ServiceException;

/**
 * Controller mapped to respond to company specific requests.
 *
 * @author Stefan Pamparau
 */
@RestController
@RequestMapping(path = "/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @RequestMapping(path = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<Company> getCompanyForId(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity<>(companyService.getCompany(id), new HttpHeaders(), HttpStatus.ACCEPTED);
        } catch (ServiceException e) {
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/get", method = RequestMethod.GET)
    public ResponseEntity<Company> getCompanyForRegistrationNumber(@RequestParam("registrationNumber") String registrationNumber) {
        try {
            return new ResponseEntity<>(companyService.findCompanyByRegistrationNumber(registrationNumber), new HttpHeaders(), HttpStatus.ACCEPTED);
        } catch (ServiceException e) {
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/insert", method = RequestMethod.POST)
    public ResponseEntity<?> insertCompany(@RequestBody Company company) {
        try {
            companyService.insertCompany(company);

            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setLocation(ServletUriComponentsBuilder
                    .fromCurrentRequest().path("/{id}")
                    .buildAndExpand(company.getId()).toUri());
            return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
        } catch (ServiceException e) {
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateCompany(@RequestBody Company company) {
        try {
            companyService.updateCompany(company);
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.ACCEPTED);
        } catch (ServiceException e) {
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteCompany(@RequestBody Company company) {
        try {
            companyService.deleteCompany(company);
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.ACCEPTED);
        } catch (ServiceException e) {
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
