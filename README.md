# devsuite-backend

[![Build Status](https://travis-ci.org/mocircle/devsuite-backend.svg?branch=master)](https://travis-ci.org/mocircle/devsuite-backend)

A simple development suite for backend solution.

## Projects
* core - Java library to share with other libraries.
* service - A web app to host restful web service.
* portal - A web app to host UI part.
* distribution - To assemble project files and outputs.

## Key Components/Libraries
* Java 1.8
* Spring 4.3.0
* Spring MVC 4.3.0
* Spring Security 4.1.2
* Jersey 2.2 (JAX-RS)

## Key Notes
* A web app hosted at port 8080, provides restful web service support (JAX-RS). A token (JWT) based mechanism added to support stateless authentication and authorization.
* A web app hosted at port 8090, provides web page application based on MVC structure.

## License

Released under version 2.0 of the Apache License.
