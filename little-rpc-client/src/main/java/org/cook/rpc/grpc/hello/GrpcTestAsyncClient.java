package org.cook.rpc.grpc.hello;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class GrpcTestAsyncClient {
    private static final Logger log = LoggerFactory.getLogger(GrpcTestAsyncClient.class);
    private final ManagedChannel channel;
    private final GreeterGrpc.GreeterStub stub;

    final CountDownLatch latch = new CountDownLatch(1);

    public GrpcTestAsyncClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext(true).build());
    }

    /**
     * Construct client for accessing RouteGuide server using the existing channel.
     */
    GrpcTestAsyncClient(ManagedChannel channel) {
        this.channel = channel;
        stub = GreeterGrpc.newStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public void greet(String name) {
        log.info("Will try to greet {} ...",name);
        HelloRequest request = HelloRequest.newBuilder().setName(name).build();
        StreamObserver<HelloReply> stream = new StreamObserver<HelloReply>() {

            @Override
            public void onNext(HelloReply value) {
                log.info("Greeting:{}", value.getMessage());
                latch.countDown();
            }

            @Override
            public void onError(Throwable t) {
                log.info("error:{}",t.getMessage());
            }

            @Override
            public void onCompleted() {
                log.info("Completed!");
                try {
                    shutdown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        };

        try {
            stub.sayHello(request, stream);
        } catch (StatusRuntimeException e) {
            log.info("{} RPC failed:{}", Level.WARN, e.getStatus());
            return;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        GrpcTestAsyncClient client = new GrpcTestAsyncClient("127.0.0.1", 50051);
        client.greet("test1333444");
        Thread.sleep(60 * 1000);
    }
}