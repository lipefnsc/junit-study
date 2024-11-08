package com.project.service;

import com.project.domain.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonServiceTest {
    private Person adult;
    private Person notAdult;
    private PersonService ps;

    @BeforeEach
    public void setUp() {
        adult = new Person(19);
        notAdult = new Person(15);
        ps = new PersonService();
    }

    @Test
    @DisplayName("A person should be not adult when age is lower than 18")
    // nomeDoMétodo_Esperado_Condição
    void isAdult_ReturnFalse_WhenAgeIsLowerThan18() {
        assertFalse(ps.isAdult(notAdult));
    }

    @Test
    @DisplayName("A person should adult when age is greater or equal than 18")
    void isAdult_ReturnTrue_WhenAgeIsGreaterOrEqualsThan18() {
        assertTrue(ps.isAdult(adult));
    }

    @Test
    @DisplayName("Should throw NullPointerException with message when person is null")
    void isAdult_ThrowException_WhenPersonIsNull() {
        Assertions.assertThrows(NullPointerException.class, () -> ps.isAdult(null), "Person can't be null");
    }

    @Test
    @DisplayName("Should return list with only adults")
    void filterRemovingNotAdult_ReturnListWithAdultOnly_WhenListOfPersonWithAdultIsPassed() {
        Person person1 = new Person(17);
        Person person2 = new Person(18);
        Person person3 = new Person(21);
        List<Person> personList = new ArrayList<>(Arrays.asList(person1,person2,person3));
        Assertions.assertEquals(2, ps.filterRemovingNotAdult(personList).size());
    }
}