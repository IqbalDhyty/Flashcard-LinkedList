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

    /**
     * Method untuk menginisialisasi kartu-kartu saat awal program bermulai
     * @param Kata Array Mengandung kata
     * @param Definisi Array mengandung definsi untuk kata tersebut
     * @param Awal 
     */
    public void inisialisasiKartuAwal(String[] Kata, String[] Definisi, flashcard Awal, flashcard Akhir) {

    }
}
