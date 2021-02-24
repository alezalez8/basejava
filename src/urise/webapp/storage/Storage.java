package urise.webapp.storage;

import urise.webapp.model.Resume;

import java.util.Arrays;

public interface Storage {


    void save(Resume resume);

    void update(Resume resume);

    Resume get(String uuid);

    void delete(String uuid);

    Resume[] getAll();

    void clear();

    int size();


    //public boolean isPresent(String uuid, Resume[] storage, int i);
     public int getSize();

}
