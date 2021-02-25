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
        if (getIndex(resume.getUuid()) != -1) {
            System.out.println("Resume " + resume.getUuid() + " already exist");
        } else if (size == storage.length) {
            System.out.println("Storage overflow ");
        } else {
            storage[size] = resume;
            size++;
        }
    }


    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index == -1) {
            System.out.println("Resume " + resume.getUuid() + " not exist");
        } else
            storage[index] = resume;
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Resume " + uuid + " not exist");
            return null;
        }
        return storage[index];
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Resume " + uuid + " not exist");
        } else {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
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
