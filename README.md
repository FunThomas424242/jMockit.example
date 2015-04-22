# jMockit.example
Testbeispiele mit jMockit

##Hinweise
jMockit arbeitet mit Instrumentierung des ByteCodes.

##Bekannte Probleme
1. Eine Ausführung in eclipse funktioniert zunächst nicht weil das eclipse eigene junit jar signiert ist. 
Workaround: Einbindungung eines nicht signierten JUnit jars in eclipse.
2. Beim Maven Build muss jMockit for jUnit als Abhängigkeit deklariert werden.

## Best Praxis
1. Funktioniert gut im Maven Build
2. Funktioniert gut mit TestNG
