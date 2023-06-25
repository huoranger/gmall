package com.huoranger.gmall.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huoranger.gmall.model.product.BaseAttrInfo;
import com.huoranger.gmall.model.product.BaseCategory1;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface BaseAttrInfoMapper extends BaseMapper<BaseAttrInfo> {

    /**
     * 根据分类id查询属性数据
     * @param category1Id
     * @param category2Id
     * @param category3Id
     * @return
     */
    List<BaseAttrInfo> selectBaseAttrInfoList(@Param("category1Id") Long category1Id,
                                              @Param("category2Id")Long category2Id,
                                              @Param("category3Id")Long category3Id);

}
