package me.ddevil.shiroi.design

import java.awt.Color
import java.util.regex.Pattern

sealed class MinecraftColor(
        /**
         * The char code this color is represented by
         */
        val code: Char,
        /**
         * The RGB java awt color for this minecraft color
         */
        val color: Color,
        /**
         * @return The color's alternative color, for example, [.LightPurple] alternative color is [.DarkPurple]
         */
        val alternativeCode: MinecraftColor
) {
    init {
        BY_CHAR[code] = this
    }


    override fun toString() = "$COLOR_CHAR$code"

    companion object {
        val SUBSTITUTE_COLOR_CHAR = '&'
        val COLOR_CHAR = '§'
        private val STRIP_COLOR_PATTERN = Pattern.compile("[$SUBSTITUTE_COLOR_CHAR$COLOR_CHAR][0-9a-fA-FR]")
        private val STRIP_FORMAT_PATTERN = Pattern.compile("[$SUBSTITUTE_COLOR_CHAR$COLOR_CHAR][k-oK-OrR]")
        @JvmStatic
        private val BY_CHAR = HashMap<Char, MinecraftColor>()


        fun getByChar(code: Char) = BY_CHAR[code] ?: throw IllegalArgumentException("Unknown code '$code'!")

        fun stripAll(input: String) = stripColor(stripFormat(input))

        fun stripColor(input: String) = STRIP_COLOR_PATTERN.matcher(input).replaceAll("")!!

        @JvmOverloads
        fun getColors(input: String, altColorChar: Char = '&'): List<MinecraftColor> {
            val list = ArrayList<MinecraftColor>()
            val b = input.toCharArray()
            for (i in 0..b.size - 1 - 1) {
                val next = b[i + 1]
                if (b[i] == altColorChar && "0123456789AaBbCcDdEeFfKkLlMmNnOoRr".indexOf(next) > -1) {
                    list += MinecraftColor.getByChar(next)
                }
            }
            return list
        }

        fun stripFormat(input: String) = STRIP_FORMAT_PATTERN.matcher(input).replaceAll("")!!

        /**
         * Translates a string using an alternate design code character into a
         * string that uses the internal MinecraftColor.COLOR_CODE design code
         * character. The alternate design code character will only be replaced if
         * it is immediately followed by 0-9, A-F, a-f, K-O, k-o, R or r.
         * @param altColorChar    The alternate design code character to replace. Ex: &amp;
         * *
         * @param textToTranslate Text containing the alternate design code character.
         * *
         * @return Text containing the MinecraftColor.COLOR_CODE design code character.
         */
        @JvmOverloads
        fun translateAlternateColorCodes(textToTranslate: String, altColorChar: Char = '&'): String {
            val b = textToTranslate.toCharArray()
            for (i in 0..b.size - 1 - 1) {
                if (b[i] == altColorChar && "0123456789AaBbCcDdEeFfKkLlMmNnOoRr".indexOf(b[i + 1]) > -1) {
                    b[i] = MinecraftColor.COLOR_CHAR
                    b[i + 1] = Character.toLowerCase(b[i + 1])
                }
            }
            return String(b)
        }

        /**
         * Gets the ChatColors used at the end of the given input string.
         * @param input Input string to retrieve the colors from.
         * *
         * @return Any remaining ChatColors to pass onto the next line.
         */
        fun getLastColors(input: String): String {
            var result = ""
            val length = input.length

            // Search backwards from the end as it is faster
            for (index in length - 1 downTo -1 + 1) {
                val section = input[index]
                if (section == COLOR_CHAR && index < length - 1) {
                    val c = input[index + 1]
                    val color = getByChar(c)
                    result = color.toString() + result
                }
            }
            return result
        }
    }

    object Black : MinecraftColor('0', Color(0, 0, 0), White)
    object DarkBlue : MinecraftColor('1', Color(0, 0, 128), Blue)
    object DarkGreen : MinecraftColor('2', Color(0, 128, 0), Green)
    object DarkAqua : MinecraftColor('3', Color(0, 128, 128), Aqua)
    object DarkRed : MinecraftColor('4', Color(128, 0, 0), Red)
    object DarkPurple : MinecraftColor('5', Color(128, 0, 128), LightPurple)
    object Gold : MinecraftColor('6', Color(255, 165, 0), Yellow)
    object Gray : MinecraftColor('7', Color(80, 80, 80), DarkGray)
    object DarkGray : MinecraftColor('8', Color(35, 35, 35), Gray)
    object Blue : MinecraftColor('9', Color(0, 0, 255), DarkBlue)
    object Green : MinecraftColor('a', Color(0, 255, 0), DarkGreen)
    object Aqua : MinecraftColor('b', Color(0, 255, 255), DarkAqua)
    object Red : MinecraftColor('c', Color(255, 0, 0), DarkRed)
    object LightPurple : MinecraftColor('d', Color(255, 0, 255), DarkPurple)
    object Yellow : MinecraftColor('e', Color(255, 255, 0), Gold)
    object White : MinecraftColor('f', Color(255, 255, 255), Black)

}