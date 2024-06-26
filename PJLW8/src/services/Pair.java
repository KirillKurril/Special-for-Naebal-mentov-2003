package services;

public class Pair<T, U> {
    private T key;
    private U value;

    public Pair(T key, U value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return key;
    }

    public U getValue() {
        return value;
    }

    public void setKey(T first) {
        this.key = first;
    }

    public void setValue(U second) {
        this.value = second;
    }
}
