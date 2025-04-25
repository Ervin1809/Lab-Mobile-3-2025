package com.example.instagram;

import android.net.Uri;

import java.util.ArrayList;
import java.util.HashMap;

public class DataSourcePostingan {
    public static HashMap<String, ArrayList<Postingan>> posts = generateDummyPost();
    public static HashMap<String, UserStats> userStats = generateDummyStats();
    public static HashMap<String,ArrayList<Highlight>> story = generateDummyHighlight();

    private static HashMap<String, ArrayList<Highlight>> generateDummyHighlight() {
        HashMap<String, ArrayList<Highlight>> storyMap = new HashMap<>();

        // User 1: ervinhsn
        ArrayList<Highlight> ervinhsnPosts = new ArrayList<>();
        ervinhsnPosts.add(new Highlight(R.drawable.nanci));
        ervinhsnPosts.add(new Highlight(R.drawable.nanci));
        ervinhsnPosts.add(new Highlight(R.drawable.nanci));
        storyMap.put("ervinhsn", ervinhsnPosts);

        // User 2: fararhmsri
        ArrayList<Highlight> fararhmsriPosts = new ArrayList<>();
        fararhmsriPosts.add(new Highlight(R.drawable.aipun));
        fararhmsriPosts.add(new Highlight(R.drawable.nanci));
        fararhmsriPosts.add(new Highlight(R.drawable.heart));
        storyMap.put("fararhmsri", fararhmsriPosts);

        // User 3: ys_erlangga
        ArrayList<Highlight> ysErlanggaPosts = new ArrayList<>();
        ysErlanggaPosts.add(new Highlight(R.drawable.nanci));
        ysErlanggaPosts.add(new Highlight(R.drawable.nanci));
        ysErlanggaPosts.add(new Highlight(R.drawable.nanci));
        ysErlanggaPosts.add(new Highlight(R.drawable.nanci));
        storyMap.put("ys_erlangga", ysErlanggaPosts);

        // User 4: nancyjwno_
        ArrayList<Highlight> nancyjwnoPosts = new ArrayList<>();
        nancyjwnoPosts.add(new Highlight(R.drawable.nanci));
        storyMap.put("nancyjwno_", nancyjwnoPosts);

        // User 5: muhaipunprtma
        ArrayList<Highlight> muhaipunprtmaPosts = new ArrayList<>();
        muhaipunprtmaPosts.add(new Highlight(R.drawable.nanci));
        storyMap.put("muhaipunprtma", muhaipunprtmaPosts);

        // User 6: andiaisar_
        ArrayList<Highlight> andiaisarPosts = new ArrayList<>();
        andiaisarPosts.add(new Highlight(R.drawable.nanci));
        andiaisarPosts.add(new Highlight(R.drawable.nanci));
        andiaisarPosts.add(new Highlight(R.drawable.nanci));
        storyMap.put("andiaisar_", andiaisarPosts);

        // User 7: chndrajnrdi
        ArrayList<Highlight> chndrajnrdiPosts = new ArrayList<>();
        chndrajnrdiPosts.add(new Highlight(R.drawable.nanci));
        storyMap.put("chndrajnrdi", chndrajnrdiPosts);

        // User 8: khlika_
        ArrayList<Highlight> khlikaPosts = new ArrayList<>();
        khlikaPosts.add(new Highlight(R.drawable.nanci));
        khlikaPosts.add(new Highlight(R.drawable.nanci));
        khlikaPosts.add(new Highlight(R.drawable.nanci));
        khlikaPosts.add(new Highlight(R.drawable.nanci));
        khlikaPosts.add(new Highlight(R.drawable.nanci));
        khlikaPosts.add(new Highlight(R.drawable.nanci));
        khlikaPosts.add(new Highlight(R.drawable.nanci));
        storyMap.put("khlika_", khlikaPosts);

        // User 9: kevinardhana
        ArrayList<Highlight> kevinardhanaPosts = new ArrayList<>();
        kevinardhanaPosts.add(new Highlight(R.drawable.nanci));
        kevinardhanaPosts.add(new Highlight(R.drawable.nanci));
        storyMap.put("kevinardhana", kevinardhanaPosts);

        // User 10: zainab_mchsn
        ArrayList<Highlight> zainabMchsnPosts = new ArrayList<>();
        zainabMchsnPosts.add(new Highlight(R.drawable.nanci));
        storyMap.put("zainab_mchsn", zainabMchsnPosts);

        return storyMap;
    }

