package glitch.kraken.`object`.json

import glitch.api.objects.json.interfaces.IDObject
import java.awt.Color
import java.util.*

/**
 *
 * @author Damian Staszewski [damian@stachuofficial.tv]
 * @version %I%, %G%
 * @since 1.0
 */
data class Cheermote(
        val prefix: String,
        val tiers: List<Tier>
) {

    /**
     *
     * @author Damian Staszewski [damian@stachuofficial.tv]
     * @version %I%, %G%
     * @since 1.0
     */
    data class Tier(
            override val id: Long,
            val color: Color,
            val images: Map<Background, Map<Type, Map<Size, String>>>
    ) : IDObject<Long> {
        fun getImage(background: Background, type: Type, size: Size) =
                images.getValue(background).getValue(type).getValue(size)
    }

    /**
     *
     * @author Damian Staszewski [damian@stachuofficial.tv]
     * @version %I%, %G%
     * @since 1.0
     */
    enum class Background {
        LIGHT,
        DARK
    }

    /**
     *
     * @author Damian Staszewski [damian@stachuofficial.tv]
     * @version %I%, %G%
     * @since 1.0
     */
    enum class Type {
        STATIC,
        ANIMATED
    }

    /**
     *
     * @author Damian Staszewski [damian@stachuofficial.tv]
     * @version %I%, %G%
     * @since 1.0
     */
    enum class Size private constructor(private val value: Double) {
        X1(1.0),
        X15(1.5),
        X2(2.0),
        X3(3.0),
        X4(4.0);


        companion object {
            fun of(size: Double): Size {
                return Arrays.stream(values()).filter { s -> s.value == size }
                        .findFirst().orElseThrow { NullPointerException("Cannot obtain requested size: $size") }
            }
        }
    }
}
