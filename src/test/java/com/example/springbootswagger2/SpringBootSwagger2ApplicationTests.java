package com.example.springbootswagger2;

import com.example.springbootswagger2.controller.Swagger2DemoRestController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SpringBootSwagger2ApplicationTests {

	private final static int EXPECTED_PORT = 8010;

	@Autowired
	private Swagger2DemoRestController controller;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void contextLoads() {
		assertThat(this.restTemplate.getForObject("http://localhost:" + EXPECTED_PORT + "/swagger-document/healthcheck",
				String.class)).contains("Ok");
	}

}
