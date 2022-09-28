package com.example.service;

import com.example.dao.HostReplyDao;
import com.example.domain.HostReply;

/**
 * @彭新宇出品
 * @please respect copyringht
 */
public class HostReplyService {
    private HostReplyDao hostReplyDao = null;

    //根据一个回复的id获取他的主人回复
    public HostReply getHostReplyById (Integer replyId) throws Exception {
        return hostReplyDao.getHostReplyByReplyId(replyId);
    }

    //根据id删除hostReply
    public void deleteReply(Integer id) throws Exception {
        hostReplyDao.deleteHostReply(id);
    }
}
