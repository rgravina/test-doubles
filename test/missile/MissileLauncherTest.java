package missile;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static missile.MissileLauncher.launchMissile;

class MissileLauncherTest {
    FakeUsedLaunchCodes usedLaunchCodes;
    @BeforeEach
    void setUp() {
        usedLaunchCodes = new FakeUsedLaunchCodes();
    }

    @Test
    void givenExpiredLaunchCodes_missileIsNotLaunched_usingDummy() {
        LaunchCode expiredLaunchCode = new ExpiredLaunchCodeStub();

        launchMissile(new DummyMissile(), expiredLaunchCode, usedLaunchCodes);
    }

    @Test
    void givenExpiredLaunchCodes_missileIsNotLaunched_usingSpy() {
        LaunchCode expiredLaunchCode = new ExpiredLaunchCodeStub();
        MockMissile mockMissile = new MockMissile();

        launchMissile(mockMissile, expiredLaunchCode, usedLaunchCodes);

        mockMissile.verifyCodeRedAbort();
    }

    @Test
    void givenUnsignedLaunchCodes_missileIsNotLaunched_usingSpy() {
        LaunchCode expiredLaunchCode = new UnsignedLaunchCodeStub();
        MockMissile mockMissile = new MockMissile();

        launchMissile(mockMissile, expiredLaunchCode, usedLaunchCodes);

        mockMissile.verifyCodeRedAbort();
    }

    @Test
    void givenValidLaunchCodes_launchesMissile() {
        LaunchCode validLaunchCode = new ValidLaunchCodeStub();
        MockMissile mockMissile = new MockMissile();

        launchMissile(mockMissile, validLaunchCode, usedLaunchCodes);

        mockMissile.launchWasCalled();
    }

    @Test
    void givenReusedLaunchCodes_verifyCodeRedAbort() {
        LaunchCode validLaunchCode = new ValidLaunchCodeStub();
        MockMissile mockMissile = new MockMissile();

        launchMissile(new MockMissile(), validLaunchCode, usedLaunchCodes);
        launchMissile(mockMissile, validLaunchCode, usedLaunchCodes);

        mockMissile.verifyCodeRedAbort();
    }
}