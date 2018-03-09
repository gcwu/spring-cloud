package com.common.base.exception;

/**
 * 调用的Zk服务不可用时抛出此异常
 */
public class ZookeeperServiceException extends Exception {

    public ZookeeperServiceException() {
    }

    public ZookeeperServiceException(String message) {
        super(message);
    }
}
