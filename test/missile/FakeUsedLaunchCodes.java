package missile;

import java.util.HashSet;

public class FakeUsedLaunchCodes implements UsedLaunchCodes {
    private HashSet<LaunchCode> usedCodes = new HashSet<>();

    @Override
    public boolean contains(LaunchCode launchCode) {
        return usedCodes.contains(launchCode);
    }

    @Override
    public void add(LaunchCode launchCode) {
        usedCodes.add(launchCode);
    }
}
