package xyz.supersec.secmanager.db.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import xyz.supersec.secmanager.db.entity.BcInsnTableSwitchInsn;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author baomidou
 * @since 2025-07-06
 */
@Mapper
public interface BcInsnTableSwitchInsnMapper extends BaseMapper<BcInsnTableSwitchInsn> {
    boolean save(BcInsnTableSwitchInsn entity);

    boolean saveBatch(List<BcInsnTableSwitchInsn> entityList);
}
