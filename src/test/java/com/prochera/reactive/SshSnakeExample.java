package com.prochera.reactive;


        import io.termd.core.ssh.netty.NettySshTtyBootstrap;

        import java.util.concurrent.TimeUnit;

public class SshSnakeExample {

    public synchronized static void main(String[] args) throws Exception {
        NettySshTtyBootstrap bootstrap = new NettySshTtyBootstrap().
                setPort(5000).
                setHost("localhost");
        bootstrap.start(new SnakeGame()).get(10, TimeUnit.SECONDS);
        System.out.println("SSH started on localhost:5000");
        SshSnakeExample.class.wait();
    }
}