# What's this? #

This is a grails plugin that is a wrapper for [bitly.com](http://bitly.org) [shorten API method](http://code.google.com/p/bitly-api/wiki/ApiDocumentation). To short urls.

# Installation #

```
grails install-plugin bitly-shortener
```

# Configuration #

In Config.groovy should be configured login, apiKey; and optionally the custom domain (may be your own domain if you have a premium account).

```
bitly.login = "danilat"
bitly.apiKey = "R_FooBar"
bitly.domain = "j.mp" //optional
```

# How to #

There are 2 grails grails artifacts, a service bitlyService:

```
def shortened = bitlyService.shorten("http://www.danilat.com")
shortened.statusCode // 200 if all is ok, error code if not.
shortened.statusText // "OK" if all is ok, error message if not.
shortened.url // The shortened url if all is ok.
```

A taglib bitly:shorten:

```
${bitly.shorten(url:'http://www.danilat.com')}
```
```
<bitly:shorten url="http://www.danilat.com"/ >
```