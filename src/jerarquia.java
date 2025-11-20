public class jerarquia {
    public static void aaJerarquia() throws InterruptedException {

        String[] aaPersonas = {
            "Gnasthostomata",
            "Osteichthyes",
            "Sarcopterygli",
            "Tetrapoda",
            "Amniota"
        };

        int aaLargo = 30; 
        int aaDelay = 80;

        int aaPos = 0;
        int aaDireccion = 1;

        long aaInicio = System.currentTimeMillis();
        long aaDuracion = 5000;

        while (System.currentTimeMillis() - aaInicio < aaDuracion) {

            System.out.print("\033[H\033[2J");
            System.out.flush();

            for (int i = 0; i < aaPersonas.length; i++) {

                StringBuilder barra = new StringBuilder();

                for (int j = 0; j < aaLargo; j++) {
                    if (j == aaPos) barra.append('0');
                    else barra.append('o');
                }

                System.out.println(barra + "   " + aaPersonas[i]);
            }

            Thread.sleep(aaDelay);

            aaPos += aaDireccion;

            if (aaPos == aaLargo - 1 || aaPos == 0) {
                aaDireccion *= -1;
            }
        }
    }    
}
