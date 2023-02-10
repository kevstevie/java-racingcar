package racingcar;

public class Car {


    public static final int MOVE_RANGE = 1;
    private static final int INIT_POSITION = 0;
    private static final int BOUNDARY = 4;
    public static final int MAX_LENGTH = 5;

    private final String name;
    private int position;

    public Car(String name) {
        String carName = name.trim();
        validateBlank(name);
        validateLength(carName);
        this.name = carName;
        this.position = INIT_POSITION;
    }

    private static void validateBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateLength(String carName) {
        if (carName.length() >= MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }


    public void move(int number) {
        if (number >= BOUNDARY) {
            this.position += MOVE_RANGE;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
