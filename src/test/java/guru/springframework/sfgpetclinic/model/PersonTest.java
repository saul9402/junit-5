package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;

/**
 * Estos tags sirven para "agrupar" las pruebas y ejecutarlas conforme este
 * criterio. Esto se configura en run configurations
 * 
 * @author savila
 *
 */
class PersonTest {

	@Test
	void groupedAssertions() {
		// given
		Person person = new Person(1l, "Joe", "Buck");

		// then
		assertAll("Test Props Set", () -> assertEquals("Joe", person.getFirstName()),
				() -> assertEquals("Buck", person.getLastName()));
	}

	@Test
	void groupedAssertionMsgs() {
		// given
		Person person = new Person(1l, "Joe", "Buck");

		// then
		assertAll("Test Props Set", () -> assertEquals("Joe", person.getFirstName(), "First Name Failed"),
				() -> assertEquals("Buck", person.getLastName(), "Last Name Failed"));
	}
}