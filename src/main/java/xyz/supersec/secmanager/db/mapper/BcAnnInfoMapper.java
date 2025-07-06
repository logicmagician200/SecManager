package xyz.supersec.secmanager.db.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import xyz.supersec.secmanager.db.entity.BcAnnInfo;
import xyz.supersec.secmanager.tools.asm.pojo.EbAnnInfo;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author baomidou
 * @since 2025-07-06
 */
@Mapper
public interface BcAnnInfoMapper extends BaseMapper<BcAnnInfo> {
    boolean save(BcAnnInfo entity);

    boolean saveBatch(List<BcAnnInfo> entityList);

    boolean saveEb(List<EbAnnInfo> ebAnnInfos);
}
