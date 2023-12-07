package mx.edu.itsur.pokebatalla.model.Pokemons;

import mx.edu.itsur.pokebatalla.model.moves.Agilidad;
import mx.edu.itsur.pokebatalla.model.moves.AtaqueAla;
import mx.edu.itsur.pokebatalla.model.moves.Tornado;
import mx.edu.itsur.pokebatalla.model.moves.Movimiento;

/**
 *
 * @author Francisco Gonzalez Regalado
 */
public class Pidgeot extends Pokemon {
    
    public enum Movimientos {
        AGILIDAD,
        ATAQUE_ALA,
        TORNADO
    }
        
    public Pidgeot() {
        this.tipo = "NORMAL/VOLADOR";
        this.hp = 86;
        this.ataque = 43;
        this.defensa = 90;
        this.nivel = 1;
        this.precision = 5;
    }    
    
    public Pidgeot(String nombre){
        this(); 
        this.nombre = nombre;
    }
    
    @Override
    public Enum[] getMovimiento() {
        return Pidgeot.Movimientos.values();
    }

    @Override
    public void atacar(Pokemon oponente, int ordinalMovimiento) {
        if (this.hp <= 0) {
            System.out.println("Pidgeot esta agotado y no puede realizar mas movimientos.");
            return;
        }

        Pidgeot.Movimientos movimientoAUtilizar = Pidgeot.Movimientos.values()[ordinalMovimiento];
        Movimiento instanciaMovimiento;

        switch (movimientoAUtilizar) {
            case AGILIDAD:
                instanciaMovimiento = new Agilidad();
                break;
            case ATAQUE_ALA:
                instanciaMovimiento = new AtaqueAla();
                break;
            case TORNADO:
                instanciaMovimiento = new Tornado();
                break;
            default:
                throw new AssertionError();
        }

        instanciaMovimiento.utilizar(this, oponente);
    }
    
}
