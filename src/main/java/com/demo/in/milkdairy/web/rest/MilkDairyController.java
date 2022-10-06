package com.demo.in.milkdairy.web.rest;

import com.demo.in.milkdairy.generateddomain.service.dto.Bill;
import com.demo.in.milkdairy.generateddomain.service.dto.BillList;
import com.demo.in.milkdairy.service.MilkDairyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MilkDairyController implements MilkDailyApi{

    private MilkDairyService milkDairyService;

    /**
     * GET /bill/total : Total Bill
     * This endponit will used for getting all customers bill.
     *
     * @return OK (status code 200)
     */
    public ResponseEntity<BillList> getBillTotal() {

        BillList billList = milkDairyService.getBillTotal();
        return new ResponseEntity<>(billList, HttpStatus.OK);

    }


    /**
     * GET /bill/{userId} : Get User Bill
     * This endpoint is used for getting the bill for specific user.
     *
     * @param userId  (required)
     * @return OK (status code 200)
     */
    public ResponseEntity<Bill> getBillUserId(String userId) {

        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }
}
