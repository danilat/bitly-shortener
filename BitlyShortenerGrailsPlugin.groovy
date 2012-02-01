class BitlyShortenerGrailsPlugin {
	def version = "0.1"
	def grailsVersion = "1.3 > *"
	def pluginExcludes = [
		"grails-app/views/error.gsp"
	]

	def author = "Dani Latorre"
	def authorEmail = "dani@danilat.com"
	def title = "Bitly shortener"
	def description = 'A wrapper to bitly.com shorten API method'
	def documentation = "https://github.com/danilat/bitly-shortener"
}
