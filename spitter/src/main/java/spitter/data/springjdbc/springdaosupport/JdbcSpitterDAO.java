package spitter.data.springjdbc.springdaosupport;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import spitter.data.Spitter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;


/**
 *  JdbcDaoSuppoort has a built-in JdbcTemplate
 */
public class JdbcSpitterDAO extends JdbcDaoSupport implements SpitterDAO {

    private Random random = new Random();
    private static final int RANGE = 999_999_999;

    private static final String SQL_INSERT = "INSERT INTO spitter(id, username, password, fullname) value(?, ?, ?, ?);";



    @Override
    public void addSpitter(Spitter spitter) {
        spitter.setId(queryForIdentity());
        getJdbcTemplate().update(SQL_INSERT, spitter.getId(), spitter.getUserName(), spitter.getPassword(), spitter.getFullName());
    }

    @Override
    public int queryForIdentity() {
        return Math.abs(random.nextInt(RANGE) << 16);
    }

    private static final String SQL_SELECT_BY_ID = "SELECT * FROM spitter WHERE id = ?;";

    @Override
    public Spitter findById(int id) {
        return getJdbcTemplate().queryForObject(SQL_SELECT_BY_ID, new Object[] {id}, new BeanPropertyRowMapper<>(Spitter.class));
    }

    @Override
    public Spitter findByIdWithRowMapper(int id) {
        return getJdbcTemplate().queryForObject(SQL_SELECT_BY_ID, new Object[]{id}, new RowMapper<Spitter>() {
            @Override
            public Spitter mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Spitter(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("fullname")
                );
            }
        });
    }

    private static final String SQL_SELECT_BY_USERNAME = "SELECT * FROM spitter WHERE username = ?;";

    @Override
    public Spitter findByUserName(String username) {
        return getJdbcTemplate().queryForObject(SQL_SELECT_BY_USERNAME, new Object[] {username}, new BeanPropertyRowMapper<>(Spitter.class));
    }

    private static final String SQL_DELETE_BY_ID = "DELETE FROM spitter WHERE id = ?;";

    @Override
    public int deleteById(int id) {
        return getJdbcTemplate().update(SQL_DELETE_BY_ID, id);
    }
}
