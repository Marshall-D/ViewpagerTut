package com.example.viewpagertut

object TextListObj {
    var HH : String = "Understanding " +
            "the law has never been easier! " +
            "Get access to various areas of Nigerian law explained for your benefit."

    var LL : String = "The Law at your fingertips"
    val textSlide = listOf(
        TextData(R.drawable.ic_launcher_background, HH,"skip",LL),
        TextData(R.drawable.ic_ellipse_1,HH,"skip",LL),
        TextData(R.drawable.ic_ellipse_1,HH,"skip",LL),
        )
}