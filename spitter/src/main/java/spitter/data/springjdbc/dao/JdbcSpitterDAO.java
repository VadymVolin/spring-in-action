package spitter.data.springjdbc.dao;

//import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import spitter.data.Spitter;

import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class JdbcSpitterDAO implements SpitterDAO {

    private JdbcTemplate jdbcTemplate;
//    private NamedParameterJdbcTemplate jdbcTemplate;

    private Random random = new Random();

    private static final int range = 999_999_999;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String SQL_INSERT_SPITTER =
            // without named params
            "insert into spitter(id, username, password, fullname) values (?, ?, ?, ?)";
//            with named params
//            "INSERT INTO spitter(id, username, password, fullname) VALUES(:id, :username, :password, :fullname)";

    @Override
    public void addSpitter(Spitter spitter) {
        spitter.setId(queryForIdentity());
//        For update without named params
        jdbcTemplate.update(SQL_INSERT_SPITTER,
                spitter.getId(),
                spitter.getUserName(),
                spitter.getPassword(),
                spitter.getFullName());
//        Map<String, Object> params = new HashMap<>();
//        params.put("id", spitter.getId());
//        params.put("username", spitter.getUserName());
//        params.put("password", spitter.getPassword());
//        params.put("fullname", spitter.getFullName());
//        jdbcTemplate.update(SQL_INSERT_SPITTER, params);
        System.out.println(spitter);
    }

    private static final String SQL_SELECT_SPITTER_BY_ID =
            "SELECT * FROM spitter WHERE id = ?";

    /**
     * @param id type int
     *           <p>
     *           select from DB use JdbcTemplate method - queryOfObject(SQL_QUERY, args(Object[]), BeanPropertyRowMapper<>(ClassName.class))
     *           <p>
     * @return Object
     * @method findById
     */
    @Override
    public Spitter findById(int id) {
        return jdbcTemplate.queryForObject(SQL_SELECT_SPITTER_BY_ID, new Object[]{id}, new BeanPropertyRowMapper<>(Spitter.class));
    }

    /**
     * @param id type int
     *           <p>
     *           select from DB use JdbcTemplate method - queryOfObject(SQL_QUERY, args(Object[]), RowMapper)
     *           <p>
     * @return Object
     * @method findById
     */
    @Override
    public Spitter findByIdWithRowMapper(int id) {
        return jdbcTemplate.queryForObject(SQL_SELECT_SPITTER_BY_ID, new Object[]{id}, new RowMapper<Spitter>() {
            @Override
            public Spitter mapRow(ResultSet resultSet, int i) throws SQLException {
                Spitter spitter = new Spitter();
                spitter.setId(resultSet.getInt("id"));
                spitter.setUserName(resultSet.getString("username"));
                spitter.setPassword(resultSet.getString("password"));
                spitter.setFullName(resultSet.getString("fullname"));
                return spitter;
            }
        });
    }

    private static final String SQL_SELECT_BY_NAME = "SELECT * FROM SPITTER WHERE username = ?";

    /**
     * @param username type String
     *                 <p>
     *                 select from DB use JdbcTemplate - method queryOfObject
     *                 </p>
     * @return Object
     * @method findByUserName
     */
    @Override
    public Spitter findByUserName(String username) {
        return jdbcTemplate.queryForObject(SQL_SELECT_BY_NAME, new Object[]{username}, new BeanPropertyRowMapper<>(Spitter.class));
    }

    private static final String SQL_DELETE_BY_ID = "DELETE FROM spitter WHERE id = ?";

    /**
     * @return COUNT of delete
     * @method deleteById
     */
    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update(SQL_DELETE_BY_ID, id);
    }

    @Override
    public int queryForIdentity() {
        return Math.abs(random.nextInt(range) << 16);
    }

}
