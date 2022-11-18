package web.servers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAO;
import web.models.User;

import java.util.List;

@Service
public class UserServerImpl implements UserServer {

    private final UserDAO userDAO;

    @Autowired
    public UserServerImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    @Override
    public void create(User user) {
        userDAO.create(user);
    }

    @Transactional
    @Override
    public User read(int id) {
        return userDAO.read(id);
    }

    @Transactional
    @Override
    public List<User> readAll() {
        return userDAO.readAll();
    }

    @Transactional
    @Override
    public void update(User user, int id) {
        userDAO.update(user, id);
    }

    @Transactional
    @Override
    public void delete(int id) {
        userDAO.delete(id);
    }
}
