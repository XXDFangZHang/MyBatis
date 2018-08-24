package com.cjh.dao;

import com.cjh.pojo.Country;

import java.io.Serializable;

public interface CountryMapper {

    Country selectProvincial(Serializable id);

}
