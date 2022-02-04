package missile;

import missile.Missile;

public class DummyMissile implements Missile {
    @Override
    public void launch() {
        throw new RuntimeException();
    }

    @Override
    public void disable() {
    }
}
