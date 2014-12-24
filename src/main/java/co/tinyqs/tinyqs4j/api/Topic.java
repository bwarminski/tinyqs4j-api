package co.tinyqs.tinyqs4j.api;

import java.io.IOException;

public interface Topic
{
    public int publish(ByteMessage message) throws IOException;
    public void subscribe(Channel destination) throws IOException;
    public void unsubscribe(Channel destination) throws IOException;
}
