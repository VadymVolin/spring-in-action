package spitter.data.standartjdbc.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import spitter.data.Spitter;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcSpitterDAO implements SpitterDAO {

    private DataSource dataSource;
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private static final String SQL_INSERT = "INSERT INTO spitter(id, username, password, fullname) values(?, ?, ?, ?)";

    @Override
    public void insert(Spitter spitter) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(spitter);
        tx.commit();
        session.close();
    }

    private static final String SQL_SELECT = "SELECT id, username, password, fullname FROM spitter WHERE id = ?";

    @Override
    public Spitter findById(int id) {
        Session session = sessionFactory.openSession();
        Spitter spitter = session.get(Spitter.class, id);
        session.close();
        return spitter;
    }

    @Override
    public List<Spitter> list() {
        Session session = sessionFactory.openSession();
        List<Spitter> spitters = (List<Spitter>) session.createSQLQuery("select id, username, password, fullname from spitter")
                .addEntity(Spitter.class)
                .list();
        session.close();
        return spitters;
    }

    @Override
    public void delete(Spitter spitter) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Spitter spitter1 = session.get(Spitter.class, spitter.getId());
        session.delete(spitter1);
        tx.commit();
        session.close();
    }

}
