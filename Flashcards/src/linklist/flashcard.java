package linklist;

import java.util.Scanner;

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
     * @return Awal dari list agar bisa dilakukan iterasi pada list untuk program
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

        // Return Awal untuk melakukan traversal melalui list
        return Awal;
    }

    /**
     * Method untuk menambah kartu kepada akhir linked list
     * @param Kata Kata yang ingin ditambahkan kartu
     * @param Definisi .
     * @param Awal Awal dari linoked list, digunakan untuk menentukkan jika list kosong, dan juga untuk memanipulasi node akhir
     * @return Awal dari list agar bisa dilakukan iterasi pada list untuk program
     */
    public static flashcard tambahkanKartuAkhir(String Kata, String Definisi, flashcard Awal) {
        
        // Ciptakan kartu baru
        flashcard nodeBaru = new flashcard(Kata, Definisi);

        // Jika List Kosong (Tidak mungkin terjadi selagi menjalankan method inisialisasi kartu di awal)
        if (Awal == null) {
            nodeBaru.setflashcardSetelah(nodeBaru);
            nodeBaru.setflashcardSebelum(nodeBaru);
            return nodeBaru;
        }

        // Jika tidak kosong maka ciptkan referensi untuk node akhir
        flashcard Akhir = Awal.getflashcardSebelum();
        
        nodeBaru.setflashcardSetelah(Awal);  // flashcardSetelah node baru adalah Awal List (Circular)
        nodeBaru.setflashcardSebelum(Akhir); // flashcardSebelum node baru adalah Akhir yang lama
        Akhir.setflashcardSetelah(nodeBaru); // flashCardSetelah dari Akhir yang lama menunjuk ke nodeBaru
        Awal.setflashcardSebelum(nodeBaru);  // flashCardSebelum dari Awal menunjuk ke nodeBaru (Circular)

        // Return Awal untuk melakukan traversal melalui list
        return Awal;
    }


    /**
     * Method untuk melihat seluruh kartu pada linked list, pengguna akan memasuki infinite loop dengan tiga opsi, melihat kartu setelah, melihat kartu sebelumnya, dan keluar dari loop
     * @param kartuSaatIni kartu pertama yang akan digunakan sebagai dasar dari loop pengguna
     */
    public static void lihatSemuaKartu(flashcard kartuSaatIni) {
        if (kartuSaatIni == null) {
            System.out.println("Tidak ada kartu untuk ditampilkan.");
            return;
        }

        String pilihan;
        Scanner input = new Scanner(System.in);

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