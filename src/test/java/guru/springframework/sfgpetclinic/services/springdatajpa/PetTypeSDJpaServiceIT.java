package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.junitextensions.TimingExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * Maven reconoce la clase como clase de test de integracion por el sufijo "IT"
 * que lleva el nombre de la clase.
 * 
 * Es posible extender Junit con la antoacion @ExtendWith pueden ser clases
 * propias.
 * 
 * @author savila
 *
 */
@ExtendWith(TimingExtension.class)
class PetTypeSDJpaServiceIT {

	@BeforeEach
	void setUp() {
	}

	@Test
	void findAll() {
	}

	@Test
	void findById() {
	}

	@Test
	void save() {
	}

	@Test
	void delete() {
	}

	@Test
	void deleteById() {
	}
}