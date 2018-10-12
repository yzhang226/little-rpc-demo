package org.cook.rpc;

import org.cook.rpc.sample.model.clock.DayOfWeek;
import org.cook.rpc.sample.model.clock.LocalTime;
import org.cook.rpc.sample.model.clock.LocalTimes;
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

        System.out.println(Base64.getEncoder().encodeToString(baos.toByteArray()) );
        System.out.println("----");

        LocalTimes parsed = LocalTimes.parseFrom(baos.toByteArray());
        System.out.println(parsed.getLocalTime(0));

    }

}
