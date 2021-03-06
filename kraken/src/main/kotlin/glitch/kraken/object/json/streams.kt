package glitch.kraken.`object`.json

import com.google.gson.annotations.SerializedName
import glitch.api.objects.json.interfaces.Creation
import glitch.api.objects.json.interfaces.IDObject
import java.time.Instant

/**
 *
 * @author Damian Staszewski [damian@stachuofficial.tv]
 * @version %I%, %G%
 * @since 1.0
 */
data class FeatureStream(
        val image: String,
        val priority: Int,
        val isScheduled: Boolean,
        val isSponsored: Boolean,
        val stream: Stream,
        val text: String,
        val title: String
)

data class Stream(
        override val id: Long,
        val game: String,
        val viewers: Int,
        val videoHeight: Int,
        val averageFps: Int,
        val delay: Int,
        override val createdAt: Instant,
        @SerializedName("is_playlist")
        val isPlaylist: Boolean,
        val preview: Image,
        val channel: Channel
) : IDObject<Long>, Creation

data class StreamSummary(
        val channels: Int,
        val viewers: Int
)