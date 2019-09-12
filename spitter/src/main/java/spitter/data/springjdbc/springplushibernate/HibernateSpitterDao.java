package spitter.data.springjdbc.springplushibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.w3c.dom.ls.LSOutput;
import spitter.data.Spitter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class HibernateSpitterDao implements SpitterDAO {

    private Random random = new Random();
    private static final int RANGE = 999_999_999;
    private SessionFactory sessionFactory;

        @Autowired
    // we create dao with sessionFactory
    public HibernateSpitterDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //    get current session from factory
    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    //    save spitter to db use current session
    @Override
    public void addSpitter(Spitter spitter) {
        spitter.setId(queryForIdentity());
        Transaction tx = currentSession().beginTransaction();
        currentSession().save(spitter);
        tx.commit();
    }

    @Override
    public Spitter findById(int id) {
        Transaction tx = currentSession().beginTransaction();
        Spitter spitter = currentSession().get(Spitter.class, id);
        tx.commit();
        return spitter;
    }

    @Override
    public ArrayList<Spitter> list() {
        Transaction tx = currentSession().beginTransaction();
        ArrayList<Spitter> list;
        list = (ArrayList<Spitter>) currentSession().createSQLQuery("SELECT * FROM spitter").list();
        tx.commit();
        if (list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }

    @Override
    public void delete(Spitter spitter) {
        Transaction tx = currentSession().beginTransaction();
        currentSession().delete(spitter);
        tx.commit();
    }

    public int queryForIdentity() {
        return Math.abs(random.nextInt(RANGE) << 16);
    }
}
