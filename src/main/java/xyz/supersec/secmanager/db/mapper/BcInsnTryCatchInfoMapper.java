package xyz.supersec.secmanager.db.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import xyz.supersec.secmanager.db.entity.BcInsnTryCatchInfo;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author baomidou
 * @since 2025-07-06
 */
@Mapper
public interface BcInsnTryCatchInfoMapper extends BaseMapper<BcInsnTryCatchInfo> {
    boolean save(BcInsnTryCatchInfo entity);

    boolean saveBatch(List<BcInsnTryCatchInfo> entityList);
}
