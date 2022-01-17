package com.budget.mapper;

import com.budget.entitys.CustomScheme;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Harlan.Liu
 * @version 1.0
 * @date 2021/9/25 13:30
 */
@Mapper
public interface CustomSchemeMapper {

    List<CustomScheme> getAllCustomScheme();
}