    public static ArrayList<Highlight> getHighlightByUsername(String username){
        ArrayList<Highlight> result = new ArrayList<>();
        if (story.containsKey(username)) {
            result = story.get(username); // Ambil highlight berdasarkan username
        }
        return result;
    }

    private static HashMap<String, ArrayList<Postingan>> generateDummyPost() {
        HashMap<String, ArrayList<Postingan>> postsMap = new HashMap<>();

        // User 1: ervinhsn
        ArrayList<Postingan> ervinhsnPosts = new ArrayList<>();
        ervinhsnPosts.add(new Postingan(R.drawable.ervin, R.drawable.heart, 4758, 338, 0, "ervinhsn", "Caption Vibes"));
        ervinhsnPosts.add(new Postingan(R.drawable.ervin, R.drawable.caca, 9940, 787, 0, "ervinhsn", "Cold banget"));
        ervinhsnPosts.add(new Postingan(R.drawable.ervin, R.drawable.fara, 6900, 332, 0, "ervinhsn", "Happy time"));
        postsMap.put("ervinhsn", ervinhsnPosts);

        // User 2: fararhmsri
        ArrayList<Postingan> fararhmsriPosts = new ArrayList<>();
        fararhmsriPosts.add(new Postingan(R.drawable.fara, R.drawable.heart, 3942, 676, 0, "fararhmsri", "Chillin"));
        fararhmsriPosts.add(new Postingan(R.drawable.fara, R.drawable.heart, 8911, 456, 0, "fararhmsri", "Chillin"));
        fararhmsriPosts.add(new Postingan(R.drawable.fara, R.drawable.heart, 1790, 115, 0, "fararhmsri", "Cold banget"));
        postsMap.put("fararhmsri", fararhmsriPosts);

        // User 3: ys_erlangga
        ArrayList<Postingan> ysErlanggaPosts = new ArrayList<>();
        ysErlanggaPosts.add(new Postingan(R.drawable.yusra, R.drawable.heart, 2325, 145, 0, "ys_erlangga", "Morning vibes"));
        ysErlanggaPosts.add(new Postingan(R.drawable.yusra, R.drawable.heart, 3876, 200, 0, "ys_erlangga", "Work hard"));
        ysErlanggaPosts.add(new Postingan(R.drawable.yusra, R.drawable.heart, 5200, 567, 0, "ys_erlangga", "Lunchtime"));
        postsMap.put("ys_erlangga", ysErlanggaPosts);

        // User 4: nancyjwno_
        ArrayList<Postingan> nancyjwnoPosts = new ArrayList<>();
        nancyjwnoPosts.add(new Postingan(R.drawable.nanci, R.drawable.heart, 5000, 555, 0, "nancyjwno_", "Vacation time"));
        nancyjwnoPosts.add(new Postingan(R.drawable.nanci, R.drawable.heart, 7100, 892, 0, "nancyjwno_", "Weekend plans"));
        postsMap.put("nancyjwno_", nancyjwnoPosts);

        // User 5: muhaipunprtma
        ArrayList<Postingan> muhaipunprtmaPosts = new ArrayList<>();
        muhaipunprtmaPosts.add(new Postingan(R.drawable.aipun, R.drawable.heart, 600, 45, 0, "muhaipunprtma", "Sunny days"));
        muhaipunprtmaPosts.add(new Postingan(R.drawable.aipun, R.drawable.heart, 4200, 275, 0, "muhaipunprtma", "Relaxing"));
        postsMap.put("muhaipunprtma", muhaipunprtmaPosts);

        // User 6: andiaisar_
        ArrayList<Postingan> andiaisarPosts = new ArrayList<>();
        andiaisarPosts.add(new Postingan(R.drawable.aisar, R.drawable.heart, 2000, 170, 0, "andiaisar_", "New look"));
        andiaisarPosts.add(new Postingan(R.drawable.aisar, R.drawable.heart, 2750, 180, 0, "andiaisar_", "Love life"));
        postsMap.put("andiaisar_", andiaisarPosts);

        // User 7: chndrajnrdi
        ArrayList<Postingan> chndrajnrdiPosts = new ArrayList<>();
        chndrajnrdiPosts.add(new Postingan(R.drawable.chandra, R.drawable.heart, 800, 120, 0, "chndrajnrdi", "Happy moments"));
        chndrajnrdiPosts.add(new Postingan(R.drawable.chandra, R.drawable.heart, 3500, 230, 0, "chndrajnrdi", "Chill day"));
        postsMap.put("chndrajnrdi", chndrajnrdiPosts);

        // User 8: khlika_
        ArrayList<Postingan> khlikaPosts = new ArrayList<>();
        khlikaPosts.add(new Postingan(R.drawable.caca, R.drawable.heart, 9500, 800, 0, "khlika_", "Beach vibes"));
        khlikaPosts.add(new Postingan(R.drawable.caca, R.drawable.heart, 12000, 1000, 0, "khlika_", "Summer fun"));
        postsMap.put("khlika_", khlikaPosts);

        // User 9: kevinardhana
        ArrayList<Postingan> kevinardhanaPosts = new ArrayList<>();
        kevinardhanaPosts.add(new Postingan(R.drawable.kevin, R.drawable.heart, 3200, 450, 0, "kevinardhana", "Morning grind"));
        kevinardhanaPosts.add(new Postingan(R.drawable.kevin, R.drawable.heart, 4100, 500, 0, "kevinardhana", "Weekend hangout"));
        kevinardhanaPosts.add(new Postingan(R.drawable.kevin, R.drawable.heart, 5500, 600, 0, "kevinardhana", "City vibes"));
        postsMap.put("kevinardhana", kevinardhanaPosts);

        // User 10: zainab_mchsn
        ArrayList<Postingan> zainabMchsnPosts = new ArrayList<>();
        zainabMchsnPosts.add(new Postingan(R.drawable.mbajeb, R.drawable.heart, 2900, 305, 0, "zainab_mchsn", "Adventure time"));
        zainabMchsnPosts.add(new Postingan(R.drawable.mbajeb, R.drawable.heart, 4200, 440, 0, "zainab_mchsn", "Weekend getaway"));
        postsMap.put("zainab_mchsn", zainabMchsnPosts);

        return postsMap;
    }

