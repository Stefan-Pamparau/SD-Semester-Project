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

import model.planner.taskboard.TaskBoard;
import service.TaskBoardService;
import service.exception.ServiceException;

/**
 * Controller mapped to respond to task board specific requests.
 *
 * @author Stefan Pamparau
 */
@RestController
@RequestMapping(path = "/taskBoard")
public class TaskBoardController {
    @Autowired
    private TaskBoardService taskBoardService;

    @RequestMapping(path = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<TaskBoard> getTaskBoardForId(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity<>(taskBoardService.getTaskBoard(id), HttpStatus.ACCEPTED);
        } catch (ServiceException e) {
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/insert", method = RequestMethod.POST)
    public ResponseEntity<?> insertTaskBoard(@RequestBody TaskBoard taskBoard) {
        try {
            taskBoardService.insertTaskBoard(taskBoard);

            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setLocation(ServletUriComponentsBuilder
                    .fromCurrentRequest().path("/{id}")
                    .buildAndExpand(taskBoard.getId()).toUri());

            return new ResponseEntity<>(taskBoard, httpHeaders, HttpStatus.CREATED);
        } catch (ServiceException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateTaskBoard(@RequestBody TaskBoard taskBoard) {
        try {
            taskBoardService.updateTaskBoard(taskBoard);

            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.ACCEPTED);
        } catch (ServiceException e) {
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteTaskBoard(@RequestBody TaskBoard taskBoard) {
        try {
            taskBoardService.deleteTaskBoard(taskBoard);

            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.ACCEPTED);
        } catch (ServiceException e) {
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteTaskBoardForId(@PathVariable("id") Integer id) {
        try {
            TaskBoard taskBoard = new TaskBoard();
            taskBoard.setId(id);
            taskBoardService.deleteTaskBoard(taskBoard);

            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.ACCEPTED);
        } catch (ServiceException e) {
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
