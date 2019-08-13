package com.example.demo.mapper;

import com.example.demo.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {

    @Insert("insert into question (title,description,gmt_create,gmt_modified,creator,comment_count,view_count,like_count,tag)" +
            "value (#{title},#{description},#{gmt_create},#{gmt_modified},#{creator},#{comment_count},#{view_count},#{like_count},#{tag})")
    void create(Question question);

    @Select("select count(1) from question")
    Integer count();

    @Select("select * from question limit #{page},#{size}")
    List<Question> PageList(@Param(value = "page") Integer offset, @Param(value = "size") Integer size);

    @Select("select * from question where creator=#{creator} limit #{page},#{size}")
    List<Question> ListByUserId(@Param(value = "creator")Integer creator,@Param(value = "page") Integer offset, @Param(value = "size") Integer size);

    @Select("select count(1) from question where creator=#{userId}")
    Integer countByUserId(@Param(value = "userId") Integer userId);
}
