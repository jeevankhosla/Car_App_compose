package de.inovex.finder.ui.car

import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.model.ItemList
import androidx.car.app.model.ListTemplate
import androidx.car.app.model.Row
import androidx.car.app.model.Template
import de.inovex.finder.R
import de.inovex.finder.util.ImageUtils.getCarIconFrom

class AllDevicesScreen(carContext: CarContext) : Screen(carContext) {

    override fun onGetTemplate(): Template {
        val itemList = ItemList.Builder()
            .addItem(createRow("🎮 Gaming consoles"))
            .addItem(createRow("🏡 Garden"))
            .addItem(createRow("🚗 Garage"))
            .addItem(createRow("🏢 Office"))
            .build()

        return ListTemplate.Builder()
            .setSingleList(itemList)
            .setTitle("All devices")
            .build()
    }

    private fun createRow(title: String): Row {
        val searchIcon = getCarIconFrom(carContext,  R.drawable.search)

        return Row.Builder()
            .setTitle(title)
            .setBrowsable(true)
            .setImage(searchIcon)
            .setOnClickListener {
                // Handle item click if needed
            }
            .build()
    }
}