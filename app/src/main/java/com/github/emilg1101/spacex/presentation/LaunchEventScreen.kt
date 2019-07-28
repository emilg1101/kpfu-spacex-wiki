package com.github.emilg1101.spacex.presentation

import android.content.Context
import android.content.Intent
import android.provider.CalendarContract
import android.provider.CalendarContract.Events
import com.github.emilg1101.spacex.presentation.model.LaunchEventModel
import ru.terrakok.cicerone.android.support.SupportAppScreen
import java.util.*

class LaunchEventScreen(private val launchEventModel: LaunchEventModel) : SupportAppScreen() {

    override fun getScreenKey() = "launch_event"

    override fun getActivityIntent(context: Context?): Intent {
        val intent = Intent(Intent.ACTION_INSERT)
        intent.type = "vnd.android.cursor.item/event"

        val calendar = Calendar.getInstance()
        calendar.timeInMillis = launchEventModel.time * 1000
        calendar.timeZone = TimeZone.getDefault()
        intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, calendar.timeInMillis)
        intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, false)


        intent.putExtra(Events.TITLE, launchEventModel.title)
        intent.putExtra(Events.DESCRIPTION, launchEventModel.description)
        intent.putExtra(Events.EVENT_LOCATION, launchEventModel.location)
        return intent
    }
}
