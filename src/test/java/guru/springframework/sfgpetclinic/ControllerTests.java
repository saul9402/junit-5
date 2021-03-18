package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInstance;

/**
 * Created by jt on 2018-10-28.
 */
/**
 * Se agrega la anotacion para poder ejecutar el metodo default
 * 
 * @author savila
 *
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Tag("controllers")
public interface ControllerTests {

	@BeforeAll
	default void beforeAll() {
		System.out.println("Lets do something here");
	}
}
