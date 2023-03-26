package com.ty.tymockdemo.service.impl;

import com.ty.tymockdemo.mapper.TyMapper;
import com.ty.tymockdemo.service.OderService;
import com.ty.tymockdemo.service.TyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description :
 * @Author : 田迎
 * @Date : 2023/3/25 23:07
 * @Version : 1.0.0
 **/
@Service
public class TyServiceImpl implements TyService {

    @Autowired
    private OderService oderService ;

    @Autowired
    private TyMapper tyMapper ;

    @Override
    public List<String> find() {

        List<String> oderId = oderService.findByOrderId("oderId");
        System.out.println(oderId);

        return tyMapper.find();
    }

    @Override
    public void save(String rpaTaskId) {
        List<String> oderId = oderService.findByOrderId(rpaTaskId);
        System.out.println(oderId);
        tyMapper.save(oderId);
    }
}
