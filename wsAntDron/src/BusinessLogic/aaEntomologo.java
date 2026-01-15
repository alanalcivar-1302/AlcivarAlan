package BusinessLogic;

import BusinessLogic.Entities.HRastreadora;
import BusinessLogic.Entities.Hormiga;
import BusinessLogic.Interfaces.aaIEntomologo;
import DataAccess.DTOs.HormigaDTO;
import DataAccess.DTOs.AlimentoTipoDTO;

public class aaEntomologo implements aaIEntomologo {

    // Colores
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";

    @Override
    public void etlAntNest() {
        System.out.println("\n[+] Hormigas");
        try {
            java.util.List<String> aaLines = java.nio.file.Files.readAllLines(
                    java.nio.file.Paths.get(Infrastructure.AppConfig.ROOT_PATH + "storage/DataFiles/AntNest.txt"));
            for (String aaLine : aaLines) {
                String[] aaAnts = aaLine.split(",");
                for (String aaAnt : aaAnts) {
                    aaAnt = aaAnt.trim();
                    if (aaAnt.isEmpty())
                        continue;

                    if (aaAnt.equals("HRastreadora")) {
                        System.out.println("  \\|/- " + aaAnt);

                        // Creando entidad DTO para BD
                        HormigaDTO aaHormigaDTO = new HormigaDTO();
                        aaHormigaDTO.setNombre(aaAnt);
                        aaHormigaDTO.setEstado("VIVO");
                        saveToDB("Hormigas", aaHormigaDTO.toString()); // Simulando envio de objeto
                    } else {
                        System.out.println(ANSI_RED + "  \\|/- " + aaAnt + ANSI_RESET);
                    }
                }
            }
        } catch (java.io.IOException e) {
            System.out.println("Error leyendo AntNest.txt: " + e.getMessage());
        }
    }

    @Override
    public void etlAntFood() {
        System.out.println("\n[+] Alimentos");
        try {
            java.util.List<String> aaLines = java.nio.file.Files
                    .readAllLines(java.nio.file.Paths
                            .get(Infrastructure.AppConfig.ROOT_PATH + "storage/DataFiles/AntFood.txt"));
            for (String aaLine : aaLines) {
                String[] aaFoods = aaLine.split("-");
                for (String aaFood : aaFoods) {
                    aaFood = aaFood.trim();
                    if (aaFood.isEmpty())
                        continue;

                    if (aaFood.equals("Insectívoro")) {
                        System.out.println("  .o. " + aaFood);

                        // Creando entidad DTO para BD
                        AlimentoTipoDTO aaAlimentoDTO = new AlimentoTipoDTO();
                        aaAlimentoDTO.setNombre(aaFood);
                        saveToDB("Alimentos", aaAlimentoDTO.toString());
                    } else {
                        System.out.println(ANSI_RED + "  .o. " + aaFood + ANSI_RESET);
                    }
                }
            }
        } catch (java.io.IOException e) {
            System.out.println("Error leyendo AntFood.txt: " + e.getMessage());
        }
    }

    private void saveToDB(String table, String data) {
        // Simulación de guardado en BD
        // System.out.println("Guardando en " + table + ": " + data);
    }

    public void preparar(String alimento) {
        System.out.println("[ Preparado ]-< " + alimento + " >-");
    }

    @Override
    public void alimentarAnt(Hormiga hormiga, String alimento) {
        System.out.println("Entomólogo alimentando hormiga con " + alimento);

        if (hormiga instanceof HRastreadora) {
            HRastreadora hRastreadora = (HRastreadora) hormiga;
            if (alimento.equals(hRastreadora.getAlimento())) {
                System.out.println("La hormiga HRastreadora ha comido y VIVE.");
                if ("XY".equals(hRastreadora.getGenoma())) {
                    System.out.println("SuperHabilidad activada: " + hRastreadora.superRastreo());
                }
            } else {
                System.out.println("La hormiga ha muerto por alimento incorrecto.");
            }
        } else {
            System.out.println("Hormiga alimentada.");
        }
    }
}
