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

import model.planner.user.ProjectManager;
import service.ProjectManagerService;
import service.exception.ServiceException;

/**
 * Controller mapped to project manager specific requests.
 *
 * @author Stefan Pamparau
 */
@RestController
@RequestMapping(path = "/projectManager")
public class ProjectManagerController {
    @Autowired
    private ProjectManagerService projectManagerService;

    @RequestMapping(path = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<ProjectManager> getProjectManagerForId(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity<>(projectManagerService.getProjectManager(id), HttpStatus.ACCEPTED);
        } catch (ServiceException e) {
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/get", method = RequestMethod.GET)
    public ResponseEntity<ProjectManager> getProjectManagerForCNP(@RequestParam("CNP") String CNP) {
        try {
            return new ResponseEntity<>(projectManagerService.findProjectManagerByCNP(CNP), HttpStatus.ACCEPTED);
        } catch (ServiceException e) {
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/insert", method = RequestMethod.POST)
    public ResponseEntity<?> insertProjectManager(@RequestBody ProjectManager projectManager) {
        try {
            projectManagerService.insertProjectManager(projectManager);

            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setLocation(ServletUriComponentsBuilder
                    .fromCurrentRequest().path("/{id}")
                    .buildAndExpand(projectManager.getId()).toUri());

            return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
        } catch (ServiceException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public ResponseEntity<Void> updateProjectManager(@RequestBody ProjectManager projectManager) {
        try {
            projectManagerService.updateProjectManager(projectManager);

            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.ACCEPTED);
        } catch (ServiceException e) {
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteProjectManager(@RequestBody ProjectManager projectManager) {
        try {
            projectManagerService.deleteProjectManager(projectManager);

            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.ACCEPTED);
        } catch (ServiceException e) {
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
