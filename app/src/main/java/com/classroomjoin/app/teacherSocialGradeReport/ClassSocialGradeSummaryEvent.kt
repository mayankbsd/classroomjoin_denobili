package com.classroomjoin.app.teacherSocialGradeReport


import com.classroomjoin.app.helper_utils.DisplayItem
import com.classroomjoin.app.helper_utils.Event
import com.classroomjoin.app.helper_utils.ListEvent


class ClassSocialGradeSummaryEvent : ListEvent<DisplayItem> {
    constructor(event: Event) : super(event) {}

    constructor(event: Event, error: String) : super(event, error) {}

    //constructor(event: Event, results: List<DisplayItem>, error: String) : super(event, results, error) {}

    //constructor(error: String) : super(error) {}

    constructor(results: List<DisplayItem>) : super(results) {}

    override var event: Event
        get() = super.event
        set(value) {}
}
