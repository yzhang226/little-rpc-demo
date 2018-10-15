package org.cook.rpc.pool;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * Created by cook on 2018/10/7
 */
@Getter
@Setter
public class SimpleHost {

    /**
     * 主机地址 - IP
     */
    private String hostAddress;

    /**
     *
     */
    private int port;

    public SimpleHost() {
    }

    public SimpleHost(String hostAddress, int port) {
        this.hostAddress = hostAddress;
        this.port = port;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleHost that = (SimpleHost) o;
        return port == that.port &&
                Objects.equals(hostAddress, that.hostAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hostAddress, port);
    }

    public String getHostAddress() {
        return hostAddress;
    }

    public void setHostAddress(String hostAddress) {
        this.hostAddress = hostAddress;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
