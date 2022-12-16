package bridge.domain;

public class BridgeSize {
    int bridgeSize;
    private static final String REGEX = "(^[1-3]{1}$)|(^1[0-9]{1}$)|(^20$)";

    public BridgeSize (String bridgeSize) {
        if(bridgeSize.matches(REGEX)) {
            throw new IllegalArgumentException("3-20 사이의 숫자를 입력해주세요.");
        }
        this.bridgeSize = Integer.parseInt(bridgeSize);
    }
}
