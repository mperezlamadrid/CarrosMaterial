package com.example.manuelperez.carrosmaterial;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void carro_existe_retorna_true() throws Exception {
        Carro c1 = new Carro("id", "IRY487", 0, 0, 0, 10, 0);
        Carro c2 = new Carro("id2", "IRY488", 0, 0, 0, 10, 0);
        Carro c3 = new Carro("id3", "IRY489", 0, 0, 0, 10, 0);

        Carro carros[] = {c1, c2, c3};

        ArrayList<Carro> cars = new ArrayList<>(Arrays.asList(carros));

        assertTrue(Metodos.exitenciaDeCarro(cars, "IRY487"));
    }

    @Test
    public void carro_no_existe_retorna_false() throws Exception {
        Carro c1 = new Carro("id", "IRY487", 0, 0, 0, 10, 0);
        Carro c2 = new Carro("id2", "IRY488", 0, 0, 0, 10, 0);
        Carro c3 = new Carro("id3", "IRY489", 0, 0, 0, 10, 0);

        Carro carros[] = {c1, c2, c3};

        ArrayList<Carro> cars = new ArrayList<>(Arrays.asList(carros));

        assertFalse(Metodos.exitenciaDeCarro(cars, "IRY486"));
    }

    @Test
    public void se_puede_editar_carro_retorna_true() throws Exception {
        Carro c1 = new Carro("id", "IRY487", 0, 0, 0, 10, 0);
        Carro c2 = new Carro("id2", "IRY488", 0, 0, 0, 10, 0);
        Carro c3 = new Carro("id3", "IRY489", 0, 0, 0, 10, 0);

        Carro carros[] = {c1, c2, c3};

        ArrayList<Carro> cars = new ArrayList<>(Arrays.asList(carros));

        assertTrue(Metodos.existenciaDeCarroE(cars, "IRY487", "IRY444"));
    }

    @Test
    public void no_puede_editar_carro_retorna_false() throws Exception {
        Carro c1 = new Carro("id", "IRY487", 0, 0, 0, 10, 0);
        Carro c2 = new Carro("id2", "IRY488", 0, 0, 0, 10, 0);
        Carro c3 = new Carro("id3", "IRY489", 0, 0, 0, 10, 0);

        Carro carros[] = {c1, c2, c3};

        ArrayList<Carro> cars = new ArrayList<>(Arrays.asList(carros));

        assertFalse(Metodos.existenciaDeCarroE(cars, "IRY487", "IRY487"));
    }

    @Test
    public void no_puede_editar_carro_no_existente_retorna_false() throws Exception {
        Carro c1 = new Carro("id", "IRY487", 0, 0, 0, 10, 0);
        Carro c2 = new Carro("id2", "IRY488", 0, 0, 0, 10, 0);
        Carro c3 = new Carro("id3", "IRY489", 0, 0, 0, 10, 0);

        Carro carros[] = {c1, c2, c3};

        ArrayList<Carro> cars = new ArrayList<>(Arrays.asList(carros));

        assertFalse(Metodos.existenciaDeCarroE(cars, "IRY000", "IRY111"));
    }
}