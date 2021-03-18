package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Estos tags sirven para "agrupar" las pruebas y ejecutarlas conforme este
 * criterio. Esto se configura en run configurations
 * 
 * @author savila
 *
 */
class PersonTest implements ModelTests {

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

	/**
	 * Value son las veces que se va a repetir el metodo; Y lo demás e spara
	 * customizar el nombre
	 */
	@RepeatedTest(value = 10, name = "{displayName} : {currentRepetition} - {totalRepetitions}")
	@DisplayName("My Repeated Test")
	/**
	 * @Test Es redundante ponerla cuando se trata de test repetitivos
	 */
	void myRepeatedTest() {
		// todo - impl
	}

	/**
	 * Se pueden inyectar tres tipos de "resolvers"
	 * 
	 * TestInfo - Sirve para obtener informacion sobre el nomre dle tes, el metodo,
	 * la clase de test y los tags del test
	 * 
	 * RepetitionInfo - Sirve para obtener informacion sobre test que se repiten.
	 * 
	 * TestReporter - Permite publicar informacion del runtime para reportes del
	 * test
	 * 
	 * @param testInfo
	 * @param repetitionInfo
	 */
	@RepeatedTest(5)
	void myRepeatedTestWithDI(TestInfo testInfo, RepetitionInfo repetitionInfo) {
		System.out.println(testInfo.getDisplayName() + ": " + repetitionInfo.getCurrentRepetition());

	}
}