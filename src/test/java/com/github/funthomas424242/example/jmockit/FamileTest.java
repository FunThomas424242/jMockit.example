package com.github.funthomas424242.example.jmockit;

/*-
 * #%L
 * Testbeispiele mit jmockit)
 * %%
 * Copyright (C) 2019 PIUG
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 *
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */

import mockit.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class FamileTest {

    @Tested
    private Familie familie;

    @BeforeEach
    void setUpTestfall() {
        // Tested Objekt ohne Standardkonstruktor kann selbst initialisiert werden.
        familie = new Familie("Untreu und Vermögend");
    }


    /**
     * Definition welche Resultate nach und nach beim Aufruf einer Methode zurück gegeben werden sollen.
     *
     * @param person
     */
    @Test
    void gleichMethodeVerschiedeneErgebnisse(@Mocked Person person) {

        new Expectations() {
            {
                person.getAlter();
                result = 1;
                result = 2;
                result = 3;
                times = 3;
            }
        };

        familie.addMitglied(person);
        familie.addMitglied(person);
        familie.addMitglied(person);
        familie.addMitglied(person);
        familie.addMitglied(person);

        assertEquals(1, person.getAlter());
        assertEquals(2, person.getAlter());
        assertEquals(3, person.getAlter());


    }

    @Test
    void testConstructorMockUp() {
        new Expectations() {
            {
                new MockUp<Familie>() {
                    @Mock
                    public void $init(Invocation invocation, String bezeichnung) {
                        ((Familie) invocation.getInvokedInstance()).id = 56;
                    }
                };
            }
        };

        final Familie familie = new Familie("Graf von Blasius");
        // Wurde beim new über das MockUp gesetzt
        assertEquals(56, familie.id);
        // Es können nur nicht finale Felder gesetzt werden
        assertNull(familie.sippenBezeichnung);
    }


}
