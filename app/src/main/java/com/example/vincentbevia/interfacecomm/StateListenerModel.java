package com.example.vincentbevia.interfacecomm;

/**
 * Created by vincentbevia on 30/11/2016.
 */

public class StateListenerModel {

    private static StateListenerModel stateListenerModelInstance;
    private StateListener stateListener;
    private boolean currentState;

    private StateListenerModel() {}

    public static StateListenerModel getInstance() {
        if(stateListenerModelInstance == null) {
            stateListenerModelInstance = new StateListenerModel();
        }
        return stateListenerModelInstance;
    }

    public void setListener(StateListener stateListener) {
        this.stateListener = stateListener;
    }

    public void changeState(boolean state) {
        if(stateListener != null) {
            currentState = state;
            notifyStateChange();
        }
    }

    public boolean getState() {
        return currentState;
    }

    private void notifyStateChange() {
        stateListener.stateChanged();
    }

}
