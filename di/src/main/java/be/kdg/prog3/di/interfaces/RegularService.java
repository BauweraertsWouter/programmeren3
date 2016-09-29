package be.kdg.prog3.di.interfaces;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class RegularService implements Service {
    @Override
    public String getName() {
        return "RegularService";
    }
}
