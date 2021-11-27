package com.example.db_2.Services;

import com.example.db_2.POJO.OptionalProduct;
import com.example.db_2.POJO.Order;
import com.example.db_2.POJO.Package;
import com.example.db_2.POJO.User;
import org.aspectj.weaver.ast.Or;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderService {

    @PersistenceContext
    private EntityManager entityManager;


    public int createOrder(@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startSub, int validity, int user_id, int package_id, List<Integer> prod_ids ) throws MessageException {
        List<OptionalProduct> optionalProducts = new ArrayList<>();
        OptionalProduct op = new OptionalProduct();



        User user = new User();
        user = entityManager.find(User.class,user_id);
        if (user == null )
        {
            throw new MessageException("User is not logged!");
        }
        Package pack = new Package();
        pack = entityManager.find(Package.class,package_id);
        if (pack == null )
        {
            throw new MessageException("The selected package "+ package_id +" is not avaiable!");
        }

        Order order = new Order();
        order.setaPackage(pack);
        if(prod_ids!= null) {
            for (int prod_id : prod_ids) {
                op = entityManager.find(OptionalProduct.class, prod_id);
                if (op == null) {
                    throw new MessageException("Optional product " + prod_id + " is not avaiable!");
                }
                optionalProducts.add(op);

            }
            order.setOptionalProducts(optionalProducts);
        }
        order.setUser(user);
        order.setStart_subs(startSub);
        order.setValidity(validity);
        entityManager.persist(order);
        entityManager.flush();
        return order.getId();
    }

    public int setStatusPayed(Integer order_id) throws MessageException {
        if(order_id == null)
        {
            throw new MessageException("Invalid order id!");
        }
        Order order = new Order();

        order = entityManager.find(Order.class,order_id);

        if(order == null)
        {
            throw new MessageException("No order " + order_id +" was found!");
        }

        order.setStatus(1);
        return order.getStatus();
    }

    public int refusedPayment(Integer order_id) throws MessageException {
        if(order_id == null)
        {
            throw new MessageException("Invalid order id!");
        }
        Order order = new Order();

        order = entityManager.find(Order.class,order_id);

        if(order == null)
        {
            throw new MessageException("No order " + order_id +" was found!");
        }
        Integer i;
        i=order.getStatus();

        order.setStatus((i==0)? 2 : i+1);
        return order.getStatus();
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

    public List<Order> getUserOrdersPayed (int user_id) throws MessageException {
        User user =new User();
        user = entityManager.find(User.class,user_id);
        if (user == null)
        {
            throw new MessageException("User "+ user_id + " not found!");
        }

        Integer param1=1;
        Query query = entityManager.createQuery("select o from Order o, User u  where o.user=u and o.status=?1 and u.id = ?2 ");
        query.setParameter(1,param1);
        query.setParameter(2,user_id);

        return query.getResultList();

    }

    public List<Order> getUserOrdersRejected (int user_id) throws MessageException {
        User user =new User();
        user = entityManager.find(User.class,user_id);
        if (user == null)
        {
            throw new MessageException("User "+ user_id + " not found!");
        }

        Integer param1=1;
        Query query = entityManager.createQuery("select o from Order o, User u  where o.user=u and o.status>?1 and u.id = ?2 ");
        query.setParameter(1,param1);
        query.setParameter(2,user_id);

        return query.getResultList();

    }


    public List<Order> getUserOrdersCart (int user_id) throws MessageException {
        User user =new User();
        user = entityManager.find(User.class,user_id);
        if (user == null)
        {
            throw new MessageException("User "+ user_id + " not found!");
        }

        Integer param1=0;
        Query query = entityManager.createQuery("select o from Order o, User u  where o.user=u and o.status=?1 and u.id = ?2 ");
        query.setParameter(1,param1);
        query.setParameter(2,user_id);

        return query.getResultList();

    }


    public Order getOrder(int id) throws MessageException {
        Order o = new Order();
       o = entityManager.find(Order.class,id);
        if(o==null){
            throw new MessageException("order" + id + " Does not exist");
        }
        else{
            return o;
        }
    }

}
