package missile;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class UsedLaunchCodesContract {
    protected abstract UsedLaunchCodes createUsedLaunchCodes();

    UsedLaunchCodes usedLaunchCodes;
    @BeforeEach
    void setUp() {
        usedLaunchCodes = createUsedLaunchCodes();
    }

    @Test
    void contains() {
        LaunchCode launchCode = new ValidLaunchCodeStub();
        assertFalse(usedLaunchCodes.contains(launchCode));
        usedLaunchCodes.add(launchCode);
        assertTrue(usedLaunchCodes.contains(launchCode));    }
}
