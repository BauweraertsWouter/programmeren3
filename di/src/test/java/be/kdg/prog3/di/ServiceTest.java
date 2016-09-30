package be.kdg.prog3.di;

import be.kdg.prog3.di.interfaces.Service;
import be.kdg.prog3.di.interfaces.ServiceConnection;
import be.kdg.prog3.di.interfaces.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class ServiceTest {
    @Autowired
    private Service service;

    @Autowired
    @Qualifier("specialService")
    private Service specialService;

    @Autowired
    private ServiceConnection serviceConnection;

    @Test
    public void testServiceWork() {
        assertEquals(service.getName(), "RegularService");
    }

    @Test
    public void testSpecialServiceWork() {
        assertEquals(specialService.getName(), "SpecialService (conn. " + serviceConnection.getId() + ")");
    }
}
