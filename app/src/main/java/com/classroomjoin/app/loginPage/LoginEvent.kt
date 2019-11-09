package com.classroomjoin.app.loginPage

import com.classroomjoin.app.helper_utils.BaseEvent
import com.classroomjoin.app.helper_utils.Event


class LoginEvent : BaseEvent {

    var message: String? = null

    constructor(event: Event, message: String?) : super(event) {
        this.message = message
    }

    constructor(event: Event) : super(event) {}
}
