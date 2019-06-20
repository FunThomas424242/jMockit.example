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
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class RechnerTest {

    @Mocked
    Formatierer formatierer;

    @Injectable
    private String format = "#,###.##";

    @Tested
    Rechner rechner;

    @BeforeAll
    static void initialisiereTestsuit(){
        // Notwendig für Ausführung in Cloud z.B. Travis-CI
        Locale.setDefault(new Locale("de", "DE"));
    }

// Nicht notwendig, da jMockit die @Tested Instanz über den Standardkonstruktor erzeugt
//    @BeforeEach
//    void initialisiereTestfall() {
//        rechner = new Rechner(format);
//    }

    @Test
    public void addiereZulaessig() {

        new Expectations() {{
            formatierer.formatiere(7.0);
            times = 1;
        }};

        rechner.addiere(3, 4);

        new Verifications() {{
            formatierer.formatiere(7.0);
            times = 1;
        }};

    }

}
