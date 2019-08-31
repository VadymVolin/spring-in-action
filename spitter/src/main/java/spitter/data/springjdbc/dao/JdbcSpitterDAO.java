package spitter.data.springjdbc.dao;

//import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import spitter.data.Spitter;

import java.util.Random;

public class JdbcSpitterDAO implements SpitterDAO {

    private JdbcTemplate jdbcTemplate;

    private static final String SQL_INSERT_SPITTER =
            "insert into spitter(username, password, fullname) values (?, ?, ?)";

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addSpitter(Spitter spitter) {
        jdbcTemplate.update(SQL_INSERT_SPITTER,
                spitter.getUserName(),
                spitter.getPassword(),
                spitter.getFullName());
        spitter.setId(queryForIdentity());
    }

    @Override
    public Spitter findById(int id) {
        return new Spitter();
    }

    @Override
    public int queryForIdentity() {
        return new Random().nextInt();
    }

}
