package com.ouwy.DBDemo.demo;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

public class DBTest {

	@Test
	void getUUID() {
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid);
	}
}
