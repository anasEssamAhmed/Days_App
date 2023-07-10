package com.example.days_app.datasource

import com.example.days_app.R
import com.example.days_app.model.DayTask

class datasource {

    fun reloadData(): List<DayTask> {
        return listOf(
            DayTask("Day 1", R.string.title, R.drawable.image1, R.string.Desc),
            DayTask("Day 2", R.string.title, R.drawable.image2, R.string.Desc),
            DayTask("Day 3", R.string.title, R.drawable.image3, R.string.Desc),
            DayTask("Day 4", R.string.title, R.drawable.image4, R.string.Desc),
            DayTask("Day 5", R.string.title, R.drawable.image5, R.string.Desc),
            DayTask("Day 6", R.string.title, R.drawable.image6, R.string.Desc),
            DayTask("Day 7", R.string.title, R.drawable.image7, R.string.Desc),
            DayTask("Day 8", R.string.title, R.drawable.image8, R.string.Desc),
            DayTask("Day 9", R.string.title, R.drawable.image9, R.string.Desc),
            DayTask("Day 10", R.string.title, R.drawable.image10, R.string.Desc)
        )
    }
}