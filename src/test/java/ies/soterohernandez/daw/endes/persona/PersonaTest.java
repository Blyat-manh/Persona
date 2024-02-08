package ies.soterohernandez.daw.endes.persona;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Unit test for simple App.
 */
public class PersonaTest 
{
    /**
     * Rigorous Test :-)
     */
	private static Persona persona;
	
	@BeforeEach
    public static void init() {
        persona = new Persona("Juan", 20, 'H', 70.0, 1.70);
    }

    @AfterEach
    public static void finish() {
        persona = null;
    }

    @Test
    public void testConstructorDefault() {
        assertNotNull(persona);
    }

    @Test
    public void testConstructor3Entradas() {
        assertNotNull(persona);
        assertEquals("Juan", persona.getNombre());
        assertEquals(20, persona.getEdad());
        assertEquals('H', persona.getSexo());
    }

    @Test
    public void testConstructor5Entradas() {
        Persona p = new Persona("Juan", 20, 'H', 70.0, 1.70);
        assertNotNull(p);
        assertEquals("Juan", persona.getNombre());
        assertEquals(20, persona.getEdad());
        assertEquals('H', persona.getSexo());
        assertEquals(70.0, persona.getPeso(), 0.001);
        assertEquals(1.70, persona.getAltura(), 0.001);
    }

    @Test
    public void testCalcularIMC() {
        Persona p = new Persona("Juan", 20, 'H');
        p.setPeso(55.0);
        p.setAltura(1.70);
        assertEquals(Persona.PESO_IDEAL, p.calcularIMC());

        p.setPeso(45.0);
        assertEquals(Persona.INFRAPESO, p.calcularIMC());

        p.setPeso(80.0);
        assertEquals(Persona.SOBREPESO, p.calcularIMC());
    }

    @Test
    public void testEsMayorDeEdad() {
        Persona p = new Persona();
        p.setEdad(18);
        assertTrue(p.esMayorDeEdad());

        p.setEdad(17);
        assertFalse(p.esMayorDeEdad());
    }
}