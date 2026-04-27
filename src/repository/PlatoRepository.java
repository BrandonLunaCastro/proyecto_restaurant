package repository;
import model.Plato;
import java.util.ArrayList;
import java.util.List;

public class PlatoRepository {
    //Base de datos simulada
    List<Plato> platos = new ArrayList<>();

    public void add(Plato plato) {
        platos.add(plato);
    }

    public List<Plato> getPlatos() {
        return platos;
    }

    public void delete(Plato plato) {
        platos.remove(plato);
    }


}
