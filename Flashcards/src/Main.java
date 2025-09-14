import java.util.Scanner;
import linklist.flashcard;

public class Main {

    // Array isi kata
    static String[] daftarKata = {
        "Adjacent", "Alight", "Barren", "Disrupt", "Dynasty", 
        "Foretaste", "Germinate", "Humdrum", "Hurtle", "Insinuate", 
        "Interminable", "Interrogate", "Recompense", "Renovate", "Resume", 
        "Sullen", "Trickle", "Trivial", "Truce", "Vicious"
    };

    // Array isi definisi dari kata
    static String[] daftarDefinisi = {
        "having a common boundary or edge",
        "settle or come to rest",
        "completely wanting or lacking",
        "make a break in",
        "A sequence of powerful leaders in the same family",
        "An early limited awareness of something yet to occur",
        "sprout; produce buds or branches",
        "tediously repetitious or lacking in variety",
        "Move with or as if with a rushing sound",
        "suggest in an indirect or covert way; give to understand",
        "tiresomely long; seemingly without end",
        "pose a series of questions to",
        "make payment to",
        "Restore to a previous or better condition",
        "take up or begin anew",
        "showing a brooding ill humor",
        "run or flow slowly, as in drops or in an unsteady stream",
        "(informal) small and of little importance",
        "a state of peace agreed to between opponents",
        "having the nature of evildoing"
    };
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);

        // Inisialisasi objek flashcard untuk penciptaan list
        flashcard Awal = null, Akhir = null;

        // Inisialisasi kartu-kartu awal
        Awal = flashcard.inisialisasiKartuAwal(daftarKata, daftarDefinisi, Awal, Akhir);

        // TEST, cek jika method tambahkan kartu bekerja
        Awal = flashcard.tambahkanKartuAkhir("Vicious", "having the nature of evildoing", Awal);
        
        // TEST, melihat jika kartu berhasil diinisialisasi di method inisialisasiKartuAwal dan tambahkanKartuAkhir
        if (Awal != null) {
            flashcard Bantu = Awal;
            int i = 1;
            do {
                System.out.println("Kartu " + i + ": " + Bantu.getKata() + " - " + Bantu.getDefinisi());
                Bantu = Bantu.getflashcardSetelah();
                i++;
            } while (Bantu != Awal);
        }

        // TEST, meihat jika fungsi melihat semua kartu fungsional
        flashcard.lihatSemuaKartu(Awal);

        //INTERFACE MENU
        while (true) {
            //==============================
            System.out.println("\n====== Flashcards Menu ======");
            System.out.println("1. Add new card");
            System.out.println("2. see all cards");
            System.out.println("3. Exit");
            System.out.println("=============================");
            System.out.print("Select menu (enter 1/2/3): ");
            String pilihan = input.nextLine();

            switch (pilihan) {
                case "1":
                    //memasukkan isi flashcard
                    System.out.print("Enter word (in English): ");
                    String kata = input.nextLine();
                    System.out.print("Enter the definition: ");
                    String definisi = input.nextLine();
                    Awal = flashcard.tambahkanKartuAkhir(kata, definisi, Awal);
                    System.out.println("Good, ur card added succesfully");
                    break;

                case "2":
                    //melihat semua kartu
                    flashcard.lihatSemuaKartu(Awal);
                    break;

                case "3":
                    //keluar
                    System.out.println("Out from program, see you!!");
                    input.close();
                    return;

                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }

   }
}