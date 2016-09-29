package be.kdg.prog3.di.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Client {
    private final Service service;
    private Service specialService;

    @Autowired
    private Client(final Service service) {
        this.service = service;
    }

    @Autowired
    @Qualifier("specialService")
    private void setSpecialService(final Service specialService) {
        this.specialService = specialService;
    }

    public void work() {
        System.out.printf("Calling service \"%s\".%n", service.getName());
    }

    public void specialWork() {
        System.out.printf("Calling service \"%s\".%n", specialService.getName());
    }
}
