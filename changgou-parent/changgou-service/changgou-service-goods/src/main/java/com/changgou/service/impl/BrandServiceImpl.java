package com.changgou.service.impl;

import com.changgou.dao.BrandMapper;
import com.changgou.goos.pojo.Brand;
import com.changgou.service.BrandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public PageInfo<Brand> findPage(Brand brand, Integer page, Integer size) {
        PageHelper.startPage(page,size);
        Example example = createExample(brand);
        List<Brand> brandList = brandMapper.selectByExample(example);
        return new PageInfo<Brand>(brandList);
    }

    /**
     * @Description: 分页查询
     * @Param: Integer page, Integer size
     * @return: PageInfo<Brand>
     * @Author: zhaozl
     * @Date: 2022/10/20
     * */
    @Override
    public PageInfo<Brand> findPage(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<Brand> brandList = brandMapper.selectAll();
        return new PageInfo<Brand>(brandList);
    }

    /**
     * 查询所有
     * */
    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }
    
    /**
     * @Description: 多条件查询品牌
     * @Param: brand
     * @return: List<Brand>
     * @Author: zhaozl
     * @Date: 2022/10/20
     * */
    @Override
    public List<Brand> findList(Brand brand) {
        Example example = createExample(brand);
        return brandMapper.selectByExample(example);
    }

    /**
     * @Description: 条件构造器
     * @Param: brand
     * @return: Example
     * @Author: zhaozl
     * @Date: 2022/10/20
     * */
    public Example createExample(Brand brand){
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        if (!ObjectUtils.isEmpty(brand)){
            if (!StringUtil.isEmpty(brand.getName())){
                criteria.andLike("name","%"+brand.getName()+"%");
            }
            if (!StringUtil.isEmpty(brand.getLetter())){
                criteria.andEqualTo("letter", brand.getLetter());
            }
        }
        return example;
    }

    /**
     *  根据ID查询
     * */
    @Override
    public Brand findById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    /**
     *  添加品牌
     * */
    @Override
    public int add(Brand brand) {
        return brandMapper.insertSelective(brand);
    }
    
    /**
     * @Description: 根据ID修改品牌
     * @Param: brand
     * @return: 
     * @Author: zhaozl
     * @Date: 2022/10/20
     * */
    @Override
    public int update(Brand brand) {
        return brandMapper.updateByPrimaryKeySelective(brand);
    }

    /**
     * @Description: 根据id删除品牌
     * @Param: id
     * @return:
     * @Author: zhaozl
     * @Date: 2022/10/20
     * */
    @Override
    public int delete(Integer id) {
        return brandMapper.deleteByPrimaryKey(id);
    }
}
