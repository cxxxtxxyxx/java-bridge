package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeShape;
import bridge.domain.BridgeSize;
import bridge.domain.Moving;
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
        Bridge bridge = setBridge();
        play(bridge);
    }

    private Bridge setBridge() {
        BridgeSize bridgeSize = inputView.readBridgeSize();
        BridgeShape bridgeShape = new BridgeShape(bridgeMaker.makeBridge(bridgeSize.getBridgeSize()));
        return new Bridge(bridgeSize, bridgeShape);
    }

    private void play(Bridge bridge) {
        Moving moving = inputView.readMoving();
    }
}
