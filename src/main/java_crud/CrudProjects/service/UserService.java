package CrudProjects.service;

import CrudProjects.dao.UserDAO;
import CrudProjects.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    private UserDAO userDAO;

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserById(Long id) {
        return userDAO.getUserById(id);
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        userDAO.saveUser(user);

    }

    @Transactional
    @Override
    public void updateUser(long id, User updatedUser) {
        userDAO.updateUser(id, updatedUser);

    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        userDAO.deleteUser(id);

    }
}
