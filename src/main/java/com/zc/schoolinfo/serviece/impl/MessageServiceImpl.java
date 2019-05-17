package com.zc.schoolinfo.serviece.impl;

import com.github.pagehelper.Page;
import com.zc.schoolinfo.dao.MessageMapper;
import com.zc.schoolinfo.model.pojo.Message;
import com.zc.schoolinfo.serviece.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description TODO
 * @Author zc
 * @Date 2019/5/8 19:12
 * @Version 1.0
 **/
@Service
public class MessageServiceImpl implements MessageService {

    @Resource
    private MessageMapper messageMapper;

    @Override
    public Page<Message> getMyMessage(Integer pageNum, Integer pageSize, Integer id) {
        return messageMapper.findByToUser(pageNum,pageSize,id);
    }

    @Override
    public int send(Integer toId, String content) {
        Message message = new Message();
        message.setTitle("审核结果通知");
        message.setContent(content);
        message.setToUser(toId);
        return messageMapper.insertSelective(message);
    }
}
