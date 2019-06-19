package com.github.funthomas424242.example.jmockit;

/*-
 * #%L
 * Testbeispiele mit jMockit)
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

import java.util.ArrayList;
import java.util.List;

public class Familie {

    protected final List<Person> mitglieder;
    protected final String sippenBezeichnung;
    protected Integer id = 3;

    public Familie(final String sippenBezeichnung) {
        this.mitglieder = new ArrayList<>();
        this.sippenBezeichnung = sippenBezeichnung;
    }

    public void addMitglied(final Person person) {
        mitglieder.add(person);
    }
}
