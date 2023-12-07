package mx.edu.itsur.pokebatalla.model.moves;

import java.io.Serializable;
import mx.edu.itsur.pokebatalla.model.Pokemons.Pokemon;
/**
 *
 * @author Francisco Gonzalez Regalado
 */
public abstract class Movimiento implements Serializable {

    enum TiposDeMovimiento {
        AGUA,
        BICHO,
        DRAGON,
        ELECTRICO,
        FANTASMA,
        FUEGO,
        HIELO,
        LUCHA,
        NORMAL,
        PLANTA,
        PSIQUICO,
        ROCA,
        SINIESTRO,
        TIERRA,
        VENENO,
        VOLADOR      
    }

    protected TiposDeMovimiento tipo;
    protected int potencia;
    protected int precision;
    protected int puntosPoder;

    
    public abstract void utilizar(Pokemon usuario, Pokemon objectivo);
        
}