package TMPS.lab1.S;

public class SingleResponsibility {
    private interface Students_I{
        int nrAbsente();

        int buget_institutie();
    }

    public class Student implements Students_I{
        public Student(String nume, double nota_m, String an_st, String sef_pr, Institutie inst){
            name = nume;
            nota_medie = nota_m;
            an_de_studii = an_st;
            sef_de_program = sef_pr;
            instit = inst;
        }

        private String an_de_studii;
        private String sef_de_program;
        private String name = "";
        public char prezenta[] = new char[32];
        private double nota_medie = 1;
        private Institutie instit;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public char[] getPrezenta() {
            return prezenta;
        }

        public void setPrezenta(char[] prezenta) {
            this.prezenta = prezenta;
        }

        public double getNota_medie() {
            return nota_medie;
        }

        public void setNota_medie(double nota_medie) {
            this.nota_medie = nota_medie;
        }

        public String getSef_de_program() {
            return sef_de_program;
        }

        public String getAn_de_studii() {
            return an_de_studii;
        }

        public void setAn_de_studii(String an_de_studii) {
            this.an_de_studii = an_de_studii;
        }

        public void setSef_de_program(String sef_de_program) {
            this.sef_de_program = sef_de_program;
        }

        @Override
        public int nrAbsente() {
            int sum=0;
            for(int i=1;i<=30;i++) {
                if(prezenta[i] == 'a')sum++;
            }
            return sum;
        }

        @Override
        public int buget_institutie() {
            int buget = instit.buget_contracte + instit.buget_transmis_stat + instit.buget_studenti;
            return buget;
        }
    }

    public class Elev implements Students_I{
        public Elev(String nume, double nota_m, String cl, String dir, Institutie inst){
            name = nume;
            nota_medie = nota_m;
            clasa = clasa;
            diriginta = dir;
            instit = inst;
        }
        private String clasa;
        private String diriginta;
        private String name = "";
        public char prezenta[] = new char[32];
        private double nota_medie = 1;
        private Institutie instit ;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public char[] getPrezenta() {
            return prezenta;
        }

        public void setPrezenta(char[] prezenta) {
            this.prezenta = prezenta;
        }

        public double getNota_medie() {
            return nota_medie;
        }

        public void setNota_medie(double nota_medie) {
            this.nota_medie = nota_medie;
        }

        public String getClasa() {
            return clasa;
        }

        public String getDiriginta() {
            return diriginta;
        }

        public void setClasa(String clasa) {
            this.clasa = clasa;
        }

        public void setDiriginta(String diriginta) {
            this.diriginta = diriginta;
        }

        @Override
        public int nrAbsente() {
            int sum=0;
            for(int i=1;i<=30;i++) {
                if(prezenta[i] == 'a')sum++;
            }
            return sum;
        }

        @Override
        public int buget_institutie() {
            int buget = instit.buget_contracte + instit.buget_transmis_stat;
            return buget;
        }
    }

    public class Institutie{
        public Institutie(int bts, int bc, String nume, String adr){
            buget_transmis_stat = bts;
            buget_contracte = bc;
            buget_studenti = 0;
            name = nume;
            adresa = adr;
        }

        public Institutie(int bts, int bc, int bs, String nume, String adr){
            buget_transmis_stat = bts;
            buget_contracte = bc;
            buget_studenti = bs;
            name = nume;
            adresa = adr;
        }

        private int buget_transmis_stat;
        private int buget_contracte;
        private int buget_studenti;
        private String name;
        private String adresa;

        public int getBuget_transmis_stat() {
            return buget_transmis_stat;
        }

        public int getBuget_contracte() {
            return buget_contracte;
        }

        public String getName() {
            return name;
        }

        public String getAdresa() {
            return adresa;
        }

        public void setBuget_transmis_stat(int buget_transmis_stat) {
            this.buget_transmis_stat = buget_transmis_stat;
        }

        public void setBuget_contracte(int buget_contracte) {
            this.buget_contracte = buget_contracte;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAdresa(String adresa) {
            this.adresa = adresa;
        }
    }


    public void quick_example(){
        //we have 2 intitutions like liceu and University
        //let's initialize them :
        Institutie liceu = new Institutie(160000, 165000, "Liceul Stere", "D.Cantemir 88/1");
        Institutie univer = new Institutie(500000, 700000, 200000, "UTM", "Studentilor 9/3");
        // de ex avem 2 persoane care studiaza :
        Student catalin = new Student("Cătălin", 9.85,"Anul III","Mihai Gavrilita", univer);
        Elev sandu = new Elev("Alexandru", 10,"clasa VII F","Zasmenco Ala", liceu);

        // sa le punem niste absente :
        catalin.prezenta[10] = 'a';
        catalin.prezenta[1] = 'a';
        catalin.prezenta[9] = 'a';
        catalin.prezenta[21] = 'a';
        catalin.prezenta[6] = 'a';

        sandu.prezenta[1] = 'a';

        //acum putem schimba orice in aceste obiecte prin set si get :
        System.out.println(catalin.getNota_medie());
        catalin.setNota_medie(9.99);
        System.out.println(catalin.getNota_medie());

        // putem afla numarul de absente :
        System.out.println(catalin.nrAbsente());

        //dar putem afla si bugetul institutiei , ceea ce nu ar fi corect pentru single responsability :
        System.out.println(catalin.buget_institutie());

        //printam o lista de studenti
        Students_I[] students_list = {catalin,sandu};
        for (int i=0; i<students_list.length; i++)
        {
            if( students_list[i] instanceof Students_I){
                System.out.println(((Student) students_list[i]).name);
            }
        }
    }
}
