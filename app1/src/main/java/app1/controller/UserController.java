package app1.controller;

import app1.HttpException;
import app1.domains.UpdateUserRequest;
import app1.domains.User;
import app1.service.UserService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserService service;
    @Autowired
    private
    EurekaClient eurekaClient;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @PostMapping("/user")
    public User createUser(@Valid @RequestBody User user) {
        logger.info("Creating user.");
        User result = service.create(user);
        if (result == null) {
            logger.info("Unknown problem during creating the user.");
            throw HttpException.builder()
                .httpStatus(500)
                .build();
        }
//        logger.info("User created successful");
//        Application application = eurekaClient.getApplication("notification-service");
//        InstanceInfo instanceInfo = application.getInstances().get(0);
//        String url = "http://" +instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/mail/feedback";
//        User object = restTemplate.getForObject(url, User.class);
        return result;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        logger.info("Getting all users.");
        List<User> result = service.getAll();
        if (result.isEmpty()) {
            logger.info("Users not found in DB.");
            return ResponseEntity.notFound().build();
        }
        logger.info("Amount of all users is " + result.size());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") String id) {
        logger.info("Getting user by id " + id);
        User foundUser = service.findById(id);
        if (foundUser == null) {
            logger.error(String.format("User %s wasn't found in DB", id));
            return ResponseEntity.notFound().build();
        }
        logger.debug("Found user with id " + id);
        return new ResponseEntity<>(foundUser, HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<User> deleteUserById(@PathVariable("id") String id) {
        logger.info("Deleting user by " + id);
        User deletedUser = service.deleteById(id);
        if (deletedUser == null) {
            logger.error("Error during deleting the user - user was not found.");
            return ResponseEntity.notFound().build();
        }
        String okMessage = "Deleted user " + deletedUser.getId();
        logger.info(okMessage);
        return ResponseEntity.ok(deletedUser);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") String id, @Valid @RequestBody UpdateUserRequest request) {
        logger.info("Updating user with id: " + id);
        User updatedUser = service.updateById(id, request);
        if (updatedUser == null) {
            logger.error("User wasn't updated, id: " + id);
            return ResponseEntity.notFound().build();
        }
        String okMessage = "Updated user with id: " + updatedUser.getId();
        logger.info(okMessage);
        return ResponseEntity.ok(updatedUser);
    }
}