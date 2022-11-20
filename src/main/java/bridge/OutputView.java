package bridge;

/**
 * 패키지 변경 가능
 * 메서드 이름 변경 불가
 * 인자 변경 가능
 * 반환 타입 변경 가능
 * 추가 메서드 구현 가능
 * BridgeGame 클래스에서 사용 불가
 */

import bridge.Constants.BridgeShape;
import bridge.Constants.OutputState;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public void printErrorState(IllegalArgumentException e) {
        System.out.println(e);
    }
    public void printStartGame() {
        System.out.println(OutputState.START_GAME);
    }


    public void printInputBridgeLength() {
        System.out.println(OutputState.INPUT_BRIDGE_LENGTH);
    }

    public void printInputMoveDirection() {
        System.out.println(OutputState.INPUT_MOVE_DIRECTION);
    }

    public void printInputRetryCommand() {
        System.out.println(OutputState.INPUT_RETRY_COMMAND);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame) {
        String upLineForm = bridgeGame.getUpLineForm();
        String downLineForm = bridgeGame.getDownLineForm();
        System.out.println(BridgeShape.START_LINE + upLineForm + BridgeShape.END_LINE);
        System.out.println(BridgeShape.START_LINE + downLineForm + BridgeShape.END_LINE);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.println(OutputState.GAME_RESULT);
        printMap(bridgeGame);
        System.out.println(OutputState.SUCCESS_OR_NOT + BridgeGame.RESULT);
        System.out.println(OutputState.TOTAL_ATTEMPT + BridgeGame.getCountAttempt());
    }
}
