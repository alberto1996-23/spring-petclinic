package org.springframework.samples.petclinic;

import org.junit.jupiter.api.Test;
import org.springframework.aot.hint.RuntimeHints;

class PetClinicRuntimeHintsTests {

	@Test
	void registerHintsDoesNotThrow() {
		PetClinicRuntimeHints registrar = new PetClinicRuntimeHints();
		RuntimeHints hints = new RuntimeHints();
		registrar.registerHints(hints, getClass().getClassLoader());
	}

}
