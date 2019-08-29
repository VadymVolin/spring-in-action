package spitter.data.standartjdbc;

import spitter.data.Spitter;

public interface SpitterDAO {

    public void insert(Spitter spitter);
    public Spitter findById(int id);

}
