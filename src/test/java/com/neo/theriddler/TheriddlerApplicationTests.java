package com.neo.theriddler;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TheriddlerApplicationTests {

	@Test
	public void contextLoads() {

		RiddlerExtractor riddlerExtractor = new RiddlerExtractor();

		riddlerExtractor.extractRiddle();

	}

}
