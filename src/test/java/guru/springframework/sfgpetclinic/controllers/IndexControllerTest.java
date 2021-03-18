package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {

	IndexController controller;

	@BeforeEach
	void setUp() {
		controller = new IndexController();
	}

	@DisplayName("Test Proper View name is returned for index page")
	@Test
	void index() {
		assertEquals("index", controller.index());
		assertEquals("index", controller.index(), "Wrong View Returned");

		assertEquals("index", controller.index(), () -> "Another Expensive Message " + "Make me only if you have to");
	}

	@Test
	@DisplayName("Test exception")
	void oupsHandler() {
		assertThrows(ValueNotFoundException.class, () -> controller.oopsHandler());
	}

	@Disabled("Demo of timeout")
	@Test
	void testTimeOut() {

		/**
		 * Si se hace asi esperara lo que tarde el metodo en ejecutar y devolvera lo que
		 * se espera
		 */
		assertTimeout(Duration.ofMillis(100), () -> {
			Thread.sleep(5000);

			System.out.println("I got here");
		});
	}

	@Disabled("Demo of timeout")
	@Test
	void testTimeOutPrempt() {

		/**
		 * En cambio si se hace asi sólo va a esperar lo que se defina en el timeout y
		 * terminara el proceso
		 */
		assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
			Thread.sleep(5000);

			System.out.println("I got here 2342342342342");
		});
	}
}