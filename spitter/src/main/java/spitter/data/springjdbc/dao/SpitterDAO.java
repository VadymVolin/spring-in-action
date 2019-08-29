package spitter.data.springjdbc.dao;

import spitter.data.Spitter;

public interface SpitterDAO {

    public void addSpitter(Spitter spitter);
    public int queryForIdentity();

}
