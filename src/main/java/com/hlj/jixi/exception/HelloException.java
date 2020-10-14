package com.hlj.jixi.exception;

/**
 * 简单定义下运行时抛出异常
 * @Date 2020/9/9
 */
public class HelloException extends RuntimeException{
    public HelloException() {
        super("hello不存在");
    }
}
