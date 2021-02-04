package app1.dal;

import app1.dao.UserDao;
import app1.domains.UpdateUserRequest;
import app1.domains.User;

public interface UserDal extends UserDao<User> {
    User findByUserEmail(String userEmail);
    User updateById(String id, UpdateUserRequest request);
}