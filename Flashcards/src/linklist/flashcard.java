package linklist;

/* 
 *   Class untuk node linkedlist pada program utama
 *   Diciptakan untuk membuat circular doubly linked list
 *   Ada dua field String untuk Kata dan juga Definisi dari kata tersebut
 *   Lalu dua field lagi untuk flashcard setelah dan juga sebelumnya
*/


public class flashcard {
    private String Kata;
    private String Definisi;
    private flashcard flashcardSebelum;
    private flashcard flashcardSetelah;

    public String getKata(){
        return Kata;
    }

    public String getDefinisi(){
        return Definisi;
    }

    public void setKata(String Kata){
        this.Kata = Kata;
    }

    public void setDefinisi(String Definisi){
        this.Definisi = Definisi;
    }

    public flashcard getflashcardSebelum() {
        return flashcardSebelum;
    }

    public flashcard getflashcardSetelah() {
        return flashcardSetelah;
    }

    public void setflashcardSebelum(flashcard flashcardSebelum) {
        this.flashcardSebelum = flashcardSebelum;
    }

    public void setflashcardSetelah(flashcard flashcardSetelah) {
        this.flashcardSetelah = flashcardSetelah;
    }

    public flashcard(String Kata, String Definisi) {
        this.Kata = Kata;
        this.Definisi = Definisi;
        this.flashcardSebelum = null;
        this.flashcardSetelah = null;
    }

    /**
     * Method untuk menginisialisasi kartu-kartu saat awal program bermulai
     * @param Kata Array Mengandung kata
     * @param Definisi Array mengandung definsi untuk kata tersebut
     * @param Awal variabel node awal dari linked list
     * @param Akhir variabel node akhir dari linked list
     */
    public static flashcard inisialisasiKartuAwal(String[] Kata, String[] Definisi, flashcard Awal, flashcard Akhir) {
        // Loop melalui satu array
        for (int i = 0; i < Kata.length; i++) {

            // Buat node Baru menggunakan komponen Array
            flashcard nodeBaru = new flashcard(Kata[i], Definisi[i]);

            // Untuk Node Pertama
            if (Awal == null){
                Awal = nodeBaru;
                Akhir = nodeBaru;
                // Awal menunjuk ke node sendiri
                Awal.setflashcardSetelah(Awal);
                Awal.setflashcardSebelum(Awal);
            } else {
                // Untuk Node selanjutnya
                nodeBaru.setflashcardSebelum(Akhir); // flashcardSebelum Node baru menunjuk ke Akhir lama
                nodeBaru.setflashcardSetelah(Awal);  // flashcardSetelah menunjuk ke Awal
                Akhir.setflashcardSetelah(nodeBaru); // flashcardSetelah Akhir lama menunjuk ke ndde baru
                Awal.setflashcardSebelum(nodeBaru);  // flashcardSebelum Kepada menunjuk ke Akhir baru
                Akhir = nodeBaru;                    // Akhir menjadi node baru   
            }
        }
        return Awal;
    }
}