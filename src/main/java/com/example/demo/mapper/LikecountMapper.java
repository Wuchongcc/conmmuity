package com.example.demo.mapper;

import com.example.demo.model.Likecount;
import com.example.demo.model.LikecountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface LikecountMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table likecount
     *
     * @mbg.generated Thu Sep 05 21:37:49 CST 2019
     */
    long countByExample(LikecountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table likecount
     *
     * @mbg.generated Thu Sep 05 21:37:49 CST 2019
     */
    int deleteByExample(LikecountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table likecount
     *
     * @mbg.generated Thu Sep 05 21:37:49 CST 2019
     */
    int insert(Likecount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table likecount
     *
     * @mbg.generated Thu Sep 05 21:37:49 CST 2019
     */
    int insertSelective(Likecount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table likecount
     *
     * @mbg.generated Thu Sep 05 21:37:49 CST 2019
     */
    List<Likecount> selectByExampleWithRowbounds(LikecountExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table likecount
     *
     * @mbg.generated Thu Sep 05 21:37:49 CST 2019
     */
    List<Likecount> selectByExample(LikecountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table likecount
     *
     * @mbg.generated Thu Sep 05 21:37:49 CST 2019
     */
    int updateByExampleSelective(@Param("record") Likecount record, @Param("example") LikecountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table likecount
     *
     * @mbg.generated Thu Sep 05 21:37:49 CST 2019
     */
    int updateByExample(@Param("record") Likecount record, @Param("example") LikecountExample example);
}