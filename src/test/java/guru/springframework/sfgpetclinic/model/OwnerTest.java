package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.CustomArgsProvider;
import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OwnerTest implements ModelTests {

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

		/**
		 * Método que viene de la biblioteca harmcrest, ya es vieja pero aun se usa y es
		 * útil
		 */
		assertThat(owner.getCity(), is("Key West"));
	}

	/**
	 * Repite el test por cada valor en el enum
	 */
	@DisplayName("Enum Source Test")
	@ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
	@EnumSource(OwnerType.class)
	void enumTest(OwnerType ownerType) {
		System.out.println(ownerType);
	}

	/**
	 * También se repite por cada elemento del "CSV"
	 * 
	 * En este caso son 3 columnas cada una tiene tres filas de valores
	 */
	@DisplayName("CSV Input Test")
	@ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
	@CsvSource({ "FL, 1, 1", "OH, 2, 2", "MI, 3, 1" })
	void csvInputTest(String stateName, int val1, int val2) {
		System.out.println(stateName + " = " + val1 + ":" + val2);
	}

	/**
	 * Repite el test para cada valor que se dé en el ValueSource
	 * 
	 * Se agrega formato para el nombre del metodo, :3
	 */
	@DisplayName("Value Source Test")
	@ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
	@ValueSource(strings = { "Spring", "Framework", "Guru" })
	void testValueSource(String val) {
		System.out.println(val);
	}

	@DisplayName("CSV From File Test")
	@ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
	@CsvFileSource(resources = "/input.csv", numLinesToSkip = 1)
	void csvFromFileTest(String stateName, int val1, int val2) {
		System.out.println(stateName + " = " + val1 + ":" + val2);
	}

	@DisplayName("Method Provider Test")
	@ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
	@MethodSource("getargs")
	void fromMethodTest(String stateName, int val1, int val2) {
		System.out.println(stateName + " = " + val1 + ":" + val2);
	}

	@DisplayName("Custom Provider Test")
	@ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
	@ArgumentsSource(CustomArgsProvider.class)
	void fromCustomProviderTest(String stateName, int val1, int val2) {
		System.out.println(stateName + " = " + val1 + ":" + val2);
	}

	static Stream<Arguments> getargs() {
		return Stream.of(Arguments.of("FL", 5, 1), Arguments.of("OH", 2, 8), Arguments.of("MI", 3, 5));
	}
}