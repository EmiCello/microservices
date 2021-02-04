package app1.dal;

import app1.domains.UpdateUserRequest;
import app1.domains.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDalImpl implements UserDal{

    @Autowired
    private MongoOperations mongoTemplate;

    @Override
    public List<User> getAll() {
        return mongoTemplate.findAll(User.class);
    }

    @Override
    public User create(User user) {
        return  mongoTemplate.insert(user);
    }

    @Override
    public User findById(String id) {
        return mongoTemplate.findById(id, User.class);
    }

    @Override
    public User deleteById(String id) {
        return mongoTemplate.findAndRemove(Query.query(Criteria.where("id").is(id)), User.class);
    }

    @Override
    public User findByUserEmail(String userEmail) {
        return mongoTemplate.findOne(Query.query(Criteria.where("email").is(userEmail)), User.class);
    }

    @Override
    public User updateById(String id, UpdateUserRequest request) {
        User userToUpdate = mongoTemplate.findOne(Query.query(Criteria.where("id").is(id)), User.class);
        if (userToUpdate == null) {
            return null;
        }
        if (request.getFirstName() != null) {
            userToUpdate.setFirstName(request.getFirstName());
        }
        if (request.getLastName() != null) {
            userToUpdate.setFirstName(request.getLastName());
        }

        return mongoTemplate.save(userToUpdate);
    }
}