package glitch.chat.events;

import glitch.socket.utils.EventImmutable;
import javax.annotation.Nullable;
import org.immutables.value.Value;

@EventImmutable
@Value.Immutable
public interface BanEvent extends ClearChatEvent, UserEvent {
    @Nullable
    String getReason();
}