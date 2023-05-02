package com.atguigu.servicecms.service;

import com.atguigu.servicecms.entity.CrmBanner;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 首页banner表 服务类
 * </p>
 *
 * @author testjava
 * @since 2023-04-25
 */
public interface CrmBannerService extends IService<CrmBanner> {
        CrmBanner select();
}
