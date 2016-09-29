package be.kdg.prog3.di.basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        Client client = context.getBean(Client.class);
        client.work();
        client.specialWork();
        Service specialService = (Service)context.getBean("specialService");
        System.out.printf("Manually calling service \"%s\".%n", specialService.getName());
    }
}
