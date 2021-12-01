package com.example.db_2.Services;

import com.example.db_2.POJO.OptionalProduct;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OptionalProductService {

    @PersistenceContext
    private EntityManager entityManager;

    public List<OptionalProduct> getAll(){
        Query query = entityManager.createQuery("select o from OptionalProduct o" );
        return query.getResultList();
    }

    public int create(OptionalProduct optionalProduct) throws MessageException {

        Query query = entityManager.createQuery("select op from OptionalProduct op where op.name=?1 and op.monthly_fee=?2", OptionalProduct.class);
        query.setParameter(1,optionalProduct.getName());
        query.setParameter(2,optionalProduct.getMonthly_fee());

        if(!query.getResultList().isEmpty()){
            throw new MessageException("Optional product " + optionalProduct.getName() + " already exists ! ");
        }

        entityManager.persist(optionalProduct);
        entityManager.flush();
        return optionalProduct.getId();
    }
}
