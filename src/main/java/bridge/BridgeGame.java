package bridge;

/**
 * 필드 변수 추가 가능 패키지 변경 가능 메서드 이름 변경 불가 인자 변경 가능 타입 변경 가능 추가 메서드 구현 가능
 */

import bridge.Constants.OutputState;
import bridge.Constants.Result;
import java.util.ArrayList;
import java.util.List;
import bridge.Constants.BridgeShape;
import bridge.Constants.Command;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static List<String> bridge;
    private static int attemptCount = 0;
    private List<String> upline;
    private List<String> downline;
    private int bridgeIndex;
    private String result;

    BridgeGame() {
        this.upline = new ArrayList<String>();
        this.downline = new ArrayList<String>();
        this.result = Result.FAIL;
        this.bridgeIndex = 0;
    }

    public static String attemptCountToString() {
        return OutputState.TOTAL_ATTEMPT + BridgeGame.attemptCount;
    }

    public static void increaseAttemptCount() {
        BridgeGame.attemptCount += 1;
    }

    public String resultToString() {
        return OutputState.SUCCESS_OR_NOT + result;
    }

    public static void setBridge(List<String> bridge) {
        BridgeGame.bridge = bridge;
    }

    public boolean isSuccessFinish() {
        if (BridgeGame.bridge.size() == this.bridgeIndex) {
            this.result = Result.SUCCESS;
            return true;
        }
        this.result = Result.FAIL;
        return false;
    }


    public String uplineToString() {
        return BridgeShape.START_SYMBOL + String.join(BridgeShape.SEPERATOR, this.upline) + BridgeShape.END_SYMBOL;

    }

    public String downlineToString() {
        return BridgeShape.START_SYMBOL + String.join(BridgeShape.SEPERATOR, this.downline) + BridgeShape.END_SYMBOL;
    }


    public boolean isCorrectDirection(String command) {
        return BridgeGame.bridge.get(bridgeIndex).equals(command);
    }

    private void drawLine(List<String> selectedLine, List<String> oppositeLine, String movementShape) {
        selectedLine.add(movementShape);
        oppositeLine.add(BridgeShape.BLOCK);
    }
    private void addMovement(List<String> selectedLine, List<String> oppositeLine, boolean isCorrect) {
        this.bridgeIndex += 1;
        if (isCorrect) {
            drawLine(selectedLine, oppositeLine, BridgeShape.MOVABLE);
            return;
        }
        drawLine(selectedLine, oppositeLine, BridgeShape.UNMOVABLE);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private boolean isCorrectMovement(List<String> selectedLine, List<String> unselectedLine, String direction) {
        boolean isCorerct = isCorrectDirection(direction);
        addMovement(selectedLine, unselectedLine, isCorerct);
        return isCorerct;
    }

    public boolean move(String direction) {
        List<String> selectedLine = this.upline;
        List<String> unselectedLine = this.downline;
        if (direction.equals(Command.DOWN)) {
            selectedLine = this.downline;
            unselectedLine = this.upline;
        }
        return isCorrectMovement(selectedLine, unselectedLine, direction);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String command) {
        return command.equals(Command.RETRY);
    }
}
