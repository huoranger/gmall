package com.huoranger.gmall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huoranger.gmall.model.product.BaseTrademark;
import com.huoranger.gmall.product.mapper.BaseTrademarkMapper;
import com.huoranger.gmall.product.service.BaseTrademarkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BaseTrademarkServiceImpl extends ServiceImpl<BaseTrademarkMapper, BaseTrademark > implements BaseTrademarkService {

    @Resource
    private BaseTrademarkMapper baseTrademarkMapper;

    @Override
    public IPage<BaseTrademark> getBaseTrademarkList(Page page) {
        return baseTrademarkMapper.selectPage(page, new LambdaQueryWrapper<BaseTrademark>()
                .orderByDesc(BaseTrademark::getId));
    }

}
