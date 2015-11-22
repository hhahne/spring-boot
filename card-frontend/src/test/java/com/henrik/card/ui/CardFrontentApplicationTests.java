package com.henrik.card.ui;

import com.henrik.card.CardFrontentApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CardFrontentApplication.class)
@WebAppConfiguration
public class CardFrontentApplicationTests {

	@Test
	public void contextLoads() {
	}

}
