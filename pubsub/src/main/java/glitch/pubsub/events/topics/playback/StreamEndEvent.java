package glitch.pubsub.events.topics.playback;

import glitch.pubsub.GlitchPubSub;
import glitch.socket.events.Event;
import glitch.socket.utils.EventImmutable;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

@EventImmutable
@Value.Immutable
@Gson.TypeAdapters(fieldNamingStrategy = true)
public interface StreamEndEvent extends Event<GlitchPubSub> {
}