/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size = 0;

    public int getSize() {
        return size;
    }

    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    boolean isPresent(String uuid, Resume[] storage, int i) {
        return uuid == storage[i].getUuid();
    }

    void save(Resume r) {
       // update(r);
        storage[size] = r;
        size++;
    }

    void update(Resume r) {
        for (int i = 0; i < size; i++) {
            if (r.getUuid() == storage[i].getUuid()) {
                System.out.println("Resume is present in base, input another name");
                break;
            }
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            //if (uuid == storage[i].getUuid()) {
            if (isPresent(uuid, storage, i)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {

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
    Resume[] getAll() {
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
