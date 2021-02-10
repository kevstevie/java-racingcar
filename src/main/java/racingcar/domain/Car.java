package racingcar.domain;

public class Car {

  private static final int MIN_RUNNABLE_FUEL = 4;
  private static final int MIN_NAME_LENGTH = 1;
  private static final int MAX_NAME_LENGTH = 5;
  private final String name;
  private int position = 0;

  public Car(final String name) {
    validateName(name);
    this.name = name;
  }

  private void validateName(String name) {
    if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
      throw new IllegalStateException("1글자 이상 5글자 이하의 이름을 입력해주세요.");
    }
  }

  public void run(int fuel) {
    if (runnable(fuel)) {
      this.position++;
    }
  }

  private boolean runnable(final int fuel) {
    return fuel >= MIN_RUNNABLE_FUEL;
  }

  public boolean isSamePosition(int position) {
    return this.position == position;
  }

  public int position() {
    return position;
  }

  public String name() {
    return name;
  }
}