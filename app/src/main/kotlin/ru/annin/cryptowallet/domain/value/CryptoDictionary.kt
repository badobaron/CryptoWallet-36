package ru.annin.cryptowallet.domain.value

/**
 * Криптографический словарь.
 * ! Важно криптографические свойства словарей не должны пересекаться.
 * ! Важно криптографические свойства словарей должны охватывать весь диапозон значений.
 *
 *
 * @author Pavel Annin, 2016
 */
object CryptoDictionary {

    /** Цифровой словарь. */
    val NUMBER : Map<Char, Int>
    /** Буквенный словарь. */
    val ENGLISH : Map<Char, Int>
    /** Буквеноцифровой словарь. */
    val NUMENGLISH : MutableMap<Char, Int>


    init {
        NUMBER = mapOf(
                Pair('0', 9),
                Pair('1', 8),
                Pair('2', 7),
                Pair('3', 6),
                Pair('4', 5),
                Pair('5', 4),
                Pair('6', 3),
                Pair('7', 2),
                Pair('8', 1),
                Pair('9', 0))

        ENGLISH = mapOf(
                Pair('A', 61),
                Pair('a', 60),
                Pair('B', 59),
                Pair('b', 58),
                Pair('C', 57),
                Pair('c', 56),
                Pair('D', 55),
                Pair('d', 54),
                Pair('E', 53),
                Pair('e', 52),
                Pair('F', 51),
                Pair('f', 50),
                Pair('G', 49),
                Pair('g', 48),
                Pair('H', 47),
                Pair('h', 46),
                Pair('I', 45),
                Pair('i', 44),
                Pair('J', 43),
                Pair('j', 42),
                Pair('K', 41),
                Pair('k', 40),
                Pair('L', 39),
                Pair('l', 38),
                Pair('M', 37),
                Pair('m', 36),
                Pair('N', 35),
                Pair('n', 34),
                Pair('O', 33),
                Pair('o', 32),
                Pair('P', 31),
                Pair('p', 30),
                Pair('Q', 29),
                Pair('q', 28),
                Pair('R', 27),
                Pair('r', 26),
                Pair('S', 25),
                Pair('s', 24),
                Pair('T', 23),
                Pair('t', 22),
                Pair('U', 21),
                Pair('u', 20),
                Pair('V', 19),
                Pair('v', 18),
                Pair('W', 17),
                Pair('w', 16),
                Pair('X', 15),
                Pair('x', 14),
                Pair('Y', 13),
                Pair('y', 12),
                Pair('Z', 11),
                Pair('z', 10))

        NUMENGLISH = mutableMapOf()
        NUMENGLISH .putAll(NUMBER)
        NUMENGLISH.putAll(ENGLISH)
    }
}