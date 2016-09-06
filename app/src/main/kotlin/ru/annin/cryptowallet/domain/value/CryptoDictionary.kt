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
    val NUMBER: Map<Char, Int>
    /** Буквенный словарь (Английский). */
    val ENGLISH: Map<Char, Int>
    /** Буквенный словарь (Русский). */
    val RUSSIAN: Map<Char, Int>
    /** Спецсимвольный словарь. */
    val SPECIAL: Map<Char, Int>

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
                Pair('A', 51),
                Pair('B', 50),
                Pair('C', 49),
                Pair('D', 48),
                Pair('E', 47),
                Pair('F', 46),
                Pair('G', 45),
                Pair('H', 44),
                Pair('I', 43),
                Pair('J', 42),
                Pair('K', 41),
                Pair('L', 40),
                Pair('M', 39),
                Pair('N', 38),
                Pair('O', 37),
                Pair('P', 36),
                Pair('Q', 35),
                Pair('R', 34),
                Pair('S', 33),
                Pair('T', 32),
                Pair('U', 31),
                Pair('V', 30),
                Pair('W', 29),
                Pair('X', 28),
                Pair('Y', 27),
                Pair('Z', 26),
                Pair('a', 25),
                Pair('b', 24),
                Pair('c', 23),
                Pair('d', 22),
                Pair('e', 21),
                Pair('f', 20),
                Pair('g', 19),
                Pair('h', 18),
                Pair('i', 17),
                Pair('j', 16),
                Pair('k', 15),
                Pair('l', 14),
                Pair('m', 13),
                Pair('n', 12),
                Pair('o', 11),
                Pair('p', 10),
                Pair('q', 9),
                Pair('r', 8),
                Pair('s', 7),
                Pair('t', 6),
                Pair('u', 5),
                Pair('v', 4),
                Pair('w', 3),
                Pair('x', 2),
                Pair('y', 1),
                Pair('z', 0))

        RUSSIAN = mapOf(
                Pair('А', 65),
                Pair('Б', 64),
                Pair('В', 63),
                Pair('Г', 62),
                Pair('Д', 61),
                Pair('Е', 60),
                Pair('Ё', 59),
                Pair('Ж', 58),
                Pair('З', 57),
                Pair('И', 56),
                Pair('Й', 55),
                Pair('К', 54),
                Pair('Л', 53),
                Pair('М', 52),
                Pair('Н', 51),
                Pair('О', 50),
                Pair('П', 49),
                Pair('Р', 48),
                Pair('С', 47),
                Pair('Т', 46),
                Pair('У', 45),
                Pair('Ф', 44),
                Pair('Х', 43),
                Pair('Ц', 42),
                Pair('Ч', 41),
                Pair('Ш', 40),
                Pair('Щ', 39),
                Pair('Ъ', 38),
                Pair('Ы', 37),
                Pair('Ь', 36),
                Pair('Э', 35),
                Pair('Ю', 34),
                Pair('Я', 33),
                Pair('а', 32),
                Pair('б', 31),
                Pair('в', 30),
                Pair('г', 29),
                Pair('д', 28),
                Pair('е', 27),
                Pair('ё', 26),
                Pair('ж', 25),
                Pair('з', 24),
                Pair('и', 23),
                Pair('й', 22),
                Pair('к', 21),
                Pair('л', 20),
                Pair('м', 19),
                Pair('н', 18),
                Pair('о', 17),
                Pair('п', 16),
                Pair('р', 15),
                Pair('с', 14),
                Pair('т', 13),
                Pair('у', 12),
                Pair('ф', 11),
                Pair('х', 10),
                Pair('ц', 9),
                Pair('ч', 8),
                Pair('ш', 7),
                Pair('щ', 6),
                Pair('ъ', 5),
                Pair('ы', 4),
                Pair('ь', 3),
                Pair('э', 2),
                Pair('ю', 1),
                Pair('я', 0))

        SPECIAL = mapOf(
                Pair(' ', 32),
                Pair('!', 31),
                Pair('"', 30),
                Pair('#', 29),
                Pair('$', 28),
                Pair('%', 27),
                Pair('&', 26),
                Pair('\'', 25),
                Pair('(', 24),
                Pair(')', 23),
                Pair('*', 22),
                Pair('+', 21),
                Pair(',', 20),
                Pair('-', 19),
                Pair('.', 18),
                Pair('/', 17),
                Pair(':', 16),
                Pair(';', 15),
                Pair('<', 14),
                Pair('=', 13),
                Pair('>', 12),
                Pair('?', 11),
                Pair('@', 10),
                Pair('[', 9),
                Pair('\\', 8),
                Pair(']', 7),
                Pair('^', 6),
                Pair('_', 5),
                Pair('`', 4),
                Pair('~', 3),
                Pair('{', 2),
                Pair('}', 1),
                Pair('№', 0))
    }

    fun create(option: Dictionary): Map<Char, Int> {
        var dictionary: Map<Char, Int> = emptyMap()
        if (option.isNumber) {
            dictionary = unite(dictionary, offset(NUMBER, dictionary.size))
        }
        if (option.isEnglish) {
            dictionary = unite(dictionary, offset(ENGLISH, dictionary.size))
        }
        if (option.isRussian) {
            dictionary = unite(dictionary, offset(RUSSIAN, dictionary.size))
        }
        if (option.isSpecial) {
            dictionary = unite(dictionary, offset(SPECIAL, dictionary.size))
        }
        return dictionary
    }

    fun offset(dic: Map<Char, Int>, offset: Int): Map<Char, Int> {
        val dictionary: MutableMap<Char, Int> = mutableMapOf()
        dictionary.putAll(dic)
        for (key: Char in dictionary.keys) {
            val currentValue: Int = dictionary[key]!!
            dictionary[key] = currentValue + offset
        }
        return dictionary
    }

    fun unite(vararg dictionaries: Map<Char, Int>): Map<Char, Int> {
        val dictionary: MutableMap<Char, Int> = mutableMapOf()
        for (dic: Map<Char, Int> in dictionaries) {
            dictionary.putAll(dic)

        }
        return dictionary
    }

    data class Dictionary(val isNumber: Boolean = false,
                          val isEnglish: Boolean = false,
                          val isRussian: Boolean = false,
                          val isSpecial: Boolean = false)
}