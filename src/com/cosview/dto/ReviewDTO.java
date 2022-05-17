package com.cosview.dto;

public class ReviewDTO extends DTO {
    private String name; //제목
    private String member_nickname;
    private String member_id; // 회원아이디
    private String product_name;
    private String rcontents; //리뷰내용
    private String score; //점수
    private String insert_time; //시간

    public ReviewDTO(String name, String member_nickname, String member_id, String product_name, String rcontents, String score, String insert_time) {
        this.name = name;
        this.member_nickname = member_nickname;
        this.member_id = member_id;
        this.product_name = product_name;
        this.rcontents = rcontents;
        this.score = score;
        this.insert_time = insert_time;
    }

    public ReviewDTO(String name, String member_nickname, String product_name, String rcontents, String score) {
        this.name = name;
        this.member_nickname = member_nickname;
        this.product_name = product_name;
        this.rcontents = rcontents;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMember_nickname() {
        return member_nickname;
    }

    public void setMember_nickname(String member_nickname) {
        this.member_nickname = member_nickname;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getRcontents() {
        return rcontents;
    }

    public void setRcontents(String rcontents) {
        this.rcontents = rcontents;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getInsert_time() {
        return insert_time;
    }

    public void setInsert_time(String insert_time) {
        this.insert_time = insert_time;
    }

    @Override
    public String toString() {
        return "ReviewDTO{" +
                "name='" + name + '\'' +
                ", member_nickname='" + member_nickname + '\'' +
                ", member_id='" + member_id + '\'' +
                ", product_name='" + product_name + '\'' +
                ", rcontents='" + rcontents + '\'' +
                ", score='" + score + '\'' +
                ", insert_time='" + insert_time + '\'' +
                '}';
    }
}
