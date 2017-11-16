import java.util.Scanner;

public class Main {

    static String[] agendaDeNume = new String[3];
    static int pozitie = 0;

    public static void afisareMeniu() {
        System.out.println("1> Afisare");
        System.out.println("2> Adaugare");
        System.out.println("3> Cautare");
        System.out.println("4> Stergere");
        System.out.println("0> Exit");

    }

    public static String citireNume(String label) {
        System.out.print(label);
        Scanner scan = new Scanner(System.in);
        String vapor = scan.nextLine();
        return vapor;
    }

    public static String citirePersoana(String label) {
        System.out.print(label);
        Scanner scan = new Scanner(System.in);
        String vapor = scan.nextLine();
        return vapor;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        int optiune = -1;
        do {
            afisareMeniu();
            Scanner sc = new Scanner(System.in);
            optiune = sc.nextInt();
            switch (optiune) {
                case 1: {
                    afisareAgenda();
                    break;
                }

                case 2: {
                    adaugareAgenda();
                    break;
                }

                case 3: {
                    cautarenume();


                }



                case 4: {
                    stergere();
                }
            }
        }
        while (optiune != 0);
    }


    public static void afisareAgenda() {
        for (int i = 0; i < agendaDeNume.length; i++) {
            if (agendaDeNume[i] != null) {
                System.out.println(agendaDeNume[i]);
            }

        }
    }

    public static void adaugareAgenda() {
        if (pozitie < agendaDeNume.length) {
            String nume = citireNume("Da-ti numele de adaugat:");
            agendaDeNume[pozitie] = nume;
            pozitie++;
        } else {
            // totusi hai sa cautam in goluri , ugly code !!!!
            for (int i = 0; i < agendaDeNume.length; i++) {
                if (agendaDeNume[i] == null) {
                    String nume = citireNume("Da-ti numele de adaugat:");
                    agendaDeNume[i] = nume;
                    break;
                }
            }


            System.out.println("agenda plina, ia alta mai mare");
        }

        System.out.println();
    }


    public static int cautare(String nume) { //se opreste la primul gasit
        int found = -1;
        for (int i = 0; i < agendaDeNume.length; i++) {
            if (nume.equalsIgnoreCase(agendaDeNume[i])) {
                agendaDeNume[i] = null;
                System.out.println("am ras-o pe:" + nume);
                found = i;
                break;
            }
        }
        return found;
    }

    public static void stergere() {
        String nume = citireNume("Da-ti numele de sters:");
        int indexCautat = -1;
        indexCautat = cautare(nume);
        if(indexCautat!=-1)
            agendaDeNume[indexCautat]=null;
    }

    public static void cautarenume() {
        if (pozitie < agendaDeNume.length) {
            String nume = citirePersoana("Introduce-ti numele persoanei care o cautati:");
            agendaDeNume[pozitie] = nume;

            pozitie++;


            System.out.println("Persoana cautata este trecuta in agenda pe pozitia:  " + pozitie);
        }else{
            System.out.println("Persoana cautata nu este trecuta in agenda");}
    }
}