package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import web.servers.UserServer;

@Controller
@RequestMapping()
public class UsersController {

    private final UserServer userServer;

    @Autowired
    public UsersController(UserServer userServer) {
        this.userServer = userServer;
    }

    @GetMapping(value = "/readAll")
    public String getUsers(Model model) {
        model.addAttribute("users", userServer.readAll());
        return "users/readAll";
    }

    @GetMapping(value = "/{id}")
    public String getUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userServer.read(id));
        return "users/read";
    }
}
