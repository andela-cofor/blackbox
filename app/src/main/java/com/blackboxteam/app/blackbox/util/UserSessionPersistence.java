package com.blackboxteam.app.blackbox.util;

/**
 * UserSessionPersistence
 *
 * Manages user session
 */
public class UserSessionPersistence {

    private boolean isActiveSession = false;


    public boolean isActiveSession() {
        return isActiveSession;
    }

    public void setActiveSession(boolean activeSession) {
        isActiveSession = activeSession;
    }
}
