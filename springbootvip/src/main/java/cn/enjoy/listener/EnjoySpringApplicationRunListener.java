package cn.enjoy.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;


public class EnjoySpringApplicationRunListener implements SpringApplicationRunListener {

    //必须有的构造器
    public EnjoySpringApplicationRunListener (SpringApplication application, String[] args){

    }

    @Override
    public void starting() {
        System.out.println("EnjoySpringApplicationRunListener.starting()执行了");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        System.out.println("EnjoySpringApplicationRunListener.environmentPrepared()执行了");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("EnjoySpringApplicationRunListener.contextPrepared()执行了");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("EnjoySpringApplicationRunListener.contextLoaded()执行了");
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        System.out.println("EnjoySpringApplicationRunListener.started()执行了");
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        System.out.println("EnjoySpringApplicationRunListener.running()执行了");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("EnjoySpringApplicationRunListener.failed()执行了");
    }
}
