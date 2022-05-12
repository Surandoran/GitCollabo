package com.cosview.controller;

import com.cosview.dto.DTO;
import com.cosview.service.CustomerService;

public class CustomerController implements SubController{

    CustomerService service = new CustomerService();

    @Override
    public boolean execute(int num, DTO dto) {

        //

        return false;
    }
}
