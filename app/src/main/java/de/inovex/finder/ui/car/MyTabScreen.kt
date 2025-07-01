package de.inovex.finder.ui.car


import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.model.*
import androidx.car.app.model.Action.APP_ICON
import androidx.core.graphics.drawable.IconCompat
import de.inovex.finder.R
import de.inovex.finder.domain.model.TabInfo

class MyTabScreen(carContext: CarContext)  : Screen(carContext)  {


    private val TAB_ALL_DEVICES = "all_devices"
    private val TAB_MY_DEVICES = "my_devices"
    private val TAB_SETTINGS = "settings"
    private val TAB_MORE = "more"

    private val firstTab = TabInfo("first_tab", R.string.app_name, R.drawable.icecream)
    private val secondTab = TabInfo("second_tab", R.string.app_name, R.drawable.icecream)
    
    private var activeContentId: String = firstTab.tabId




    private fun getFirstTabTemplate() : Template {
        return MessageTemplate.Builder("This is my first tab").build()
    }

    private fun getSecondTabTemplate() : Template {
        return MessageTemplate.Builder("This is my second tab").build()
    }


    private fun getActiveTabContent(): TabContents {
        return if (activeContentId == firstTab.tabId) {
            TabContents.Builder(getFirstTabTemplate()).build()
        } else {
            TabContents.Builder(getSecondTabTemplate()).build()
        }
    }

    private fun getTab(tabInfo: TabInfo) = Tab.Builder()
        .setTitle(carContext.getString(tabInfo.tabTitle))
        .setIcon(
            CarIcon.Builder(IconCompat.createWithResource(carContext, tabInfo.tabIcon)).build()
        ).setContentId(tabInfo.tabId).build()


    override fun onGetTemplate(): Template {

        /*val row = Row.Builder().setTitle("Hello world!").build()
        val pane = Pane.Builder().addRow(row).build()
        return PaneTemplate.Builder(pane)
            .setHeaderAction(Action.APP_ICON)
            .build()*/

        val tabTemplate = TabTemplate.Builder(object : TabTemplate.TabCallback {
            override fun onTabSelected(tabContentId: String) {
                activeContentId = tabContentId
                invalidate() //call invalidate() to get the new template to display
            }
        })
            .setHeaderAction(APP_ICON)
        tabTemplate.addTab(getTab(firstTab))
        tabTemplate.addTab(getTab(secondTab))
        tabTemplate.setTabContents(getActiveTabContent())
        return tabTemplate.setActiveTabContentId(activeContentId).build()


    }

}