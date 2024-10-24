package racingcar.model;

import racingcar.util.ramdom.RandomRange;

import java.util.List;

public class RacingCars {

    private final List<RacingCar> values;

    public RacingCars(List<RacingCar> values) {
        validate(values);
        this.values = values.stream()
                .map(RacingCar::new)
                .toList();
    }

    public void moveRandomly(RandomRange randomRange) {
        values.forEach(racingCar -> racingCar.moveRandomly(randomRange));
    }

    private void validate(List<RacingCar> values) {
        validateEmpty(values);
        validateDuplication(values);
    }

    private void validateEmpty(List<RacingCar> values) {
        if (values.isEmpty()) {
            throw new IllegalArgumentException("자동하는 1대 이상이어야 합니다.");
        }
    }

    private void validateDuplication(List<RacingCar> values) {
        if (values.stream().distinct().count() != values.size()) {
            throw new IllegalArgumentException("중복된 자동차가 존재합니다.");
        }
    }
}
