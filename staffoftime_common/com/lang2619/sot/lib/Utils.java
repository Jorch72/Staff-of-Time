package com.lang2619.sot.lib;

public class Utils
{
    public static String prependFormatTag(String str, char format)
    {
        return "\u00a7" + format + str;
    }

    public static String appendResetTag(String str)
    {
        return str + "\u00a7r";
    }

    public static String wrapMultipleFormatTags(String str, Object... tags)
    {
        for(Object tag : tags){
            if(tag instanceof Character){
                str = prependFormatTag(str, (Character) tag);
            }
            else if(tag instanceof FormatCodes){
                str = prependFormatTag(str, ((FormatCodes) tag).character);
            }
        }
        return appendResetTag(str);

    }

    public static enum FormatCodes 
    {
        Black('0'),
        DarkBlue('1'),
        DarkGreen('2'),
        DarkAqua('3'),
        DarkRed('4'),
        Purple('5'),
        Gold('6'),
        Grey('7'),
        DarkGrey('8'),
        Indigo('9'),
        BrightGreen('a'),
        Aqua('b'),
        Red('c'),
        Pink('d'),
        Yellow('e'),
        White('f'),
        RandomChar('k'),
        Bold('l'),
        Strike('m'),
        Underlined('n'),
        Italic('o'),
        Reset('r');

        public char character;

        private FormatCodes(char character){
            this.character = character;
        }
    }
}
