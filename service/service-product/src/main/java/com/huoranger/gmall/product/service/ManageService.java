package com.huoranger.gmall.product.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huoranger.gmall.model.product.*;
import com.huoranger.gmall.product.mapper.BaseCategory3Mapper;

import java.util.List;

public interface ManageService {
    /**
     * 获取所有一级分类
     * @return 一级分类数据
     */
    List<BaseCategory1> getBaseCategory1();

    /**
     * 通过一级分类id获取二级分类
     * @param category1Id 一级分类id
     * @return 二级分类数据
     */
    List<BaseCategory2> getBaseCategory2(Long category1Id);

    /**
     * 通过二级分类id获取三级分类
     * @param category2Id 二级分类id
     * @return 三级分类数据
     */
    List<BaseCategory3> getBaseCategory3(Long category2Id);

    /**
     * 获取分类下的属性
     * @param category1Id 一级分类id
     * @param category2Id 二级分类id
     * @param category3Id 三级分类id
     * @return 属性数据
     */
    List<BaseAttrInfo> getBaseAttrInfoList(Long category1Id, Long category2Id, Long category3Id);

    /**
     * 修改/保存平台属性数据
     * @param baseAttrInfo 属性数据
     */
    void saveAttrInfo(BaseAttrInfo baseAttrInfo);

    /**
     * 根据属性id获取属性值数据
     * @param attrId 属性Id
     * @return 属性值
     */
    List<BaseAttrValue> getBaseAttrValueList(Long attrId);

    /**
     * 根据三级分类id获取SpuInfo集合数据
     * @param spuInfoPage 分页对西那个
     * @param category3Id 三级分类ID
     * @return spu分页数据
     */
    IPage<SpuInfo> getSpuInfoList(Page<SpuInfo> spuInfoPage, String category3Id);
}
