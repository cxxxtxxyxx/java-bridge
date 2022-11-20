package bridge;

import java.util.List;

public class Program {
    private static OutputView outputView = new OutputView();
    private static InputView inputView = new InputView();
    private static BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private static BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

    private static BridgeGame bridgeGame;

    public static void init() {
        startGame();
        setupBridge();
        playGame();
        finishGame();
    }

    private static void startGame() {
        outputView.printStartGame();
    }

    private static void setupBridge() {
        outputView.printInputBridgeLength();

        int bridgeSize = getBridgeSize();
        createBridge(bridgeSize);
    }
    private static void createBridge(int bridgeSize) {
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        BridgeGame.setBridge(bridge);
    }



    private static int getBridgeSize() {
        while (true) {
            try {
                return inputView.readBridgeSize();
            } catch (IllegalArgumentException e) {
                outputView.printErrorState(e);
            }
        }
    }



    private static void setGame() {
        bridgeGame = new BridgeGame();
        BridgeGame.setCountAttempt();
    }

    private static void finishGame() {
        outputView.printResult(bridgeGame);
    }


    private static boolean askToQuitGame() {
        outputView.printInputRetryCommand();
        String command = getRetryCommand();
        boolean isRetry = bridgeGame.retry(command);
        if (!isRetry) {
            return true;
        }
        return false;
    }

    private static boolean generateMovement() {
        outputView.printInputMoveDirection();
        String direction = getDirection();

        boolean isSuccess = bridgeGame.move(direction);
        outputView.printMap(bridgeGame);

        return isSuccess;
    }

    private static boolean proceedGame() {
        while (true) {
            boolean isSuccessMovement = generateMovement();
            if (!isSuccessMovement) {
                return askToQuitGame();
            }
            if (bridgeGame.isSuccessFinish()) {
                return true;
            }
        }
    }

    private static void playGame() {
        while (true) {
            setGame();
            boolean isCompleted = proceedGame();
            if (isCompleted) {
                break;
            }
        }
    }

    private static String getDirection() {
        while (true) {
            try {
                return inputView.readMoving();
            } catch (IllegalArgumentException e) {
                outputView.printErrorState(e);
            }
        }
    }

    private static String getRetryCommand() {
        while (true) {
            try {
                return inputView.readRetryCommand();
            } catch (IllegalArgumentException e) {
                outputView.printErrorState(e);
            }
        }
    }
}
