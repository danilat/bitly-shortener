grails.project.work.dir = 'target'

grails.project.dependency.resolution = {

	inherits 'global'
	log 'warn'

	repositories {
		grailsPlugins()
		grailsHome()
		grailsCentral()
		mavenLocal()
		mavenCentral()
	}

	dependencies {
		compile('org.codehaus.groovy.modules.http-builder:http-builder:0.5.1') {
			excludes 'xalan'
			excludes 'xml-apis'
			excludes 'groovy'
		}
	}
}
