package com.grails.plugins.bitly

import groovyx.net.http.*
import org.springframework.beans.factory.InitializingBean 

class BitlyService implements InitializingBean{

    static transactional = false
	def grailsApplication
	def login
	def apiKey
	def domain
	
	void afterPropertiesSet() { 
		login = grailsApplication.config.bitly.login
		apiKey = grailsApplication.config.bitly.apiKey
		domain = grailsApplication.config.bitly.domain
	}
	

    def shorten(String url) {
		def http = new HTTPBuilder('https://api-ssl.bitly.com/')
		def shortened = [:]
		def params = [format:'json', longUrl:url, login: login, apiKey: apiKey]
		if(domain){
			params['domain'] = domain
		}
		http.get( path: 'v3/shorten', 
			query: params ) { resp, json ->
				shortened['statusCode'] = json.status_code
				shortened['statusText'] = json.status_txt
				shortened['url'] = json.data.url
		}
		return shortened
    }
}

