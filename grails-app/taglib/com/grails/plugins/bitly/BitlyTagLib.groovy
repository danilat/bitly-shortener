package com.grails.plugins.bitly

class BitlyTagLib {
	static namespace = "bitly"
	
	def bitlyService
	
	def shorten = { attrs ->
		def url = attrs.url
		def shortened = bitlyService.shorten(url)
		if(shortened){
			out << shortened.url
		}
	}
}
