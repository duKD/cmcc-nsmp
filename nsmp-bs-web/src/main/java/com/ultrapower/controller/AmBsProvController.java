package com.ultrapower.controller;

import com.ultrapower.pojo.Nodes;
import com.ultrapower.service.AmBsProvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AmBsProvController {
    @Autowired
    AmBsProvService amBsProvService;

    /**
     * 省级业务树
     * @return
     */
    @GetMapping("amBsProvTree")
    public List<Nodes> amBsProvTree(){
        List<Nodes> nodes = amBsProvService.amBsProvTree();
        return nodes;
    }
 }
