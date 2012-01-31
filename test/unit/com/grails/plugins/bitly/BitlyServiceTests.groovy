package com.grails.plugins.bitly

import grails.test.*
import org.codehaus.groovy.grails.commons.GrailsApplication
import org.codehaus.groovy.grails.commons.DefaultGrailsApplication

class BitlyServiceTests extends GrailsUnitTestCase {
	def bitlyService
    protected void setUp() {
		bitlyService = new BitlyService()
		bitlyService.login = 'danilat'
		bitlyService.apiKey = 'R_dfe892d83437cf0ae1a745021ca106c1'
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testShortAnUrl() {
		def shortened = bitlyService.shorten("http://www.google.com")
		assertEquals 200, shortened.statusCode
		assertEquals "OK", shortened.statusText
		assertNotNull shortened.url
	}
	
	void testShortAnUrlWithACustomDomain() {
		bitlyService.domain = 'j.mp'
		def shortened = bitlyService.shorten("http://www.google.com")
		assertEquals 200, shortened.statusCode
		assertEquals "OK", shortened.statusText
		assertNotNull shortened.url
	}
	
	void testShortAMalformedUrl() {
		def shortened = bitlyService.shorten("www.google.com")
		assertEquals 500, shortened.statusCode
		assertEquals "INVALID_URI", shortened.statusText
    }
}
