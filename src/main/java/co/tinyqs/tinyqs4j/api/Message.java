package co.tinyqs.tinyqs4j.api;

public interface Message<T> extends ByteMessage
{
    public T getPayload();
}
