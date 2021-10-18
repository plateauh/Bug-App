package com.najed.bugapp.model

import com.najed.bugapp.model.entry.Entry
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root
import java.io.Serializable

@Root(name = "feed", strict = false)
class Feed constructor(): Serializable {

    @field:Element(name = "title")
    var title: String? = null

    @field: ElementList(inline = true, name = "entry")
    var entries: ArrayList<Entry>? = null
}