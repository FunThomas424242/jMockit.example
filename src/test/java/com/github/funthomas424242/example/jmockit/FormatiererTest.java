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

import mockit.Tested;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class FormatiererTest {

    @Tested
    Formatierer formatierer;

    @BeforeEach
    void initialisiereTestfall() {
        formatierer = new Formatierer("#.###.##");
    }

    @Test
    void erzeugeValidInstanz() {
        final Formatierer formatierer = new Formatierer("#,###.##");
        assertNotNull(formatierer);
        final String siebenFormatiert = formatierer.formatiere(7.34);
        assertEquals("7,34", siebenFormatiert);
        final String achtMillionenFormatiert = formatierer.formatiere(8000000.56);
        assertEquals("8.000.000,56", achtMillionenFormatiert);

    }

}
