package com.lankaguide.tripplanner.model.place.transport

import com.lankaguide.tripplanner.model.Location

class Airport : TransportNode {
    internal var code: String

    constructor(code: String, name: String, location: Location) : super(name, location) {
        this.code = code
    }

    constructor(code: String, location: Location) : super(code, location) {
        this.code = code
    }

    constructor(name: String, code: String) : super(name) {
        this.code = code
    }

    constructor(code: String) : super(code) {
        this.code = code
    }
}
