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
    val NUMBER : Map<Char, Int>;
    /** Буквенный словарь. */
    val ENGLISH : Map<Char, Int>;

    init {
        NUMBER = mapOf(
                Pair('0', 0),
                Pair('1', 1),
                Pair('2', 2),
                Pair('3', 3),
                Pair('4', 4),
                Pair('5', 5),
                Pair('6', 6),
                Pair('7', 7),
                Pair('8', 8),
                Pair('9', 9));

        ENGLISH = mapOf(
                Pair('A', 10),
                Pair('a', 11),
                Pair('B', 12),
                Pair('b', 13),
                Pair('C', 14),
                Pair('c', 15),
                Pair('D', 16),
                Pair('d', 17),
                Pair('E', 18),
                Pair('e', 19),
                Pair('F', 20),
                Pair('f', 21),
                Pair('G', 22),
                Pair('g', 23),
                Pair('H', 24),
                Pair('h', 25),
                Pair('I', 26),
                Pair('i', 27),
                Pair('J', 28),
                Pair('j', 29),
                Pair('K', 30),
                Pair('k', 31),
                Pair('L', 32),
                Pair('l', 33),
                Pair('M', 34),
                Pair('m', 35),
                Pair('N', 36),
                Pair('n', 37),
                Pair('O', 38),
                Pair('o', 39),
                Pair('P', 40),
                Pair('p', 41),
                Pair('Q', 42),
                Pair('q', 43),
                Pair('R', 44),
                Pair('r', 45),
                Pair('S', 46),
                Pair('s', 47),
                Pair('T', 48),
                Pair('t', 49),
                Pair('U', 50),
                Pair('u', 51),
                Pair('V', 52),
                Pair('v', 53),
                Pair('W', 54),
                Pair('w', 55),
                Pair('X', 56),
                Pair('x', 57),
                Pair('Y', 58),
                Pair('y', 59),
                Pair('Z', 60),
                Pair('z', 61));
    }
}