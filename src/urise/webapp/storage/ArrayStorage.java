package urise.webapp.storage;

import urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public int getSize() {
        return size;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    public boolean isPresent(String uuid, Resume[] storage, int i) {
        return uuid == storage[i].getUuid();
    }

    public void save(Resume resume) {
        // update(resume);
        storage[size] = resume;
        size++;
    }

    public void update(Resume resume) {
        for (int i = 0; i < size; i++) {
            if (resume.getUuid() == storage[i].getUuid()) {
                System.out.println("urise.webapp.model.Resume is present in base, input another name");
                break;
            }
        }
    }

    public Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid == storage[i].getUuid()) {
                // if (isPresent(uuid, storage, i)) {
                return storage[i];
            }
        }
        return null;
    }

    public void delete(String uuid) {

        for (int i = 0; i < size; i++) {
            //if (uuid == storage[i].getUuid()) {
            if (isPresent(uuid, storage, i)) {
                storage[i] = storage[size - 1];
                storage[size - 1] = null;
                size--;
                break;

            }


        }

    }



    /*void delete(String uuid) {

        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid()==uuid) {
                for (int k = i; (k - 1) < size; k++) {
                    storage[k] = storage[k + 1];
                }
                size--;
                break;

            }

        }
    }*/


    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] newResume = new Resume[size];
        for (int i = 0; i < size; i++) {
            newResume[i] = storage[i];
        }
        return newResume;
    }

    int size() {
        return size;
    }
}
