package org.cook.rpc.grpc.hello;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;

import java.util.concurrent.TimeUnit;

public class GrpcTestBlockingClient {

    private static final Logger log = LoggerFactory.getLogger(GrpcTestBlockingClient.class);

    private final ManagedChannel channel;
    private final GreeterGrpc.GreeterBlockingStub blockingStub;

    /** Construct client connecting to HelloWorld server at {@code host:port}. */
    public GrpcTestBlockingClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext(true)
                .build());
    }

    /** Construct client for accessing RouteGuide server using the existing channel. */
    GrpcTestBlockingClient(ManagedChannel channel) {
        this.channel = channel;
        blockingStub = GreeterGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    /** Say hello to server. */
    public void greet(String name) {
        log.info("Will try to greet " + name + " ...");
        HelloRequest request = HelloRequest.newBuilder().setName(name).build();
        HelloReply response;
        try {
            response = blockingStub.sayHello(request);
        } catch (StatusRuntimeException e) {
            log.info("{} RPC failed:{}", Level.WARN,e.getStatus());
            return;
        }
        log.info("Greeting: " + response.getMessage());
    }

    public static void main(String[] args) {
        GrpcTestBlockingClient blockingClient = new GrpcTestBlockingClient("127.0.0.1", 50051);
        blockingClient.greet("test1333");
    }

}
