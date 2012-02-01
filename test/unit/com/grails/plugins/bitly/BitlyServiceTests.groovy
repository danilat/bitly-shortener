package com.grails.plugins.bitly

import grails.test.GrailsUnitTestCase

class BitlyServiceTests extends GrailsUnitTestCase {

	private BitlyService bitlyService = new BitlyService()

	protected void setUp() {
		configureService()
		super.setUp()
	}

	void testShortAnUrl() {
		def shortened = bitlyService.shorten("http://www.danilat.com")
		assertEquals 200, shortened.statusCode
		assertEquals "OK", shortened.statusText
		assertNotNull shortened.url
	}

	void testShortAnUrlWithACustomDomain() {
		bitlyService.domain = 'j.mp'
		def shortened = bitlyService.shorten("http://www.danilat.com")
		assertEquals 200, shortened.statusCode
		assertEquals "OK", shortened.statusText
		assertNotNull shortened.url
	}

	void testShortAMalformedUrl() {
		def shortened = bitlyService.shorten("www.danilat.com")
		assertEquals 500, shortened.statusCode
		assertEquals "INVALID_URI", shortened.statusText
	}

	private void configureService() {
		def devConfig = new File('dev-config.groovy')
		assertTrue devConfig.exists()
		def config = new ConfigSlurper().parse(devConfig.text)
		bitlyService.login = config.bitly.login
		bitlyService.apiKey = config.bitly.apiKey
	}
}
