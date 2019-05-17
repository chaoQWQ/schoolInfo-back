package com.zc.schoolinfo.serviece;

import com.github.pagehelper.Page;
import com.zc.schoolinfo.model.pojo.Message;

import java.util.List;

/**
 * @Description TODO
 * @Author zc
 * @Date 2019/5/8 19:12
 * @Version 1.0
 **/
public interface MessageService {
    int send(Integer toId, String content);

    Page<Message> getMyMessage(Integer pageNum,Integer pageSize,Integer id);
}
