package xyz.supersec.secmanager.db.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import xyz.supersec.secmanager.db.entity.BcAnnContent;
import xyz.supersec.secmanager.tools.asm.pojo.EbAnnContentInfo;

/**
 * <p>
 * 注解的内容 Mapper 接口
 * </p>
 *
 * @author baomidou
 * @since 2025-07-06
 */
@Mapper
public interface BcAnnContentMapper extends BaseMapper<BcAnnContent> {
    boolean save(BcAnnContent entity);

    boolean saveBatch(List<BcAnnContent> entityList);

    boolean saveEb(List<EbAnnContentInfo> ebAnnContentInfos);
}
