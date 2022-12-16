package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeShape;
import bridge.domain.BridgeSize;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private InputView inputView;
    private OutputView outputView;
    private BridgeMaker bridgeMaker;

    public BridgeGameController(InputView inputView, OutputView outputView,
                                BridgeMaker bridgeMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
    }

    public void init() {
        outputView.printStart();
        BridgeSize bridgeSize = inputView.readBridgeSize();
        BridgeShape bridgeShape = new BridgeShape(bridgeMaker.makeBridge(bridgeSize.getBridgeSize()));


    }
}
