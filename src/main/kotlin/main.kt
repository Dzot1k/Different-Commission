const val VKPAY = "Vk Pay"
const val MASTERCARD = "Mastercard"
const val MAESTRO = "Maestro"
const val VISA = "Visa"
const val MIR = "Мир"
const val RUB = 100

fun main() {
    println(transfer(amount = 10_000))
    println(transfer(VKPAY, 50_000, 5_000))
    println(transfer(MAESTRO, 80_000, 70_000))
    println(transfer(cardType = VISA, amount = 60_000))
    println(transfer(MIR, 500_000, 3_000))
    println(transfer(MASTERCARD, 350_000, 76_000))
    println(transfer(MASTERCARD, 50_000, 300_000))
}

fun transfer(
    cardType: String = VKPAY,
    amountMonth: Int = 0,
    amount: Int
): String {
    return when (cardType) {
        VKPAY -> vkPay(amount, amountMonth)
        MASTERCARD -> masterCard(amount, amountMonth)
        MAESTRO -> maestro(amount, amountMonth)
        VISA -> visa(amount, amountMonth)
        MIR -> mir(amount, amountMonth)
        else -> "Такого типа карты нет"
    }

}

fun vkPay(amount: Int, amountMonth: Int): String {
    val amountMax = 15_000
    val amountMonthMax = 40_000
    return when {
        amountMonth + amount > amountMonthMax -> "Ваш лимит карты $VKPAY на месяц превышен"
        amount > amountMax -> "Ваш лимит карты $VKPAY за сутки превышен"
        else -> "Комиссия с карты $VKPAY не взимается, деньги переведены"
    }
}

fun masterCard(amount: Int, amountMonth: Int): String {
    val amountMax = 150_000
    val amountMonthMax = 600_000
    return when {
        amountMonth + amount > amountMonthMax -> "Ваш лимит карты $MASTERCARD на месяц превышен"
        amount > amountMax -> "Ваш лимит карты $MASTERCARD за сутки превышен"
        else -> {
            val commission = if (amount > 75_000) amount * RUB * 6 / 1000 + 20 * RUB else 0
            "Комиссия за перевод с карты $MASTERCARD составила: $commission коп."
        }
    }
}

fun maestro(amount: Int, amountMonth: Int): String {
    val amountMax = 150_000
    val amountMonthMax = 600_000
    return when {
        amountMonth + amount > amountMonthMax -> "Ваш лимит карты $MAESTRO на месяц превышен"
        amount > amountMax -> "Ваш лимит карты $MAESTRO за сутки превышен"
        else -> {
            val commission = if (amount > 75_000) amount * RUB * 6 / 1000 + 20 * RUB else 0
            "Комиссия за перевод c карты $MAESTRO составила: $commission коп."
        }
    }
}

fun visa(amount: Int, amountMonth: Int): String {
    val amountMax = 150_000
    val amountMonthMax = 600_000
    return when {
        amountMonth + amount > amountMonthMax -> "Ваш лимит карты $VISA на месяц превышен"
        amount > amountMax -> "Ваш лимит карты $VISA за сутки превышен"
        else -> {
            val commission = if (amount * RUB * 75 / 10000 < 35 * RUB) 35 * RUB else amount * RUB * 75 / 10000
            "Комиссия за перевод c карты $VISA составила: $commission коп."
        }
    }
}

fun mir(amount: Int, amountMonth: Int): String {
    val amountMax = 150_000
    val amountMonthMax = 600_000
    return when {
        amountMonth + amount > amountMonthMax -> "Ваш лимит карты $MIR на месяц превышен"
        amount > amountMax -> "Ваш лимит карты $MIR за сутки превышен"
        else -> {
            val commission = if (amount * RUB * 75 / 10000 < 35 * RUB) 35 * RUB else amount * RUB * 75 / 10000
            "Комиссия за перевод c карты $MIR составила: $commission коп."
        }
    }

}