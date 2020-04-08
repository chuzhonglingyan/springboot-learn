package com.yuntian.helloworld.service.impl;

import com.yuntian.helloworld.service.CmdService;

/**
 * @author guangleilei.
 * @date Created in 15:32 2019/10/22
 * @description
 */
//Linux下的实现类
public class LinuxListServiceImpl implements CmdService {

    @Override
    public String listCmd() {
        return "ls";
    }
}
