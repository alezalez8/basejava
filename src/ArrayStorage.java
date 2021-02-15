/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int indexOfRecord = 0;

    public int getIndexOfRecord() {
        return indexOfRecord;
    }

    void clear() {
        for (int i = 0; i < indexOfRecord; i++) {
            storage[i] = null;
        }
        indexOfRecord = 0;
    }

    void save(Resume r) {
        storage[indexOfRecord] = r;
        indexOfRecord++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < indexOfRecord; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {

        for (int i = 0; i < indexOfRecord; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                for (int k = i; (k - 1) < indexOfRecord; k++) {
                    storage[k] = storage[k + 1];
                }
                indexOfRecord--;
                break;

            }

        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] newResume = new Resume[indexOfRecord];
        for (int i = 0; i < indexOfRecord; i++) {
            newResume[i] = storage[i];
        }
        return newResume;
    }

    int size() {
        return indexOfRecord;
    }
}
