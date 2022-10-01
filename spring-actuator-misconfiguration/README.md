# access env
curl 'http://localhost:8080/actuator/env' -i -X GET

# set properties
curl -H "Content-Type: application/json" -X POST -d '{"name":"server.port", "value":9090}' http://localhost:8080/actuator/env

# set refresh
curl 'http://localhost:8080/actuator/refresh' -i -X POST

# set restart (port is altered at this point)
curl 'http://localhost:8080/actuator/restart' -i -X POST
