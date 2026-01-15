package BusinessLogic.Interfaces;

import BusinessLogic.Entities.Hormiga;
//import java.util.List;

public interface aaIEntomologo {
    void etlAntNest();

    void etlAntFood();

    void alimentarAnt(Hormiga hormiga, String alimento);
}
