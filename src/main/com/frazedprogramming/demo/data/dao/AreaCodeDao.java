package com.frazedprogramming.demo.data.dao;

import com.frazedprogramming.demo.data.domain.AreaCode;
import com.frazedprogramming.demo.data.mapper.AreaCodeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;

/**
 * Created by Santosh on 1/20/2017.
 */
@Repository
public class AreaCodeDao {

    private static Logger logger = LoggerFactory.getLogger(AreaCodeDao.class);


    @Autowired
    private JdbcTemplate jdbcTemplate;



    public int save(AreaCode areaCode) {

        try {
            String insertSQL = "INSERT INTO us_states_area_codes(\n" +
                    "\tarea_code, state_code, city_name)\n" +
                    "\tVALUES (?, ?, ?)";

            Object[] params = new Object[]{
                    areaCode.getAreaCode(),
                    areaCode.getState_code(),
                    areaCode.getCity_name()

            };

            int[] types = new int[]{
                    Types.INTEGER,
                    Types.VARCHAR,
                    Types.VARCHAR
            };

            // return number of row / rows processed by the executed query
            logger.debug(insertSQL + " insertSQL.");
            int row = jdbcTemplate.update(insertSQL, params, types);
            logger.debug(row + " row inserted.");

            return row;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    public int update(AreaCode areaCode) {

        try {
            String updateSQL = "UPDATE us_states_area_codes\n" +
                    "\tSET state_code=?, city_name=?\n" +
                    "\tWHERE area_code=?";
            // define query arguments

            Object[] params = new Object[]{
                    areaCode.getState_code(),
                    areaCode.getCity_name(),
                    areaCode.getAreaCode()};
            //  define SQL types of the arguments
            int[] types = new int[]{
                    Types.VARCHAR,
                    Types.VARCHAR,
                    Types.INTEGER,
            };

            int row = jdbcTemplate.update(updateSQL, params, types);

            logger.debug(row + " row(s) updated.");

            return row;

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }

    }

    public int delete(int id) {

        try {
            String deteleSQL = "DELETE FROM us_states_area_codes WHERE area_code=?";
            Object[] params = new Object[]{id};
            int[] types = new int[]{Types.INTEGER};

            int row = jdbcTemplate.update(deteleSQL, params, types);

            logger.debug(row + " row deleted.");

            return row;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    public List findAll() {

        try {
            String SQL = "select * from us_states_area_codes";
            List<AreaCode> retval = jdbcTemplate.query(SQL, new AreaCodeMapper());

            return retval;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }

    }

    public int count() {

        try {
            String SQL = "select count(*) from us_states_area_codes ";
            int retVal = jdbcTemplate.queryForObject(SQL, Integer.class);

            return retVal;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }

    }

    public AreaCode findOne(int areaCode) {
        try {
            String SQL = "select area_code, state_code, city_name from us_states_area_codes WHERE area_code=?";
            Object[] params = new Object[]{areaCode};
            int[] types = new int[]{Types.INTEGER};
            List<AreaCode> retVal = jdbcTemplate.query(SQL, params, types, new AreaCodeMapper());

            if (null == retVal || retVal.isEmpty()) return null;

            return retVal.get(0);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }

    }


}

