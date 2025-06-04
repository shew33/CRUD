package CrudProjects.dao;

import CrudProjects.model.User;
import java.util.List;

public interface UserDAOInterface {

    List<User> getAllUsers();

    void saveUser(User user);

    User getUserById(Long id);

    void updateUser(long id, User updatedUser);

    void deleteUser(Long id);
}
