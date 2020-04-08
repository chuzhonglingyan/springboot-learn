package com.yuntian.helloworld.service.impl;

import com.yuntian.helloworld.service.CmdService;

/**
 * @author guangleilei.
 * @date Created in 15:31 2019/10/22
 * @descriptionWindows下的实现类
 */
public class WindowsListServiceImpl implements CmdService {

    @Override
    public String listCmd() {
        return "dir";
    }
}

