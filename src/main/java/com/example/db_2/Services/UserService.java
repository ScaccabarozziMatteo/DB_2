package com.example.db_2.Services;

import com.example.db_2.POJO.Order;
import com.example.db_2.POJO.User;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {
    @PersistenceContext
    private EntityManager entityManager;

    public User findUserByEmail(String email){
        return entityManager.createNamedQuery("User.findByEmail",User.class).setParameter(1,email).getSingleResult();
    }

    public boolean isEmailPresent(String email){
        Query query = entityManager.createQuery( "select count (u) from User u where u.email =?1");

        query.setParameter(1,email);
        Long i = (Long) query.getSingleResult();
        return ((i.equals(0L))? false:true);
    }

    public User checkCredentials(String email, String pwd) throws NonUniqueResultException, MessageException {
        List<User> userList = null;
        try {
            userList = entityManager.createNamedQuery("User.checkCredentials", User.class).setParameter(1, email).setParameter(2, pwd)
                    .getResultList();
        } catch (PersistenceException e) {
            throw new MessageException("Could not verify credentials");
        }
        if (userList.isEmpty() || userList == null)
            throw new MessageException("Invalid credentials!");
        else if (userList.size() == 1)
            return userList.get(0);
        throw new NonUniqueResultException("Multiple user registered with same credentials!");

    }

    public int createUser(String email, String username, String password) throws MessageException{
        if(isEmailPresent(email)){
            throw new MessageException("This email is already registered!");
        }

        if(email.equals("")|| username.equals("") || password.equals("") ||email.isEmpty()|| username.isEmpty() || password.isEmpty() || email.length() > 31 || password.length() > 61){
            throw new MessageException("Can't register empty strings, insert valid credentials");
        }

        User u= new User();
        u.setEmail(email);
        u.setUsername(username);
        u.setPassword(password);
        entityManager.persist(u);
        entityManager.flush();
       return u.getId();
    }

    public List<Order> getUserOrders (int user_id) throws MessageException {
        User user =new User();
        user = entityManager.find(User.class,user_id);
        if (user == null)
        {
            throw new MessageException("User "+ user_id + " not found!");
        }

        Query query = entityManager.createQuery("select o from Order o, User u  where o.user=u and u.id = ?1 ");

        query.setParameter(1,user_id);

        return query.getResultList();

    }


}
