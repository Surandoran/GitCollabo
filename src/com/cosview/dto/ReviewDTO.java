package com.cosview.dto;

public class ReviewDTO extends DTO{
        private String name;
        private String member_nickname;
        private String product_name ;
        private String contents ;
        private int score;
        private String insert_time;
		public ReviewDTO(String name, String member_nickname, String product_name, String contents, int score,
				String insert_time) {
			super();
			this.name = name;
			this.member_nickname = member_nickname;
			this.product_name = product_name;
			this.contents = contents;
			this.score = score;
			this.insert_time = insert_time;
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
		public String getProduct_name() {
			return product_name;
		}
		public void setProduct_name(String product_name) {
			this.product_name = product_name;
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
		public String getInsert_time() {
			return insert_time;
		}
		public void setInsert_time(String insert_time) {
			this.insert_time = insert_time;
		}
		@Override
		public String toString() {
			return "ReviewDTO [name=" + name + ", member_nickname=" + member_nickname + ", product_name=" + product_name
					+ ", contents=" + contents + ", score=" + score + ", insert_time=" + insert_time + "]";
		}

		
        
   
}
