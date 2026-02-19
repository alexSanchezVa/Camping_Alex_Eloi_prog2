
package prog2.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;

public class ParcelaTest {

    private Parcela parcela;

    @BeforeEach
    void setUp() {
        // Crear una instància de Parcela per als tests
        parcela = new Parcela("Parcela A", "P001", 50.0f, true);
    }

    @Test
    public void constructorValid() {
        Parcela p = new Parcela("Parcela B", "P002", 30.5f, false);
        assertEquals("Parcela B", p.getNom());
        assertEquals("P002", p.getId());
        assertEquals(30.5f, p.getMida());
        assertFalse(p.isConnexioElectrica());
    }

    @Test
    public void testGetMida() {
        assertEquals(50.0f, parcela.getMida());
    }

    @Test
    public void testSetMida() {
        parcela.setMida(60.0f);
        assertEquals(60.0f, parcela.getMida());
    }

    @Test
    public void testIsConnexioElectrica() {
        assertTrue(parcela.isConnexioElectrica());
    }

    @Test
    public void testSetConnexioElectrica() {
        parcela.setConnexioElectrica(false);
        assertFalse(parcela.isConnexioElectrica());
    }

    @Test
    public void testCorrecteFuncionamentAmbConnexioElectrica() {
        assertTrue(parcela.correcteFuncionament());
    }

    @Test
    public void testCorrecteFuncionamentSenseConnexioElectrica() {
        parcela.setConnexioElectrica(false);
        assertFalse(parcela.correcteFuncionament());
    }

    @Test
    public void testHerenciaAllotjament() {
        assertEquals(4, parcela.getEstadaMinima(InAllotjament.Temp.ALTA));
        assertEquals(2, parcela.getEstadaMinima(InAllotjament.Temp.BAIXA));
        parcela.setEstadaMinima(5, 3);
        assertEquals(5, parcela.getEstadaMinima(InAllotjament.Temp.ALTA));
        assertEquals(3, parcela.getEstadaMinima(InAllotjament.Temp.BAIXA));
    }

    @Test
    public void testToString() {
        String expected = "Nom=Parcela A, Id=P001, estada mínima en temp ALTA: 4, estada mínima en temp BAIXA: 2.";
        assertTrue(parcela.toString().contains(expected));
    }
}
