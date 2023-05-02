package com.atguigu.servicecms.service.impl;

import com.atguigu.servicecms.entity.CrmBanner;
import com.atguigu.servicecms.mapper.CrmBannerMapper;
import com.atguigu.servicecms.service.CrmBannerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 首页banner表 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2023-04-25
 */
@Service
public class CrmBannerServiceImpl extends ServiceImpl<CrmBannerMapper, CrmBanner> implements CrmBannerService {

    @Override
    public CrmBanner select() {
        CrmBanner crm = baseMapper.crm();
        return crm;
    }
}
