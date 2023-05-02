package com.atguigu.servicecms.mapper;

import com.atguigu.servicecms.entity.CrmBanner;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 首页banner表 Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2023-04-25
 */
public interface CrmBannerMapper extends BaseMapper<CrmBanner> {
  CrmBanner crm();
}
