package co.tinyqs.tinyqs4j.api;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public interface Channel
{
    public void send(ByteMessage message) throws IOException;
    public ByteMessage receive() throws IOException;
    public ByteMessage receive(int timeoutSec) throws IOException, TimeoutException;
    public <T> Message<T> receive(Class<? extends T> msgClass) throws IOException;
    public <T> Message<T> receive(Class<? extends T> msgClass, int timeoutSec) throws IOException, TimeoutException;
    public void release(ByteMessage message) throws IOException;
    public void acknowledge(ByteMessage message) throws IOException;
}
