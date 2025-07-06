package xyz.supersec.secmanager.db.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import xyz.supersec.secmanager.db.entity.BcFieldInfo;
import xyz.supersec.secmanager.db.entity.BcInsnFieldInsn;
import xyz.supersec.secmanager.db.entity.BcMethodInfo;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author baomidou
 * @since 2025-07-06
 */
@Mapper
public interface BcInsnFieldInsnMapper extends BaseMapper<BcInsnFieldInsn> {
    boolean save(BcInsnFieldInsn entity);

    boolean saveBatch(List<BcInsnFieldInsn> entityList);

    List<BcInsnFieldInsn> getLogPoint(BcMethodInfo bcMethodInfo, List<BcFieldInfo> bcInsnFieldInsns);
}
