package com.demo.in.milkdairy.service;

import com.demo.in.milkdairy.generateddomain.service.dto.BillDetails;
import com.demo.in.milkdairy.generateddomain.service.dto.BillList;
import com.demo.in.milkdairy.repository.BillRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MilkDairyService implements IMilkDairyService{

    private BillRepository billRepository;
    public BillList getBillTotal(){
        List<BillDetails> bills = billRepository.findAll();
        BillList billList = new BillList();
        billList.setBills(bills);
        return billList;
    }
}
