package com.ty.tymockdemo.service.impl;

import com.ty.tymockdemo.mapper.TyMapper;
import com.ty.tymockdemo.service.OderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description :
 * @Author : 田迎
 * @Date : 2023/3/26 14:12
 * @Version : 1.0.0
 **/
@Service
public class OderServiceImpl implements OderService {

    @Autowired
    private TyMapper tyMapper;

    @Override
    public List<String> findByOrderId(String orderId) {
        return tyMapper.find();
    }
}
