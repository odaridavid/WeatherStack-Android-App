package com.github.odaridavid.wingu.shared

interface DomainMapper<in Response, out Domain> {

    fun map(response: Response): Domain
}
