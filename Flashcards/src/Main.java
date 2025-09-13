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


        /*
         * TODO:
         * Buat Method untuk iterasi melalui semua kartu, pastikan pengguna bisa berhenti di setiap kartu, lalu bisa memilih untuk ke kartu sebelumnya dan setelahnya
         * Pastikan pengguna juga dapat keluar dari mode melihat kartu
         * TODO:
         * Buat interface agar pengguna bisa berinteraksi dengan fungsi melihat kartu, dan juga untuk menambahkan kartu di bagian akhir
         */
    }
}
