package xyz.supersec.secmanager.db.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import xyz.supersec.secmanager.db.entity.BcFieldInfo;
import xyz.supersec.secmanager.tools.asm.pojo.EbFieldInfo;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author baomidou
 * @since 2025-07-06
 */
@Mapper
public interface BcFieldInfoMapper extends BaseMapper<BcFieldInfo> {
    boolean save(BcFieldInfo entity);

    boolean saveBatch(List<BcFieldInfo> entityList);

    boolean saveEb(List<EbFieldInfo> ebFieldInfos);

    List<BcFieldInfo> getPrintLogField(int p_id);
}
