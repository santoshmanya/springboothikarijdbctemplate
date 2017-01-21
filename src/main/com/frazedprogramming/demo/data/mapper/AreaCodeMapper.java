package com.frazedprogramming.demo.data.mapper;

import com.frazedprogramming.demo.data.SQLConstants;
import com.frazedprogramming.demo.data.domain.AreaCode;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Santosh on 1/20/2017.
 */
public final class AreaCodeMapper implements RowMapper<AreaCode> {


    @Override
    public AreaCode mapRow(ResultSet resultSet, int i) throws SQLException {
        AreaCode returnObj = new AreaCode();
        returnObj.setAreaCode(resultSet.getInt(SQLConstants.AREA_CODE));
        returnObj.setState_code(resultSet.getString("state_code"));
        returnObj.setCity_name(resultSet.getString("city_name"));
        return returnObj;
    }
}