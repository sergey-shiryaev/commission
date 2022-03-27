package ru.netology

import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun commis_vkpay_less_maxlimit() {
        //arrange
        val cardType = "VK Pay"
        val monthAmount = 30_000
        val moneyTransfer = 5_000
        val expectedResult = 0
        //act
        val actualCommission = commission(
            cardType = cardType,
            monthAmount = monthAmount,
            moneyTransfer = moneyTransfer
        )
        //assert
        assertEquals(expectedResult, actualCommission)
    }

    @Test
    fun commis_vkpay_more_maxlimit() {
        //arrange
        val cardType = "VK Pay"
        val monthAmount = 37_000
        val moneyTransfer = 5_000
        val expectedResult = null
        //act
        val actualCommission = commission(
            cardType = cardType,
            monthAmount = monthAmount,
            moneyTransfer = moneyTransfer
        )
        //assert
        assertEquals(expectedResult, actualCommission)
    }

    @Test
    fun commis_mastercard_maestro_less_maxlimit() {
        //arrange
        val cardType = "Mastercard"
        val monthAmount = 37_000
        val moneyTransfer = 5_000
        val expectedResult = 0
        //act
        val actualCommission = commission(
            cardType = cardType,
            monthAmount = monthAmount,
            moneyTransfer = moneyTransfer
        )
        //assert
        assertEquals(expectedResult, actualCommission)
    }

    @Test
    fun commis_mastercard_maestro_more_maxlimit() {
        //arrange
        val cardType = "Mastercard"
        val monthAmount = 600_000
        val moneyTransfer = 5_000
        val expectedResult = 320
        //act
        val actualCommission = commission(
            cardType = cardType,
            monthAmount = monthAmount,
            moneyTransfer = moneyTransfer
        )
        //assert
        assertEquals(expectedResult, actualCommission)
    }

    @Test
    fun commis_visa_mir_less_maxlimit() {
        //arrange
        val cardType = "Visa"
        val monthAmount = 30_000
        val moneyTransfer = 5_000
        val expectedResult = 375
        //act
        val actualCommission = commission(
            cardType = cardType,
            monthAmount = monthAmount,
            moneyTransfer = moneyTransfer
        )
        //assert
        assertEquals(expectedResult, actualCommission)
    }

    @Test
    fun commis_visa_mir_more_maxlimit() {
        //arrange
        val cardType = "Visa"
        val monthAmount = 600_000
        val moneyTransfer = 5_000
        val expectedResult = null
        //act
        val actualCommission = commission(
            cardType = cardType,
            monthAmount = monthAmount,
            moneyTransfer = moneyTransfer
        )
        //assert
        assertEquals(expectedResult, actualCommission)
    }

    @Test
    fun commis_catdtype_doesnt_exist() {
        //arrange
        val cardType = "AAAAA"
        val monthAmount = 600_000
        val moneyTransfer = 5_000
        val expectedResult = null
        //act
        val actualCommission = commission(
            cardType = cardType,
            monthAmount = monthAmount,
            moneyTransfer = moneyTransfer
        )
        //assert
        assertEquals(expectedResult, actualCommission)
    }

    @Test
    fun commis_default() {
        //arrange
        val moneyTransfer = 5_000
        val expectedResult = 0
        //act
        val actualCommission = commission(
            moneyTransfer = moneyTransfer
        )
        //assert
        assertEquals(expectedResult, actualCommission)
    }
}