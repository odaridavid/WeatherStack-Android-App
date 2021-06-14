## Wingu - Weather App

A weather app built on [WeatherStack's API](https://weatherstack.com/).

## Prerequisite

Get the Access Key by setting up a free a account and add it to your local.properties file
```
WEATHERSTACK_ACCESS_KEY= Your Access Key
```

## Architecture

The applications project structure follows an mvvm approach with elements of CLEAN architecture principles, SOLID principles and usage of common design patterns
such as observer pattern and facade pattern.

We consume data from a RESTful api service , this is exposed by our remote data source and after a fetch is done we save the results in our local database,  
exposed by our local remote data source.

The repository handles mediation of data from the remote and local data sources which are facades on whats happening behind the scenes and makes it library agnostic  
hence being our source of truth.

The repository behaviours are exposed as usecases , another case of the facade pattern and single responsibility principle at play. I created a state object class
exposing two possible states from the data layer , Success or Failure. States such as loading can be handled in the ui layer.

The viewmodels then make use of the usecases that they need , this form of abstractions help only expose whats needed by the necessary classes.

## Testing

The plan is to have unit & integration testing for logic i.e upto the viewmodel layer and maybe have ui tests if necessary.

Personally i am not a fan of ui tests , they easily get flaky and slow down the CI pipelines.If you have QA engineers I also don't deem them necessary
in that case since they'll have their own automation tests.

A sample of doing parameterized tests with Junit5 has been done for the `ApiErroHandler`.

## To Note

Some API features required a paid membership i.e
- Using https over http
- Requesting for a 7 day forecast

## TODOs

A couple of todos have been spread out in the codebase and will be worked on incrementally, as this is still a work in progress
