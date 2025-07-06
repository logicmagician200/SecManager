package xyz.supersec.secmanager.db.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import xyz.supersec.secmanager.db.entity.BcInsnLookupSwitchInsn;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author baomidou
 * @since 2025-07-06
 */
@Mapper
public interface BcInsnLookupSwitchInsnMapper extends BaseMapper<BcInsnLookupSwitchInsn> {
    boolean save(BcInsnLookupSwitchInsn entity);

    boolean saveBatch(List<BcInsnLookupSwitchInsn> entityList);
}
