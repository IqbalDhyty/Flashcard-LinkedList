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

        lihatSemuaKartu(Awal);

        System.out.println("Terima kasih telah menggunakan program flashcard!");


   }
    public static void lihatSemuaKartu(flashcard kartuSaatIni) {
        if (kartuSaatIni == null) {
            System.out.println("Tidak ada kartu untuk ditampilkan.");
            return;
        }

        Scanner input = new Scanner(System.in);
        String pilihan;

        while (true) {
            // Mengdisplay kartu saat ini
            System.out.println("\n==============================");
            System.out.println("Kata: " + kartuSaatIni.getKata());
            System.out.println("Definisi: " + kartuSaatIni.getDefinisi());
            System.out.println("==============================");

            // Opsi kepada user
            System.out.print("Pilihan: (N)ext, (P)revious, (K)eluar -> ");
            pilihan = input.nextLine().toUpperCase();

            if (pilihan.equals("N")) {
                kartuSaatIni = kartuSaatIni.getflashcardSetelah(); // kartu selanjuutnya
            } else if (pilihan.equals("P")) {
                kartuSaatIni = kartuSaatIni.getflashcardSebelum(); // kartu sebelumnya
            } else if (pilihan.equals("K")) {
                System.out.println("Kembali ke menu utama...");
                break; //keluar 
            } else {
                System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        }
    }
}