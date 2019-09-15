package spitter.data.jpa;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spitter.data.Spitter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Random;

@Repository("spitter")
@Transactional
public class JpaSpitterDao implements SpitterDAO {

    private Random random = new Random();
    private static final int RANGE = 999_999_999;

    private static final String SQL_ALL_SPITTER = "SELECT s FROM spitter s";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addSpitter(Spitter spitter) {
        Session session = entityManager.unwrap(Session.class);
        entityManager.persist(spitter);
    }

    @Transactional
    @Override
    public Spitter findById(int id) {
        Session session = entityManager.unwrap(Session.class);
        Spitter spitter = entityManager.find(Spitter.class, id);
        return spitter;
    }

    @Override
    public List<Spitter> list() {
        Session session = entityManager.unwrap(Session.class);
        List<Spitter> objectList = entityManager.createQuery(SQL_ALL_SPITTER).getResultList();
        return objectList;
    }

    @Override
    public void delete(Spitter spitter) {
        Session session = entityManager.unwrap(Session.class);
        Spitter deleteSpitter = entityManager.find(Spitter.class, spitter.getId());
        entityManager.remove(deleteSpitter);
    }

    public int queryForIdentity() {
        return Math.abs(random.nextInt(RANGE) << 16);
    }

}
