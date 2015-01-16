package co.tinyqs.tinyqs4j.api;

public abstract class TypedMessageBuilder<T> extends MessageBuilder<Message<T>> 
{
    protected T payload = null;
    
    public final TypedMessageBuilder<T> payload(T payload) {this.payload = payload; return this;}

    @Override
    public abstract Message<T> build();

}
