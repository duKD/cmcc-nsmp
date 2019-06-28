package com.ultrapower.service;

import com.ultrapower.dao.AmBsProvMapper;
import com.ultrapower.pojo.AmBsProv;
import com.ultrapower.pojo.AmProvDTO;
import com.ultrapower.pojo.Nodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AmBsProvServiceImpl implements AmBsProvService {
    @Autowired
    AmBsProvMapper amBsProvMapper;
    /**
     * 省级业务树
     * @return
     */
    public List<Nodes> amBsProvTree() {
        List<Nodes> list=new ArrayList<Nodes>();
        List<AmProvDTO> amProvDTOS = amBsProvMapper.provTree();
        for(int i=0;i<amProvDTOS.size();i++){
            //一级树
            Nodes one = new Nodes();
            one.setpId(0+"");
            one.setId((i+1)+"");
            AmProvDTO amProvDTO = amProvDTOS.get(i);
            one.setName(amProvDTO.getName());
            one.setPkid(amProvDTO.getId());
            list.add(one);
            for(int j = 0; j<amProvDTO.getAmProvDTOS().size(); j++){
                //二级树
                Nodes two=new Nodes();
                two.setpId((i+1)+"");
                two.setId(((j+1)*100)+"");
                AmProvDTO amProvDTO1 = amProvDTO.getAmProvDTOS().get(j);
                two.setName(amProvDTO1.getName());
                two.setPkid(amProvDTO1.getId());
                list.add(two);
            }
        }
        return list;
    }
}
