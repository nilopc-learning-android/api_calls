package com.nilportugues.simplewebapi.shared.ui.presenter;

/**
 * Interface representing a Presenter in a model view presenter (MVP) pattern.
 *
 * In Android, all these methods should be used in Activity or Fragment classes.
 */
public interface Presenter {

    void resume();

    void pause();

    void destroy();
}
