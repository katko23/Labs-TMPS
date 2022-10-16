package TMPS.lab1.O;

public class OpenClosedDesign {
    public interface Curs{
       double NotaSesie();
    }

    public class TMPS implements Curs{
        double notaMedie;
        double notaExamen;
        public double NotaSesie(){
            return 0.5*notaExamen+0.5*notaExamen;
        }
    }

    public class CS implements Curs{
        double notaMedie;
        double notaExamen;
        double notaLaburi;
        double notaProiect;
        public double NotaSesie(){
            return 0.3*notaExamen+0.2*notaExamen+0.2*notaLaburi + 0.3*notaProiect;
        }
    }
}
