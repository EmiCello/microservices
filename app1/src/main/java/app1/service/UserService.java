package app1.service;

import app1.domains.UpdateUserRequest;
import app1.domains.User;

import java.util.List;

public interface UserService {
    List<User> getAll() ;

    User create(User user);

    User findById(String id);

    User deleteById(String id);

    User findByUserEmail(String userEmail);

    User updateById(String id, UpdateUserRequest request);
}
