### Travis CI [![Build Status](https://travis-ci.org/Studio-Projektowe-AGH/PA_FBConnector.svg)](https://travis-ci.org/Studio-Projektowe-AGH/PA_FBConnector)
======
Host:
=================================
Ścieżki:

POST        /update/business
POST        /update/individual

Ścieżki przyjmują application/x-www-form-urlencoded z polami fbToken i gpToken
W przypadku powodzenia zwracają jsona
{
    request:  "request do fb"
    response: "response od serwisu profilowego"
}
