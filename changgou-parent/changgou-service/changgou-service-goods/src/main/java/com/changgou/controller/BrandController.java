package com.changgou.controller;

import com.changgou.goos.pojo.Brand;
import com.changgou.service.BrandService;
import com.github.pagehelper.PageInfo;
import com.changgou.entity.Result;
import com.changgou.entity.StatusCode;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @Description: 品牌控制器
 * @Param: brand
 * @Author: zhaozl
 * @Date: 2022/10/20
 * */
@RestController
@RequestMapping(value = "/brand")
@CrossOrigin // 开启跨域
public class BrandController {
    private Logger logger  = org.apache.log4j.Logger.getLogger(BrandController.class);


    @Autowired
    private BrandService brandService;

    /**
     * @Description: 条件分页查询
     * @Param:
     * @return:
     * @Author: zhaozl
     * @Date: 2022/10/20
     * */
    @PostMapping(value = "/search/{page}/{size}")
    public Result<PageInfo<Brand>> findPage(@RequestBody Brand brand,@PathVariable(value = "page") Integer page,@PathVariable(value = "size") Integer size){
        int a = 10/0;
        PageInfo<Brand> brandPageInfo = brandService.findPage(brand,page,size);
        return new Result<>(true, StatusCode.OK, "请求成功", brandPageInfo);
    }


    /**
     * @Description: 分页查询
     * @Param: 
     * @return: 
     * @Author: zhaozl
     * @Date: 2022/10/20
     * */
    @GetMapping(value = "/search/{page}/{size}")
    public Result<PageInfo<Brand>> findPage(@PathVariable(value = "page") Integer page,@PathVariable(value = "size") Integer size){
        PageInfo<Brand> brandPageInfo = brandService.findPage(page,size);
        return new Result<>(true, StatusCode.OK, "请求成功", brandPageInfo);
    }

    
    /**
     * @Description: 多条件查询品牌
     * @Param: brand
     * @return: Result<List<Brand>>
     * @Author: zhaozl
     * @Date: 2022/10/20
     * */
    @PostMapping(value = "/search")
    public Result<List<Brand>> findList(@RequestBody Brand brand){
        List<Brand> brandList = brandService.findList(brand);
        return new Result<>(true, StatusCode.OK, "请求成功", brandList);
    }
    
    
    /**
     * @Description: 查询所有品牌
     * @Param: 
     * @return: Result<List<Brand>>
     * @Author: zhaozl
     * @Date: 2022/10/20
     * */
    @GetMapping
    public Result<List<Brand>> findAll(){
        List<Brand> brandList = brandService.findAll();
        return new Result<>(true, StatusCode.OK, "请求成功", brandList);
    }

    /**
     * @Description: 根据ID查询
     * @Param:  id
     * @return: Result<Brand>
     * @Author: zhaozl
     * @Date: 2022/10/20
     * */
    @GetMapping(value = "/{id}")
    public Result<Brand> findById(@PathVariable(value = "id",required = false) Integer id){
        Brand brand = brandService.findById(id);
        return new Result<>(true, StatusCode.OK, "请求成功", brand);
    }

    
    /**
     * @Description: 添加品牌
     * @Param: brand
     * @return: Result
     * @Author: zhaozl
     * @Date: 2022/10/20
     * */
    @PostMapping
    public Result add(@RequestBody Brand brand){
        brandService.add(brand);
        return new Result(true, StatusCode.OK, "请求成功");
    }
    
    /**
     * @Description: 根据ID修改品牌
     * @Param: brand
     * @return: Result
     * @Author: zhaozl
     * @Date: 2022/10/20
     * */
    @PutMapping(value = "/{id}")
    public Result update(@PathVariable(value = "id") Integer id,@RequestBody Brand brand){
        brand.setId(id);
        brandService.update(brand);
        return new Result(true, StatusCode.OK, "请求成功");
    }
    
    /**
     * @Description: 根据ID删除品牌
     * @Param: id
     * @return: Result
     * @Author: zhaozl
     * @Date: 2022/10/20
     * */
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable(value = "id") Integer id){
        brandService.delete(id);
        return new Result(true, StatusCode.OK, "请求成功");
    }
}