    public static ArrayList<Postingan> getSatuPostinganPerUser() {
        ArrayList<Postingan> result = new ArrayList<>();
        for (ArrayList<Postingan> postinganUser : posts.values()) {
            if (!postinganUser.isEmpty()) {
                result.add(postinganUser.get(0)); // ambil postingan pertama
            }
        }
        return result;
    }

    public static void postFoto(Uri uri, String capt){
        if (posts.containsKey("ervinhsn")){
            posts.get("ervinhsn").add(0,new Postingan(R.drawable.ervin ,uri, 4200, 440, 0, "ervinhsn", capt));
        }
    }

    public static ArrayList<Postingan> getPostinganByUsername(String username){
        ArrayList<Postingan> result = new ArrayList<>();
        if (posts.containsKey(username)) {
            result = posts.get(username); // Ambil postingan berdasarkan username
        }
        return result;
    }

    private static HashMap<String, UserStats> generateDummyStats() {
        HashMap<String, UserStats> statsMap = new HashMap<>();
        statsMap.put("ervinhsn", new UserStats("Ervink",R.drawable.ervin,5000000, 700, posts.get("ervinhsn").size()));
        statsMap.put("fararhmsri", new UserStats("Fara Rahmasari Fahirun",R.drawable.fara,4200, 520, posts.get("fararhmsri").size()));
        statsMap.put("ys_erlangga", new UserStats("Yusra Erlangga",R.drawable.yusra,3600, 450, posts.get("ys_erlangga").size()));
        statsMap.put("nancyjwno_", new UserStats("Nancy Jiwono",R.drawable.nanci,8000, 600, posts.get("nancyjwno_").size()));
        statsMap.put("muhaipunprtma", new UserStats("Muh. Aipun Pratama",R.drawable.aipun,1200, 340, posts.get("muhaipunprtma").size()));
        statsMap.put("andiaisar_", new UserStats("Andi Aisar",R.drawable.aisar,3900, 430, posts.get("andiaisar_").size()));
        statsMap.put("chndrajnrdi", new UserStats("Chandra Junardi",R.drawable.chandra,2700, 310, posts.get("chndrajnrdi").size()));
        statsMap.put("khlika_", new UserStats("Khalika Tsabitah",R.drawable.caca,9100, 1200, posts.get("khlika_").size()));
        statsMap.put("kevinardhana", new UserStats("Kevin Ardhana",R.drawable.kevin,5000, 480, posts.get("kevinardhana").size()));
        statsMap.put("zainab_mchsn", new UserStats("Zainab Muchsinin",R.drawable.mbajeb,4700, 400, posts.get("zainab_mchsn").size()));

        return statsMap;
    }


    public static UserStats getStatsByUsername(String username) {
        return userStats.get(username);
    }




}
