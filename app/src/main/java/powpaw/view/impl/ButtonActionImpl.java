package powpaw.view.impl;

import powpaw.view.api.ButtonAction;

public class ButtonActionImpl implements ButtonAction {

    @Override
    public void increaseValue(int value) {
        value++;
    }

    @Override
    public void decreaseValue(int value) {
        value--;
    }
}