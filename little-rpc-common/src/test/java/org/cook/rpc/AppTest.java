package org.cook.rpc;

import com.google.protobuf.*;
import org.cook.rpc.helix.model.protobuf.PBHeartbeatModel;
import org.cook.rpc.helix.model.protobuf.PBInputParameter;
import org.cook.rpc.helix.utils.MessageParserFactory;
import org.cook.rpc.sample.model.clock.DayOfWeek;
import org.cook.rpc.sample.model.clock.LocalTime;
import org.cook.rpc.sample.model.clock.LocalTimes;
import org.cook.rpc.sample.ping.SimplePingService;
import org.junit.Test;
import sun.misc.HexDumpEncoder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() throws IOException {
        LocalTimes lts = LocalTimes.newBuilder()
                .addLocalTime(LocalTime.newBuilder()
                        .setYear(2018)
                        .setMonth(11)
                        .setDayOfMonth(12)
                        .setHour(12)
                        .setMinute(12)
                        .setSecond(12)
                        .setDayOfWeek(DayOfWeek.FRIDAY)
                        .build())
                .build();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        lts.writeTo(baos);

        HexDumpEncoder encoder = new HexDumpEncoder();
        System.out.println(encoder.encode(baos.toByteArray()));

        System.out.println(Base64.getEncoder().encodeToString(baos.toByteArray()));
        System.out.println("----");

        LocalTimes parsed = LocalTimes.parseFrom(baos.toByteArray());
        System.out.println(parsed.getLocalTime(0));

    }

    @Test
    public void test2() throws Exception {
        PBInputParameter req = PBInputParameter.newBuilder()
                .addParameters(0, Any.pack(Int32Value.of(32)))
                .addParameters(1, Any.pack(Int32Value.of(33)))
                .build()
                ;

//        Message msg = null;

        System.out.println("is " + Any.pack(Int32Value.of(32)).getDescriptorForType().getName());

        System.out.println(Int32Value.of(32).getAllFields().keySet().iterator().next().getType());


        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        req.writeTo(baos);

        HexDumpEncoder encoder = new HexDumpEncoder();
        System.out.println(encoder.encode(baos.toByteArray()));

        System.out.println(Base64.getEncoder().encodeToString(baos.toByteArray()));
        System.out.println("----");

        PBInputParameter parsed = PBInputParameter.parseFrom(baos.toByteArray());
        System.out.println(Int32Value.parseFrom(parsed.getParameters(0).getValue()).getValue());
        System.out.println(Int32Value.parseFrom(parsed.getParameters(1).getValue()).getValue());

        MessageParserFactory.registerMessageParserByClass(PBInputParameter.class);
        Parser pa = MessageParserFactory.getParser(PBInputParameter.class);

        PBInputParameter parameter = (PBInputParameter) pa.parseFrom(baos.toByteArray());
        System.out.println(Int32Value.parseFrom(parameter.getParameters(0).getValue()).getValue());
        System.out.println(Int32Value.parseFrom(parameter.getParameters(1).getValue()).getValue());

    }

    @Test
    public void test3() {


    }

}
