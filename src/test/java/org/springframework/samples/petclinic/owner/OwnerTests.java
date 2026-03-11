/*
 * Copyright 2012-2025 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for {@link Owner}
 *
 * @author Generated for specification-based testing
 */
class OwnerTests {

	@Test
	void testGetPet_ValidName_IgnoreNewFalse_PetNotNew() {
		// Arrange
		Owner owner = new Owner();
		Pet pet = new Pet();
		pet.setName("Fluffy");
		pet.setId(1); // Not new
		owner.getPets().add(pet);

		// Act
		Pet result = owner.getPet("Fluffy", false);

		// Assert
		assertEquals(pet, result);
	}

	@Test
	void testGetPet_ValidName_IgnoreNewFalse_PetNew() {
		// Arrange
		Owner owner = new Owner();
		Pet pet = new Pet();
		pet.setName("Fluffy");
		// No ID set, so isNew() == true
		owner.getPets().add(pet);

		// Act
		Pet result = owner.getPet("Fluffy", false);

		// Assert
		assertEquals(pet, result);
	}

	@Test
	void testGetPet_ValidName_IgnoreNewTrue_PetNotNew() {
		// Arrange
		Owner owner = new Owner();
		Pet pet = new Pet();
		pet.setName("Fluffy");
		pet.setId(1); // Not new
		owner.getPets().add(pet);

		// Act
		Pet result = owner.getPet("Fluffy", true);

		// Assert
		assertEquals(pet, result);
	}

	@Test
	void testGetPet_ValidName_IgnoreNewTrue_PetNew() {
		// Arrange
		Owner owner = new Owner();
		Pet pet = new Pet();
		pet.setName("Fluffy");
		// No ID set, so isNew() == true
		owner.getPets().add(pet);

		// Act
		Pet result = owner.getPet("Fluffy", true);

		// Assert
		assertNull(result);
	}

	@Test
	void testGetPet_InvalidName_IgnoreNewFalse() {
		// Arrange
		Owner owner = new Owner();
		Pet pet = new Pet();
		pet.setName("Fluffy");
		pet.setId(1);
		owner.getPets().add(pet);

		// Act
		Pet result = owner.getPet("NonExistent", false);

		// Assert
		assertNull(result);
	}

	@Test
	void testGetPet_InvalidName_IgnoreNewTrue() {
		// Arrange
		Owner owner = new Owner();
		Pet pet = new Pet();
		pet.setName("Fluffy");
		pet.setId(1);
		owner.getPets().add(pet);

		// Act
		Pet result = owner.getPet("NonExistent", true);

		// Assert
		assertNull(result);
	}

	@Test
	void testGetPet_NameNull_IgnoreNewFalse() {
		// Arrange
		Owner owner = new Owner();
		Pet pet = new Pet();
		pet.setName("Fluffy");
		pet.setId(1);
		owner.getPets().add(pet);

		// Act
		Pet result = owner.getPet(null, false);

		// Assert
		assertNull(result);
	}

	@Test
	void testGetPet_EmptyName_IgnoreNewFalse() {
		// Arrange
		Owner owner = new Owner();
		Pet pet = new Pet();
		pet.setName("Fluffy");
		pet.setId(1);
		owner.getPets().add(pet);

		// Act
		Pet result = owner.getPet("", false);

		// Assert
		assertNull(result);
	}

	@Test
	void testGetPet_CaseInsensitiveMatch_IgnoreNewFalse() {
		// Arrange
		Owner owner = new Owner();
		Pet pet = new Pet();
		pet.setName("Fluffy");
		pet.setId(1);
		owner.getPets().add(pet);

		// Act
		Pet result = owner.getPet("FLUFFY", false);

		// Assert
		assertEquals(pet, result);
	}

	@Test
	void testGetPet_MultiplePets_ReturnsFirstMatch() {
		// Arrange
		Owner owner = new Owner();
		Pet pet1 = new Pet();
		pet1.setName("Fluffy");
		pet1.setId(1);
		Pet pet2 = new Pet();
		pet2.setName("Fluffy");
		pet2.setId(2);
		owner.getPets().add(pet1);
		owner.getPets().add(pet2);

		// Act
		Pet result = owner.getPet("Fluffy", false);

		// Assert
		assertEquals(pet1, result);
	}

}