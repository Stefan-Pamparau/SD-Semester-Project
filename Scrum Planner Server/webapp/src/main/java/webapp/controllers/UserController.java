package webapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.planner.user.User;
import service.UserService;
import service.exception.ServiceException;

/**
 * Controller mapped to user specific requests.
 *
 * @author Stefan Pamparau
 */
@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(path = "/get")
    public ResponseEntity<User> getUserForEmailAndPassword(@RequestParam("email") String email, @RequestParam("password") String password) {
        try {
            User user = userService.getUserByEmailAndPassword(email, password);
            return new ResponseEntity<>(user, new HttpHeaders(), HttpStatus.ACCEPTED);
        } catch (ServiceException e) {
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
