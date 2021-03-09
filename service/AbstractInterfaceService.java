/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * Apr 19, 2019
 */
public interface AbstractInterfaceService<T, ID extends Serializable> {
    
    public Optional<T> get(ID id);

    public List<T> getByIds(List<Long> ids);

    public List<T> getAll();

    public Optional<T> save(T t);

    public List<T> save(List<T> objects);

    public Optional<T> delete(ID id);

}
