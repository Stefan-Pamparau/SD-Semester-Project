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

import model.planner.user.RegularUser;
import service.RegularUserService;
import service.exception.ServiceException;

/**
 * Controller mapped to respond to regular user specific requests.
 *
 * @author Stefan Pamparau
 */
@RestController
@RequestMapping(path = "/regularUser")
public class RegularUserController {
    @Autowired
    private RegularUserService regularUserService;

    @RequestMapping(path = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<RegularUser> getRegularUserForId(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity<>(regularUserService.getRegularUser(id), HttpStatus.ACCEPTED);
        } catch (ServiceException e) {
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/get", method = RequestMethod.GET)
    public ResponseEntity<RegularUser> getRegularUserForId(@RequestParam("CNP") String CNP) {
        try {
            return new ResponseEntity<>(regularUserService.findRegularUserByCNP(CNP), HttpStatus.ACCEPTED);
        } catch (ServiceException e) {
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/insert", method = RequestMethod.POST)
    public ResponseEntity<?> insertProject(@RequestBody RegularUser regularUser) {
        try {
            regularUserService.insertRegularUser(regularUser);

            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setLocation(ServletUriComponentsBuilder
                    .fromCurrentRequest().path("/{id}")
                    .buildAndExpand(regularUser.getId()).toUri());

            return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
        } catch (ServiceException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public ResponseEntity<Void> updateProject(@RequestBody RegularUser regularUser) {
        try {
            regularUserService.updateRegularUser(regularUser);

            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.ACCEPTED);
        } catch (ServiceException e) {
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteProject(@RequestBody RegularUser regularUser) {
        try {
            regularUserService.deleteRegularUser(regularUser);

            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.ACCEPTED);
        } catch (ServiceException e) {
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
