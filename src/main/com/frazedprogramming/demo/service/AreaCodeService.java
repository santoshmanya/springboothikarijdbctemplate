package com.frazedprogramming.demo.service;

import com.frazedprogramming.demo.data.dao.AreaCodeDao;
import com.frazedprogramming.demo.data.domain.AreaCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Santosh on 1/20/2017.
 */
@Service
public class AreaCodeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AreaCodeService.class);

    @Autowired
    AreaCodeDao areaCodeDao;

    public boolean save(AreaCode areaCode) {

        int retVal = areaCodeDao.save(areaCode);
        if (retVal != 0) return true;
        return false;

    }

    public boolean update(AreaCode areaCode) {

        int retVal = areaCodeDao.update(areaCode);
        if (retVal != 0) return true;
        return false;
    }

    public boolean delete(int id) {
        int retVal = areaCodeDao.delete(id);
        if (retVal != 0) return true;
        return false;
    }

    public List findAll() {

        List retVal = areaCodeDao.findAll();
        if (null == retVal || retVal.isEmpty()) return null;
        return retVal;

    }

    public AreaCode findOne(int areaCode) {

        AreaCode areacode = areaCodeDao.findOne(areaCode);

        if (null == areacode) return null;
        return areacode;
    }

}
