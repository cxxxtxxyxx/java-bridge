package bridge.controller;

import bridge.domain.BridgeSize;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private InputView inputView;
    private OutputView outputView;

    public BridgeGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void init() {
        outputView.printStart();
        BridgeSize bridgeSize = inputView.readBridgeSize();

    }
}
