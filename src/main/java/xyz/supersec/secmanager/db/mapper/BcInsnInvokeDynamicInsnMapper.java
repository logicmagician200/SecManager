package xyz.supersec.secmanager.db.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import xyz.supersec.secmanager.db.entity.BcInsnInvokeDynamicInsn;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author baomidou
 * @since 2025-07-06
 */
@Mapper
public interface BcInsnInvokeDynamicInsnMapper extends BaseMapper<BcInsnInvokeDynamicInsn> {
    boolean save(BcInsnInvokeDynamicInsn entity);

    boolean saveBatch(List<BcInsnInvokeDynamicInsn> entityList);
}
