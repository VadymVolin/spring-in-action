package spitter.data.standartjdbc.hibernate;

import spitter.data.Spitter;

public interface SpitterDAO {

    public void insert(Spitter spitter);
    public Spitter findById(int id);
    public void delete(Spitter spitter);

}
