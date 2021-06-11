package pl.edu.pw.pik.pikactivitytrackerserver;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.edu.pw.pik.pikactivitytrackerserver.controller.EventController;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PikactivityTrackerServerApplication.class)
public class PikactivityTrackerServerApplicationTests {

	@Autowired
	EventController eventController;

	@Test
	public void contextLoads() {
		assertEquals(true, true);
	}

}
