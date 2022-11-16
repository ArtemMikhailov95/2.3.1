package web.servers;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAO;
import web.models.User;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServerImpl implements UserServer {

    private final UserDAO userDAO;

    public UserServerImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public void create(User user) {
        userDAO.create(user);
    }

    @Override
    public User read(int id) {
        return userDAO.read(id);
    }

    @Override
    public List<User> readAll() {
        return userDAO.readAll();
    }

    @Override
    @Transactional
    public void update(User user, int id) {
        userDAO.update(user, id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userDAO.delete(id);
    }
}
