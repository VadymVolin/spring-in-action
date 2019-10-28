package spitter.services;

import spitter.data.Spitter;

public interface SpitterService {

    public void saveSpitter(Spitter spitter);
    public void editSpitter(Spitter spitter);
    public Spitter findSpitter(int id);
    public void deleteSpitter(Spitter spitter);
    public void listSpitter();

}
