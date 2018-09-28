package org.cook.rpc.grpc.hello;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class GrpcTestServer implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(GrpcTestServer.class);

    private int port = 50051;

    private Server server;

    @Override
    public void run() {

        try {
            startServer();
        } catch (InterruptedException e) {
            logger.error("", e);
        } catch (IOException e) {
            logger.error("", e);
        }


    }

    private void startServer() throws InterruptedException, IOException {
        final GrpcTestServer server = new GrpcTestServer();
        server.start1();
        server.blockUntilShutdown();
    }

    private void start1() throws IOException {
        server = ServerBuilder.forPort(port).addService(new GreeterImpl()).build().start();
        logger.info("Server started, listening on {}", port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                logger.error("shutting down gRPC Server");

                GrpcTestServer.this.stop();

                logger.error("gRPC Server shut down");
            }
        });
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new GrpcTestServer()).start();

        Thread.sleep(60 * 60 * 10000);
    }

}
