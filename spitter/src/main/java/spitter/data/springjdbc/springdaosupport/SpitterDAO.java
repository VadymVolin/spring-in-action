package spitter.data.springjdbc.springdaosupport;

import spitter.data.Spitter;

public interface SpitterDAO {

    public void addSpitter(Spitter spitter);
    public int queryForIdentity();
    public Spitter findById(int id);
    public Spitter findByIdWithRowMapper(int id);
    public Spitter findByUserName(String username);
    public int deleteById(int id);

}
