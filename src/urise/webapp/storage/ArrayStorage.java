package urise.webapp.storage;

import urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage implements Storage {

    private static final int STORAGE_LIMIT = 10000;
    private Resume[] storage = new Resume[STORAGE_LIMIT];
    private int size = 0;

    public int getSize() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    private boolean isPresent(String uuid) {
        for (int i = 0; i < size; i++) {
            // if (resume.getUuid().equals(storage[i].getUuid())) {}
            if (uuid.equals(storage[i].getUuid())) {
                return true;
            }
        }
        return false;
    }

    public void save(Resume resume) {
        if (isPresent(resume.getUuid())) {
            System.out.println("ERROR: this record already present in base");

        } else {
            if (size < storage.length) {
                storage[size] = resume;
                size++;
            }
        }

    }


    public void update(Resume resume) {
        if (isPresent(resume.getUuid())) {
            System.out.println("urise.webapp.model.Resume is present in base, input another name");
        }

    }

    public Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid == storage[i].getUuid()) {
                return storage[i];
            } else System.out.println("ERROR");
        }
        return null;
    }

    public void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid == storage[i].getUuid()) {
                storage[i] = storage[size - 1];
                storage[size - 1] = null;
                size--;
                break;

            } else System.out.println("ERROR");


        }

    }


    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid == storage[i].getUuid()) {
                return i;
            }
        }
        return -1;
    }
}
