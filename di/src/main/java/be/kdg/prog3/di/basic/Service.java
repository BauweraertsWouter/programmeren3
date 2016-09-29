package be.kdg.prog3.di.basic;

import org.springframework.stereotype.Component;

@Component
public class Service {
    private final String name;

    public Service() {
        this.name = "RegularService";
    }

    public Service(final String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
