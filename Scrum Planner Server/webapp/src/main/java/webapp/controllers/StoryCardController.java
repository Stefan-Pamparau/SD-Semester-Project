package webapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import model.planner.card.StoryCard;
import service.StoryCardService;
import service.exception.ServiceException;

/**
 * Controller mapped to respond to story cards specific requests.
 *
 * @author Stefan Pamparau
 */
public class StoryCardController {
    @Autowired
    private StoryCardService storyCardService;

    @RequestMapping(path = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<StoryCard> getStoryCardForId(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity<>(storyCardService.getStoryCard(id), HttpStatus.ACCEPTED);
        } catch (ServiceException e) {
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/insert", method = RequestMethod.POST)
    public ResponseEntity<?> insertStoryCard(@RequestBody StoryCard storyCard) {
        try {
            storyCardService.insertStoryCard(storyCard);

            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setLocation(ServletUriComponentsBuilder
                    .fromCurrentRequest().path("/{id}")
                    .buildAndExpand(storyCard.getId()).toUri());

            return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
        } catch (ServiceException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public ResponseEntity<Void> updateStoryCard(@RequestBody StoryCard storyCard) {
        try {
            storyCardService.updateStoryCard(storyCard);

            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.ACCEPTED);
        } catch (ServiceException e) {
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteStoryCard(@RequestBody StoryCard storyCard) {
        try {
            storyCardService.deleteStoryCard(storyCard);

            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.ACCEPTED);
        } catch (ServiceException e) {
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
