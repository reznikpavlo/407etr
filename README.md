# Assignment - 407 Trip Calculator

---

This project was created using Spring boot

| Link                                            | description                                                               |
|-------------------------------------------------|---------------------------------------------------------------------------|
| *[localhost:8080/toll][1]*                      | shows all locations from `interchanges.json` (located in dir `resources`) |
| *[localhost:8080/toll/{id}] [2]*                | shows one location founded by `id`.                                       |
| *[localhost:8080/toll/cost/namefrom/nameto][3]* | calculate the rote first param `name from`, and second param `name to`    |

---
[1]: (http://localhost:8080/toll)
[2]: (http://localhost:8080/toll/{id})
[3]: (http://localhost:8080/toll/cost/namefrom/nameto)

When wy try to calculate trip - result is object 
>costOfTrip { 
> {'nameFrom', nameTo'},
> distance: ??,
> cost: ??
> }

## Exceptions
If you try to provide some `nameFrom` or `nameTo` and some of those names doesn't exist in `interchanges.json` application throws
`NotFoundExceptions` which extends `RuntimeException` with respond status `HttpStatus.NOT_FOUND`

## JavaScript requests
Also, for testing rest we can use a `fetch` command in console of web browser.

That request returns in console information about location with `id=1`
```
fetch('/toll/1').then(response => response.json().then(console.log))
```

or for calculating cost of trip from `QEW` to `Highway 400`

```
fetch('/toll/cost/QEW/Highway 400').then(response => response.json().then(console.log))
```


## Examples

### First example
Trying to calculate the cost of trip from `QEW` to `Highway 400`
```
http://localhost:8080/toll/cost/QEW/Highway%20400
```

Result 
```
{"costOfTrip":["QEW","Highway 400"],"distance":68.93,"cost":17.2325}
```

### Second Example
Let's calculate the cost of trip from `Salem Road` and `QEW`
```
http://localhost:8080/toll/cost/Salem%20Road/QEW
```
Result: 

```
{"costOfTrip":["Salem Road","QEW"],"distance":107.96400000000001,"cost":26.991000000000003}
```

Third Example

Last example demonstrate the cost of trip from `QEW` to `Salem Road`
```
http://localhost:8080/toll/cost/QEW/Salem%20Road
```
Result:
```
{"costOfTrip":["QEW","Salem Road"],"distance":115.27700000000002,"cost":28.819250000000004}
```

