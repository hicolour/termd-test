package com.prochera.reactive;



        import io.termd.core.ssh.netty.NettySshTtyBootstrap;

        import java.awt.*;
        import java.util.concurrent.TimeUnit;

public class SshScreencaster{

    public synchronized static void main(String[] args) throws Exception {

        NettySshTtyBootstrap bootstrap = new NettySshTtyBootstrap().
                setPort(5000).
                setHost("localhost");

        Robot robot = new Robot();

        bootstrap.start(conn -> new Screencaster(robot, conn).handle()).get(10, TimeUnit.SECONDS);

        System.out.println("SSH started on localhost:5000");

        SshScreencaster.class.wait();
    }
}