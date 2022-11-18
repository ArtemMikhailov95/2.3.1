package web.servers;

import web.models.User;

import java.util.List;

public interface UserServer {
    void create(User user);
    User read(int id);
    List<User> readAll();
    void update(User user, int id);
    void delete(int id);
}
