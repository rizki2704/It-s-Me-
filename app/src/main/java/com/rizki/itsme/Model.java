package com.rizki.itsme;

public class Model {
    // 1 Juni 2021, 10118025 Rizki Restu Illahi IF-1
private String[] subjects;
private int[] subjects2;
private String[] namaT;
private int[] fotoT;
private String[] musik;
private String[] judulVideo;
private String[] video;

    public String[] getMusik() {
        return musik;
    }

    public void setMusik(String[] musik) {
        this.musik = musik;
    }

    public String[] getJudulVideo() {
        return judulVideo;
    }

    public void setJudulVideo(String[] judulVideo) {
        this.judulVideo = judulVideo;
    }

    public String[] getVideo() {
        return video;
    }

    public void setVideo(String[] video) {
        this.video = video;
    }

    public int[] getFotoGallery() {
        return fotoGallery;
    }

    public void setFotoGallery(int[] fotoGallery) {
        this.fotoGallery = fotoGallery;
    }

    private int[] fotoGallery;

    public String[] getNamaT() {
        return namaT;
    }

    public void setNamaT(String[] namaT) {
        this.namaT = namaT;
    }

    public int[] getFotoT() {
        return fotoT;
    }

    public void setFotoT(int[] fotoT) {
        this.fotoT = fotoT;
    }

    public String[] getSubjects() {
        return subjects;
    }

    public void setSubjects(String[] subjects) {
        this.subjects = subjects;
    }

    public int[] getSubjects2() {
        return subjects2;
    }

    public void setSubjects2(int[] subjects2) {
        this.subjects2 = subjects2;
    }
}
