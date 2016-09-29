package be.kdg.prog3.di.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("specialService")
public class SpecialService implements Service {
    private final ServiceConnection serviceConnection;

    @Autowired
    SpecialService(final ServiceConnection serviceConnection) {
        this.serviceConnection = serviceConnection;
    }

    @Override
    public String getName() {
        return "SpecialService (conn. " + this.serviceConnection.getId() + ")";
    }
}
