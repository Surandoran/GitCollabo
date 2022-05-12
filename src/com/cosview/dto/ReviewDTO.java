package com.cosview.dto;

public class ReviewDTO extends DTO {
    private String name; //제목
    private String id; // 회원아이디
    private String nickname; //회원닉네임
    private String pname; //상품이름
    private String contents; //리뷰내용
    private int score; //점수
    private int time; //시간

    public ReviewDTO(String name, String id, String nickname, String pname, String contents, int score, int time) {
        this.name = name;
        this.id = id;
        this.nickname = nickname;
        this.pname = pname;
        this.contents = contents;
        this.score = score;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "ReviewDTO{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", nickname='" + nickname + '\'' +
                ", pname='" + pname + '\'' +
                ", contents='" + contents + '\'' +
                ", score=" + score +
                ", time=" + time +
                '}';
    }
}
