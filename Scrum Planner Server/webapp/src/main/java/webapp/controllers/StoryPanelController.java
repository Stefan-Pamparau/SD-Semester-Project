package webapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import model.planner.taskboard.StoryPanel;
import service.StoryPanelService;
import service.exception.ServiceException;

/**
 * Controller mapped to respond to story panel specific requests.
 *
 * @author Stefan Pamparau
 */
@RestController
@RequestMapping(path = "/storyPanel")
public class StoryPanelController {
    @Autowired
    private StoryPanelService storyPanelService;

    @RequestMapping(path = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<StoryPanel> getStoryPanelForId(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity<>(storyPanelService.getStoryPanel(id), HttpStatus.ACCEPTED);
        } catch (ServiceException e) {
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/insert", method = RequestMethod.POST)
    public ResponseEntity<?> insertStoryPanel(@RequestBody StoryPanel storyPanel) {
        try {
            storyPanelService.insertStoryPanel(storyPanel);

            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setLocation(ServletUriComponentsBuilder
                    .fromCurrentRequest().path("/{id}")
                    .buildAndExpand(storyPanel.getId()).toUri());

            return new ResponseEntity<>(storyPanel, httpHeaders, HttpStatus.CREATED);
        } catch (ServiceException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateStoryPanel(@RequestBody StoryPanel storyPanel) {
        try {
            storyPanelService.updateStoryPanel(storyPanel);

            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.ACCEPTED);
        } catch (ServiceException e) {
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteStoryPanel(@RequestBody StoryPanel storyPanel) {
        try {
            storyPanelService.deleteStoryPanel(storyPanel);

            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.ACCEPTED);
        } catch (ServiceException e) {
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteStoryPanelForId(@PathVariable("id") Integer id) {
        try {
            StoryPanel storyPanel = new StoryPanel();
            storyPanel.setId(id);
            storyPanelService.deleteStoryPanel(storyPanel);

            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.ACCEPTED);
        } catch (ServiceException e) {
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
