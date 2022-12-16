package bridge.domain;

public enum Direction {
    UP("U",0),
    DOWN("D",1);

    private final String abbreviation;
    private final int symbol;

    Direction(String abbreviation, int symbol) {
        this.abbreviation = abbreviation;
        this.symbol = symbol;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public int getSymbol() {
        return symbol;
    }

    public static boolean isDown(Direction direction) {
        return direction.getAbbreviation().equals(DOWN.abbreviation);
    }

    public static boolean isUp(Direction direction) {
        return direction.getAbbreviation().equals(UP.abbreviation);
    }


}
