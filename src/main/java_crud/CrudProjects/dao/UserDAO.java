package CrudProjects.dao;

import CrudProjects.model.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAO implements UserDAOInterface {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {

        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUserById(Long id) {

        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(long id, User updatedUser) {
        User userToBeUpdate = entityManager.find(User.class, id);
        userToBeUpdate.setName(updatedUser.getName());
        userToBeUpdate.setSurname(updatedUser.getSurname());
        userToBeUpdate.setAge(updatedUser.getAge());

    }

    @Override
    public void deleteUser(Long id) {
        User userToDeleted = getUserById(id);
        if (userToDeleted != null) {
            entityManager.remove(userToDeleted);
        }

    }
}
