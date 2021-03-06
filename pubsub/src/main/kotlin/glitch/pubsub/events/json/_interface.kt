package glitch.pubsub.events.json

import com.google.gson.annotations.SerializedName
import glitch.api.objects.enums.SubscriptionType
import glitch.pubsub.`object`.enums.MessageType
import glitch.pubsub.`object`.enums.SubscriptionContext
import java.time.Instant

/**
 *
 * @author Damian Staszewski [damian@stachuofficial.tv]
 * @version %I%, %G%
 * @since 1.0
 */
interface Subscription {
    @get:SerializedName("user_name")
    val username: String
    val displayName: String
    val channelName: String
    val userId: Long
    val channelId: Long
    val time: Instant
    @get:SerializedName("sub_plan")
    val subscriptionType: SubscriptionType
    @get:SerializedName("sub_plan_name")
    val subscriptionName: String?
    val months: Int
    val context: SubscriptionContext
    @get:SerializedName("sub_message")
    val message: OrdinalMessage?
}

interface IModerator {
    val moderatorName: String
    val moderatorId: Long
}

interface ITarget {
    val targetName: String
    val targetId: Long
}

interface DataType {
    val type: MessageType
}