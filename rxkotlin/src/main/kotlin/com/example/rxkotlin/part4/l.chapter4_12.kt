package com.example.rxkotlin.part4

import io.reactivex.schedulers.Schedulers
import io.reactivex.BackpressureStrategy
import io.reactivex.Observable
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking


fun main(args: Array<String>) {
    val source = Observable.range(1, 100)
    source.toFlowable(BackpressureStrategy.MISSING)
            .map { MyItem10(it) }
            .observeOn(Schedulers.io())
            .subscribe{
                println(it)
                runBlocking { delay(100) }
            }
    runBlocking { delay(60000) }
}

data class MyItem10 (val id:Int) {
    init {
        println("MyItem Created $id")
    }
}

//MyItem Created 1
//MyItem Created 2
//MyItem Created 3
//MyItem10(id=1)
//MyItem Created 4
//MyItem Created 5
//MyItem Created 6
//MyItem Created 7
//MyItem Created 8
//MyItem Created 9
//MyItem Created 10
//MyItem Created 11
//MyItem Created 12
//MyItem Created 13
//MyItem Created 14
//MyItem Created 15
//MyItem Created 16
//MyItem Created 17
//MyItem Created 18
//MyItem Created 19
//MyItem Created 20
//MyItem Created 21
//MyItem Created 22
//MyItem Created 23
//MyItem Created 24
//MyItem Created 25
//MyItem Created 26
//MyItem Created 27
//MyItem Created 28
//MyItem Created 29
//MyItem Created 30
//MyItem Created 31
//MyItem Created 32
//MyItem Created 33
//MyItem Created 34
//MyItem Created 35
//MyItem Created 36
//MyItem Created 37
//MyItem Created 38
//MyItem Created 39
//MyItem Created 40
//MyItem Created 41
//MyItem Created 42
//MyItem Created 43
//MyItem Created 44
//MyItem Created 45
//MyItem Created 46
//MyItem Created 47
//MyItem Created 48
//MyItem Created 49
//MyItem Created 50
//MyItem Created 51
//MyItem Created 52
//MyItem Created 53
//MyItem Created 54
//MyItem Created 55
//MyItem Created 56
//MyItem Created 57
//MyItem Created 58
//MyItem Created 59
//MyItem Created 60
//MyItem Created 61
//MyItem Created 62
//MyItem Created 63
//MyItem Created 64
//MyItem Created 65
//MyItem Created 66
//MyItem Created 67
//MyItem Created 68
//MyItem Created 69
//MyItem Created 70
//MyItem Created 71
//MyItem Created 72
//MyItem Created 73
//MyItem Created 74
//MyItem Created 75
//MyItem Created 76
//MyItem Created 77
//MyItem Created 78
//MyItem Created 79
//MyItem Created 80
//MyItem Created 81
//MyItem Created 82
//MyItem Created 83
//MyItem Created 84
//MyItem Created 85
//MyItem Created 86
//MyItem Created 87
//MyItem Created 88
//MyItem Created 89
//MyItem Created 90
//MyItem Created 91
//MyItem Created 92
//MyItem Created 93
//MyItem Created 94
//MyItem Created 95
//MyItem Created 96
//MyItem Created 97
//MyItem Created 98
//MyItem Created 99
//MyItem Created 100
//MyItem10(id=2)
//MyItem10(id=3)
//MyItem10(id=4)
//MyItem10(id=5)
//MyItem10(id=6)
//MyItem10(id=7)
//MyItem10(id=8)
//MyItem10(id=9)
//MyItem10(id=10)
//MyItem10(id=11)
//MyItem10(id=12)
//MyItem10(id=13)
//MyItem10(id=14)
//MyItem10(id=15)
//MyItem10(id=16)
//MyItem10(id=17)
//MyItem10(id=18)
//MyItem10(id=19)
//MyItem10(id=20)
//MyItem10(id=21)
//MyItem10(id=22)
//MyItem10(id=23)
//MyItem10(id=24)
//MyItem10(id=25)
//MyItem10(id=26)
//MyItem10(id=27)
//MyItem10(id=28)
//MyItem10(id=29)
//MyItem10(id=30)
//MyItem10(id=31)
//MyItem10(id=32)
//MyItem10(id=33)
//MyItem10(id=34)
//MyItem10(id=35)
//MyItem10(id=36)
//MyItem10(id=37)
//MyItem10(id=38)
//MyItem10(id=39)
//MyItem10(id=40)
//MyItem10(id=41)
//MyItem10(id=42)
//MyItem10(id=43)
//MyItem10(id=44)
//MyItem10(id=45)
//MyItem10(id=46)
//MyItem10(id=47)
//MyItem10(id=48)
//MyItem10(id=49)
//MyItem10(id=50)
//MyItem10(id=51)
//MyItem10(id=52)
//MyItem10(id=53)
//MyItem10(id=54)
//MyItem10(id=55)
//MyItem10(id=56)
//MyItem10(id=57)
//MyItem10(id=58)
//MyItem10(id=59)
//MyItem10(id=60)
//MyItem10(id=61)
//MyItem10(id=62)
//MyItem10(id=63)
//MyItem10(id=64)
//MyItem10(id=65)
//MyItem10(id=66)
//MyItem10(id=67)
//MyItem10(id=68)
//MyItem10(id=69)
//MyItem10(id=70)
//MyItem10(id=71)
//MyItem10(id=72)
//MyItem10(id=73)
//MyItem10(id=74)
//MyItem10(id=75)
//MyItem10(id=76)
//MyItem10(id=77)
//MyItem10(id=78)
//MyItem10(id=79)
//MyItem10(id=80)
//MyItem10(id=81)
//MyItem10(id=82)
//MyItem10(id=83)
//MyItem10(id=84)
//MyItem10(id=85)
//MyItem10(id=86)
//MyItem10(id=87)
//MyItem10(id=88)
//MyItem10(id=89)
//MyItem10(id=90)
//MyItem10(id=91)
//MyItem10(id=92)
//MyItem10(id=93)
//MyItem10(id=94)
//MyItem10(id=95)
//MyItem10(id=96)
//MyItem10(id=97)
//MyItem10(id=98)
//MyItem10(id=99)
//MyItem10(id=100)