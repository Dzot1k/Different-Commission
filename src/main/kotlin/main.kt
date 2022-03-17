const val VKPAY = "Vk Pay"
const val MASTERCARD = "Mastercard"
const val MAESTRO = "Maestro"
const val VISA = "Visa"
const val WORLD = "Мир"
const val RUB = 100

fun main() {
    transfer(amount = 10_000)
    transfer(VKPAY, 50_000, 5_000)
    transfer(MAESTRO, 80_000, 70_000)
    transfer(cardType = VISA, amount = 60_000)
    transfer(WORLD, 500_000, 3_000)
    transfer(MASTERCARD, 350_000, 76_000)
    transfer(MASTERCARD, 50_000, 300_000)
}

fun transfer(
    cardType: String = VKPAY,
    amountMonth: Int = 0,
    amount: Int
) {
    when (cardType) {
        VKPAY -> vkPay(amount, amountMonth)
        MASTERCARD -> masterCard(amount, amountMonth)
        MAESTRO -> maestro(amount, amountMonth)
        VISA -> visa(amount, amountMonth)
        WORLD -> world(amount, amountMonth)
    }

}

fun vkPay(amount: Int, amountMonth: Int) {
    val amountMax = 15_000
    val amountMonthMax = 40_000
    when {
        amountMonth + amount > amountMonthMax -> println("Ваш лимит карты $VKPAY на месяц превышен")
        amount > amountMax -> println("Ваш лимит карты $VKPAY за сутки превышен")
        amount <= amountMax -> println("Комиссия с карты $VKPAY не взимается, деньги переведены")
    }
}

fun masterCard(amount: Int, amountMonth: Int) {
    val amountMax = 150_000
    val amountMonthMax = 600_000
    when {
        amountMonth + amount > amountMonthMax -> println("Ваш лимит карты $MASTERCARD на месяц превышен")
        amount > amountMax -> println("Ваш лимит карты $MASTERCARD за сутки превышен")
        amount <= amountMax -> {
            val commission = if (amount > 75_000) amount * RUB * 6 / 1000 + 20 * RUB else 0
            println("Комиссия за перевод с карты $MASTERCARD составила: $commission коп.")
        }
    }
}

fun maestro(amount: Int, amountMonth: Int) {
    val amountMax = 150_000
    val amountMonthMax = 600_000
    when {
        amountMonth + amount > amountMonthMax -> println("Ваш лимит карты $MAESTRO на месяц превышен")
        amount > amountMax -> println("Ваш лимит карты $MAESTRO за сутки превышен")
        amount <= amountMax -> {
            val commission = if (amount > 75_000) amount * RUB * 6 / 1000 + 20 * RUB else 0
            println("Комиссия за перевод c карты $MAESTRO составила: $commission коп.")
        }
    }
}

fun visa(amount: Int, amountMonth: Int) {
    val amountMax = 150_000
    val amountMonthMax = 600_000
    when {
        amountMonth + amount > amountMonthMax -> println("Ваш лимит карты $VISA на месяц превышен")
        amount > amountMax -> println("Ваш лимит карты $VISA за сутки превышен")
        amount <= amountMax -> {
            val commission = if (amount * RUB * 75 / 10000 < 35 * RUB) 35 * RUB else amount * RUB * 75 / 10000
            println("Комиссия за перевод c карты $VISA составила: $commission коп.")
        }
    }
}

fun world(amount: Int, amountMonth: Int) {
    val amountMax = 150_000
    val amountMonthMax = 600_000
    when {
        amountMonth + amount > amountMonthMax -> println("Ваш лимит карты $WORLD на месяц превышен")
        amount > amountMax -> println("Ваш лимит карты $WORLD за сутки превышен")
        amount <= amountMax -> {
            val commission = if (amount * RUB * 75 / 10000 < 35 * RUB) 35 * RUB else amount * RUB * 75 / 10000
            println("Комиссия за перевод c карты $WORLD составила: $commission коп.")
        }
    }

}