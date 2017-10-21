package com.example.manuelperez.carrosmaterial;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by manuelperez on 10/21/17.
 */

public class Metodos {

    public static int fotoAleatoria(ArrayList<Integer> fotos){
        int fotoSeleccionada;
        Random r = new Random();
        fotoSeleccionada = r.nextInt(fotos.size());
        return fotos.get(fotoSeleccionada);
    }

    public static boolean exitenciaDeCarro(ArrayList<Carro> carros, String placa){
        for (int i = 0; i <carros.size() ; i++) {
            if(carros.get(i).getPlaca().equals(placa)){
                return true;
            }
        }
        return false;
    }

    public static boolean existenciaDeCarroE(ArrayList<Carro> personas, String placaE, String placaActual){
        if (!placaActual.equals(placaE)) {
            if (exitenciaDeCarro(personas, placaE)) {
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }
}
