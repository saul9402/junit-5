package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {

	@Test
	void dependentAssertions() {

		Owner owner = new Owner(1l, "Joe", "Buck");
		owner.setCity("Key West");
		owner.setTelephone("1231231234");

		/**
		 * Se agrupan pruebas para ejecutar todas de una vez en el mismo test y no tener
		 * que estar en un ciclo de "ejecutar y corregir" constantemente
		 */
		assertAll("Properties Test",
				() -> assertAll("Person Properties",
						() -> assertEquals("Joe", owner.getFirstName(), "First Name Did not Match"),
						() -> assertEquals("Buck", owner.getLastName())),
				() -> assertAll("Owner Properties",
						() -> assertEquals("Key West", owner.getCity(), "City Did Not Match"),
						() -> assertEquals("1231231234", owner.getTelephone())));
	}
}