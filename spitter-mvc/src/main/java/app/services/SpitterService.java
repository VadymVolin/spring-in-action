package app.services;

import app.data.Spitter;

public interface SpitterService {

    public void saveSpitter(Spitter spitter);
    public void editSpitter(Spitter spitter);
    public Spitter findSpitter(int id);
    public void deleteSpitter(Spitter spitter);
    public void listSpitter();

    Object getRecentSpittles(int defaultSpittlesPerPage);
}
