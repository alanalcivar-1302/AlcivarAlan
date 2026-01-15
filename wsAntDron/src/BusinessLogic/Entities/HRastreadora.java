package BusinessLogic.Entities;

// import Infrastructure.AppException;

public class HRastreadora extends Hormiga {

    public HRastreadora() {
    }

    public String getGenoma() {
        return "XY";
    }

    public String getAlimento() {
        return "Insectívoro";
    }

    public String superRastreo() {
        return "superRastreo(...)";
    }

    @Override
    public String toString() {
        return "HRastreadora { Genoma: " + getGenoma() + ", Alimento: " + getAlimento() + " }";
    }
}
