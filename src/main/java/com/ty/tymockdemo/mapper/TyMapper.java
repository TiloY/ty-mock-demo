package com.ty.tymockdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TyMapper {

    @Select("select * from test.test")
    List<String> find();

    void save(List<String> oderId);
}
