package com.creditas.challenge.services;

import com.creditas.challenge.model.Order;
import com.creditas.challenge.model.Product;
import com.creditas.challenge.repositories.ProductRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class DefaultProductService implements ProductService {
/*
    @PersistenceContext
    private EntityManager em;

    private Session getSession() {
        Session session = null;
        if (em == null || (session = em.unwrap(Session.class)) == null) {
            throw new NullPointerException();
        }
        return session;
    }

 */

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAllProductsByOrder(Order order) {
       /* Query<Product> query = getSession().createNamedQuery("Product.findProductsByOrderId",
                Product.class);
        query.setParameter("employeeNo", "001");
        List<Product> resultList = query.getResultList();
        return resultList;

        */
        return null;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
}
