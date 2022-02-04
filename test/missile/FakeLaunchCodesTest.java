package missile;

public class FakeLaunchCodesTest extends UsedLaunchCodesContract {
    @Override
    protected UsedLaunchCodes createUsedLaunchCodes() {
        return new FakeUsedLaunchCodes();
    }
}
