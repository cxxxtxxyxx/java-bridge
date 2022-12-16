package bridge.domain;

import static bridge.domain.Direction.DOWN;
import static bridge.domain.Direction.UP;

public class Moving {
    private String moving;


    public Moving(String moving) {
        if(!(moving.equals(UP.getAbbreviation()) || moving.equals(DOWN.getAbbreviation()))){
            throw new IllegalArgumentException("올바르지 않은 방향입니다.");
        }
        this.moving = moving;
    }

    public Direction getDirection() {
        if(moving.equals(UP.getAbbreviation())) {
            return UP;
        }
        return DOWN;
    }



    @Override
    public boolean equals (Object obj) {
        if (obj instanceof Moving) {
            Moving moving = (Moving) obj;
            if(moving.equals(this.moving)) {
                return true;
            }
        }
        return false;
    }
}
