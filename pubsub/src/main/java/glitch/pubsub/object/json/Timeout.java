package glitch.pubsub.object.json;

import lombok.Data;

import javax.annotation.Nullable;

@Data
public class Timeout {
    private final String moderatorName;
    private final Long moderatorId;
    private final String targetName;
    private final Long targetId;
    private final int duration;
    @Nullable
    private final String reason;
}
