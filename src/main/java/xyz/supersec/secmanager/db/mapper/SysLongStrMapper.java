package xyz.supersec.secmanager.db.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import xyz.supersec.secmanager.db.entity.SysLongStr;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author baomidou
 * @since 2025-07-06
 */
@Mapper
public interface SysLongStrMapper extends BaseMapper<SysLongStr> {
    int getMaxId();
    boolean save(SysLongStr entity);
    boolean saveBatch(List<SysLongStr> entityList);
}
