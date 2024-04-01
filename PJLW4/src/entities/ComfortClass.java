package entities;

public enum ComfortClass {
    ECONOMY(1),
    BUSINESS(2),
    LUXURY(3);

    private int code;

    ComfortClass(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}