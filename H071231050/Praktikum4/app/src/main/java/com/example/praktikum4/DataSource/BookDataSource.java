package com.example.praktikum4.DataSource;

import com.example.praktikum4.Model.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookDataSource {
    public static ArrayList<Book> bookList = generateDummyComics();
    public static ArrayList<String> genre = generateGenre();

    public static ArrayList<Book> generateDummyComics() {
        ArrayList<Book> comics = new ArrayList<>();

        // Komik 1
        comics.add(new Book(
                "Solo Leveling",
                "Chugong",
                "Dalam dunia di mana hunters—manusia yang memiliki kemampuan magis—harus bertarung dengan monster untuk melindungi umat manusia, Sung Jin-Woo adalah hunter terlemah, dikenal sebagai 'Rank-E Hunter'. Suatu hari, setelah hampir mati dalam dungeon, dia terbangun dengan sistem misterius yang memungkinkannya untuk 'naik level' dan menjadi semakin kuat.",
                "2016",
                "https://i.pinimg.com/736x/5b/6d/ee/5b6dee0124a9ccb6e890357521648104.jpg",
                true,
                new ArrayList<>(Arrays.asList("Action", "Adventure", "Fantasy", "Supernatural"))
        ));

        // Komik 2
        comics.add(new Book(
                "God Of High School",
                "Yongje Park",
                "Turnamen bela diri terbesar dimulai! Pemenangnya akan mendapatkan apapun yang mereka inginkan. Jin Mo-Ri diundang untuk bergabung dalam pertempuran. Jin tidak terlalu peduli dengan turnamen ini dan hanya ingin bertarung dengan lawan yang kuat. Namun, ia segera mengetahui bahwa ada agenda tersembunyi di balik turnamen ini.",
                "2011",
                "https://i.pinimg.com/736x/06/d0/f3/06d0f336be3e947914a7219c7e70b353.jpg",
                false,
                new ArrayList<>(Arrays.asList("Action", "Adventure", "Comedy", "Supernatural", "Martial Arts"))
        ));

        // Komik 3
        comics.add(new Book(
                "The Beginning After The End",
                "TurtleMe",
                "King Grey memiliki kekuatan, kekayaan, dan prestise yang tak tertandingi di dunia yang diatur oleh kemampuan bela diri. Namun, kesendirian tetap mengikutinya di puncak kekuatannya. Di bawah eksterior yang megah dari pria yang kuat itu terdapat jiwa yang kosong tanpa tujuan. Dia terlahir kembali sebagai Arthur Leywin, dan dia bertekad untuk menghindari kesalahan masa lalunya.",
                "2016",
                "https://i.pinimg.com/736x/d7/f9/01/d7f9015ba86eb7cbd2d5b5ef5edf689f.jpg",
                false,
                new ArrayList<>(Arrays.asList("Action", "Adventure", "Fantasy", "Reincarnation"))
        ));

        // Komik 4
        comics.add(new Book(
                "Lookism",
                "Park Tae-joon",
                "Park Hyung Suk, seorang siswa SMA yang gendut dan sering dibully, secara misterius memiliki dua tubuh yang berbeda yang dapat dia ganti dengan tidur. Tubuh barunya sangat tampan, tinggi, dan kuat, sedangkan tubuh aslinya tetap sama. Menggunakan tubuh barunya di sekolah, dia menjadi populer, sementara tubuh aslinya digunakan di rumah.",
                "2014",
                "https://i.pinimg.com/736x/1c/bb/87/1cbb8773d9152724c750651ec79c10e0.jpg",
                false,
                new ArrayList<>(Arrays.asList("Drama", "Psychological", "School Life", "Comedy"))
        ));

        // Komik 5
        comics.add(new Book(
                "Magic Emperor",
                "Zhuo Yihang",
                "Zhuo Fan, seorang yang terkenal sebagai Emperor of Magic, ditusuk dari belakang oleh muridnya sendiri dan terlahir kembali menjadi seorang pembantu dari keluarga Cripple. Dengan niat untuk membalaskan dendamnya, dia memulai perjalanan untuk merebut kembali tahtanya sebagai penyihir terkuat di dunia.",
                "2017",
                "https://i.pinimg.com/736x/5d/17/9a/5d179abd550295dbb12b709b6b4545a7.jpg",
                true,
                new ArrayList<>(Arrays.asList("Action", "Adventure", "Fantasy", "Martial Arts", "Reincarnation"))
        ));

        // Komik 6
        comics.add(new Book(
                "The Boxer",
                "JH",
                "Sebuah cerita tentang seorang petinju bernama Yu yang memiliki bakat alami yang luar biasa. Cerita ini mengikuti perjalanannya ke puncak dunia tinju, sementara juga mengeksplorasi tema kemanusiaan, kekosongan, dan arti kemenangan.",
                "2019",
                "https://i.pinimg.com/736x/99/fe/d7/99fed78df1543abe791e32ba21d7ac96.jpg",
                false,
                new ArrayList<>(Arrays.asList("Action", "Drama", "Psychological", "Sports"))
        ));

        // Komik 7
        comics.add(new Book(
                "Nano Machine",
                "Han Joong-wol",
                "Setelah dibully dan dianiaya oleh keluarganya sendiri, Cheon Yeo-Woon, seorang yatim piatu dari keluarga prajurit menerima kunjungan dari keturunannya dari masa depan yang menanamkan Nano Machine ke dalam tubuhnya. Kekuatan barunya membuatnya menjadi prajurit terkuat, membalikkan nasibnya dan memimpin takdir klannya.",
                "2020",
                "https://i.pinimg.com/736x/92/02/dd/9202ddc2549ff92d01d96e6f3f7b6437.jpg",
                false,
                new ArrayList<>(Arrays.asList("Action", "Adventure", "Fantasy", "Martial Arts"))
        ));

        // Komik 8
        comics.add(new Book(
                "Return of the Mount Hua Sect",
                "Biga",
                "Chung Myung, seorang praktisi terbaik dari Sekte Mount Hua, adalah satu-satunya yang selamat dari pembantaian oleh sekte musuh. Sebelum kematiannya, dia bersumpah akan kembali dan memulihkan sektenya ke masa kejayaannya. Seratus tahun kemudian, dia terlahir kembali sebagai anak yatim piatu dan mencari Sekte Mount Hua yang sekarang telah menjadi yang terlemah di antara semua sekte.",
                "2020",
                "https://i.pinimg.com/736x/64/ab/1a/64ab1adb2530a6d64a13ad0610d0b14d.jpg",
                false,
                new ArrayList<>(Arrays.asList("Action", "Adventure", "Comedy", "Martial Arts", "Reincarnation"))
        ));

        // Komik 9
        comics.add(new Book(
                "Legend of the Northern Blade",
                "Woo-gak",
                "Ketika dunia jatuh ke dalam kekacauan, sekelompok prajurit elit yang dikenal sebagai Northern Heavenly Sect muncul untuk melindungi dunia. Namun, pewaris sekte, Jin Mu-Won, menyaksikan ayahnya menutup sekte dan bunuh diri setelah difitnah. Bertahun-tahun kemudian, Jin Mu-Won yang telah dewasa memutuskan untuk mengambil jalan seni bela diri dan membalaskan dendam ayahnya.",
                "2019",
                "https://i.pinimg.com/736x/02/d8/c0/02d8c0f3fe28a18ba00015ad6eb9a14c.jpg",
                true,
                new ArrayList<>(Arrays.asList("Action", "Adventure", "Martial Arts"))
        ));

        // Komik 10
        comics.add(new Book(
                "The Greatest Estate Developer",
                "Moon Sung-ho",
                "Kim Suho, seorang pengembang real estate yang sukses, tiba-tiba dikirim ke dunia novel fantasi. Dengan pengetahuannya tentang pengembangan real estate, dia memutuskan untuk mengubah tanah yang ia warisi menjadi kerajaan yang luar biasa.",
                "2020",
                "https://i.pinimg.com/736x/22/1b/c3/221bc3a65e81a91db3c0a68616119bea.jpg",
                false,
                new ArrayList<>(Arrays.asList("Comedy", "Fantasy", "Isekai", "Slice of Life"))
        ));

        // Komik 11
        comics.add(new Book(
                "How to Fight",
                "Park Tae-joon",
                "Hobin Yoo selalu menjadi korban bully. Suatu hari, dia menemukan channel YouTube yang mengajarkan teknik bertarung nyata. Dengan tekad untuk berubah, dia mulai merekam pertarungannya sendiri dan mengunggahnya ke internet, menjadi sensasi YouTube yang tidak terduga.",
                "2019",
                "https://i.pinimg.com/736x/3b/94/ab/3b94abe50c8ff15daa11d98a313efcea.jpg",
                true,
                new ArrayList<>(Arrays.asList("Action", "Comedy", "Drama", "Martial Arts"))
        ));

        // Komik 12
        comics.add(new Book(
                "The Return of the Disaster-Class Hero",
                "Samuelharu",
                "Setelah mengabdikan hidupnya untuk umat manusia dan 12 pahlawan lainnya, protagonist dibunuh oleh mereka yang ia anggap teman. Namun, diberikan kesempatan kedua, dia kembali dari kematian dengan tekad untuk membalas dendam terhadap semua yang telah mengkhianatinya.",
                "2021",
                "https://i.pinimg.com/736x/a5/a8/56/a5a856d4d285085e02806e9831c24f27.jpg",
                false,
                new ArrayList<>(Arrays.asList("Action", "Adventure", "Fantasy", "Revenge"))
        ));

        // Komik 13
        comics.add(new Book(
                "Swordmaster's Youngest Son",
                "Sesangnahollo",
                "Jin Runcandel, putra bungsu dari keluarga Runcandel yang terhormat, dibuang dan dibunuh karena dianggap tidak memiliki bakat. Namun, takdir memberinya kesempatan kedua untuk hidup kembali dan membalaskan dendamnya terhadap keluarganya sendiri.",
                "2021",
                "https://i.pinimg.com/736x/ff/54/1a/ff541ae930a12e315f229ffe12698a89.jpg",
                false,
                new ArrayList<>(Arrays.asList("Action", "Adventure", "Fantasy", "Reincarnation"))
        ));

        // Komik 14
        comics.add(new Book(
                "Leveling with God",
                "D-Dart",
                "Dikhianati dan dibunuh oleh guild-nya sendiri, Kim YuJin dibangkitkan dan diberikan kesempatan untuk kembali ke masa lalu. Dengan pengetahuan tentang masa depan, dia bertekad untuk menjadi lebih kuat dan mengubah takdirnya, bahkan jika itu berarti melawan para dewa.",
                "2021",
                "https://i.pinimg.com/736x/c2/02/01/c202016db8306d09c8818ccf717a722c.jpg",
                false,
                new ArrayList<>(Arrays.asList("Action", "Adventure", "Fantasy", "Regression"))
        ));

        // Komik 15
        comics.add(new Book(
                "Infinite Mage",
                "REDICE STUDIO",
                "Shirone, seorang penyihir muda yang hidup di dunia di mana kekuatan sihir ditentukan oleh jumlah inti sihir yang dimiliki seseorang. Dengan hanya satu inti sihir, dia dianggap tidak berbakat. Namun, dia menemukan bahwa inti sihirnya memiliki kapasitas tak terbatas, memungkinkan dia untuk menyerap dan mempelajari sihir tanpa batas.",
                "2022",
                "https://i.pinimg.com/736x/d6/d5/a1/d6d5a134e77649d64a4dca06c032bf87.jpg",
                false,
                new ArrayList<>(Arrays.asList("Action", "Adventure", "Fantasy"))
        ));

        // Komik 16
        comics.add(new Book(
                "Shark",
                "Kim Woo-seop",
                "Cha Woo-sol, seorang siswa SMA yang menjadi korban perundungan brutal, menemukan harapan baru setelah bertemu dengan Ju Do-hyeon, seorang juara MMA. Dengan bimbingannya, Woo-sol berlatih keras untuk mengatasi traumanya dan mengejar impian menjadi petarung profesional.",
                "2020",
                "https://i.pinimg.com/736x/9c/3e/d9/9c3ed979f7f3170abeac4abe9e09aeed.jpg",
                true,
                new ArrayList<>(Arrays.asList("Action", "Martial Arts", "Drama", "School Life", "Psychological"))
        ));


        // Komik 17
        comics.add(new Book(
                "Pick Me Up",
                "Hanza Art",
                "Park Dan-A tiba-tiba dikirim ke dunia webtoon dan harus mencari tahu cara untuk kembali ke dunia nyata. Di dunia webtoon ini, dia bisa melihat status dan statistik karakter, dan suatu hari dia menyadari ada karakter dengan statistik yang sangat tinggi tetapi terjebak dalam peran karakter latar belakang.",
                "2020",
                "https://i.pinimg.com/736x/d0/03/7e/d0037e19a80805c6e098363b9d99329a.jpg",
                false,
                new ArrayList<>(Arrays.asList("Comedy", "Fantasy", "Romance", "Isekai"))
        ));

        // Komik 18
        comics.add(new Book(
                "The 100th Regression of the Max-Level Player",
                "Jung Dasom",
                "Setelah menjadi pemain level maksimum dan mengalahkan raja iblis 99 kali, pahlawan kita mengalami regresi untuk ke-100 kalinya. Dengan pengetahuan dan pengalaman dari 99 kehidupan sebelumnya, dia berencana untuk menyelesaikan dunia game ini sekali dan untuk selamanya.",
                "2022",
                "https://i.pinimg.com/736x/b4/1f/64/b41f6485d9f92a5ea581fa736a71d590.jpg",
                false,
                new ArrayList<>(Arrays.asList("Action", "Adventure", "Fantasy", "Regression"))
        ));

        // Komik 19
        comics.add(new Book(
                "Revenge of the Iron-Blooded Sword Hound",
                "Cheon Garam",
                "Setelah menjalani kehidupan yang penuh kesengsaraan sebagai anjing pedang untuk keluarga bangsawan, Ian dikhianati dan dibunuh oleh tuannya sendiri. Diberikan kesempatan untuk kembali ke masa lalu oleh iblis, dia bersumpah untuk membalas dendam terhadap semua yang telah memanfaatkannya.",
                "2022",
                "https://i.pinimg.com/736x/6a/f2/fd/6af2fd8ea2d87b528254bc94762dde84.jpg",
                false,
                new ArrayList<>(Arrays.asList("Action", "Adventure", "Fantasy", "Martial Arts", "Revenge"))
        ));

        // Komik 20
        comics.add(new Book(
                "The Extra's Academy Survival Guide",
                "Hayden",
                "Setelah bereinkarnasi sebagai karakter tambahan dalam novel aksi-fantasi, Noah menyadari bahwa dia ditakdirkan untuk mati sebagai korban dalam pembantaian akademi yang akan datang. Bertekad untuk mengubah nasibnya, dia mencari cara untuk bertahan hidup di dunia yang kejam ini.",
                "2021",
                "https://i.pinimg.com/736x/ef/a2/da/efa2daa85c91a103a650db7616f30241.jpg",
                true,
                new ArrayList<>(Arrays.asList("Action", "Adventure", "Fantasy", "School Life", "Reincarnation"))
        ));

        return comics;
    }

    public static ArrayList<Book> getBookList() {
        return bookList;
    }

    public static ArrayList<String> generateGenre() {
        Set<String> genreSet = new HashSet<>();
        ArrayList<Book> books = getBookList();
        genreSet.add("All");
        for (Book book : books) {
            genreSet.addAll(book.getGenres());
        }
        return new ArrayList<>(genreSet);
    }


    public static ArrayList<String> getGenre() {
        return genre;
    }

    public static ArrayList<Book> getBookFavorite() {
        ArrayList<Book> bookFavorite = new ArrayList<>();
        ArrayList<Book> books = getBookList();
        for (Book book : books) {
            if (book.isStatusLike()) {
                bookFavorite.add(book);
            }
        }
        return bookFavorite;
    }

    public static Book getBookByTitle(String title) {
        for (Book book : bookList) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    public static ArrayList<Book> filterByGenre(String genre, String type) {
        ArrayList<Book> filtered = new ArrayList<>();
        if(type.equals("home")){
            if (genre.equals("All")) {
                return getBookList();
            } else {
                for (Book book : getBookList()) {
                    if (book.getGenres().contains(genre)) {
                        filtered.add(book);
                    }
                }
            }
        }else{
            if (genre.equals("All")) {
                return getBookFavorite();
            } else {
                for (Book book : getBookFavorite()) {
                    if (book.getGenres().contains(genre)) {
                        filtered.add(book);
                    }
                }
            }
        }
        return filtered;
    }

    public static ArrayList<Book> filterByTitle(String keyword, String type, String genre) {
        ArrayList<Book> filtered = new ArrayList<>();
        if (type.equals("home")) {
            for (Book book : filterByGenre(genre, type)) {
                if (book.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                    filtered.add(book);
                }
            }
            return filtered;
        } else if (type.equals("favorite")) {
            for (Book book : filterByGenre(genre, type)) {
                if (book.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                    filtered.add(book);
                }
            }
            return filtered;
        }
        return filtered;
    }

    public static void addBook(Book book) {
        bookList.add(0,book);
    }
}

