package app1.service;

import app1.dal.UserDal;
import app1.domains.UpdateUserRequest;
import app1.domains.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDal userDal;

    @Override
    public List<User> getAll() {
        return userDal.getAll();
    }

    @Override
    public User create(User user) {
        return userDal.create(User.builder()
            .email(user.getEmail())
            .firstName(user.getFirstName())
            .lastName(user.getLastName())
            .age(user.getAge())
            .build());
    }

    @Override
    public User findById(String id) {
        return userDal.findById(id);
    }

    @Override
    public User deleteById(String id) {
        return userDal.deleteById(id);
    }

    @Override
    public User findByUserEmail(String userEmail) {
        return userDal.findByUserEmail(userEmail);
    }

    @Override
    public User updateById(String id, UpdateUserRequest request) {
        return userDal.updateById(id, request);
    }
}