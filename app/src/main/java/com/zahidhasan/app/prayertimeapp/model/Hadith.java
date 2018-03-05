package com.zahidhasan.app.prayertimeapp.model;

/**
 * Created by DarkzGothic on 8/28/2017.
 */

public class Hadith {
    private int id;
    private String title;
    private String inBangla;
    private String inEnglish;
    private String inArabic;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInBangla() {
        return inBangla;
    }

    public void setInBangla(String inBangla) {
        this.inBangla = inBangla;
    }

    public String getInEnglish() {
        return inEnglish;
    }

    public void setInEnglish(String inEnglish) {
        this.inEnglish = inEnglish;
    }

    public String getInArabic() {
        return inArabic;
    }

    public void setInArabic(String inArabic) {
        this.inArabic = inArabic;
    }

    public Hadith(int id, String title, String inBangla, String inEnglish, String inArabic) {

        this.id = id;
        this.title = title;
        this.inBangla = inBangla;
        this.inEnglish = inEnglish;
        this.inArabic = inArabic;
    }

    public Hadith() {

    }
}
