package com.grails.plugins.bitly

import grails.test.TagLibUnitTestCase

class BitlyTagLibTests extends TagLibUnitTestCase {

	private output = new StringWriter()
	private BitlyService bitlyService = new BitlyService()
	private BitlyTagLib bitlyTagLib = new BitlyTagLib(bitlyService: bitlyService)

	protected void setUp() {
		super.setUp()
		configureService()
		bitlyTagLib.metaClass.out = output
	}

	void testShorten() {
		bitlyTagLib.shorten(url: "http://www.danilat.com")
		assertEquals bitlyService.shorten("http://www.danilat.com").url, output.toString()
	}

	private void configureService() {
		def devConfig = new File('dev-config.groovy')
		assertTrue devConfig.exists()
		def config = new ConfigSlurper().parse(devConfig.text)
		bitlyService.login = config.bitly.login
		bitlyService.apiKey = config.bitly.apiKey
	}
}
