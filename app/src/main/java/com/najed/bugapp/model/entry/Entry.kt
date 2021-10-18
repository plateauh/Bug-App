package com.najed.bugapp.model.entry

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root
import java.io.Serializable

@Root(name = "entry", strict = false)
class Entry @JvmOverloads constructor(

    @field:Element(name = "title")
    @param:Element(name = "title")
    var title: String? = null,

    @field:Element(name = "content")
    @param:Element(name = "content")
    var content: String? = null,

    @field:Element(name = "published")
    @param:Element(name = "published")
    var published: String? = null,

    @field:Element(name = "author")
    @param:Element(name = "author")
    var author: Author? = null,

): Serializable