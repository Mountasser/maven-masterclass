package com.mylab.wul.service;

import java.util.List;

import com.mylab.wul.dto.BaseRequest;
import com.mylab.wul.dto.BaseResponse;
import com.mylab.wul.exception.BaseNotFoundException;

/**
* <h1>BaseService</h1>
* BaseService interface definition 
* <p>
* <b>BaseService</b> definition of methods of interface
* for sevice layer
*
* @author  Cristian Romero Matesanz
*
* 
*/
public interface BaseService {

    /**
     * delete a base of pizza from repository
     * @param base base to delete
     * @throws BaseNotFoundException
     */
    void deleteBase(final BaseRequest base) throws BaseNotFoundException;

    /**
     * list all base of pizza from repository
     * @return
     */
    List<BaseResponse> findAllBases();

    /**
     * save a base of pizza from repository
     * @param base base to save
     */
    void saveBase(final BaseRequest base);

}
