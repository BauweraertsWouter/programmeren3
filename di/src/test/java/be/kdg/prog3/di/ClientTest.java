package be.kdg.prog3.di;

import be.kdg.prog3.di.interfaces.Client;
import be.kdg.prog3.di.interfaces.Service;
import be.kdg.prog3.di.interfaces.SpringConfiguration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class ClientTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private PrintStream out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        out = System.out;
    }

    @After
    public void cleanUpStreams() {
        System.setOut(out);
    }

    @Autowired
    private Client client;

    @Autowired
    private Service service;

    @Autowired
    @Qualifier("specialService")
    private Service specialService;

    @Test
    public void testClientWork() {
        client.work();
        assertEquals("Calling service \"" + service.getName() + "\".\n", outContent.toString());
    }

    @Test
    public void testClientSpecialWork() {
        client.specialWork();
        assertEquals("Calling service \"" + specialService.getName() + "\".\n", outContent.toString());
    }
}
