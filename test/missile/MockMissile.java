package missile;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MockMissile implements Missile {
    private boolean launch_wasCalled = false;
    private boolean disable_wasCalled = false;

    public void launch() {
        launch_wasCalled = true;
    }

    @Override
    public void disable() {
        disable_wasCalled = true;
    }

    public boolean launchWasCalled() {
        return launch_wasCalled;
    }

    public boolean disableWasCalled() {
        return disable_wasCalled;
    }

    public void verifyCodeRedAbort() {
        assertFalse(this.launchWasCalled());
        assertTrue(this.disableWasCalled());
    }
}
