import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                storage[i] = null;
            } else {
                return;
            }
        }
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                return;
            }
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                if (storage[i].uuid == uuid) {
                    return storage[i];
                }
            } else {
                break;
            }
        }
        return null;
    }

    void delete(String uuid) {
        boolean deleted = false;
        for (int i = 0; i < storage.length; i++) {
            if (!deleted) {
                if (storage[i].uuid == uuid) {
                    storage[i] = null;
                    deleted = true;
                }
            } else {
                if (storage[i] != null) {
                    storage[i - 1] = storage[i];
                } else {
                    storage[i - 1] = null;
                    return;
                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size());
    }

    int size() {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                return i;
            }
        }
        return 0;
    }
}
