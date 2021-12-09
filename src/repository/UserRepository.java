package repository;

import datasource.UserDataSource;
import model.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository implements Repository<Long, User> {

    private final UserDataSource<User> userDataSource = UserDataSource.getInstance();

    @Override
    public User save(User user) {
        return userDataSource.insert(user);
    }

    @Override
    public User findById(Long id) {
        return userDataSource.findEntity(id);
    }
}
