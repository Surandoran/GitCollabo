package com.cosview.service;

import com.cosview.domain.ReviewDAO;
import com.cosview.dto.ReviewDTO;


public class ReviewService {

    ReviewDAO dao = new ReviewDAO();

    //조회
    public boolean RSelect(ReviewDTO dto) {
        return dao.RSelect(dto);
    }

    //추가
    public boolean RInsert(ReviewDTO dto) {
        return dao.RInsert(dto);
    }

    //수정
    public boolean RUpdate(ReviewDTO dto) {
        return dao.RUpdate(dto);
    }

    //삭제
    public boolean RDelete(ReviewDTO dto) {
        return dao.RDelete(dto);
    }

}
