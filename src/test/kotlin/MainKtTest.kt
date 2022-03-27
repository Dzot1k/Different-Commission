import org.junit.Test

import org.junit.Assert.*

class MainKtTest1 {

    @Test
    fun transferWithAllDefaultParametersCardTypeAndAmountMonth(){
        val amount = 10_000

        val expectedResult = "Комиссия с карты Vk Pay не взимается, деньги переведены"

        val actualResult = transfer(amount = amount)

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun transferWithDefaultParameterCardType(){
        val amount = 10_000
        val amountMonth = 50_000

        val expectedResult = "Ваш лимит карты Vk Pay на месяц превышен"

        val actualResult = transfer(amount = amount, amountMonth = amountMonth)

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun transferWithoutDefaultParameters(){
        val amount = 10_000
        val amountMonth = 50_000
        val cardType = MASTERCARD

        val expectedResult = "Комиссия за перевод с карты $MASTERCARD составила: 0 коп."

        val actualResult = transfer(cardType = cardType, amount = amount, amountMonth = amountMonth)

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun transferTestMaestro(){
        val amount = 10_000
        val amountMonth = 50_000
        val cardType = MAESTRO

        val expectedResult = "Комиссия за перевод c карты $MAESTRO составила: 0 коп."

        val actualResult = transfer(cardType = cardType, amount = amount, amountMonth = amountMonth)

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun transferTestVisa(){
        val amount = 140_000
        val amountMonth = 500_000
        val cardType = VISA

        val expectedResult = "Ваш лимит карты $VISA на месяц превышен"

        val actualResult = transfer(cardType = cardType, amount = amount, amountMonth = amountMonth)

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun transferTestMir(){
        val amount = 140_000
        val amountMonth = 500_000
        val cardType = MIR

        val expectedResult = "Ваш лимит карты $MIR на месяц превышен"

        val actualResult = transfer(cardType = cardType, amount = amount, amountMonth = amountMonth)

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun transferTestOtherCardType(){
        val amount = 10_000
        val amountMonth = 50_000
        val cardType = "Japan Card"

        val expectedResult = "Такого типа карты нет"

        val actualResult = transfer(cardType = cardType, amount = amount, amountMonth = amountMonth)

        assertEquals(expectedResult, actualResult)
    }



    @Test
    fun vkPayMonthLimitExceeded() {
        val amount = 10_000
        val amountMonth = 35_000
        val expectedResult = "Ваш лимит карты $VKPAY на месяц превышен"

        val actualResult = vkPay(amount, amountMonth)

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun vkPayDayLimitExceeded() {
        val amount = 20_000
        val amountMonth = 10_000
        val expectedResult = "Ваш лимит карты $VKPAY за сутки превышен"

        val actualResult = vkPay(amount, amountMonth)

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun vkPayTransferIsTrue() {
        val amount = 5_000
        val amountMonth = 10_000
        val expectedResult = "Комиссия с карты $VKPAY не взимается, деньги переведены"

        val actualResult = vkPay(amount, amountMonth)

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun masterCardMonthLimitExceeded() {
        val amount = 110_000
        val amountMonth = 500_000
        val expectedResult = "Ваш лимит карты $MASTERCARD на месяц превышен"

        val actualResult = masterCard(amount, amountMonth)

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun masterCardDayLimitExceeded() {
        val amount = 200_000
        val amountMonth = 100_000
        val expectedResult = "Ваш лимит карты $MASTERCARD за сутки превышен"

        val actualResult = masterCard(amount, amountMonth)

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun masterCardTransferIsTrueWithCommission() {
        val amount = 90_000
        val amountMonth = 300_000
        val expectedResult = "Комиссия за перевод с карты $MASTERCARD составила: 56000 коп."

        val actualResult = masterCard(amount, amountMonth)

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun masterCardTransferIsTrueWithoutCommission() {
        val amount = 50_000
        val amountMonth = 500_000
        val expectedResult = "Комиссия за перевод с карты $MASTERCARD составила: 0 коп."

        val actualResult = masterCard(amount, amountMonth)

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun maestroMonthLimitExceeded() {
        val amount = 110_000
        val amountMonth = 500_000
        val expectedResult = "Ваш лимит карты $MAESTRO на месяц превышен"

        val actualResult = maestro(amount, amountMonth)

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun maestroDayLimitExceeded() {
        val amount = 200_000
        val amountMonth = 100_000
        val expectedResult = "Ваш лимит карты $MAESTRO за сутки превышен"

        val actualResult = maestro(amount, amountMonth)

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun maestroTransferIsTrueWithCommission() {
        val amount = 90_000
        val amountMonth = 300_000
        val expectedResult = "Комиссия за перевод c карты $MAESTRO составила: 56000 коп."

        val actualResult = maestro(amount, amountMonth)

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun maestroTransferIsTrueWithoutCommission() {
        val amount = 50_000
        val amountMonth = 500_000
        val expectedResult = "Комиссия за перевод c карты $MAESTRO составила: 0 коп."

        val actualResult = maestro(amount, amountMonth)

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun visaMonthLimitExceeded() {
        val amount = 100_000
        val amountMonth = 550_000
        val expectedResult = "Ваш лимит карты $VISA на месяц превышен"

        val actualResult = visa(amount, amountMonth)

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun visaDayLimitExceeded() {
        val amount = 200_000
        val amountMonth = 20_000
        val expectedResult = "Ваш лимит карты $VISA за сутки превышен"

        val actualResult = visa(amount, amountMonth)

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun visaTransferIsTrueWithCommissionIn35Rub() {
        val amount = 1_000
        val amountMonth = 20_000
        val expectedResult = "Комиссия за перевод c карты $VISA составила: 3500 коп."

        val actualResult = visa(amount, amountMonth)

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun visaTransferIsTrueWithCommissionMore35Rub() {
        val amount = 10_000
        val amountMonth = 20_000
        val expectedResult = "Комиссия за перевод c карты $VISA составила: 7500 коп."

        val actualResult = visa(amount, amountMonth)

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun mirMonthLimitExceeded() {
        val amount = 100_000
        val amountMonth = 550_000
        val expectedResult = "Ваш лимит карты $MIR на месяц превышен"

        val actualResult = mir(amount, amountMonth)

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun mirDayLimitExceeded() {
        val amount = 200_000
        val amountMonth = 20_000
        val expectedResult = "Ваш лимит карты $MIR за сутки превышен"

        val actualResult = mir(amount, amountMonth)

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun mirTransferIsTrueWithCommissionIn35Rub() {
        val amount = 1_000
        val amountMonth = 20_000
        val expectedResult = "Комиссия за перевод c карты $MIR составила: 3500 коп."

        val actualResult = mir(amount, amountMonth)

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun mirMTransferIsTrueWithCommissionMore35Rub() {
        val amount = 10_000
        val amountMonth = 20_000
        val expectedResult = "Комиссия за перевод c карты $MIR составила: 7500 коп."

        val actualResult = mir(amount, amountMonth)

        assertEquals(expectedResult, actualResult)
    }
}