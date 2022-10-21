package com.changgou.service;

import com.changgou.goos.pojo.Brand;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BrandService {

    PageInfo<Brand> findPage(Brand brand,Integer page,Integer size);

    PageInfo<Brand> findPage(Integer page,Integer size);

    List<Brand> findAll();

    List<Brand> findList(Brand brand);

    Brand findById(Integer id);

    int add(Brand brand);

    int update(Brand brand);

    int delete(Integer id);
}
