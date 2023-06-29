package com.huoranger.gmall.product.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.huoranger.gmall.model.product.BaseTrademark;

public interface BaseTrademarkService extends IService<BaseTrademark> {

    /**
     * 分页获取品牌数据
     * @return 品牌列表数据
     */
    IPage<BaseTrademark> getBaseTrademarkList(Page page);

}
