package de.inovex.finder.util

import android.graphics.drawable.Icon
import androidx.annotation.DrawableRes
import androidx.car.app.CarContext
import androidx.car.app.model.CarIcon
import androidx.core.graphics.drawable.IconCompat

object ImageUtils {

    fun getCarIconFrom(carContext: CarContext, @DrawableRes resIdRes: Int): CarIcon {
        return CarIcon.Builder(
            IconCompat.createFromIcon(
                carContext,
                Icon.createWithResource(
                    carContext,
                    resIdRes
                )
            )!!
        ).build()
    }
}