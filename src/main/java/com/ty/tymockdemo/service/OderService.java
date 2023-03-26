package com.ty.tymockdemo.service;

import java.util.List;

public interface OderService {

    List<String> findByOrderId(String orderId);
}
