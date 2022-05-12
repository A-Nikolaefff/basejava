import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = 0;

    void clear() {
        if (size != 0) {
            for (int i = 0; i < storage.length; i++) {
                if (storage[i] != null) {
                    storage[i] = null;
                } else {
                    size = 0;
                    return;
                }
            }
        }
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                size++;
                return;
            }
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                if (storage[i].uuid.equals(uuid)) {
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
                if (storage[i].uuid.equals(uuid)) {
                    storage[i] = null;
                    deleted = true;
                    size--;
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
        return Arrays.copyOf(storage, size);
    }

    int size() {
        return size;
    }
}
