package com.ultrapower.service;

import com.ultrapower.pojo.AmBsProv;
import com.ultrapower.pojo.Nodes;

import java.util.List;

public interface AmBsProvService {
    /**
     * 省级业务树
     * @return
     */
    public List<Nodes> amBsProvTree();
}
