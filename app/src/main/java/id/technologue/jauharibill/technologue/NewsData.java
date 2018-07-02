package id.technologue.jauharibill.technologue;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by jauharibill on 7/2/2018.
 */

public class NewsData {


    public static String[][] dataNews = new String[][]{
            {"Setelah Fortnite, Ini Game yang Terancam Gagal Cross-Play Karena Sony", "Ulwan Fakhri Noviadhista", "July 2, 2018", "https://technologue.id/wp-content/uploads/2018/07/Fallout-76-source-YouTube-Bethesda-Softworks-324x160.jpg"},
            {"Facebook Incar Hak Siar Liga Inggris", "Ulwan Fakhri Noviadhista", "July 2, 2018", "https://technologue.id/wp-content/uploads/2018/07/Ilustrasi-Facebook-source-Facebook--324x160.jpg"},
            {"Agustus 2018, Motorola Punya Smartphone Flagship Baru?", "Aqmal Maulana", "July 2, 2018", "https://technologue.id/wp-content/uploads/2018/07/motorola-2018-event-324x160.jpg"},
            {"Grab-Bosowa Kolaborasi, Siap Bahu-membahu di Aspal", "Ulwan Fakhri Noviadhista", "July 1, 2018", "https://technologue.id/wp-content/uploads/2018/07/Ongki-Kurniawan-Executive-Director-Grab-Indonesia-kanan-berbincang-bersama-Subhan-Aksa-CEO-Bosowa-Automotive-Group-di-dep-324x160.jpg"},
            {"Setelah Sedekade, Akhirnya Teknologi Wi-Fi Terima Security Update", "Choiru Rizkia", "July 1, 2018", "https://technologue.id/wp-content/uploads/2018/06/wifi-324x160.jpg"},
            {"Flash Sale Infinix Hot 6 Pro Ditunda Tanggal Segini", "Ulwan Fakhri Noviadhista", "July 1, 2018", "https://technologue.id/wp-content/uploads/2018/07/Peresmian-Infinix-Hot-6-Pro-di-Indonesia-eksklusif-Technologue.id_-324x160.jpg"},
    };

    public static ArrayList<News> getListData(){
        News news = null;

        ArrayList<News> list = new ArrayList<>();
        for (int i=0;i<dataNews.length;i++){
            news = new News();
            news.setTitle(dataNews[i][0]);
            news.setAuthor(dataNews[i][1]);
            news.setDate(dataNews[i][2]);
            news.setPhoto(dataNews[i][3]);

            list.add(news);
        }

        return list;
    }

}
