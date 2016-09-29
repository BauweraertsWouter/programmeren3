package be.kdg.prog3.di.interfaces;

import org.springframework.stereotype.Component;

@Component
public class ServiceConnection {
    private final int id = 1234;

    public int getId() {
        return id;
    }
}
