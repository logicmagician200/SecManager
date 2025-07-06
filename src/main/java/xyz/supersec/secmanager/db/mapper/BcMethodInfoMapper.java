package xyz.supersec.secmanager.db.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import xyz.supersec.secmanager.db.entity.BcMethodInfo;
import xyz.supersec.secmanager.tools.asm.pojo.EbMethodInfo;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author baomidou
 * @since 2025-07-06
 */
@Mapper
public interface BcMethodInfoMapper extends BaseMapper<BcMethodInfo> {
    boolean save(BcMethodInfo entity);

    boolean saveBatch(List<BcMethodInfo> entityList);

    boolean saveEb(List<EbMethodInfo> ebList);

    List<BcMethodInfo> getClassMethods(String classUUID);
}
