package com.grails.plugins.bitly

import grails.test.*

class BitlyTagLibTests extends TagLibUnitTestCase {
	def bitlyTagLib
	def output
	def bitlyService
	
    protected void setUp() {
        super.setUp()
		bitlyService = new BitlyService()
		bitlyService.login = 'danilat'
		bitlyService.apiKey = 'R_dfe892d83437cf0ae1a745021ca106c1'
		bitlyTagLib = new BitlyTagLib(bitlyService: bitlyService)
		output = new StringWriter()
		bitlyTagLib.metaClass.out = output
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testShorten() {
		bitlyTagLib.shorten(url: "http://www.danilat.com")
		assertEquals bitlyService.shorten("http://www.danilat.com").url, output.toString()
    }
}
