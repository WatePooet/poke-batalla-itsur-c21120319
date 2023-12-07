package mx.edu.itsur.pokebatalla.model.Pokemons;

import mx.edu.itsur.pokebatalla.model.moves.GolpeCuerpo;
import mx.edu.itsur.pokebatalla.model.moves.HidroBomba;
import mx.edu.itsur.pokebatalla.model.moves.PistolaAgua;
import mx.edu.itsur.pokebatalla.model.moves.Movimiento;

/**
 *
 * @author Francisco Gonzalez Regalado
 */
public class Gyarados extends Pokemon {
    
    public enum Movimientos {
        GOLPE_CUERPO,
        HIDROBOMBA,
        PISTOLA_AGUA
    }
        
    public Gyarados() {
        this.tipo = "AGUA/VOLADOR";
        this.hp = 64;
        this.ataque = 95;
        this.defensa = 84;
        this.nivel = 1;
        this.precision = 4;
    }    
    
    public Gyarados(String nombre){
        this(); 
        this.nombre = nombre;
    }
    
    @Override
    public Enum[] getMovimiento() {
        return Gyarados.Movimientos.values();
    }

    @Override
    public void atacar(Pokemon oponente, int ordinalMovimiento) {
        if (this.hp <= 0) {
            System.out.println("Gyarados esta agotado y no puede realizar mas movimientos.");
            return;
        }

        Gyarados.Movimientos movimientoAUtilizar = Gyarados.Movimientos.values()[ordinalMovimiento];
        Movimiento instanciaMovimiento;

        switch (movimientoAUtilizar) {
            case GOLPE_CUERPO:
                instanciaMovimiento = new GolpeCuerpo();
                break;
            case HIDROBOMBA:
                instanciaMovimiento = new HidroBomba();
                break;
            case PISTOLA_AGUA:
                instanciaMovimiento = new PistolaAgua();
                break;
            default:
                throw new AssertionError();
        }

        instanciaMovimiento.utilizar(this, oponente);
    }
    
}
