package urise.webapp.storage;

import urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage implements Storage{

    private static final int STORAGE_LIMIT = 10000;
    private Resume[] storage = new Resume[STORAGE_LIMIT];
    private int size = 0;

    public int getSize() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
       /* for (int i = 0; i < size; i++) {
            storage[i] = null;
        }*/
        size = 0;
    }

    public boolean isPresent(String uuid, Resume[] storage, int i) {
        return uuid == storage[i].getUuid();
    }

    public void save(Resume resume) {
        storage[size] = resume;
        size++;
    }
    /*public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if(index == -1){
            System.out.println("Resume " + resume.getUuid() + " not exist");
        } else {
            storage[index] = resume;
        }
    }*/

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

     /*   Resume[] newResume = new Resume[size];
        for (int i = 0; i < size; i++) {
            newResume[i] = storage[i];
        }
        return newResume;*/
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }

    private int getIndex(String uuid){
        for(int i = 0; i < size; i++){
            if(uuid == storage[i].getUuid()){
                return i;
            }
        }
        return -1;
    }
}
