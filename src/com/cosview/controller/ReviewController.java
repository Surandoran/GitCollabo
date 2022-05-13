package com.cosview.controller;

import com.cosview.dto.DTO;
import com.cosview.dto.ReviewDTO;

import com.cosview.service.ReviewService;


public class ReviewController implements SubController {

    ReviewService service = new ReviewService();

    @Override
    public boolean execute(int num, DTO dto) {
        //downcasting
        ReviewDTO rdto = (ReviewDTO) dto;

        //1: 조회,2: 삽입,3: 수정,4: 삭제 5:점수 평균
        if (num == 1) {
            return service.RInqury(rdto);
        } else if (num == 2) {
            return service.RInsert(rdto);
        } else if (num == 3) {
            return service.RUpdate(rdto);
        } else if (num == 4) {
            return service.RDelete(rdto);
        } else if (num == 5) {
            return service.Ravg(rdto);
        }
        return false;
    }

	
}
